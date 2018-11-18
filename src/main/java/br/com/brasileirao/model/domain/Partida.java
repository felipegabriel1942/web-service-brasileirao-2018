package br.com.brasileirao.model.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Partida {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private Integer rodada;
	
	private String mandante;
	
	private String visitante;	
	
	@Column(name = "resultado_mandante")
	private Integer resultadoMandante;
	
	@Column(name = "resultado_visitante")
	private Integer resultadoVisitante;
	
	private Date data;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getRodada() {
		return rodada;
	}

	public void setRodada(Integer rodada) {
		this.rodada = rodada;
	}

	public String getMandante() {
		return mandante;
	}

	public void setMandante(String mandante) {
		this.mandante = mandante;
	}

	public String getVisitante() {
		return visitante;
	}

	public void setVisitante(String visitante) {
		this.visitante = visitante;
	}

	public Integer getResultadoMandante() {
		return resultadoMandante;
	}

	public void setResultadoMandante(Integer resultadoMandante) {
		this.resultadoMandante = resultadoMandante;
	}

	public Integer getResultadoVisitante() {
		return resultadoVisitante;
	}

	public void setResultadoVisitante(Integer resultadoVisitante) {
		this.resultadoVisitante = resultadoVisitante;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}
	
	
	
}
