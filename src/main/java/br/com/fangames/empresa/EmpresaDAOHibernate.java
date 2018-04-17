package br.com.fangames.empresa;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;

import br.com.fangames.game.Game;

public class EmpresaDAOHibernate implements EmpresaDAO{

	private Session session;
	
	@Override
	public void salvar(Empresa empresa) {
		session.save(empresa);
	}

	@Override
	public void excluir(Empresa empresa) {
		session.delete(empresa);
	}

	@Override
	public void atualizar(Empresa empresa) {
		session.update(empresa);
		
	}
	
	public List<Empresa> listaEmpresa(){
		List<Empresa> empresas = this.session.createCriteria(Empresa.class).list();
		
		return empresas;
	}
	
	public Empresa empresaEscolhida(Empresa empresa){
		System.out.println("Passou");
		return (Empresa) this.session.createCriteria(Empresa.class).add(Restrictions.eq("nome",empresa.getNome())).uniqueResult();
	}

	public Session getSession() {
		return session;
	}

	public void setSession(Session session) {
		this.session = session;
	}
	
	
	
	

}
