package financeiro.util.Test;

import org.hibernate.classic.Session;
import financeiro.util.*;
public class TestaConexao {
	public static void main (String args[]){
	
	 Session sessao = null;
		try{
			sessao = HibernateUtil.getSessionFactory().openSession();
			System.out.println("Conexao realizada!");
			
		}finally{
			sessao.close();
		}
	}
}
