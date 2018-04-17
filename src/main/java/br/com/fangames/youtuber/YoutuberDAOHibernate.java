package br.com.fangames.youtuber;

import java.util.List;


import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

public class YoutuberDAOHibernate implements YoutuberDAO{
	
	Session session;

	public void setSession(Session session){
		this.session = session;
	}

	@Override
	public void salvar(Youtuber youtuber) {
		this.session.save(youtuber);
	}

	@Override
	public void excluir(Youtuber youtuber) {
		this.session.delete(youtuber);
	}

	@Override
	public void atualizar(Youtuber youtuber) {
		this.session.update(youtuber);
	}

	@Override
	public List<Youtuber> listaYoutuber() {
		return  this.session.createCriteria(Youtuber.class).list();
	}

	@Override
	public Youtuber youtuberEscolhidoPorNome(String nomeYoutuber) {
		return (Youtuber) this.session.createCriteria(Youtuber.class).add(Restrictions.eq("nome",nomeYoutuber)).uniqueResult();
	}

	@Override
	public Youtuber consultaYoutuberPorId(String idYoutuber) {
		return (Youtuber) this.session.createCriteria(Youtuber.class).add(Restrictions.eq("id", Integer.parseInt(idYoutuber))).uniqueResult();
	}
}
