package br.com.fangames.desenvolvedor;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import br.com.fangames.hibernate.util.DAOfactory;

public class DesenvolvedorRN {
	
	DesenvolvedorDAO desenvDAO;
	
	public DesenvolvedorRN(){
		desenvDAO = DAOfactory.criaDesenvolvedorDAO();
	}
	
	public void salvar(Desenvolvedor desenv){
		desenvDAO.salvar(desenv);
	}
	
	public void excluir(Desenvolvedor desenv){
		boolean flag = desenvDAO.listaGamesDesenvolvedor(desenv);
		if(flag == false){
			desenvDAO = DAOfactory.criaDesenvolvedorDAO();
			desenvDAO.excluir(desenv);
		}else{
			FacesContext.getCurrentInstance().addMessage("desenvolvedor-table", new FacesMessage("Possívelmente há algum game existente no sistema que está relacionado a este desenvolvedor!"));
			return;
		}
	}
	
	public void atualizar(Desenvolvedor desenv){
		desenvDAO.update(desenv);
	}
	
	public Desenvolvedor desenvolvedorEscolhido(String nome){
		return desenvDAO.desenvolvedorEscolhido(nome);
	}
	
	public List<Desenvolvedor> listaDesenvolvedor(){
		return desenvDAO.listaDesnvolvedor();
	}

}
