package br.com.fangames.bean;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

import br.com.fangames.youtuber.Youtuber;
import br.com.fangames.youtuber.YoutuberRN;

@ManagedBean(name="youtuberConsultaAdminBean")
@ViewScoped
public class YoutuberConsultaAdminBean {
	
	private Youtuber youtuber;
	private YoutuberRN youtuberRN;
	
	
	
	@PostConstruct
	public void init(){
		
		//Recebendo parametro idYoutu
		HttpServletRequest hsr = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
		String idYoutuber = hsr.getParameter("idYoutu");
		
		youtuber = new Youtuber();
		
		if(idYoutuber != null){
			//Recebendo Youtuber Escolhido
			youtuberRN = new YoutuberRN();
			youtuber = youtuberRN.consultaYoutuberPorId(idYoutuber);
		}
		
	}

	public void atualizarYoutuber(){
		youtuberRN  = new YoutuberRN();
		youtuberRN.atualizar(youtuber);
	}
	
	public String telaYoutuberAdmin(){
		return "/admin/youtuber.jsf?faces-redirect=true";
	}
	
	public Youtuber getYoutuber() {
		return youtuber;
	}

	public void setYoutuber(Youtuber youtuber) {
		this.youtuber = youtuber;
	}

	public YoutuberRN getYoutuberRN() {
		return youtuberRN;
	}

	public void setYoutuberRN(YoutuberRN youtuberRN) {
		this.youtuberRN = youtuberRN;
	}
	
	
	

}
