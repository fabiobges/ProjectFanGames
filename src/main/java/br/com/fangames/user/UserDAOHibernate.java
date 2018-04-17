package br.com.fangames.user;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.hibernate.CacheMode;
import org.hibernate.FlushMode;
import org.hibernate.LockMode;
import org.hibernate.LockOptions;
import org.hibernate.Query;
import org.hibernate.ScrollMode;
import org.hibernate.ScrollableResults;
import org.hibernate.Session;
import org.hibernate.transform.ResultTransformer;
import org.hibernate.type.Type;

public class UserDAOHibernate implements UserDAO{

	Session session;
	
	public void setSession(Session session){
		this.session = session;
		this.session.isOpen();
	}
	
	@Override
	public User autenticaUser(User user) {
		
		User userAutenticado = new User();
		Query query = this.session.createQuery("select u from User u where u.login = :id and u.userSenha = :senha");
		query.setString("id", user.getLogin());
		query.setString("senha", user.getUserSenha());
		userAutenticado = (User) query.uniqueResult();
		System.out.println("Usuário: "+user.getLogin()+" - "+user);
		if(userAutenticado != null && userAutenticado.getUserSenha().equals(user.getUserSenha())){
			System.out.println("Autenticado");
			return userAutenticado;
		}else{
			System.out.println("Negado");
			return null;
		}
		
	}

	

}
