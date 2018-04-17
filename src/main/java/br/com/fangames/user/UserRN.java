package br.com.fangames.user;

import br.com.fangames.hibernate.util.DAOfactory;

public class UserRN {
	
	UserDAO userDAO;
	
	public UserRN(){
		userDAO = DAOfactory.criaUserDAO();
	}
	
	public User autenticaUser(User user){
		return userDAO.autenticaUser(user);
	}

}
