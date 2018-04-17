package br.com.fangames.hibernate.filter;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

public class AbstractFilter {
	
	public AbstractFilter(){
		
	}
	
	protected void doLogin(ServletRequest req, ServletResponse resp, HttpServletRequest httpreq) throws ServletException, IOException{
		RequestDispatcher dispacher = httpreq.getRequestDispatcher("../login.jsf");
		dispacher.forward(req, resp);
	}
	
	protected void acessoNegado(ServletRequest req, ServletResponse resp, HttpServletRequest httpreq) throws ServletException, IOException {
		RequestDispatcher dispatcher = httpreq.getRequestDispatcher("acessoNegado"); 
		dispatcher.forward(req, resp);
	}

}
