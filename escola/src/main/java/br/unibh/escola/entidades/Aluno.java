package br.unibh.escola.entidades;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="TB_ALUNO")
@PrimaryKeyJoinColumn
public class Aluno extends Pessoa {

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
