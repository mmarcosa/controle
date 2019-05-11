package br.com.futebolmobile.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Usuario implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue
    private Integer id;
	
	private String nome;
	
	private String local;
	
	private String email;
	
	@ManyToOne
	private Time time;
	
	private String idFacebook;
	
	private Integer status;
	
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

	public String getLocal() {
		return local;
	}

	public void setLocal(String local) {
		this.local = local;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Time getTime() {
		return time;
	}

	public void setTime(Time time) {
		this.time = time;
	}

	public String getIdFacebook() {
		return idFacebook;
	}

	public void setIdFacebook(String idFacebook) {
		this.idFacebook = idFacebook;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}
	
	public String getStatusString() {
		String statusString = "";
		
		if (status == null) {
			statusString = "";
		}
		else if(status == 0){
			statusString = "Bloqueado";
		}
		else if(status == 1){
			statusString = "Desbloqueado";
		}
		return statusString;
	}

	
}
