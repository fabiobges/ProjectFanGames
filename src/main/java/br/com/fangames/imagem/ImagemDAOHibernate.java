package br.com.fangames.imagem;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import br.com.fangames.game.Game;
import br.com.fangames.hibernate.util.HibernateUtil;

public class ImagemDAOHibernate implements ImagemDAO{
	
	Session session ;
	
	public void setSession(Session session) {
		
		this.session = session;

	}

	@Override
	public void salvar(Imagem imagem) {
		this.session.save(imagem);
	}
	
	@Override
	public void atualizar(Imagem imagem) {
		this.session.update(imagem);
	}

	@Override
	public void excluir(Imagem imagem) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Imagem> listaImagens() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Imagem> listaImagensPorGame(Game game) {
		System.out.println("Passou1:"+game.getId());
		return this.session.createCriteria(Imagem.class).add(Restrictions.eq("game.id",game.getId())).addOrder(Order.asc("id")).list();

	}

	

}
