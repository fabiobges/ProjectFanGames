package br.com.fangames.bean;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import br.com.fangames.user.User;
import br.com.fangames.user.UserRN;

@ManagedBean(name="loginBean")
@RequestScoped
public class LoginBean {
	
	@ManagedProperty (value = UsuarioController.INJECTION_NAME)
	private UsuarioController usuarioController;
	
	private String login;
	private String senha;
	
	public String autenticaUser(){
		if(login.length()>50 || login.isEmpty()==true){
			FacesContext.getCurrentInstance().addMessage("login", new FacesMessage("O usuário esta incorreto!"));
		}else if(senha.length()>50 || senha.isEmpty()==true){
			FacesContext.getCurrentInstance().addMessage("login", new FacesMessage("O senha esta incorreto!"));
		}
		User user = new User();
		user.setLogin(login);
		System.out.println("code1:"+senha);
		user.setUserSenha(senha);
		UserRN userRN = new UserRN();
		user = userRN.autenticaUser(user);
		if (user != null){
			usuarioController.setUser(user);
			HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest(); 
			request.getSession().setAttribute("user", user);
			return "/admin/menuAdmin.jsf?faces-redirect=true";
		}else{
			System.out.println("Usuário inválido!");
			FacesContext.getCurrentInstance().addMessage("login", new FacesMessage("Usuário Invalido!"));
			return null;
		}
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public void setUsuarioController(UsuarioController usuarioController) {
		this.usuarioController = usuarioController;
	}

	
	
	

}
