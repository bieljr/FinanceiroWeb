package financeiro.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

public class HibernateUtil {

	// private static final SessionFactory sessionFactory =
	// buildSessionFactory();
	// private static SessionFactory buildSessionFactory() {
	// try {
	// AnnotationConfiguration cfg = new AnnotationConfiguration();
	// cfg.configure("hibernate.cfg.xml");
	// System.out.println("SessionFactory criada");
	// return cfg.buildSessionFactory();
	// } catch (Throwable e) {
	// System.out.println("Criação inicial do objeto SessionFactory falhou. Erro: "
	// + e);
	// throw new ExceptionInInitializerError(e);
	// }
	// }

	// Outra forma de fazer usando Annotations
	private static final SessionFactory sessionFactory;

	static {

		AnnotationConfiguration cfg = new AnnotationConfiguration().configure("hibernate.cfg.xml");
		sessionFactory = cfg.buildSessionFactory();
		System.out.println();
	}

	// ------------------------------------------------------------------------------//

	// private static final SessionFactory sessionFactory =
	// buildSessionFactory();
	// private static SessionFactory buildSessionFactory(){
	// System.out.println("Preparando para entrar no traramento!");
	// try{
	// Configuration cfg = new Configuration();
	// cfg.configure("hibernate.cfg.xml");
	// System.out.println("SessionFactory Criada!");
	// return cfg.buildSessionFactory();
	//
	// }catch(Throwable e){
	// System.out.println("Erro ao criar objeto SessionFactory");
	// throw new ExceptionInInitializerError(e);
	// }
	// }

	public static SessionFactory getSessionFactory() {
		System.out.println("pegou a SessionFactory");
		return sessionFactory;
	}

	// private static final SessionFactory sessionFactory;
	// static {
	// try {
	// sessionFactory = new
	// AnnotationConfiguration().configure("hibernate.cfg.xml").buildSessionFactory();
	// } catch (Throwable ex) {
	// // Log exception!
	// throw new ExceptionInInitializerError(ex);
	// }
	// }
	// public static Session getSession()
	// throws HibernateException {
	// return sessionFactory.openSession();
	// }
	// public static final ThreadLocal session = new ThreadLocal();
	// public static Session currentSession() throws HibernateException {
	// Session s = (Session) session.get();
	// // Open a new Session, if this thread has none yet
	// if (s == null) {
	// s = sessionFactory.openSession();
	// // Store it in the ThreadLocal variable
	// session.set(s);
	// }
	// return s;
	// }
	// public static void closeSession() throws HibernateException {
	// Session s = (Session) session.get();
	// if (s != null)
	// s.close();
	// session.set(null);
	// }

}
