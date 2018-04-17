package br.com.fangames.hibernate.filter;

import java.io.IOException;


import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import br.com.fangames.hibernate.util.HibernateUtil;


@WebFilter(urlPatterns={"*.jsf"})
public class HibernateFilter implements Filter{
	
	SessionFactory sf;

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {
			
		Session currentSession = this.sf.getCurrentSession();
		Transaction trans = null;
                HttpServletRequest httpServReq = (HttpServletRequest) request;
                HttpSession httpSession= httpServReq.getSession();
                
		try{   
			trans = currentSession.beginTransaction();
			currentSession.isOpen();
			chain.doFilter(request, resp);
			trans.commit();
			if(currentSession.isOpen()){
				System.out.println("fecho sessao");
				currentSession.close();
			}
		}catch(Throwable e){
			try{
				if(trans.isActive()){
					
					trans.rollback();
				}
			}catch(Throwable t){
				t.printStackTrace();
			}
			throw new ServletException(e);
		}
		
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		
		this.sf =  HibernateUtil.getSessionFactory();
		
	}

	
	

}
