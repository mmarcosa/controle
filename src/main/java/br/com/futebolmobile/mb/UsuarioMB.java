package br.com.futebolmobile.mb;

import java.io.Serializable;
import java.util.List;

import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.futebolmobile.facade.TimeFacade;
import br.com.futebolmobile.facade.UsuarioFacade;
import br.com.futebolmobile.model.Time;
import br.com.futebolmobile.model.Usuario;
import br.com.futebolmobile.TX.Transacional;
import br.com.futebolmobile.util.RedirectView;

@Named // anotação do CDI, antes era a anotação do JSF
@ViewScoped // Essa anotação tem o mesmo nome, mas é de outro pacote: javax.faces.view.ViewScoped
public class UsuarioMB implements Serializable {

	private static final long serialVersionUID = 1L;

	private Usuario usuario = new Usuario();
	
	private Integer usuarioId;
	
	private Integer timeId;
	
	@Inject
	private FacesContext context;
		
	@Inject
	private UsuarioFacade usuarioFacade;
	
	@Inject
	private TimeFacade timeFacade;
			
	public UsuarioMB() {

	}
		
	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Integer getUsuarioId() {
		return usuarioId;
	}

	public void setUsuarioId(Integer usuarioId) {
		this.usuarioId = usuarioId;
	}

	@Transacional
	public RedirectView gravar(){
		System.out.println("Gravando usuario: " + this.usuario.getEmail());
		if (this.usuario.getId() == null) {
			usuarioFacade.save(this.usuario);
		} else {
			usuarioFacade.update(this.usuario);
		}
		this.usuario = new Usuario();
		return new RedirectView("usuario");
	}
	
	public List<Usuario> getUsuarios() {
		return usuarioFacade.selectAll();
	}

	@Transacional
	public void delete(Usuario usuario) {
		System.out.println("Removendo jogo: " + usuario.getEmail());
		usuarioFacade.delete(usuario);
	}

	public void select(Usuario usuario) {
		System.out.println("Carregando campeonato: " + usuario.getEmail());
		this.usuario = usuario;
	}

	public void selectById() {
		this.usuario = usuarioFacade.selectById(usuarioId);
		if (this.usuario == null) {
			this.usuario = new Usuario();
		}
	}
	
	public List<Time> getTimes() {
		return timeFacade.selectAll();
	}
	
	public Integer getTimeId() {
		return timeId;
	}

	public void setTimeId(Integer timeId) {
		this.timeId = timeId;
	}
		
}
