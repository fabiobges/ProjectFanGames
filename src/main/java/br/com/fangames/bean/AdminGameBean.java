package br.com.fangames.bean;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;


import br.com.fangames.console.Console;
import br.com.fangames.console.ConsoleRN;
import br.com.fangames.consolegame.ConsoleGame;
import br.com.fangames.desenvolvedor.Desenvolvedor;
import br.com.fangames.desenvolvedor.DesenvolvedorRN;
import br.com.fangames.game.Game;
import br.com.fangames.game.GameRN;
import br.com.fangames.videogame.VideoGame;
import br.com.fangames.youtuber.Youtuber;

@ManagedBean(name="adminGameBean")
@RequestScoped
public class AdminGameBean implements Serializable{
	
	private static final long serialVersionUID = -6655906127809098767L;
	
	private Game game = new Game();
	private String consoleFiltro;
	private ArrayList<Game> games;
	private GameRN gameRN;
	private VideoGame video = new VideoGame();
	private Youtuber youtuber = new Youtuber();
	private ArrayList<Youtuber> youtubers = new ArrayList<>();
	private Map<String,String> mapYoutu = new HashMap<String,String>();
	private ArrayList<Console> consoles = new ArrayList<>(); 
	private List<String> listConsoles = new ArrayList<String>();
	private List<String> selectedConsoles = new ArrayList<>();
	private Desenvolvedor desenvolvedor = new Desenvolvedor();
	private ArrayList<Desenvolvedor> devops = new ArrayList<>();
	private Map<String, String> mapDevops = new HashMap<String, String>();


	@PostConstruct
	public void init(){
		System.out.println("4");
		//Desenvolvedores
		carregaDesenvolvedores();
		//Console
		carregaConsoles();
		//Games
		carregaGames();

		
	}
	

	
	
	public void cadastraGame(){
		
			
		//GameRN gameRN = new GameRN();
		//Passando Desenvolvedor para o Game
		DesenvolvedorRN devopRN = new DesenvolvedorRN();
		game.setDesenvolvedor(devopRN.desenvolvedorEscolhido(desenvolvedor.getNome()));
		//Passando lista de consoles para o game
		for(String selected:selectedConsoles){
			for(Console cons:consoles){
				if(selected.equals(cons.getNome())){
					ConsoleGame consGame = new ConsoleGame();
					consGame.setConsole(cons);
					consGame.setGame(game);
					game.getConsGames().add(consGame);
				}
			}
			
		}
		
		//Verificando se foi selecionado algum console
		if(game.getConsGames().isEmpty()){
			FacesContext.getCurrentInstance().addMessage("console-game", new FacesMessage("O game deve estar disponibilizado para algum console!"));
			return;
		}
		
		//Adicionando Game ao Banco de Dados
		gameRN = new GameRN();
		gameRN.salvar(game);
		games = (ArrayList<Game>) gameRN.listaGame();
	}
	
	public void removeGame(String idGame){
		gameRN = new GameRN();
		Game gameAlvo = gameRN.gameEscolhidoPorId(idGame);
		gameRN.excluir(gameAlvo);
		games = (ArrayList<Game>) gameRN.listaGame();
	}
	
	public String consultaGame(String idGame){
		return "/admin/gameConsulta?faces-redirect=true parametro="+idGame.replace("[", "").replace("]", "");
	}
	
	public void filtroConsultaGame(){
		if(!consoleFiltro.equals("-1")){
			ConsoleRN consoleRN = new ConsoleRN();
			Console console = consoleRN.consoleEscolhido(consoleFiltro);
			console = consoleRN.listaConsoleGames(console);
			games = new ArrayList<>();
			for(ConsoleGame cg:console.getConsgames()){
				games.add(cg.getGame());
			}
		}else{
			carregaGames();
		}
	}
	
	
	public void carregaDesenvolvedores(){
		DesenvolvedorRN devopRN = new DesenvolvedorRN();
		devops = (ArrayList<Desenvolvedor>) devopRN.listaDesenvolvedor();
		for(Desenvolvedor dev:devops){
			System.out.println(dev.getNome());
			mapDevops.put(dev.getNome(), dev.getNome());
		}
	}
	
	public void carregaConsoles(){
		ConsoleRN consoleRN = new ConsoleRN();
		consoles = (ArrayList<Console>) consoleRN.listaConsole();
		for(Console console:consoles){
			listConsoles.add(console.getNome());
		}
	}
	
	public void carregaGames(){
		 games = new ArrayList<>();
		 gameRN = new GameRN();
		 try{
			 games = (ArrayList<Game>) gameRN.listaGame();
		 }catch(Exception e){
			 System.out.println("Erro:"+e);
		 }
	}
	
	public Game getGame() {
		return game;
	}

	public void setGame(Game game) {
		this.game = game;
	}


	public ArrayList<Game> getGames() {
		return games;
	}


	public Map<String, String> getMapDevops() {
		return mapDevops;
	}

	public void setMapDevops(Map<String, String> mapDevops) {
		this.mapDevops = mapDevops;
	}

	public List<String> getListConsoles() {
		return listConsoles;
	}

	public void setListConsoles(List<String> listConsoles) {
		this.listConsoles = listConsoles;
	}

	public List<String> getSelectedConsoles() {
		return selectedConsoles;
	}

	public void setSelectedConsoles(List<String> selectedConsoles) {
		this.selectedConsoles = selectedConsoles;
	}

	public ArrayList<Console> getConsoles() {
		return consoles;
	}

	public void setConsoles(ArrayList<Console> consoles) {
		this.consoles = consoles;
	}

	public ArrayList<Desenvolvedor> getDevops() {
		return devops;
	}

	public void setDevops(ArrayList<Desenvolvedor> devops) {
		this.devops = devops;
	}

	public Desenvolvedor getDesenvolvedor() {
		return desenvolvedor;
	}

	public void setDesenvolvedor(Desenvolvedor desenvolvedor) {
		this.desenvolvedor = desenvolvedor;
	}

	public ArrayList<Youtuber> getYoutubers() {
		return youtubers;
	}

	public void setYoutubers(ArrayList<Youtuber> youtubers) {
		this.youtubers = youtubers;
	}

	public Map<String, String> getMapYoutu() {
		return mapYoutu;
	}

	public void setMapYoutu(Map<String, String> mapYoutu) {
		this.mapYoutu = mapYoutu;
	}

	public VideoGame getVideo() {
		return video;
	}

	public void setVideo(VideoGame video) {
		this.video = video;
	}

	public Youtuber getYoutuber() {
		return youtuber;
	}

	public void setYoutuber(Youtuber youtuber) {
		this.youtuber = youtuber;
	}

	public String getConsoleFiltro() {
		return consoleFiltro;
	}

	public void setConsoleFiltro(String consoleFiltro) {
		this.consoleFiltro = consoleFiltro;
	}




	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	
	
	
	
	
	
	
}
