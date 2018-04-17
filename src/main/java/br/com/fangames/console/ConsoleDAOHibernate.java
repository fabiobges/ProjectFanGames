package br.com.fangames.console;

import java.util.ArrayList;
import java.util.List;




import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.postgresql.util.PSQLException;

import br.com.fangames.consolegame.ConsoleGame;


public class ConsoleDAOHibernate implements ConsoleDAO{

	Session session;
	
	public void setSession(Session session){
		this.session = session; 
		this.session.isOpen();
	}
	
	@Override
	public void salvar(Console console) {
		this.session.save(console);
	}

	@Override
	public void excluir(Console console) {
		try{
			this.session.delete(console);
		}catch (Exception e) {
			System.out.println(e);
		}
		
	}

	@Override
	public void atualizar(Console console) {
		this.session.update(console);
		
	}

	@Override
	public List<Console> listaConsoles() {
		return this.session.createCriteria(Console.class).list();
	}

	@Override
	public Console consoleEscolhido(String nome) {
		Console console = new Console();
		console = (Console) session.createCriteria(Console.class).add(Restrictions.eq("nome", nome)).uniqueResult();
		return console;
	}
	
	@Override
	public Console consoleEscolhidoPorId(int id) {
		Console console = new Console();
		console = (Console) session.createCriteria(Console.class).add(Restrictions.eq("id", id)).uniqueResult();
		return console;
	}

	@Override
	public Console listaConsoleGames(Console console) {
		List<ConsoleGame> consgames = new ArrayList<>();
		System.out.println("Passou aqui");
		Query query = this.session.createQuery("select cg from ConsoleGame cg where cg.console = :id");
		query.setInteger("id", console.getId());
		consgames = query.list();
		if(consgames != null){
			console.setConsgames(consgames);
			for(ConsoleGame cod : console.getConsgames()){
				System.out.println("Resultado: "+cod.getConsole().getNome());
				System.out.println("Resultado: "+cod.getGame().getNome());
				System.out.println("Resultado: "+cod.getGame().getCategoria());
			}
		}
		/*
		games =  this.session.createCriteria(Game.class).add(Restrictions.eq("consGames",console.getConsgames())).list();
		for(Game gam:games){
			System.out.println(gam.getNome());
		}
		trans.commit();
		*/
		return console;
	}
	
	
	
	
	
	
	

}
