package br.com.fangames.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

import br.com.fangames.game.Game;
import br.com.fangames.console.Console;
import br.com.fangames.console.ConsoleRN;
import br.com.fangames.consolegame.ConsoleGame;

@ManagedBean (name="todosGamesBean")
@ViewScoped 
public class TodosGamesBean implements Serializable{


	private static final long serialVersionUID = -5014080765324418228L;
	private Console console;
	private char letra;
	private ConsoleRN consRN;
	private List<Game> games;
	private String game;

	
	@ManagedProperty(value = "#{contextConsoleBean}")
	private ContextConsoleBean context;


	@PostConstruct
	private void init(){
		

		FacesContext ctx = FacesContext.getCurrentInstance();
		HttpServletRequest request = (HttpServletRequest) ctx.getExternalContext().getRequest();
		String nomeGame = request.getParameter("nmg");
		
		if(nomeGame == null){
			nomeGame = context.getConsole();
		}else{
			context.setConsole(nomeGame);
		}
		
		if(console == null){
			if(nomeGame == null){
				nomeGame="Playstation";
			}
			console = new Console();
			console.setNome(nomeGame);
			consRN = new ConsoleRN();
			console = consRN.consoleEscolhido(console.getNome());
		};

		
		
		if(letra == '\0'){
			games = new ArrayList<>();
			for(ConsoleGame consgame:this.console.getConsgames()){
				if(consgame.getGame().getNome().charAt(0)=='A'){
					games.add(consgame.getGame());
				}
			}
		}
		
		System.out.println("Letra>:"+console.getId());
	}

	public String telaConsoleGames(){
		System.out.println(this.console.getNome());
		consRN = new ConsoleRN();
		this.console = consRN.consoleEscolhido(this.console.getNome());
		consRN.listaConsoleGames(this.console);
		listaGames();
		return "/plataforma/todosgames?faces-redirect=true nmg="+console.getNome();
	}
	
	public String telaGame(){
		System.out.println(game);
		return "/libgames/game?faces-redirect=true parametro="+this.game;
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
	
	public String telaIndex(){
        return "/plataforma/todosgames?faces-redirect=true nmg=Playstation";
	}
	
	public Console getConsole() {
		return console;
	}

	public void setConsole(Console console) {
		this.console = console;
	}

	public char getLetra() {
		return letra;
	}

	public void setLetra(char letra) {
		this.letra = letra;
	}

	public List<Game> getGames() {
		return games;
	}

	public void setGames(List<Game> games) {
		this.games = games;
	}

	public String getGame() {
		return game;
	}

	public void setGame(String game) {
		this.game = game;
	}

	public ContextConsoleBean getContext() {
		return context;
	}

	public void setContext(ContextConsoleBean context) {
		this.context = context;
	}

	
	
	
	
	
}
