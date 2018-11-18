package br.com.brasileirao.service;

import java.util.List;

import br.com.brasileirao.model.dao.PartidaDAO;
import br.com.brasileirao.model.domain.Partida;

public class PartidaService {
	private PartidaDAO dao = new PartidaDAO();
	
	public List<Partida> getPartidas(){
		return dao.getAll();
	}
	
	public List<Partida> getPartidasByRound(Integer rodada) {
		return dao.getByRound(rodada);
	}
	
	public List<Partida> getPartidasByTeam(String time) {
		return dao.getByTeam(time);
	}
	
	public List<Partida> getPartidaByPagination(int firstResult, int maxResults){
		return dao.getByPagination(firstResult, maxResults);
	}
}
