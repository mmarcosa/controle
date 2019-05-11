package br.com.futebolmobile.mb;

import java.io.Serializable;
import java.util.List;

import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.futebolmobile.facade.JogoFacade;
import br.com.futebolmobile.facade.TimeFacade;
import br.com.futebolmobile.model.Jogo;
import br.com.futebolmobile.model.Time;
import br.com.futebolmobile.TX.Transacional;
import br.com.futebolmobile.util.RedirectView;

@Named // anotação do CDI, antes era a anotação do JSF
@ViewScoped // Essa anotação tem o mesmo nome, mas é de outro pacote: javax.faces.view.ViewScoped
public class JogoMB implements Serializable {

	private static final long serialVersionUID = 1L;

	private Jogo jogo = new Jogo();
	
	private Integer jogoId;
	
	private Integer timeId;
	
	@Inject
	private FacesContext context;
		
	@Inject
	private JogoFacade jogoFacade;
	
	@Inject
	private TimeFacade timeFacade;
			
	public JogoMB() {

	}
	
	public Jogo getJogo() {
		return jogo;
	}

	public void setJogo(Jogo jogo) {
		this.jogo = jogo;
	}

	public Integer getJogoId() {
		return jogoId;
	}

	public void setJogoId(Integer jogoId) {
		this.jogoId = jogoId;
	}

	@Transacional
	public RedirectView gravar(){
		System.out.println("Gravando campeonato: " + this.jogo.getEscudos());
		if (this.jogo.getId() == null) {
			jogoFacade.save(this.jogo);
		} else {
			jogoFacade.update(this.jogo);
		}
		this.jogo = new Jogo();
		return new RedirectView("campeonato");
	}
	
	public List<Jogo> getJogos() {
		return jogoFacade.selectAll();
	}

	@Transacional
	public void delete(Jogo jogo) {
		System.out.println("Removendo jogo: " + jogo.getEscudos());
		jogoFacade.delete(jogo);
	}

	public void select(Jogo jogo) {
		System.out.println("Carregando campeonato: " + jogo.getEscudos());
		this.jogo = jogo;
	}

	public void selectById() {
		this.jogo = jogoFacade.selectById(jogoId);
		if (this.jogo == null) {
			this.jogo = new Jogo();
		}
	}
	
	public void adicionaTime() {
		Time time = timeFacade.selectById(this.timeId);
		this.jogo.adicionaTime(time);
	}
	
	public List<Time> getTimes() {
		return timeFacade.selectAll();
	}
	
	public void removeTime(Time time) {
		this.jogo.removeTime(time);
	}

	public Integer getTimeId() {
		return timeId;
	}

	public void setTimeId(Integer timeId) {
		this.timeId = timeId;
	}
		
}
