package br.com.fangames.consolegame;

import java.io.Serializable;
import java.util.Date;

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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Cascade;

import br.com.fangames.console.Console;
import br.com.fangames.game.Game;

@Entity
@Table(name="tb_console_game")
public class ConsoleGame implements Serializable{

	private static final long serialVersionUID = -1386179846122808510L;
	
	@Id
	@SequenceGenerator(name="nm_seq_console_game",sequenceName="seq_console_game",allocationSize=1,initialValue=1)
	@GeneratedValue(generator="nm_seq_console_game",strategy=GenerationType.SEQUENCE)
	@Column(name="id_console_game")
	private Integer id;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="id_console")
	private Console console;
	
	@ManyToOne
	@JoinColumn(name="id_game")
	private Game game;
	
	@Temporal(TemporalType.DATE)
	@Column(name="dt_lanc_game")
	private Date dt_lancamento;

	@Column(name="qtd_vendidos")
	private Integer qtd_vendidos;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Console getConsole() {
		return console;
	}

	public void setConsole(Console console) {
		this.console = console;
	}

	public Game getGame() {
		return game;
	}

	public void setGame(Game game) {
		this.game = game;
	}

	public Date getDt_lancamento() {
		return dt_lancamento;
	}

	public void setDt_lancamento(Date dt_lancamento) {
		this.dt_lancamento = dt_lancamento;
	}

	public Integer getQtd_vendidos() {
		return qtd_vendidos;
	}

	public void setQtd_vendidos(Integer qtd_vendidos) {
		this.qtd_vendidos = qtd_vendidos;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((console == null) ? 0 : console.hashCode());
		result = prime * result + ((dt_lancamento == null) ? 0 : dt_lancamento.hashCode());
		result = prime * result + ((game == null) ? 0 : game.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((qtd_vendidos == null) ? 0 : qtd_vendidos.hashCode());
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
		ConsoleGame other = (ConsoleGame) obj;
		if (console == null) {
			if (other.console != null)
				return false;
		} else if (!console.equals(other.console))
			return false;
		if (dt_lancamento == null) {
			if (other.dt_lancamento != null)
				return false;
		} else if (!dt_lancamento.equals(other.dt_lancamento))
			return false;
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
		if (qtd_vendidos == null) {
			if (other.qtd_vendidos != null)
				return false;
		} else if (!qtd_vendidos.equals(other.qtd_vendidos))
			return false;
		return true;
	}
	
	
}
