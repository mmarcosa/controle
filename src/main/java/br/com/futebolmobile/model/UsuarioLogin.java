package br.com.futebolmobile.model;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.apache.commons.codec.binary.Base64;

import br.com.futebolmobile.facade.UsuarioLoginFacade;

@Entity
public class UsuarioLogin implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Inject
	private UsuarioLoginFacade usuarioLoginFacade;
	
	@Id
    @GeneratedValue
    private Integer id;
    private String email;
    private String senha;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
	
    public List<UsuarioLogin>usuarios(){
    	return usuarioLoginFacade.selectAll();
    }
    
    public static String criptografiaBase64Encoder(String senha) {
        return new Base64().encodeToString(senha.getBytes());
    }
    public static String descriptografiaBase64Decoder(String senha) {
        return new String(new Base64().decode(senha));
    }
    
    
}
