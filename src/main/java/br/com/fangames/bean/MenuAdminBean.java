package br.com.fangames.bean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean(name="menuAdminBean")
@RequestScoped
public class MenuAdminBean {
	
	public String telaGameAdmin(){
		return "/admin/games?faces-redirect=true";
	}
	
	public String telaConsoleAdmin(){
		return "/admin/console?faces-redirect=true";
	}
	
	public String telaDesenvolvedorAdmin(){
		return "/admin/desenvolvedor?faces-redirect=true";
	}
        
        public String telaPublicanteAdmin(){
		return "/admin/publicante?faces-redirect=true";
	}
	
	public String telaYoutuberAdmin(){
		return "/admin/youtuber?faces-redirect=true";
	}

}
