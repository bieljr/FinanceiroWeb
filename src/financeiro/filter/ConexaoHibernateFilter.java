package financeiro.filter;

import javax.servlet.*;

import org.hibernate.SessionFactory;

import financeiro.util.HibernateUtil;

public class ConexaoHibernateFilter implements Filter{
	
	private SessionFactory sessionFactoy;
	
	public void init(FilterConfig config) throws ServletException{
		this.sessionFactoy = HibernateUtil.getSessionFactory();
	}
	
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse,
			FilterChain chain) throws ServletException{
		try{
			this.sessionFactoy.getCurrentSession().beginTransaction();
			chain.doFilter(servletRequest, servletResponse);
			this.sessionFactoy.getCurrentSession().getTransaction().commit();
			this.sessionFactoy.getCurrentSession().close();
			System.out.println("Operação de filtro realizada com sucesso! Transação comitada!");
		}catch(Throwable e){
		try{
				if(this.sessionFactoy.getCurrentSession().getTransaction().isActive()){
				this.sessionFactoy.getCurrentSession().getTransaction().rollback();
				System.out.println("Erro ao realizar operação de filtragem, rollback iniciado!");
			}	
			}catch(Throwable t){
				t.printStackTrace();
				System.out.println("O erro esta aqui");
			}
			throw new ServletException(e);
			
		}
	}
	
	public void destroy(){}
}
