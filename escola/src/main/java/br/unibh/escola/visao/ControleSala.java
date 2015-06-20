package br.unibh.escola.visao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import br.unibh.escola.entidades.Sala;
import br.unibh.escola.entidades.enums.StatusEnum;
import br.unibh.escola.negocio.ServicoSala;

@ManagedBean(name="salamb")
@ViewScoped
public class ControleSala {
	
	@Inject
	private Logger log;
	
	@Inject
	private ServicoSala ss;
	
	private Sala sala;
	private Integer capacidadeArg;
	private Long id;
	private List<Sala> listaSala;
	private List<StatusEnum> listaStatus;
	
	public Logger getLog() {
		return log;
	}
	public void setLog(Logger log) {
		this.log = log;
	}
	public ServicoSala getSa() {
		return ss;
	}
	public void setSa(ServicoSala ss) {
		this.ss = ss;
	}
	public Sala getSala() {
		return sala;
	}
	public void setSala(Sala sala) {
		this.sala = sala;
	}
	public Integer getCapacidadeArg() {
		return capacidadeArg;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public List<Sala> getListaSala() {
		return listaSala;
	}
	public void setListaSala(List<Sala> listaSala) {
		this.listaSala = listaSala;
	}
	
	public List<StatusEnum> getListaStatus() {
		return listaStatus;
	}
	public void setListaStatus(List<StatusEnum> listaStatus) {
		this.listaStatus = listaStatus;
	}
	public void setCapacidadeArg(Integer capacidadeArg) {
		this.capacidadeArg = capacidadeArg;
	}
	@PostConstruct	
	public void inicializaLista() {
		log.info("Executando MB da Sala");
		try {
			listaSala = ss.findAll();
			listaStatus = Arrays.asList(StatusEnum.values());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void gravar() {
		FacesMessage facesMsg;
		
		try {
			if (sala.getId() == null) {
				sala = ss.insert(sala);
			} else {
				sala = ss.update(sala);
			}
			atualizaLista();
		} catch (Exception e){
			facesMsg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro: "+e.getMessage(), "");
			FacesContext.getCurrentInstance().addMessage("messagePanel", facesMsg);
			return;
		}
			facesMsg = new FacesMessage(FacesMessage.SEVERITY_INFO,
			"Sala gravado com sucesso!", "");
			FacesContext.getCurrentInstance().addMessage("messagePanel", facesMsg);
	}
	
	public void pesquisar() {
		try {
			listaSala = ss.findByCapacidade(capacidadeArg);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void novo(){ 
		sala = new Sala();
		listaSala = new ArrayList<Sala>();
	}
	
	public void cancelar(){
		sala = null;
		pesquisar();
	}
	
	public void editar(){
		try {
			sala = ss.find(id);
			return;
		} catch (Exception e) {
			e.printStackTrace();
		}
		sala = null;
		atualizaLista();
	}
	
	public void excluir(){
		try {
			ss.delete(ss.find(id));
		} catch (Exception e) {
			e.printStackTrace();
		}
		sala = null;
		atualizaLista();
	}
	
	private void atualizaLista() {
		try {
			listaSala = ss.findAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	

}
