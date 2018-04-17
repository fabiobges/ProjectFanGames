package br.com.fangames.console;

import java.util.List;

public interface ConsoleDAO {

	public void salvar(Console console);
	public void excluir(Console console);
	public void atualizar(Console console);
	public List<Console> listaConsoles();
	public Console consoleEscolhido(String nome);
	public Console listaConsoleGames(Console console);
	public Console consoleEscolhidoPorId(int id);
	
	
}
