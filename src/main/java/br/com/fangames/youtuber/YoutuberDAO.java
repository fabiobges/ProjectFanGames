package br.com.fangames.youtuber;

import java.util.List;

public interface YoutuberDAO {
	
	public void salvar(Youtuber youtuber);
	public void excluir(Youtuber youtuber);
	public void atualizar(Youtuber youtuber);
	public List<Youtuber> listaYoutuber();
	public Youtuber youtuberEscolhidoPorNome(String nomeYoutuber);
	public Youtuber consultaYoutuberPorId(String idYoutuber);

}
