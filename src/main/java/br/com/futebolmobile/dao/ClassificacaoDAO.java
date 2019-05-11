package br.com.futebolmobile.dao;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import br.com.futebolmobile.model.Classificacao;

public class ClassificacaoDAO implements Serializable{

	private static final long serialVersionUID = 1L;

	@Inject
    EntityManager entityManager;

	private DAO<Classificacao> dao;

	@PostConstruct //o CDI vai chamar esse método assim que inicializar essa classe
    void init() {
        this.dao = new DAO<Classificacao>(entityManager, Classificacao.class);
    }

	public Classificacao selectById(Integer classificacaoId) {
        return this.dao.selectById(classificacaoId);
    }

    public void save(Classificacao classificacao) {
    	this.dao.save(classificacao);
    }

    public void update(Classificacao classificacao) {
    	this.dao.update(classificacao);
    }

    public void delete(Classificacao classificacao) {
    	this.dao.delete(classificacao);
    }

    public List<Classificacao> selectAll() {
        return this.dao.selectAll();
    }

}