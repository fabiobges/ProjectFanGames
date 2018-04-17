package br.com.fangames.videogame;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import br.com.fangames.game.Game;
import br.com.fangames.youtuber.Youtuber;

@Entity
@Table(name="tb_video_game")
public class VideoGame implements Serializable{
	
	public VideoGame() {
		game = new Game();
		youtuber = new Youtuber();
	}

	private static final long serialVersionUID = 3287785247866694652L;
	
	@Id
	@SequenceGenerator(name = "nm_seq_video_game", sequenceName = "seq_video_game", allocationSize = 1, initialValue = 1)
	@GeneratedValue (strategy = GenerationType.SEQUENCE, generator="nm_seq_video_game")
	private Integer id;
	
	@OneToOne
	@JoinColumn (name="id_game")
	private Game game;
	
	@OneToOne (fetch = FetchType.EAGER)
	@JoinColumn(name="id_youtuber")
	private Youtuber youtuber;
	
	@Column (name="titulo_video")
	private String titulo;
	
	@Column (name="link_video")
	private String link;
	
	@Temporal(TemporalType.DATE)
	@Column (name="dt_publicacao")
	private Date publicacao;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Game getGame() {
		return game;
	}

	public void setGame(Game game) {
		this.game = game;
	}

	public Youtuber getYoutuber() {
		return youtuber;
	}

	public void setYoutuber(Youtuber youtuber) {
		this.youtuber = youtuber;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public Date getPublicacao() {
		return publicacao;
	}

	public void setPublicacao(Date publicacao) {
		this.publicacao = publicacao;
	}
	
	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((game == null) ? 0 : game.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((link == null) ? 0 : link.hashCode());
		result = prime * result + ((publicacao == null) ? 0 : publicacao.hashCode());
		result = prime * result + ((titulo == null) ? 0 : titulo.hashCode());
		result = prime * result + ((youtuber == null) ? 0 : youtuber.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		VideoGame other = (VideoGame) obj;
		if (game == null) {
			if (other.game != null)
				return false;
		} else if (!game.equals(other.game))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (link == null) {
			if (other.link != null)
				return false;
		} else if (!link.equals(other.link))
			return false;
		if (publicacao == null) {
			if (other.publicacao != null)
				return false;
		} else if (!publicacao.equals(other.publicacao))
			return false;
		if (titulo == null) {
			if (other.titulo != null)
				return false;
		} else if (!titulo.equals(other.titulo))
			return false;
		if (youtuber == null) {
			if (other.youtuber != null)
				return false;
		} else if (!youtuber.equals(other.youtuber))
			return false;
		return true;
	}

	
	
	
	
	
	
	

}
