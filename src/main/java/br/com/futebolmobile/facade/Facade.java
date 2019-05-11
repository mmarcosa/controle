package br.com.futebolmobile.facade;

import java.io.Serializable;

public abstract class Facade implements Serializable{

	private static final long serialVersionUID = 1L;
	
	public abstract void save();
	
	public abstract void update();
	
	public abstract void delete();
	
	public abstract void select();

}
