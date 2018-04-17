package br.com.fangames.teste;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import br.com.fangames.console.Console;
import br.com.fangames.console.ConsoleRN;
import br.com.fangames.empresa.Empresa;

public class CriaConsole {

	public static void main(String[] args) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		Empresa empresa = new Empresa();
		empresa.setNome("Sony Computer Entertainment");
		empresa.setDt_fundacao(sdf.parse("16/11/1993"));
		
		
		Console console = new Console();
		console.setNome("Playstation 2");
		console.setDescricao("O PlayStation 2 (oficialmente abreviado como PS2) foi o segundo console produzido pela empresa Sony, após o PlayStation original. Foi lançado no dia 4 de março de 2000 no Japão.");
		console.setEmpresa(empresa);
		console.setDt_lancamento(sdf.parse("04/03/2000"));
		
		ConsoleRN consRN = new ConsoleRN();
		
		consRN.salvar(console);

	}

}
