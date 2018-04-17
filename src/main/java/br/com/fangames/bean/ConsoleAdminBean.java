package br.com.fangames.bean;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import br.com.fangames.console.Console;
import br.com.fangames.console.ConsoleRN;
import br.com.fangames.empresa.Empresa;
import br.com.fangames.empresa.EmpresaRN;

@ManagedBean(name="consoleAdminBean")
@RequestScoped
public class ConsoleAdminBean implements Serializable {


	private static final long serialVersionUID = -3917301273095990254L;
	private Console console =  new Console();
	private ConsoleRN consoleRN = new ConsoleRN();
	private EmpresaRN empresaRN;
	private Map<String,String> mapEmpresas;
	private ArrayList<Console> consoles = new ArrayList<>();
	
	@PostConstruct
	public void init(){
		//Carregando empresa cadastradas
		carregaEmpresas();
		//Carregando consoles cadastrados
		consoles = (ArrayList<Console>) consoleRN.listaConsole();

	}
	
	public void cadastraConsole(){
		if(console.getEmpresa().getNome().equals("-1")){
			FacesContext.getCurrentInstance().addMessage("select-empresa-console", new FacesMessage("A empresa do console deve ser inserida! "));
			return;
		}
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		System.out.println("Data:"+df.format(console.getDt_lancamento().getTime()));
		console.setEmpresa(empresaRN.empresaEscolhida(console.getEmpresa()));
		consoleRN.salvar(console);
		carregaConsoles();
	}
	
	
	public void carregaEmpresas(){
		empresaRN = new EmpresaRN();
		mapEmpresas = new HashMap<String,String>();
		ArrayList<Empresa> empresas = (ArrayList<Empresa>) empresaRN.listaEmpresa();
		for(Empresa e:empresas){
			mapEmpresas.put(e.getNome(), e.getNome());
		}
	}
	
	public void removeConsole(String idConsole){
		Console consoleAlvo = consoleRN.consoleEscolhidoPorId(Integer.parseInt(idConsole.replace("[", "").replace("]", "")));
		System.out.println("Nome:"+consoleAlvo.getNome());
		consoleRN.excluir(consoleAlvo);
		consoles = (ArrayList<Console>) consoleRN.listaConsole();
	}
	

	
	
	public void carregaConsoles(){
		consoles = (ArrayList<Console>) consoleRN.listaConsole();
	}
	
	public ArrayList<Console> getConsoles() {
		return consoles;
	}


	public Console getConsole() {
		return console;
	}

	public void setConsole(Console console) {
		this.console = console;
	}

	public Map<String, String> getMapEmpresas() {
		return mapEmpresas;
	}
	
	
	public void setMapEmpresas(Map<String, String> mapEmpresas) {
		this.mapEmpresas = mapEmpresas;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	
	

	
	
	
	

}
