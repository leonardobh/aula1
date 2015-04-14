package br.unibh.escola.visao;

import java.util.List;
import java.util.logging.Logger;

import javax.annotation.ManagedBean;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import br.unibh.escola.entidades.Aluno;
import br.unibh.escola.negocio.ServicoAluno;

@ManagedBean("alunomb")
@ViewScoped
public class ControleAluno {
	
	@Inject
	private Logger log;
	
	@Inject
	private ServicoAluno sa;
	
	private Aluno aluno;
	private String nomeArg;
	private Long id;
	private List<Aluno> listaAluno;
	
	public Logger getLog() {
		return log;
	}
	public void setLog(Logger log) {
		this.log = log;
	}
	public ServicoAluno getSa() {
		return sa;
	}
	public void setSa(ServicoAluno sa) {
		this.sa = sa;
	}
	public Aluno getAluno() {
		return aluno;
	}
	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
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
	public List<Aluno> getListaAluno() {
		return listaAluno;
	}
	public void setListaAluno(List<Aluno> listaAluno) {
		this.listaAluno = listaAluno;
	}
	
	@PostConstruct	
	public void inicializaLista() {
		log.info("Executando MB do Aluno");
		try {
			listaAluno = sa.findAll();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void gravar() {
		FacesMessage facesMsg;
		
		try {
			if (aluno.getId() == null) {
				aluno = sa.insert(aluno);
			} else {
				aluno = sa.update(aluno);
			}
		} catch (Exception e){
			facesMsg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro: "+e.getMessage(), "");
			FacesContext.getCurrentInstance().addMessage("messagePanel", facesMsg);
			return;
		}
			facesMsg = new FacesMessage(FacesMessage.SEVERITY_INFO,
			"Aluno gravado com sucesso!", "");
			FacesContext.getCurrentInstance().addMessage("messagePanel", facesMsg);
	}
	
	public void pesquisar() {
		try {
			listaAluno = sa.findByName(nomeArg);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void novo(){ 
		aluno = new Aluno();
	}
	
	public void cancelar(){
		aluno = null;
	}
	
	public void editar(){
		try {
			aluno = sa.find(id);
			return;
		} catch (Exception e) {
			e.printStackTrace();
		}
		aluno = null;
	}
	
	public void excluir(){
		try {
			sa.delete(sa.find(id));
		} catch (Exception e) {
			e.printStackTrace();
		}
		aluno = null;
	}
	
	

}
