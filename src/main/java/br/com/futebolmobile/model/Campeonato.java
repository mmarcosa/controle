package br.com.futebolmobile.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity
public class Campeonato implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue
    private Integer id;
	
	private String nome;
	
	private String alias;

	@ManyToMany(fetch=FetchType.EAGER)
	@Fetch(FetchMode.SUBSELECT)
	private List<Jogo> jogos = new ArrayList<Jogo>();
	
	@ManyToMany(fetch=FetchType.EAGER)
	@Fetch(FetchMode.SUBSELECT)
	private List<Classificacao> classificacao = new ArrayList<Classificacao>();
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getAlias() {
		return alias;
	}

	public void setAlias(String alias) {
		this.alias = alias;
	}

	public List<Jogo> getJogos() {
		return jogos;
	}

	public void setJogos(List<Jogo> jogos) {
		this.jogos = jogos;
	}
	
	public void adicionaJogo(Jogo jogo) {
		this.jogos.add(jogo);
	}
	
	public void removeJogo(Jogo jogo) {
		this.jogos.remove(jogo);
	}

	public List<Classificacao> getClassificacao() {
		return classificacao;
	}

	public void setClassificacao(List<Classificacao> classificacao) {
		this.classificacao = classificacao;
	}
	
}
