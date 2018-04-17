package br.com.fangames.game;

import java.util.List;

import br.com.fangames.hibernate.util.DAOfactory;

public class GameRN {
	
	GameDAO gameDAO;
	
	public GameRN(){
		gameDAO = DAOfactory.criarGameDAO();
	}
	
	public void salvar(Game game){
		gameDAO.salvar(game);
	}
	
	public void excluir(Game game){
		gameDAO.excluir(game);
	}
	
	public void atualizar(Game game){
		gameDAO.atualizar(game);
	}

	public List<Game> listaGame(){
		return gameDAO.listaGame();
	}
	
	public Game gameEscolhido(Game game){
		return gameDAO.gameEscolhido(game);
	}
	
	public Game gameEscolhidoPorId(String idGame){
		return gameDAO.gameEscolhidoPorId(idGame);
	}
	
	public List<String> listaDeConsolesDoGame(int idGame){
		return gameDAO.listaDeConsolesDoGame(idGame);
	}
	
}
