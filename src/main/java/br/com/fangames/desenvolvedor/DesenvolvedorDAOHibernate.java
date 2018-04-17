package br.com.fangames.desenvolvedor;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import br.com.fangames.game.Game;

public class DesenvolvedorDAOHibernate implements DesenvolvedorDAO{
	
	Session session;
	
	public void setSession(Session session){
		this.session=session;
	}

	@Override
	public void salvar(Desenvolvedor desenv) {
		this.session.save(desenv);
		
	}

	@Override
	public void excluir(Desenvolvedor desenv) {
		this.session.delete(desenv);	
	}

	@Override
	public void update(Desenvolvedor desenv) {
		this.session.update(desenv);
	}

	@Override
	public List<Desenvolvedor> listaDesnvolvedor() {
		return this.session.createCriteria(Desenvolvedor.class).addOrder(Order.asc("nome")).list();
	}

	@Override
	public Desenvolvedor desenvolvedorEscolhido(String nome) {
		Query query = this.session.createQuery("select d from Desenvolvedor d where d.nome = :nome");
		return (Desenvolvedor) query.setString("nome", nome).uniqueResult();
		
	}
	
	@Override
	public boolean listaGamesDesenvolvedor(Desenvolvedor desenv) {
		System.out.println("Id desenv:"+desenv.getId());
	     ArrayList<Game> games = (ArrayList<Game>) this.session.createCriteria(Game.class).add(Restrictions.eq("desenvolvedor.id",desenv.getId())).list();
	     if(games.isEmpty()){
	    	 return false;
	     }else{
	    	 return true;
	     }
	}
	
	

}
