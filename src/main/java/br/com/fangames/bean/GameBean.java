package br.com.fangames.bean;

import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import org.primefaces.util.Base64;

import br.com.fangames.game.Game;
import br.com.fangames.game.GameRN;
import br.com.fangames.imagem.Imagem;
import br.com.fangames.imagem.ImagemRN;
import br.com.fangames.imgvideo.util.ImgVideo;
import br.com.fangames.videogame.VideoGame;
import br.com.fangames.videogame.VideoGameRN;


@ManagedBean(name="gameBean")
@RequestScoped
public class GameBean implements Serializable{

	
	private static final long serialVersionUID = 7223844975759738318L;
	private Game game = new Game();
	private GameRN gameRN;
	private ImagemRN imagemRN;
	private VideoGameRN videoGameRN;
	private List<String> images;
	private ArrayList<String> imgsBase64;
	private ArrayList<ImgVideo> imgVid;
	
	
	
	@ManagedProperty("#{param.parametro}")
	private String parametro;
	
	@PostConstruct
	public void startGameTela(){

		/*
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
		ContextConsoleBean context = (ContextConsoleBean) session.getAttribute("contextConsoleBean");
		System.out.println(context.getGame().getNome());
		
		this.game = context.getGame();
		gameRN = new GameRN();
		*/
		
		game.setNome(parametro);
		gameRN = new GameRN();
		game = gameRN.gameEscolhido(this.game);
		
		//Recebendo imagens do game
		imagemRN = new ImagemRN();
		game.setImagens(imagemRN.listaImagensPorGame(game));
		imgsBase64 = new ArrayList<>();
		for(Imagem img:game.getImagens()){
			imgsBase64.add("data:image/jpg;base64,"+Base64.encodeToString(img.getImg(),true));
		}
		
		//Recebendo lista de videos do game 
		videoGameRN = new VideoGameRN();
		game.setVidGames(videoGameRN.listaVideosPorGame(game));
		for(VideoGame vid:game.getVidGames()){
			System.out.println("id you:"+vid.getYoutuber().getId());
		}
		
		int cont = 0;
		imgVid = new ArrayList<>();
		ImgVideo imgVideo;
		for(VideoGame video:game.getVidGames()){
			cont++;
			imgVideo = new ImgVideo();
			imgVideo.setItem("item-"+cont);
			imgVideo.setLinkVideo(video.getLink());	
			imgVid.add(imgVideo);
		}
		for(Imagem img:game.getImagens()){
			cont++;
			imgVideo = new ImgVideo();
			imgVideo.setItem("item-"+cont);
			imgVideo.setImg64("data:image/jpg;base64,"+Base64.encodeToString(img.getImg(),true));
			imgVid.add(imgVideo);
		}
		
		
		//System.out.println("imagem 4:"+Base64.encodeToString(game.getImagens().get(3).getImg(),false));
		
	}

	
	public Game getGame() {
		return game;
	}
	
	public void setGame(Game game) {
		this.game = game;
	}

	public String getParametro() {
		return parametro;
	}

	public void setParametro(String parametro){
		this.parametro = parametro; 
	}

	public List<String> getImages() {
		return images;
	}

	public ArrayList<String> getImgsBase64() {
		return imgsBase64;
	}

	public void setImgsBase64(ArrayList<String> imgsBase64) {
		this.imgsBase64 = imgsBase64;
	}


	public ArrayList<ImgVideo> getImgVid() {
		return imgVid;
	}


	public void setImgVid(ArrayList<ImgVideo> imgVid) {
		this.imgVid = imgVid;
	}


	

	
}
