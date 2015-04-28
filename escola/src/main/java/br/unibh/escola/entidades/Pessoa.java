package br.unibh.escola.entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

@Entity	
@Table(name="TB_PESSOA")
@Inheritance(strategy=InheritanceType.JOINED)
public abstract class Pessoa {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank
	@Size(min=5,max=100)
	@Pattern(regexp="^[[ ]|\\p{L}*]+$",message="O nome deve conter letras maiúsculas ou minúsculas, acentuadas ou não")
	@Column(length=100,nullable=false)
	private String nome;
	
	@NotBlank
	@Pattern(regexp="\\d{3}\\.\\d{3}\\.\\d{3}-\\d{2}", message="O cpf deve seguir a máscara xxx.xxx.xxx-xx")
	@Column(unique=true,nullable=false,length=14)
	private String cpf;

	
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

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	
	
	
	

}
