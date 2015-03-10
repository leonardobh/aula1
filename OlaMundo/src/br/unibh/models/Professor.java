package br.unibh.models;

import java.math.BigDecimal;

public class Professor extends Pessoa{
	
	public static final double BONUS = 0.10;

	private BigDecimal salario;
	
	public Professor() {
		
	}
	
	public Professor(Long id,String nome, String cpf, BigDecimal salario) {
		super(id,nome,cpf);
		this.salario = salario;
	}
	
	public Professor(Long id,String nome, String cpf) {
		super(id,nome,cpf);
	}

	public BigDecimal getSalario() {
		return salario;
	}
	public void setSalario(BigDecimal salario) {
		this.salario = salario;
	}

	@Override
	public String toString() {
		return "Professor [nome=" + this.getNome() + ", cpf=" + this.getCpf() + ", salario="
				+ salario + "]";
	}
	
}
