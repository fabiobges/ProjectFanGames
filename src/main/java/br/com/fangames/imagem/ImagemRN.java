package br.com.fangames.imagem;

import java.util.List;

import org.hibernate.Session;

import br.com.fangames.game.Game;
import br.com.fangames.hibernate.util.DAOfactory;

public class ImagemRN {
	
	private ImagemDAO imagemDAO;
	
	public ImagemRN() {
		imagemDAO = DAOfactory.criaImagemDAO();
	}
	

	public void salvar(Imagem imagem) {
		imagemDAO.salvar(imagem);
	}
	
	public void atualizar(Imagem imagem){
		imagemDAO.atualizar(imagem);
	}

	public void excluir(Imagem imagem) {
		imagemDAO.excluir(imagem);
		
	}

	public List<Imagem> listaImagens() {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Imagem> listaImagensPorGame(Game game) {
		
		return imagemDAO.listaImagensPorGame(game);
	}

}
