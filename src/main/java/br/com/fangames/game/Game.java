package br.com.fangames.game;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.Size;


import br.com.fangames.consolegame.ConsoleGame;
import br.com.fangames.desenvolvedor.Desenvolvedor;
import br.com.fangames.imagem.Imagem;
import br.com.fangames.videogame.VideoGame;
import java.util.Objects;

@Entity
@Table(name="tb_game")
public class Game implements Serializable {
	
	public Game() {
		consGames = new ArrayList<>();
		vidGames = new ArrayList<>();
		imagens = new ArrayList<>();
	}

	private static final long serialVersionUID = 5380801723979234124L;

	@Id
	@SequenceGenerator(name="nm_seq_game",sequenceName="seq_game",allocationSize=1,initialValue=1)
	@GeneratedValue(generator="nm_seq_game",strategy=GenerationType.SEQUENCE)
	@Column(name="id_game",unique=true)
	private Integer id;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="id_desenvolvedor")
	private Desenvolvedor desenvolvedor;
     
	
	@OneToMany(mappedBy="game", fetch=FetchType.LAZY,cascade= CascadeType.ALL)
	private List<ConsoleGame> consGames;
	
	@OneToMany(mappedBy="game", fetch=FetchType.LAZY,cascade=CascadeType.ALL)
	private List<VideoGame> vidGames;
	
	@Column(name="nm_game", nullable=false, unique=true, length=100)
	@Size(max=100,min=1)
	private String nome;
	
	@Column(name="cat_game",length=50)
	private String categoria;
	
	@Column(name="faixa_etaria")
	@Size(max=2)
	private String faixa;
	
	@Column(name="desc_game")
	private String descricao;
	
	@Column(name="dicas_game")
	private String dicas;
	
	@OneToMany(mappedBy="game",fetch = FetchType.LAZY, cascade = CascadeType.ALL )
	private List<Imagem> imagens;
	



	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Desenvolvedor getDesenvolvedor() {
		return desenvolvedor;
	}

	public void setDesenvolvedor(Desenvolvedor desenvolvedor) {
		this.desenvolvedor = desenvolvedor;
	}

    
        
	public List<ConsoleGame> getConsGames() {
		return consGames;
	}

	public void setConsGames(List<ConsoleGame> consGames) {
		this.consGames = consGames;
	}

	public List<VideoGame> getVidGames() {
		return vidGames;
	}

	public void setVidGames(List<VideoGame> vidGames) {
		this.vidGames = vidGames;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome.trim();
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public String getFaixa() {
		return faixa;
	}

	public void setFaixa(String faixa) {
		this.faixa = faixa;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public List<Imagem> getImagens() {
		return imagens;
	}

	public void setImagens(List<Imagem> imagens) {
		this.imagens = imagens;
	}

	public String getDicas() {
		return dicas;
	}

	public void setDicas(String dicas) {
		this.dicas = dicas;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 41 * hash + Objects.hashCode(this.id);
        hash = 41 * hash + Objects.hashCode(this.desenvolvedor);
        hash = 41 * hash + Objects.hashCode(this.consGames);
        hash = 41 * hash + Objects.hashCode(this.vidGames);
        hash = 41 * hash + Objects.hashCode(this.nome);
        hash = 41 * hash + Objects.hashCode(this.categoria);
        hash = 41 * hash + Objects.hashCode(this.faixa);
        hash = 41 * hash + Objects.hashCode(this.descricao);
        hash = 41 * hash + Objects.hashCode(this.dicas);
        hash = 41 * hash + Objects.hashCode(this.imagens);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Game other = (Game) obj;
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        if (!Objects.equals(this.categoria, other.categoria)) {
            return false;
        }
        if (!Objects.equals(this.faixa, other.faixa)) {
            return false;
        }
        if (!Objects.equals(this.descricao, other.descricao)) {
            return false;
        }
        if (!Objects.equals(this.dicas, other.dicas)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.desenvolvedor, other.desenvolvedor)) {
            return false;
        }
        if (!Objects.equals(this.consGames, other.consGames)) {
            return false;
        }
        if (!Objects.equals(this.vidGames, other.vidGames)) {
            return false;
        }
        if (!Objects.equals(this.imagens, other.imagens)) {
            return false;
        }
        return true;
    }

	

	

	

}
