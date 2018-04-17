package br.com.fangames.hibernate.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.fangames.user.User;
import br.com.fangames.hibernate.filter.AbstractFilter;;

@WebFilter(urlPatterns="/admin/*")
public class LoginFilter extends AbstractFilter implements Filter {

	@Override
	public void destroy() {
		
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {
		
		HttpServletRequest httpReq = (HttpServletRequest) req;
		HttpServletResponse httpResp = (HttpServletResponse) resp;
		
		HttpSession session = httpReq.getSession();
		
		User user = (User)session.getAttribute("user");
		
		if(session.isNew() || user == null){
			System.out.println("Filtro: Usuário Inválido");
			doLogin(req, resp, httpReq);
		}else{
			System.out.println("Filtro: Usuário Autenticado, "+user.getLogin());
			chain.doFilter(req, resp);
		}
		
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		
	}
	
}
