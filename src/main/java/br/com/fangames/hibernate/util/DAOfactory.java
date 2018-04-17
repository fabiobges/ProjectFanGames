package br.com.fangames.hibernate.util;

import org.hibernate.Session;

import br.com.fangames.console.ConsoleDAO;
import br.com.fangames.console.ConsoleDAOHibernate;
import br.com.fangames.desenvolvedor.DesenvolvedorDAO;
import br.com.fangames.desenvolvedor.DesenvolvedorDAOHibernate;
import br.com.fangames.empresa.EmpresaDAO;
import br.com.fangames.empresa.EmpresaDAOHibernate;
import br.com.fangames.game.GameDAO;
import br.com.fangames.game.GameDAOHibernate;
import br.com.fangames.imagem.ImagemDAO;
import br.com.fangames.imagem.ImagemDAOHibernate;
import br.com.fangames.user.UserDAO;
import br.com.fangames.user.UserDAOHibernate;
import br.com.fangames.videogame.VideoGame;
import br.com.fangames.videogame.VideoGameDAO;
import br.com.fangames.videogame.VideoGameDAOHibernate;
import br.com.fangames.youtuber.YoutuberDAO;
import br.com.fangames.youtuber.YoutuberDAOHibernate;

public class DAOfactory {
	
	public static ConsoleDAO criarConsoleDAO(){
		ConsoleDAOHibernate consoleDAO = new ConsoleDAOHibernate();
		consoleDAO.setSession(HibernateUtil.getSessionFactory().getCurrentSession());
		return consoleDAO;
	}
	
	public static GameDAO criarGameDAO(){
		GameDAOHibernate gameDAO = new GameDAOHibernate();
		gameDAO.setSession(HibernateUtil.getSessionFactory().getCurrentSession());
		return gameDAO;
	}

	public static DesenvolvedorDAO criaDesenvolvedorDAO(){
		DesenvolvedorDAOHibernate desenvDAO = new DesenvolvedorDAOHibernate();
		desenvDAO.setSession(HibernateUtil.getSessionFactory().getCurrentSession());
		return desenvDAO;
	}

	public static EmpresaDAO criaEmpresaDAO(){
		EmpresaDAOHibernate empresaDAO = new EmpresaDAOHibernate();
		empresaDAO.setSession(HibernateUtil.getSessionFactory().getCurrentSession());
		return empresaDAO;
	}
	
	public static UserDAO criaUserDAO(){
		UserDAOHibernate userDAO = new UserDAOHibernate();
		userDAO.setSession(HibernateUtil.getSessionFactory().getCurrentSession());
		return userDAO;
	}
	
	public static YoutuberDAO criaYoutuberDAO(){
		YoutuberDAOHibernate youtuberDAO  = new YoutuberDAOHibernate();
		youtuberDAO.setSession(HibernateUtil.getSessionFactory().getCurrentSession());
		return youtuberDAO;
	}
	
	public static ImagemDAO criaImagemDAO(){
		ImagemDAOHibernate imagemDAO = new ImagemDAOHibernate();
		imagemDAO.setSession(HibernateUtil.getSessionFactory().getCurrentSession());
		return imagemDAO;
	}
	
	public static VideoGameDAO criaVideoGameDAO(){
		VideoGameDAOHibernate videoGameDAOHibernate = new VideoGameDAOHibernate(HibernateUtil.getSessionFactory().getCurrentSession());
		return videoGameDAOHibernate;
	}
}
