package br.unibh.escola.entidades;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="TB_PROFESSOR")
@PrimaryKeyJoinColumn
@NamedQueries({
@NamedQuery(name="Professor.findByName", query = "select p from Professor p where p.nome like :nome")})
public class Professor extends Pessoa{
	

	@NotNull
	@DecimalMin(value="500")
	@DecimalMax(value="50000")
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
