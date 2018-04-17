package br.com.fangames.game;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

public class GameDAOHibernate implements GameDAO{

	Session session ;
	
	public void setSession(Session session) {
		this.session = session;
	}
	
	@Override
	public void salvar(Game game) {
		System.out.println("Passou");
		this.session.save(game);
	}

	@Override
	public void excluir(Game game) {
		this.session.delete(game);
	}

	@Override
	public void atualizar(Game game) {
		this.session.update(game);
	}

	@Override
	public List<Game> listaGame() {	
		ArrayList<Game> games =  (ArrayList<Game>) this.session.createCriteria(Game.class).addOrder(Order.asc("nome")).list();
		return games;
	}

	@Override
	public Game gameEscolhido(Game game) {
		return (Game)this.session.createCriteria(Game.class).add(Restrictions.eq("nome", game.getNome())).uniqueResult();
	}
	
	@Override
	public Game gameEscolhidoPorId(String idGame) {
		return (Game)this.session.createCriteria(Game.class).add(Restrictions.eq("id", Integer.parseInt(idGame.replace("[", "").replace("]", "")))).uniqueResult();
	}
	
	@Override
	public List<String> listaDeConsolesDoGame(int idGame){
		Query query = this.session.createQuery("select c.nome from Console c inner join c.consgames cg where cg.game.id = :idGame");
		query.setInteger("idGame", idGame);
		return query.list();
	}

}
