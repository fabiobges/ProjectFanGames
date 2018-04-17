package br.com.fangames.hibernate.util;



import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;


public class HibernateUtil {
	
	private static final SessionFactory sessionFactory = buildSessionFactory();
	private static SessionFactory buildSessionFactory(){ 
		try{
			Configuration conf = new Configuration();
			conf.configure("hibernate.cfg.xml");
			StandardServiceRegistryBuilder ssrb = new StandardServiceRegistryBuilder();
			ssrb.applySettings( conf.getProperties());
			StandardServiceRegistry service = ssrb.build();
			return conf.buildSessionFactory(service);
		}catch(Exception e){
			System.out.println("Não possível fazer conexão com Banco de Dados: "+e);
			return null;
		}
		
	}
	
	public static SessionFactory getSessionFactory(){
		return sessionFactory;
	}
}
