package br.com.fangames.bean;

import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import br.com.fangames.desenvolvedor.Desenvolvedor;
import br.com.fangames.desenvolvedor.DesenvolvedorRN;

@ManagedBean(name="desenvolvedorAdminBean")
@RequestScoped
public class DesenvolvedorAdminBean {
	
	private Desenvolvedor desenvolvedor;
	private DesenvolvedorRN desenvolvedorRN;
	private ArrayList<Desenvolvedor> desenvolvedores;

	
	@PostConstruct
	public void init(){	
		desenvolvedorRN = new DesenvolvedorRN();
		desenvolvedor = new Desenvolvedor();
		desenvolvedores = new ArrayList<>();
	}
	
	
	public void cadastraDesenvolvedor(){
		if(desenvolvedor.getNome().length() > 50){
			FacesContext.getCurrentInstance().addMessage("input-nome-desenvolvedor", new FacesMessage("O limite máximo de caracteres do nome do desenvolvedor é de 50"));
			return;
		}
		desenvolvedorRN.salvar(desenvolvedor);
	}
	
	public void removeDesenvolvedor(String nmDesenvolvedor){
		Desenvolvedor desenvAlvo = desenvolvedorRN.desenvolvedorEscolhido(nmDesenvolvedor.replace("[", "").replace("]", ""));
		desenvolvedorRN.excluir(desenvAlvo) ;
	}
	
	
	public Desenvolvedor getDesenvolvedor() {
		return desenvolvedor;
	}

	public void setDesenvolvedor(Desenvolvedor desenvolvedor) {
		this.desenvolvedor = desenvolvedor;
	}


	public ArrayList<Desenvolvedor> getDesenvolvedores() {
		return desenvolvedores = (ArrayList<Desenvolvedor>) desenvolvedorRN.listaDesenvolvedor();
	}


	public void setDesenvolvedores(ArrayList<Desenvolvedor> desenvolvedores) {
		this.desenvolvedores = desenvolvedores;
	}
	
	
	
	
	
	

}
