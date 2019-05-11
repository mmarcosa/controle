package br.com.futebolmobile.facade;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;

import br.com.futebolmobile.dao.CampeonatoDAO;
import br.com.futebolmobile.model.Campeonato;

public class CampeonatoFacade extends Facade implements Serializable{

	private static final long serialVersionUID = 1L;

	@Inject 
	private CampeonatoDAO dao;
	
	public void save(Campeonato campeonato) {
		dao.save(campeonato);
	}
	
	public void update(Campeonato campeonato) {
		dao.update(campeonato);
	}
	
    public List<Campeonato> selectAll() {
        return this.dao.selectAll();
    }
	
    public void delete(Campeonato campeonato) {
    	dao.delete(campeonato);
    }
    
	public Campeonato selectById(Integer campeonatoId) {
        return this.dao.selectById(campeonatoId);
    }

	@Override
	public void save() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void select() {
		// TODO Auto-generated method stub
		
	}

}
