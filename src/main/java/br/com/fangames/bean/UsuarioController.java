package br.com.fangames.bean;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import br.com.fangames.user.User;

@ManagedBean (name="usuarioController")
@SessionScoped 
public class UsuarioController implements Serializable{

	private static final long serialVersionUID = 1783997791414336064L;

	public static final String INJECTION_NAME = "#{usuarioController}";
	
	private User user;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	public String logout(){
		((HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false)).invalidate();
		return "../login";
	}
	
}
