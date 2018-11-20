package br.com.brasileirao.resources;

import java.util.List;

import javax.ws.rs.BeanParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.com.brasileirao.model.domain.Partida;
import br.com.brasileirao.resources.beans.PartidaFilterBean;
import br.com.brasileirao.service.PartidaService;

@Path("/partidas")
@Consumes(MediaType.APPLICATION_JSON + ";charset=utf-8")
@Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
public class PartidaResource {

	private PartidaService service = new PartidaService();

	/**
	 * Metódo que retorna todas as partidas com ou sem recurso de paginação.
	 * 
	 * @param partidaFilter
	 * @return
	 */

	@GET
	public List<Partida> getPartidas(@BeanParam PartidaFilterBean partidaFilter) {
		if ((partidaFilter.getOffset() >= 0) && (partidaFilter.getLimit() > 0)) {
			return service.getPartidasByPagination(partidaFilter.getOffset(), partidaFilter.getLimit());
		}
		return service.getPartidas();
	}

	/**
	 * Metódo que retorna todas as partidas de uma determinada rodada.
	 * 
	 * @param partidaFilter
	 * @return
	 */

	@GET
	@Path("/rodada/{rodadaId}")
	public List<Partida> getPartidasByRounds(@PathParam("rodadaId") int rodada) {
		return service.getPartidasByRound(rodada);
	}

	/**
	 * Metódo que retorna todas as partidas de uma determinado time.
	 * 
	 * @param partidaFilter
	 * @return
	 */
	@GET
	@Path("/time/{time}")
	public List<Partida> getPartidasByTeam(@PathParam("time") String time) {
		return service.getPartidasByTeam(time);
	}

}
