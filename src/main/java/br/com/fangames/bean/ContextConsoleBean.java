package br.com.fangames.bean;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import br.com.fangames.console.Console;
import br.com.fangames.console.ConsoleRN;
import br.com.fangames.game.Game;

@ManagedBean(name="contextConsoleBean")
@SessionScoped
public class ContextConsoleBean implements Serializable{
	

	private static final long serialVersionUID = 3204884374623156178L;
	private String console;
	
	

	public String getConsole() {
		System.out.println("contexto chamado no get");
		return console;
	}



	public void setConsole(String console) {
		System.out.println("contexto chamado no set");
		this.console = console;
	}



	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	
	
	
}
