package br.unibh.escola.visao;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import br.unibh.escola.entidades.Professor;
import br.unibh.escola.negocio.ServicoProfessor;

@ManagedBean(name="professormb")
@ViewScoped
public class ControleProfessor {
	
	@Inject
	private Logger log;
	
	@Inject
	private ServicoProfessor sp;
	
	private Professor professor;
	private String nomeArg;
	private Long id;
	private List<Professor> listaProfessor;
	
	public Logger getLog() {
		return log;
	}
	public void setLog(Logger log) {
		this.log = log;
	}
	public ServicoProfessor getSp() {
		return sp;
	}
	public void setSp(ServicoProfessor sp) {
		this.sp = sp;
	}
	public Professor getProfessor() {
		return professor;
	}
	public void setProfessor(Professor professor) {
		this.professor = professor;
	}
	public String getNomeArg() {
		return nomeArg;
	}
	public void setNomeArg(String nomeArg) {
		this.nomeArg = nomeArg;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public List<Professor> getListaProfessor() {
		return listaProfessor;
	}
	public void setListaProfessor(List<Professor> listaProfessor) {
		this.listaProfessor = listaProfessor;
	}
	
	@PostConstruct	
	public void inicializaLista() {
		log.info("Executando MB do Professor");
		try {
			listaProfessor = sp.findAll();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void gravar() {
		FacesMessage facesMsg;
		
		try {
			if (professor.getId() == null) {
				professor = sp.insert(professor);
			} else {
				professor = sp.update(professor);
			}
		} catch (Exception e){
			facesMsg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro: "+e.getMessage(), "");
			FacesContext.getCurrentInstance().addMessage("messagePanel", facesMsg);
			return;
		}
			facesMsg = new FacesMessage(FacesMessage.SEVERITY_INFO,
			"Professor gravado com sucesso!", "");
			FacesContext.getCurrentInstance().addMessage("messagePanel", facesMsg);
	}
	
	public void pesquisar() {
		try {
			listaProfessor = sp.findByName(nomeArg);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void novo(){ 
		professor = new Professor();
		listaProfessor = new ArrayList<Professor>();
	}
	
	public void cancelar(){
		professor = null;
		pesquisar();
	}
	
	public void editar(){
		try {
			professor = sp.find(id);
			return;
		} catch (Exception e) {
			e.printStackTrace();
		}
		professor = null;
	}
	
	public void excluir(){
		try {
			sp.delete(sp.find(id));
		} catch (Exception e) {
			e.printStackTrace();
		}
		professor = null;
		pesquisar();
	}
	
	

}
