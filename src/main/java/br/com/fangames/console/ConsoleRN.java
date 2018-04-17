package br.com.fangames.console;



import java.util.List;

import br.com.fangames.hibernate.util.DAOfactory;

public class ConsoleRN {
	
	private ConsoleDAO consoleDAO = null;

	public ConsoleRN(){
		consoleDAO = DAOfactory.criarConsoleDAO();
	}
	
	public void salvar(Console console){
		consoleDAO.salvar(console);
	}
	
	public void atualizar(Console console){
		consoleDAO.atualizar(console);
	}
	
	public void excluir(Console console){
		consoleDAO.excluir(console);
	}
	
	public List<Console> listaConsole(){
		return consoleDAO.listaConsoles();
	}

	public Console consoleEscolhido(String nome){
		return consoleDAO.consoleEscolhido(nome);
	}
	
	public Console listaConsoleGames(Console console){
		return consoleDAO.listaConsoleGames(console);
	}
	
	public Console consoleEscolhidoPorId(int id){
		return consoleDAO.consoleEscolhidoPorId(id);
	}
}
