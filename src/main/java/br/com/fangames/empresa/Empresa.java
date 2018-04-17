package br.com.fangames.empresa;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import br.com.fangames.console.Console;

@Entity(name="tb_empresa")
public class Empresa implements Serializable{

	private static final long serialVersionUID = 3092943662033284791L;
	
	@Id
	@SequenceGenerator(name="nm_seq_empresa", sequenceName="seq_empresa", initialValue=6, allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="nm_seq_empresa")
	private int id;
	
	@Column(name="nm_empresa", unique=true, nullable=false)
	private String nome; 
	
	@Temporal(TemporalType.DATE)
	@Column(name="dt_fundacao")
	private Date dt_fundacao;
	
	@OneToMany(mappedBy="empresa")
	private List<Console> consoles;

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

	public Date getDt_fundacao() {
		return dt_fundacao;
	}

	public void setDt_fundacao(Date dt_fundacao) {
		this.dt_fundacao = dt_fundacao;
	}

	public List<Console> getConsoles() {
		return consoles;
	}

	public void setConsoles(List<Console> consoles) {
		this.consoles = consoles;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((consoles == null) ? 0 : consoles.hashCode());
		result = prime * result + ((dt_fundacao == null) ? 0 : dt_fundacao.hashCode());
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
		Empresa other = (Empresa) obj;
		if (consoles == null) {
			if (other.consoles != null)
				return false;
		} else if (!consoles.equals(other.consoles))
			return false;
		if (dt_fundacao == null) {
			if (other.dt_fundacao != null)
				return false;
		} else if (!dt_fundacao.equals(other.dt_fundacao))
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
