package br.com.fangames.youtuber;

import java.util.ArrayList;
import java.util.List;

import br.com.fangames.hibernate.util.DAOfactory;

public class YoutuberRN {
	
	YoutuberDAO youtuberDAO;
	
	public YoutuberRN(){
		youtuberDAO = DAOfactory.criaYoutuberDAO();
	}
	
	public void salvar(Youtuber youtuber){
		youtuberDAO.salvar(youtuber);
	}
	
	public void excluir(Youtuber youtuber){
		youtuberDAO.excluir(youtuber);
	}
	
	public void atualizar(Youtuber youtuber){
		youtuberDAO.atualizar(youtuber);
	}
	
	public List<Youtuber> listaYoutuber(){
		return youtuberDAO.listaYoutuber();
	}
	
	public List<String> listaNomesYoutubers(){
		List <Youtuber> youtubers = youtuberDAO.listaYoutuber();
		List<String> listaNomesYotubers = new ArrayList<>();
		for(Youtuber yout:youtubers){
			listaNomesYotubers.add(yout.getNome());
		}
		return listaNomesYotubers;
	}
	
	public Youtuber youtuberEscolhidoPorNome(String nomeYoutuber){
		return youtuberDAO.youtuberEscolhidoPorNome(nomeYoutuber.replace("[", "").replace("]", ""));
	}
	
	public Youtuber consultaYoutuberPorId(String idYoutuber){
		return youtuberDAO.consultaYoutuberPorId(idYoutuber.replace("[", "").replace("]", ""));
	}

}
