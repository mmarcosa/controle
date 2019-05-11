package br.com.futebolmobile.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Jogo implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue
    private Integer id;

	@OneToMany(fetch=FetchType.EAGER)
	private List<Time> times = new ArrayList<Time>();
	
	private String placar;
	
	private String escudos;
	
	private String descricao;
	
	private String resultado;
	
	private Date dataDoJogo;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getPlacar() {
		return placar;
	}

	public void setPlacar(String placar) {
		this.placar = placar;
	}

	public String getEscudos() {
		return escudos;
	}

	public void setEscudos(String escudos) {
		this.escudos = escudos;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getResultado() {
		return resultado;
	}

	public void setResultado(String resultado) {
		this.resultado = resultado;
	}

	public Date getDataDoJogo() {
		return dataDoJogo;
	}

	public void setDataDoJogo(Date dataDoJogo) {
		this.dataDoJogo = dataDoJogo;
	}

	public List<Time> getTimes() {
		return times;
	}

	public void setTimes(List<Time> times) {
		this.times = times;
	}
	
	public void adicionaTime(Time time) {
		this.times.add(time);
	}
	
	public void removeTime(Time time) {
		this.times.remove(time);
	}
	
	public String getResultadoString() {
		String resultadoString = "";
		
		if (resultado == null) {
			resultadoString = "";
		}
		else if(resultado == "E"){
			resultadoString = "Empate";
		}
		else if(resultado == "V"){
			resultadoString = "Vitória";
		}
		else if(resultado == "D"){
			resultadoString = "Derrota";
		}
		return resultadoString;
	}

}
