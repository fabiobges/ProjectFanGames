package br.com.fangames.imagem;

import java.util.Arrays;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import br.com.fangames.game.Game;

@Entity
@Table(name="tb_imagem_game")
public class Imagem {
	
	@Id
	@SequenceGenerator(name="nm_seq_img",sequenceName="seq_img",allocationSize=1,initialValue=1)
	@GeneratedValue(generator="nm_seq_img",strategy=GenerationType.SEQUENCE)
	@Column(name="id_img_game")
	private int id;
	
	@ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	@JoinColumn(name="id_game")
	private Game game;
	
	@Column(name="titulo_img")
	private String tituloImagem;
	
	@Column(name="img")
	private byte[] img;

	
	
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

	public String getTituloImagem() {
		return tituloImagem;
	}

	public void setTituloImagem(String tituloImagem) {
		this.tituloImagem = tituloImagem;
	}

	public byte[] getImg() {
		return img;
	}

	public void setImg(byte[] img) {
		this.img = img;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((game == null) ? 0 : game.hashCode());
		result = prime * result + id;
		result = prime * result + Arrays.hashCode(img);
		result = prime * result + ((tituloImagem == null) ? 0 : tituloImagem.hashCode());
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
		Imagem other = (Imagem) obj;
		if (game == null) {
			if (other.game != null)
				return false;
		} else if (!game.equals(other.game))
			return false;
		if (id != other.id)
			return false;
		if (!Arrays.equals(img, other.img))
			return false;
		if (tituloImagem == null) {
			if (other.tituloImagem != null)
				return false;
		} else if (!tituloImagem.equals(other.tituloImagem))
			return false;
		return true;
	}

	
	
	

	

}
