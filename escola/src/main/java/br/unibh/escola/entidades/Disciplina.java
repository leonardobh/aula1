package br.unibh.escola.entidades;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

import br.unibh.escola.entidades.enums.TipoDisciplinaEnum;

@NamedQueries({
	@NamedQuery(name="Disciplina.findByNomeOuCurso",query="select d from Disciplina d where d.nome like :nome and d.curso like :curso")
})
@Entity
@Table(name="tb_disciplina")
public class Disciplina extends EntidadeBase {
	
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Id
	private Long id;

	@Size(max=100)
	@NotBlank
	@Column(length=100,nullable=false)
	private String nome;
	
	@Size(max=100)
	@NotBlank
	@Column(length=100,nullable=false)
	private String curso;
	
	@Max(value=160)
	@Min(value=0)
	@Column(nullable=false)
	private int cargaHoraria;
	
	@Column(nullable=false)
	private int tipo;
	
	@Size(max=4000)
	@NotBlank
	@Column(length=4000,nullable=false)
	private String ementa;

	@Size(max=4000)
	@NotBlank
	@Column(length=4000,nullable=false)
	private String bibliografia;
	
	@Size(max=4000)
	@NotBlank
	@Column(length=4000,nullable=false)
	private String distribuicaoAvaliacao;
	
	@Size(max=4000)
	@Column(length=4000)
	private String observacao;
	
	@NotEmpty
	@ManyToMany(cascade={CascadeType.ALL})
	@JoinTable(name="tb_disciplina_tem_alunos",
	joinColumns={@JoinColumn(name="id_disciplina_fk",referencedColumnName="id")},
	inverseJoinColumns={@JoinColumn(name="id_aluno_fk",referencedColumnName="id")})
	private List<Aluno> alunos;
	
	@NotNull
	@ManyToOne(optional=false)
	@JoinColumn(name="id_professor_fk",nullable=false)
	private Professor professor;
	
	@NotNull
	@ManyToOne(optional=false)
	@JoinColumn(name="id_sala_fk",nullable=false)
	private Sala sala;
	
	public Disciplina() {
		this.sala = new Sala();
		this.professor = new Professor();
		this.alunos = new ArrayList<Aluno>();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCurso() {
		return curso;
	}

	public void setCurso(String curso) {
		this.curso = curso;
	}

	public int getCargaHoraria() {
		return cargaHoraria;
	}

	public void setCargaHoraria(int cargaHoraria) {
		this.cargaHoraria = cargaHoraria;
	}

	public TipoDisciplinaEnum getTipo() {
		return TipoDisciplinaEnum.getEnumByValor(tipo);
	}

	public void setTipo(TipoDisciplinaEnum tipo) {
		this.tipo = tipo.getValor();
	}

	public String getEmenta() {
		return ementa;
	}

	public void setEmenta(String ementa) {
		this.ementa = ementa;
	}

	public String getBibliografia() {
		return bibliografia;
	}

	public void setBibliografia(String bibliografia) {
		this.bibliografia = bibliografia;
	}

	public String getDistribuicaoAvaliacao() {
		return distribuicaoAvaliacao;
	}

	public void setDistribuicaoAvaliacao(String distribuicaoAvaliacao) {
		this.distribuicaoAvaliacao = distribuicaoAvaliacao;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public List<Aluno> getAlunos() {
		return alunos;
	}

	public void setAlunos(List<Aluno> alunos) {
		this.alunos = alunos;
	}

	public Professor getProfessor() {
		return professor;
	}

	public void setProfessor(Professor professor) {
		this.professor = professor;
	}

	public Sala getSala() {
		return sala;
	}

	public void setSala(Sala sala) {
		this.sala = sala;
	}
}
