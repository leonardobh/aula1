package br.unibh.escola.visao;

import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

import br.unibh.escola.entidades.Aluno;
import br.unibh.escola.entidades.Disciplina;
import br.unibh.escola.entidades.Professor;
import br.unibh.escola.entidades.Sala;
import br.unibh.escola.entidades.enums.TipoDisciplinaEnum;
import br.unibh.escola.negocio.ServicoAluno;
import br.unibh.escola.negocio.ServicoDisciplina;
import br.unibh.escola.negocio.ServicoProfessor;
import br.unibh.escola.negocio.ServicoSala;

@ManagedBean(name="disciplinamb")
@ViewScoped
public class ControleDisciplina {
	

	@Inject
	private Logger log;
	
	@Inject
	private ServicoDisciplina sd;
	
	@Inject
	private ServicoProfessor sp;
	
	@Inject
	private ServicoSala ss;
	
	@Inject
	private ServicoAluno sa;
	
	private Disciplina disciplina;
	private String nomeArg;
	private String cursoArg;
	private Long id;
	private List<Disciplina> listaDisciplina;
	private List<Professor> listaProfessor;
	private List<Sala> listaSala;
	private List<TipoDisciplinaEnum> listaTipoDisciplina;
	private List<Aluno> listaAlunos;
	private List<Aluno> listaAlunosSelecionados;
	
	public Logger getLog() {
		return log;
	}
	public void setLog(Logger log) {
		this.log = log;
	}
	public ServicoDisciplina getSa() {
		return sd;
	}
	public void setSa(ServicoDisciplina sa) {
		this.sd = sa;
	}
	public Disciplina getDisciplina() {
		return disciplina;
	}
	public void setDisciplina(Disciplina disciplina) {
		this.disciplina = disciplina;
	}
	public String getNomeArg() {
		return nomeArg;
	}
	public void setNomeArg(String nomeArg) {
		this.nomeArg = nomeArg;
	}
	public String getCursoArg() {
		return cursoArg;
	}
	public void setCursoArg(String cursoArg) {
		this.cursoArg = cursoArg;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public List<Disciplina> getListaDisciplina() {
		return listaDisciplina;
	}
	public void setListaDisciplina(List<Disciplina> listaDisciplina) {
		this.listaDisciplina = listaDisciplina;
	}
	public List<Professor> getListaProfessor() {
		return listaProfessor;
	}
	public void setListaProfessor(List<Professor> listaProfessor) {
		this.listaProfessor = listaProfessor;
	}
	public List<Sala> getListaSala() {
		return listaSala;
	}
	public void setListaSala(List<Sala> listaSala) {
		this.listaSala = listaSala;
	}
	
	public List<TipoDisciplinaEnum> getListaTipoDisciplina() {
		return listaTipoDisciplina;
	}
	public void setListaTipoDisciplina(List<TipoDisciplinaEnum> listaTipoDisciplina) {
		this.listaTipoDisciplina = listaTipoDisciplina;
	}
	
	public List<Aluno> getListaAlunos() {
		return listaAlunos;
	}
	public void setListaAlunos(List<Aluno> listaAlunos) {
		this.listaAlunos = listaAlunos;
	}
	public List<Aluno> getListaAlunosSelecionados() {
		return listaAlunosSelecionados;
	}
	public void setListaAlunosSelecionados(List<Aluno> listaAlunosSelecionados) {
		this.listaAlunosSelecionados = listaAlunosSelecionados;
	}
	@PostConstruct	
	public void inicializaLista() {
		log.info("Executando MB do Disciplina");
		try {
			listaDisciplina = sd.findAll();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public void carregarTab(ActionEvent ae)
	{
	   System.out.println(ae.getComponent().getId());
	}
	
	public void gravar() {
		FacesMessage facesMsg;
		
		try {
			if (disciplina.getId() == null) {
				disciplina = sd.insert(disciplina);
			} else {
				disciplina = sd.update(disciplina);
			}
		} catch (Exception e){
			facesMsg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro: "+e.getMessage(), "");
			FacesContext.getCurrentInstance().addMessage("messagePanel", facesMsg);
			return;
		}
			facesMsg = new FacesMessage(FacesMessage.SEVERITY_INFO,
			"Disciplina gravado com sucesso!", "");
			FacesContext.getCurrentInstance().addMessage("messagePanel", facesMsg);
	}
	
	public void pesquisar() {
		try {
			listaDisciplina = sd.findByNomeOuCurso(nomeArg, cursoArg);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void novo(){ 
		try{
			disciplina = new Disciplina();
			listaProfessor = sp.findAll();
			listaSala = ss.findAll();
			listaAlunos = sa.findAll();
			listaTipoDisciplina = Arrays.asList(TipoDisciplinaEnum.values());
			listaDisciplina = null;
		}catch(Exception e) {
			FacesContext.getCurrentInstance().addMessage("messagePanel", new FacesMessage(FacesMessage.SEVERITY_ERROR,e.getMessage(), ""));
		}
	}
	
	public void cancelar(){
		disciplina = null;
		listaAlunosSelecionados = null;
		listaAlunos = null;
		try {
			listaDisciplina = sd.findAll();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void editar(){
		try {
			novo();
			disciplina = sd.findComAlunos(id);
			listaDisciplina = null;
			return;
		} catch (Exception e) {
			e.printStackTrace();
		}
		disciplina = null;
	}
	
	public void excluir(){
		try {
			sd.delete(sd.find(id));
		} catch (Exception e) {
			e.printStackTrace();
		}
		disciplina = null;
		pesquisar();
	}

}
