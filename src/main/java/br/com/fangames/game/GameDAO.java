package br.com.fangames.game;

import java.util.List;

public interface GameDAO {

	public void salvar(Game game);
	public void excluir(Game game);
	public void atualizar(Game game);
	public List<Game> listaGame();
	public Game gameEscolhido(Game game);
	public Game gameEscolhidoPorId(String idGame);
	public List<String> listaDeConsolesDoGame(int idGame);
	
}
