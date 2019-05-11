package br.com.futebolmobile.mb;

import java.io.Serializable;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

import br.com.futebolmobile.TX.Transacional;
import br.com.futebolmobile.util.RedirectView;

@Named //anotação do CDI, antes era a anotação @ManagedBean do JSF
@ViewScoped //Essa anotação tem o mesmo nome, mas é de outro pacote: javax.faces.view.ViewScoped
public class HomeMB implements Serializable{

	private static final long serialVersionUID = 1L;

	public RedirectView goToTimes(){
		return new RedirectView("time");
	}
	
	public RedirectView goToJogos(){
		return new RedirectView("jogo");
	}
	
	public RedirectView goToClassificacao(){
		return new RedirectView("classificacao");
	}
	
	public RedirectView goToUsuario(){
		return new RedirectView("usuario");
	}

	public RedirectView goToUsuarioLogin(){
		return new RedirectView("usuarioLogin");
	}

	
}
