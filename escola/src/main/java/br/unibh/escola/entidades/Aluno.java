package br.unibh.escola.entidades;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

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



	public void setDataAniversario(Date dataAniversario) {
		this.dataAniversario = dataAniversario;
	}
	
	
	
	
	

}
