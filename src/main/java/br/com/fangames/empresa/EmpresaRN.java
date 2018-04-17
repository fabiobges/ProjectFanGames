package br.com.fangames.empresa;

import java.util.List;

import br.com.fangames.hibernate.util.DAOfactory;

public class EmpresaRN {

	EmpresaDAO empresaDAO;
	
	public EmpresaRN(){
		empresaDAO = DAOfactory.criaEmpresaDAO();
	}
	
	public void salvar(Empresa empresa){
		empresaDAO.salvar(empresa);
	}
	
	public void excluir(Empresa empresa){
		empresaDAO.excluir(empresa);
	}

	public void atualizar(Empresa empresa){
		empresaDAO.atualizar(empresa);
	}
	
	public List<Empresa> listaEmpresa(){
		return empresaDAO.listaEmpresa();
	}
	
	public Empresa empresaEscolhida(Empresa empresa){
		return empresaDAO.empresaEscolhida(empresa);
	}
	
}
