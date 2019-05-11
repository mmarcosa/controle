package br.com.futebolmobile.mb;


import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.futebolmobile.facade.UsuarioLoginFacade;
import br.com.futebolmobile.model.UsuarioLogin;
import br.com.futebolmobile.util.RedirectView;

@Named //anota��o do CDI, antes era a anota��o @ManagedBean do JSF
@ViewScoped //Essa anota��o tem o mesmo nome, mas � de outro pacote: javax.faces.view.ViewScoped
public class LoginMB implements Serializable{

	private static final long serialVersionUID = 1L;

	private UsuarioLogin usuarioLogin = new UsuarioLogin();

	@Inject
    FacesContext context;
	
	@Inject
	private UsuarioLoginFacade usuarioLoginFacade;
		
    public UsuarioLogin getUsuarioLogin() {
		return usuarioLogin;
	}

	public void setUsuarioLogin(UsuarioLogin usuarioLogin) {
		this.usuarioLogin = usuarioLogin;
	}

	public RedirectView efetuaLogin() {        
    	System.out.println("Fazendo login do usu�rio " + this.usuarioLogin.getEmail());               	
    	usuarioLogin.setSenha(criptografarSenha());
    	boolean existe = usuarioLoginFacade.exists(this.usuarioLogin);        
        if(existe) {        
        	context.getExternalContext().getSessionMap().put("usuarioLogado", this.usuarioLogin);        	
        	return new RedirectView("inicio");
        }
        
        context.getExternalContext().getFlash().setKeepMessages(true);
        context.addMessage(null, new FacesMessage("Usu�rio n�o encontrado ou senha inv�lida .."));
        
        return new RedirectView("login");
    }
    
    public RedirectView deslogar() {
		
    	FacesContext context = FacesContext.getCurrentInstance();
        context.getExternalContext().getSessionMap().remove("usuarioLogado");

        return new RedirectView("login");
    	
    }
    public String descriptografarSenha() {
    	String senhaDescriptografada;    	
    	senhaDescriptografada = this.usuarioLogin.descriptografiaBase64Decoder(this.usuarioLogin.getSenha());
    	return senhaDescriptografada;
    }
    
	public String criptografarSenha() {
		String senhaCriptografada;
		senhaCriptografada = this.usuarioLogin.criptografiaBase64Encoder(this.usuarioLogin.getSenha());
		return senhaCriptografada;
	}

}
