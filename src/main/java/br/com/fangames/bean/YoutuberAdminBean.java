package br.com.fangames.bean;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import br.com.fangames.youtuber.Youtuber;
import br.com.fangames.youtuber.YoutuberRN;

@ManagedBean(name="youtuberAdminBean")
@RequestScoped
public class YoutuberAdminBean {
	
	private Youtuber youtuber;
	private List<Youtuber> youtubers;
	private YoutuberRN youtuberRN;
	
	@PostConstruct
	public void init(){
		youtuber = new Youtuber();
		youtuberRN = new YoutuberRN();
		youtubers = youtuberRN.listaYoutuber();
	}
	
	public void cadastraYoutuber(){
		if((youtuber.getNome().length()<5) || (youtuber.getNome().length() > 50)){
			FacesContext.getCurrentInstance().addMessage("input-nome-youtuber", new FacesMessage("O nome do Youtuber deve conter no mínimo 5 e no máximo 50 caracteres!"));
			return;
		}else if(youtuber.getDescricao().length() < 20 || youtuber.getDescricao().length() > 255){
			FacesContext.getCurrentInstance().addMessage("input-desc-youtuber", new FacesMessage("A descrição do Youtuber deve conter no mínimo 20 e no máximo 255 caracteres!"));
			return;
		}
		
		youtuberRN.salvar(youtuber);
		youtubers = youtuberRN.listaYoutuber();
		youtuber = new Youtuber();
	}
	
	public String consultaYoutuber(String idYoutuber){
		return "/admin/youtuberConsulta.jsf?faces-redirect=true idYoutu="+idYoutuber.replace("[", "").replace("]", "");
	}
	
	public Youtuber getYoutuber() {
		return youtuber;
	}
	public void setYoutuber(Youtuber youtuber) {
		this.youtuber = youtuber;
	}
	public List<Youtuber> getYoutubers() {
		return youtubers;
	}
	public void setYoutubers(List<Youtuber> youtubers) {
		this.youtubers = youtubers;
	}
	
	
	

}
