package br.com.fangames.videogame;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import br.com.fangames.game.Game;

public class VideoGameDAOHibernate implements VideoGameDAO{
	
	private Session session;
	
	public VideoGameDAOHibernate(Session session) {
		this.session = session;
	}

	@Override
	public void salvar(VideoGame videoGame) {
		this.session.save(videoGame);
	}

	@Override
	public void atualizar(VideoGame videoGame) {
		this.session.update(videoGame);
	}

	@Override
	public void excluir(VideoGame videoGame) {
		this.session.delete(videoGame);
	}

	@Override
	public List<VideoGame> lista() {
		return this.session.createCriteria(VideoGame.class).list();
	}

	@Override
	public List<VideoGame> listaVideosPorGame(Game game) {
		return this.session.createCriteria(VideoGame.class).add(Restrictions.eq("game.id",game.getId())).addOrder(Order.asc("game")).list();
	}

	@Override
	public VideoGame consultaVideoGamePorId(String idVideoGame) {
		return (VideoGame) this.session.createCriteria(VideoGame.class).add(Restrictions.eq("id",Integer.parseInt(idVideoGame))).uniqueResult();
	}

}
