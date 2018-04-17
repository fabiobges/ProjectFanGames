package br.com.fangames.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.fangames.console.Console;
import br.com.fangames.console.ConsoleRN;
import br.com.fangames.consolegame.ConsoleGame;
import br.com.fangames.game.Game;

@ManagedBean
@ViewScoped
public class Playstation2Bean implements Serializable {

	
	private static final long serialVersionUID = -8572360767292092055L;
	private Console console = new Console();
	private char letra;
	private ConsoleRN consRN;
	private List<Game> games;
	
	@PostConstruct
	private void init(){
		consRN = new ConsoleRN();
		console.setNome("Playtation 2");
		console = consRN.consoleEscolhido(console.getNome());
		System.out.println("Letra>:"+letra);
	}

	public String telaConsoleGames(){
		System.out.println(this.console.getNome());
		consRN = new ConsoleRN();
		this.console = consRN.consoleEscolhido(this.console.getNome());
		consRN.listaConsoleGames(this.console);
		listaGames();
		return "/plataforma/playstation2/todosgames";
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
	
	

}
