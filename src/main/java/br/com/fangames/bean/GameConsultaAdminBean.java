package br.com.fangames.bean;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;



import br.com.fangames.game.Game;
import br.com.fangames.game.GameRN;
import br.com.fangames.imagem.Imagem;
import br.com.fangames.imagem.ImagemRN;
import br.com.fangames.videogame.VideoGame;
import br.com.fangames.videogame.VideoGameRN;
import br.com.fangames.youtuber.Youtuber;
import br.com.fangames.youtuber.YoutuberRN;
import com.google.common.io.ByteStreams;

@ManagedBean(name = "gameConsultaAdminBean")
@ViewScoped
public class GameConsultaAdminBean implements Serializable{
	

	private static final long serialVersionUID = -538157097952463398L;
	
	private Game game;
	private GameRN gameRN;
	private List<String> categorias;
	private List<String> faixas;
	private List<String> desenvs;
	private List<String> consoles;
	
	private VideoGame video;
	private List<VideoGame> videoGames;
	private VideoGameRN videoGameRN;
	
	private YoutuberRN youtuberRN;
	private List<String> listaYoutubers;
	
	private List<Imagem> imagens;
	private ImagemRN imagemRN;
	private Part img1;
	private Part img2;
	private Part img3;
	private Part img4;

	

	@PostConstruct
	public void init(){
		
		//Recebendo parâmetro
		FacesContext ctx = FacesContext.getCurrentInstance();
		HttpServletRequest request = (HttpServletRequest) ctx.getExternalContext().getRequest();
		String param = request.getParameter("parametro");
		System.out.println("parametro:"+param);
		
		//Recebendo game escolhido
		if(game == null){
			gameRN = new GameRN();
			game = gameRN.gameEscolhidoPorId(param);
			carregaDadosGame();
		}
		
		//Recebendo imagens do game escolhido
		if(imagens == null){	
			
			imagemRN = new ImagemRN();
			imagens = new ArrayList<>();
			try{
				imagens = imagemRN.listaImagensPorGame(game);
			}catch (Exception e) {
				System.out.println("erro ao receber lista:"+e);
				imagens = new ArrayList<>();
			}
		}
		
		if(listaYoutubers == null){
			YoutuberRN youtuberRN = new YoutuberRN();
			listaYoutubers = youtuberRN.listaNomesYoutubers();
		}
		
		if(video == null){
			video = new VideoGame();
		}
		
		if(videoGames == null){
			videoGameRN = new VideoGameRN();
			try{
			videoGames = videoGameRN.listaVideosPorGame(game);
			}catch (Exception e) {
				System.out.println("erro:"+e);
			}
		}
		
		if(consoles == null){
			consoles = gameRN.listaDeConsolesDoGame(game.getId());
			for(String c:consoles){
				System.out.println("console list:"+c);
			}
		}
	}
	
	public void carregaDadosGame(){
		categorias = new ArrayList<>();
		categorias.add("Ação");
		categorias.add("RPG");
		categorias.add("Luta");
		categorias.add("Musical");
		categorias.add("MMO");
		categorias.add("Casual");
		categorias.add("Aventura");
		categorias.add("Shooter");
		categorias.add("Simulação");
		categorias.add("Fitness");
		categorias.add("Estratégia");
		categorias.add("Terror/Ação");
		faixas = new ArrayList<>();
		faixas.add("L");
		faixas.add("10");
		faixas.add("12");
		faixas.add("14");
		faixas.add("16");
		faixas.add("18");
		desenvs = new ArrayList<>();
		desenvs.add(game.getDesenvolvedor().getNome());
	}
	
