package br.com.futebolmobile.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Classificacao implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue
    private Integer id;
	
	private Integer posicao;
	
	private Integer jogos;
	
	private Integer vitorias;
	
	private Integer saldoGols;
	
	private Integer pontos;
	
	private String grupo;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getPosicao() {
		return posicao;
	}

	public void setPosicao(Integer posicao) {
		this.posicao = posicao;
	}

	public Integer getJogos() {
		return jogos;
	}

	public void setJogos(Integer jogos) {
		this.jogos = jogos;
	}

	public Integer getVitorias() {
		return vitorias;
	}

	public void setVitorias(Integer vitorias) {
		this.vitorias = vitorias;
	}

	public Integer getSaldoGols() {
		return saldoGols;
	}

	public void setSaldoGols(Integer saldoGols) {
		this.saldoGols = saldoGols;
	}

	public Integer getPontos() {
		return pontos;
	}

	public void setPontos(Integer pontos) {
		this.pontos = pontos;
	}

	public String getGrupo() {
		return grupo;
	}

	public void setGrupo(String grupo) {
		this.grupo = grupo;
	}
	
}
