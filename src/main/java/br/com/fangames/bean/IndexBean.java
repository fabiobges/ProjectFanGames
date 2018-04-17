package br.com.fangames.bean;


import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;


@ManagedBean(name = "indexBean")
@RequestScoped
public class IndexBean {
    
    private String imgPrincipal;
    private String imgLegenda;
    
	
    
    @PostConstruct
    public void init(){
        imgPrincipal="principal1.jpg";
        imgLegenda = "Imagem 1";
        
    }
    
    public void alteraImagemPrincipal(String img){
       
        if(img.equals("1")){
        	 System.out.println("foi");
            imgPrincipal="principal1.jpg";
            imgLegenda = "Imagem 1";
        }else if(img.equals("2")){
            imgPrincipal="principal2.jpg";
            imgLegenda = "Imagem 2";
        }else if(img.equals("3")){
            imgPrincipal="principal3.jpg";
            imgLegenda = "Imagem 2";
        }else if(img.equals("4")){
            imgPrincipal="principal4.jpg";
            imgLegenda = "Imagem 2";
        }
    }
 
	
    public String telaTodosgames(String nomeGame){
    	HttpServletRequest req = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
        System.out.println("teste2:"+req.getParameter("tt"));
            return "/plataforma/todosgames?faces-redirect=true nmg="+nomeGame;
    }

    
    public String telaIndex(){
        return "teste?faces-redirect=true";
}

    public String getImgPrincipal() {
        return imgPrincipal;
    }

    public void setImgPrincipal(String imgPrincipal) {
        this.imgPrincipal = imgPrincipal;
    }

    public String getImgLegenda() {
        return imgLegenda;
    }

    public void setImgLegenda(String imgLegenda) {
        this.imgLegenda = imgLegenda;
    }


    
    
    

    
    

    
    
    
}
