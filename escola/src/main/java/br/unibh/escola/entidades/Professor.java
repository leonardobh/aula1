package br.unibh.escola.entidades;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name="TB_PROFESSOR")
public class Professor extends Pessoa{
	

	@NotNull
	@Size(min=500,max=5000)
	@Column(nullable=false)
	private BigDecimal salario;
	
	public Professor() {
		
	}

	public BigDecimal getSalario() {
		return salario;
	}
	public void setSalario(BigDecimal salario) {
		this.salario = salario;
	}

	
}
