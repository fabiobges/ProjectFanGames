package br.com.fangames.bean;



import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import javax.servlet.http.HttpSession;

import br.com.fangames.game.Game;
import br.com.fangames.console.Console;
import br.com.fangames.console.ConsoleRN;
import br.com.fangames.consolegame.ConsoleGame;


@ManagedBean(name="consoleBean")
@RequestScoped
public class ConsoleBean implements Serializable{


	private static final long serialVersionUID = -1295439616176449879L;
	private ConsoleRN consoleRN = new ConsoleRN();
	private Console console = new Console();
	
	private List<Game> games = new ArrayList<>();
	private char letra;
	
	@ManagedProperty("#{param.parametro}")
	private String parametro;

	//HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
	//ContextConsoleBean contextConsole = (ContextConsoleBean) session.getAttribute("contextConsoleBean");
	//this.console.setNome(contextConsole.getConsole().getNome());
	
	@PostConstruct
	public void init(){
	
		System.out.println("sinal!"+parametro);
		this.console = consoleRN.consoleEscolhido(parametro);
		letra = '0';
		listaGames();
	}
	
	public String telaConsole(){
		System.out.println("executou!!!");
		return "console?faces-redirect=true";
		
	}
	
	public String telaConsoleGames(){
		System.out.println(this.console.getNome());
		consoleRN = new ConsoleRN();
		this.console = consoleRN.consoleEscolhido(this.console.getNome());
		consoleRN.listaConsoleGames(this.console);
		listaGames();
		return "todosgames";
	}
	
	public void listaGames(){
		//this.console = consoleRN.consoleEscolhido(this.console.getNome());
		//consoleRN.listaConsoleGames(this.console);
		games = new ArrayList<>();
		System.out.println("letra - "+letra+"//"+this.console.getNome());
		if(letra == '0'){
			for(ConsoleGame consgame:this.console.getConsgames()){
				if(consgame.getGame().getNome().charAt(0)=='0'||consgame.getGame().getNome().charAt(0)=='1'||
						consgame.getGame().getNome().charAt(0)=='2'||consgame.getGame().getNome().charAt(0)=='3'||
						consgame.getGame().getNome().charAt(0)=='4'||consgame.getGame().getNome().charAt(0)=='5'||
						consgame.getGame().getNome().charAt(0)=='6'||consgame.getGame().getNome().charAt(0)=='7'||
						consgame.getGame().getNome().charAt(0)=='8'||consgame.getGame().getNome().charAt(0)=='9'){
						games.add(consgame.getGame());
				}
			}
		}else{
			for(ConsoleGame consgame:this.console.getConsgames()){
				if(consgame.getGame().getNome().charAt(0)==letra){
					games.add(consgame.getGame());
				}
			}
		}
		
	}
	

	public Console getConsole() {
		return console;
	}
	
	public void setConsole(Console console){
		this.console = console;
	}

	

	public List<Game> getGames() {
		return games;
	}

	public void setGames(List<Game> games) {
		this.games = games;
	}

	public char getLetra() {
		return letra;
	}

	public void setLetra(char letra) {
		this.letra = letra;
	}

	public String getParametro() {
		return parametro;
	}

	public void setParametro(String parametro) {
		this.parametro = parametro;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	
	
	

	

}
