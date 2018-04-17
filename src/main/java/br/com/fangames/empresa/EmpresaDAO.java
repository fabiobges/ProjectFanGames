package br.com.fangames.empresa;

import java.util.List;

public interface EmpresaDAO {
	
	public void salvar(Empresa empresa);
	public void excluir(Empresa empresa);
	public void atualizar(Empresa empresa);
	public List<Empresa> listaEmpresa();
	public Empresa empresaEscolhida(Empresa empresa);
}
