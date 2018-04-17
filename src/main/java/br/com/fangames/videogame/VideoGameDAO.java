package br.com.fangames.videogame;

import java.util.List;

import br.com.fangames.game.Game;

public interface VideoGameDAO {
	
	public void salvar(VideoGame videoGame);
	public void atualizar(VideoGame videoGame);
	public void excluir(VideoGame videoGame);
	public List<VideoGame> lista();
	public List<VideoGame> listaVideosPorGame(Game game);
	public VideoGame consultaVideoGamePorId(String idVideoGame);

}
