package br.unibh.escola.entidades;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="TB_ALUNO")
@PrimaryKeyJoinColumn
@NamedQueries({
@NamedQuery(name="Aluno.findByName", query = "select a from Aluno a where a.nome like :nome")})
public class Aluno extends Pessoa {

	@NotNull
	@Column(unique=true)
	private Long matricula;
	
	@NotNull
	@Temporal(TemporalType.DATE)
	@Column(name="data_aniversario",nullable=false)
	private Date dataAniversario;
	
	@ManyToMany(mappedBy="alunos")
	private List<Disciplina> disciplinas;
	
	public Aluno() {
		
	}



	public Long getMatricula() {
		return matricula;
	}



	public void setMatricula(Long matricula) {
		this.matricula = matricula;
	}



	public Date getDataAniversario() {
		return dataAniversario;
	}





	@Override
	public String toString() {
		return "Aluno [matricula=" + matricula + ", dataAniversario="
				+ dataAniversario + ", disciplinas=" + disciplinas
				+ ", toString()=" + super.toString() + "]";
	}



	public void setDataAniversario(Date dataAniversario) {
		this.dataAniversario = dataAniversario;
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result
				+ ((matricula == null) ? 0 : matricula.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Aluno other = (Aluno) obj;
		if (matricula == null) {
			if (other.matricula != null)
				return false;
		} else if (!matricula.equals(other.matricula))
			return false;
		return true;
	}

}
