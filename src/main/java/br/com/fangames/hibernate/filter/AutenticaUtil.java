package br.com.fangames.hibernate.filter;

import java.io.Serializable;

import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import br.com.fangames.user.User;

public class AutenticaUtil implements Serializable{


	private static final long serialVersionUID = 2306505010814072713L;
	
	public static HttpSession getHttpSession(){
		HttpSession httpSession = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
		return httpSession;
	}
	
	public static void setParameter(User user){
		getHttpSession().setAttribute("loguser",user);
	}


	public static void removeParameter(){
		getHttpSession().removeAttribute("loguser");
	}

	

}
