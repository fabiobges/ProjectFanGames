package br.com.fangames.bean;

import javax.faces.context.FacesContext;
import javax.faces.context.Flash;

public class JSFUtils {
	
	public static Flash flashScope(){
		return FacesContext.getCurrentInstance().getExternalContext().getFlash();
	}

}