	public void atualizaDadosGame(){
		gameRN = new GameRN();
		gameRN.atualizar(game);
	}
	
	
	//Recebe imgs do tipo Part converte em BYteArray
	public void insereImagensGame(){
		Imagem imagem = new Imagem();
		imagem.setGame(game);
		imagens.add(imagem);
		imagens.add(imagem);
		imagens.add(imagem);
		imagens.add(imagem);
		try{
			if(img1 != null){
				imagens.get(0).setImg(ByteStreams.toByteArray(img1.getInputStream()));
				imagemRN = new ImagemRN();
				if(imagens.get(0).getTituloImagem() ==null){
					imagens.get(0).setTituloImagem(img1.getSubmittedFileName());
					imagemRN.salvar(imagens.get(0));
				}else{
					imagens.get(0).setTituloImagem(img1.getSubmittedFileName());
					imagemRN.atualizar(imagens.get(0));
				}
			}
			if(img2 != null){
				imagens.get(1).setImg(ByteStreams.toByteArray(img2.getInputStream()));
				imagemRN = new ImagemRN();
				if(imagens.get(1).getTituloImagem() ==null){
					imagens.get(1).setTituloImagem(img2.getSubmittedFileName());
					imagemRN.salvar(imagens.get(1));
				}else{
					imagens.get(1).setTituloImagem(img2.getSubmittedFileName());
					imagemRN.atualizar(imagens.get(1));
				}
			}
			if(img3 != null){
				System.out.println("Foi 3");
				imagens.get(2).setImg(ByteStreams.toByteArray(img3.getInputStream()));
				imagemRN = new ImagemRN();
				if(imagens.get(2).getTituloImagem() ==null){
					imagens.get(2).setTituloImagem(img3.getSubmittedFileName());
					imagemRN.salvar(imagens.get(2));
				}else{
					imagens.get(2).setTituloImagem(img3.getSubmittedFileName());
					imagemRN.atualizar(imagens.get(2));
				}
			}
			if(img4 != null){
				System.out.println("Foi 4");
				imagens.get(3).setImg(ByteStreams.toByteArray(img4.getInputStream()));
				imagemRN = new ImagemRN();
				if(imagens.get(3).getTituloImagem() ==null){
					imagens.get(3).setTituloImagem(img4.getSubmittedFileName());
					imagemRN.salvar(imagens.get(3));
				}else{
					imagens.get(3).setTituloImagem(img4.getSubmittedFileName());
					imagemRN.atualizar(imagens.get(3));
				}
			}
			imagemRN = new ImagemRN();
			imagens = imagemRN.listaImagensPorGame(game);
			//ImageIO.write((RenderedImage) img1.getInputStream(),"png", baos);
		}catch (Exception e) {
			System.out.println("Erro:"+e);
			// TODO: handle exception
		}

	
		//Atualizando lista de imagens
		imagemRN = new ImagemRN();
		imagens = imagemRN.listaImagensPorGame(game);
		
	}
	
	public void cadastraVideoGame(){
		youtuberRN = new YoutuberRN();
		video.setYoutuber(youtuberRN.youtuberEscolhidoPorNome(video.getYoutuber().getNome()));
		video.setGame(game);
		videoGameRN = new VideoGameRN();
		videoGameRN.salvar(video);
		videoGameRN = new VideoGameRN();
		videoGames = videoGameRN.listaVideosPorGame(game);
		video = new VideoGame();
	}
	
	public void removeVideoGame(String idVideoGameAlvo){
		videoGameRN = new VideoGameRN();
		video = videoGameRN.consultaVideoGamePorId(idVideoGameAlvo);
		videoGameRN = new VideoGameRN();
		videoGameRN.excluir(video);
		video = new VideoGame();
		videoGameRN = new VideoGameRN();
		videoGames = videoGameRN.listaVideosPorGame(game);
	}
	
	

	public Game getGame() {
		return game;
	}

	public void setGame(Game game) {
		this.game = game;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}



	public List<String> getCategorias() {
		return categorias;
	}

	public void setCategorias(List<String> categorias) {
		this.categorias = categorias;
	}

	public List<String> getFaixas() {
		return faixas;
	}

	public void setFaixas(List<String> faixas) {
		this.faixas = faixas;
	}

	public List<String> getDesenvs() {
		return desenvs;
	}

	public void setDesenvs(List<String> desenvs) {
		this.desenvs = desenvs;
	}

	public Part getImg1() {
		return img1;
	}

	public void setImg1(Part img1) {
		this.img1 = img1;
	}

	public Part getImg2() {
		return img2;
	}

	public void setImg2(Part img2) {
		this.img2 = img2;
	}

	public Part getImg3() {
		return img3;
	}

	public void setImg3(Part img3) {
		this.img3 = img3;
	}

	public Part getImg4() {
		return img4;
	}

	public void setImg4(Part img4) {
		this.img4 = img4;
	}

	public List<Imagem> getImagens() {
		return imagens;
	}

	public void setImagens(List<Imagem> imagens) {
		this.imagens = imagens;
	}

	public List<String> getListaYoutubers() {
		return listaYoutubers;
	}

	public void setListaYoutubers(List<String> listaYoutubers) {
		this.listaYoutubers = listaYoutubers;
	}

	public VideoGame getVideo() {
		return video;
	}

	public void setVideo(VideoGame video) {
		this.video = video;
	}

	public List<VideoGame> getVideoGames() {
		return videoGames;
	}

	public void setVideoGames(List<VideoGame> videoGames) {
		this.videoGames = videoGames;
	}

	public List<String> getConsoles() {
		return consoles;
	}

	public void setConsoles(List<String> consoles) {
		this.consoles = consoles;
	}
	
	
	
	
	
	
}
