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
	@Pattern(regexp="[A-Za-zÀ-ú]*")
	@Column(length=100,nullable=false)
	private String nome;
	
	@NotBlank
	@Size(min=14,max=14)
	@Pattern(regexp="\\d{3}\\.\\d{3}\\.\\d{3}-\\d{2}")
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