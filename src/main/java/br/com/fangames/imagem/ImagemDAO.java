package br.com.fangames.imagem;

import java.util.List;

import br.com.fangames.game.Game;

public interface ImagemDAO {
	
	public void salvar(Imagem imagem);
	public void atualizar(Imagem Imagem);
	public void excluir(Imagem imagem);
	public List<Imagem> listaImagens();
	public List<Imagem> listaImagensPorGame(Game game);

}
