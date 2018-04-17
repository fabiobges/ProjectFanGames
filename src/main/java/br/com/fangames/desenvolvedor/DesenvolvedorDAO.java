package br.com.fangames.desenvolvedor;

import java.util.List;

public interface DesenvolvedorDAO {
	
	public void salvar(Desenvolvedor desenv);
	public void excluir(Desenvolvedor desenv);
	public void update(Desenvolvedor desenv);
	public Desenvolvedor desenvolvedorEscolhido(String nome);
	public List<Desenvolvedor> listaDesnvolvedor();
	public boolean listaGamesDesenvolvedor(Desenvolvedor desenv);

}
