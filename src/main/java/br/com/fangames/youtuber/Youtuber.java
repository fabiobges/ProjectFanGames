package br.com.fangames.youtuber;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import br.com.fangames.videogame.VideoGame;

@Entity
@Table (name="tb_youtuber")
public class Youtuber implements Serializable{

	private static final long serialVersionUID = 2782284171521363873L;

	@Id
	@SequenceGenerator(name="nm_seq_youtuber", sequenceName="seq_youtuber", initialValue=1, allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="nm_seq_youtuber")
	private Integer id;
	
	@OneToMany (mappedBy="youtuber",cascade=CascadeType.ALL)
	private List<VideoGame> videoGame;
	
	@Column(name="nm_youtuber", nullable=false, unique=true, length=50)
	private String nome;
	
	@Column(name="desc_youtuber")
	private String descricao;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public List<VideoGame> getVideoGame() {
		return videoGame;
	}

	public void setVideoGame(List<VideoGame> videoGame) {
		this.videoGame = videoGame;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((descricao == null) ? 0 : descricao.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((videoGame == null) ? 0 : videoGame.hashCode());
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
		Youtuber other = (Youtuber) obj;
		if (descricao == null) {
			if (other.descricao != null)
				return false;
		} else if (!descricao.equals(other.descricao))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (videoGame == null) {
			if (other.videoGame != null)
				return false;
		} else if (!videoGame.equals(other.videoGame))
			return false;
		return true;
	}
	
	
	
	
}
