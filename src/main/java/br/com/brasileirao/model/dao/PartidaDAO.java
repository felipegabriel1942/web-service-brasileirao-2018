package br.com.brasileirao.model.dao;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.brasileirao.exceptions.DAOException;
import br.com.brasileirao.exceptions.ErrorCode;
import br.com.brasileirao.model.domain.Partida;

public class PartidaDAO {

	public List<Partida> getAll() {
		EntityManager em = JPAUtil.getEntityManager();
		List<Partida> partidas = null;

		try {
			partidas = em.createQuery("select p from Partida p", Partida.class).getResultList();

		} catch (RuntimeException ex) {
			throw new DAOException("Erro ao recuperar todos os produtos do banco:" + ex.getMessage(),
					ErrorCode.SERVER_ERROR.getCode());
		} finally {
			em.close();
		}

		return partidas;
	}

	public List<Partida> getByRodada(Integer rodada) {
		EntityManager em = JPAUtil.getEntityManager();
		List<Partida> partidas = null;

		if (rodada <= 0) {
			throw new DAOException("O número da rodada precisa ser maior do que 0.", ErrorCode.SERVER_ERROR.getCode());
		}

		try {
			partidas = em.createQuery("select p from Partida p where p.rodada = :numRodada", Partida.class)
					.setParameter("numRodada", rodada)
					.getResultList();
		} catch (RuntimeException ex) {
			throw new DAOException("Erro ao buscar partidas no banco de dados: " + ex.getMessage(),
					ErrorCode.SERVER_ERROR.getCode());
		} finally {
			em.close();
		}

		if (partidas == null) {
			throw new DAOException("A rodada de número " + rodada + " não existe.", ErrorCode.NOT_FOUND.getCode());
		}

		return partidas;
	}
	
	public List<Partida> getByTime(String time) {
		EntityManager em = JPAUtil.getEntityManager();
		List<Partida> partidas = null;

		try {
			partidas = em.createQuery("select p from Partida p where p.mandante = :nomeTime or p.visitante = :nomeTime", Partida.class)
					.setParameter("nomeTime", "%" + time + "%")
					.getResultList();
		} catch (RuntimeException ex) {
			throw new DAOException("Erro ao buscar partidas no banco de dados: " + ex.getMessage(),
					ErrorCode.SERVER_ERROR.getCode());
		} finally {
			em.close();
		}

		if(partidas.isEmpty()) {
			throw new DAOException("A consulta não encontrou partidas.", ErrorCode.NOT_FOUND.getCode());
		}

		return partidas;
	}
}
