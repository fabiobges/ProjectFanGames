package br.com.fangames.console;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import br.com.fangames.consolegame.ConsoleGame;
import br.com.fangames.empresa.Empresa;




@Entity
@Table(name="tb_console")
public class Console implements Serializable{
	
	public Console(){
		empresa = new Empresa();
		consgames = new ArrayList<>();
	}
	

	private static final long serialVersionUID = 6335766158900928631L;

	@SequenceGenerator(name="nm_seq_console",sequenceName="seq_console",allocationSize=1,initialValue=1)
	@GeneratedValue(generator="nm_seq_console",strategy=GenerationType.SEQUENCE)
	@Id
	@Column(name="id_console", unique=true)
	private int id;
	
	@Column(name="nm_console",nullable=false,unique=true,length=50)
	private String nome;
	
	@OneToMany(mappedBy="console",fetch=FetchType.LAZY)
	private List<ConsoleGame> consgames;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="id_empresa")
	private Empresa empresa;
	
	/*
	@JoinTable(name="tb_console_game",joinColumns={
								@JoinColumn(name="id_console")},
								inverseJoinColumns={@JoinColumn(name="id_game")})
	private List<Game> games;
	*/
	
	
	@Column(name="dt_lancamento")
	private Date dt_lancamento;
	
	@Column(name="desc_console")
	private String descricao;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}


	public List<ConsoleGame> getConsgames() {
		return consgames;
	}

	public void setConsgames(List<ConsoleGame> consgames) {
		this.consgames = consgames;
	}

	
	public Date getDt_lancamento() {
		return dt_lancamento;
	}

	public void setDt_lancamento(Date dt_lancamento) {
		this.dt_lancamento = dt_lancamento;
	}
    
	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public Empresa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((consgames == null) ? 0 : consgames.hashCode());
		result = prime * result + ((descricao == null) ? 0 : descricao.hashCode());
		result = prime * result + ((dt_lancamento == null) ? 0 : dt_lancamento.hashCode());
		result = prime * result + ((empresa == null) ? 0 : empresa.hashCode());
		result = prime * result + id;
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
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
		Console other = (Console) obj;
		if (consgames == null) {
			if (other.consgames != null)
				return false;
		} else if (!consgames.equals(other.consgames))
			return false;
		if (descricao == null) {
			if (other.descricao != null)
				return false;
		} else if (!descricao.equals(other.descricao))
			return false;
		if (dt_lancamento == null) {
			if (other.dt_lancamento != null)
				return false;
		} else if (!dt_lancamento.equals(other.dt_lancamento))
			return false;
		if (empresa == null) {
			if (other.empresa != null)
				return false;
		} else if (!empresa.equals(other.empresa))
			return false;
		if (id != other.id)
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}

	
	
	

}
