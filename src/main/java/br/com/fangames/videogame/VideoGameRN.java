package br.com.fangames.videogame;

import java.util.List;

import br.com.fangames.game.Game;
import br.com.fangames.hibernate.util.DAOfactory;

public class VideoGameRN {
	
	private VideoGameDAO videoDAO;
	
	public VideoGameRN() {
		videoDAO = DAOfactory.criaVideoGameDAO();
	}
	
	public void salvar(VideoGame videoGame){
		videoDAO.salvar(videoGame);
	}
	
	public void atualizar(VideoGame videoGame){
		videoDAO.atualizar(videoGame);
	}
	
	public void excluir(VideoGame videoGame){
		videoDAO.excluir(videoGame);
	}
	
	public List<VideoGame> lista(){
		return videoDAO.lista();
	}
	
	public List<VideoGame> listaVideosPorGame(Game game){
		return videoDAO.listaVideosPorGame(game);
	}
	
	public VideoGame consultaVideoGamePorId(String idVideogGame){
		return videoDAO.consultaVideoGamePorId(idVideogGame.replace("[", "").replace("]", ""));
	}

}
