package br.unibh.escola.entidades;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

import br.unibh.escola.entidades.enums.StatusEnum;


@Entity
@Table(name="tb_sala")
@NamedQueries({
@NamedQuery(name="Sala.findByCapacidade", query = "select s from Sala s where s.capacidade >= :capacidade")})
public class Sala extends EntidadeBase {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	@NotEmpty
	@Size(max=10)
	@Column(length=10,nullable=false)
	private String codigo;
	
	@Column(nullable=false)
	private int capacidade;
	
	@Column(name="flg_quadro_branco")
	private boolean possuiQuadroBranco;

	@Column(name="flg_data_show")
	private boolean possuiDataShow;
	
	@Column(name="flg_computador")
	private boolean possuiComputador;
	
	@Size(max=255)
	@Column(length=255)
	private String observacao;
	
	private int status;
	
	@Temporal(TemporalType.DATE)
	@Column(name="data_termino_manut")
	private Date dataTerminoManutencao;
	
	@OneToMany(mappedBy="sala")
	private List<Disciplina> disciplinas;

	public Sala() {
		
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public int getCapacidade() {
		return capacidade;
	}

	public void setCapacidade(int capacidade) {
		this.capacidade = capacidade;
	}

	public boolean isPossuiQuadroBranco() {
		return possuiQuadroBranco;
	}

	public void setPossuiQuadroBranco(boolean possuiQuadroBranco) {
		this.possuiQuadroBranco = possuiQuadroBranco;
	}

	public boolean isPossuiDataShow() {
		return possuiDataShow;
	}

	public void setPossuiDataShow(boolean possuiDataShow) {
		this.possuiDataShow = possuiDataShow;
	}

	public boolean isPossuiComputador() {
		return possuiComputador;
	}

	public void setPossuiComputador(boolean possuiComputador) {
		this.possuiComputador = possuiComputador;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public StatusEnum getStatus() {
		return StatusEnum.getByValor(status);
	}

	public void setStatus(StatusEnum status) {
		this.status = status.getValor();
	}

	public Date getDataTerminoManutencao() {
		return dataTerminoManutencao;
	}

	public void setDataTerminoManutencao(Date dataTerminoManutencao) {
		this.dataTerminoManutencao = dataTerminoManutencao;
	}

	public List<Disciplina> getDisciplinas() {
		return disciplinas;
	}

	public void setDisciplinas(List<Disciplina> disciplinas) {
		this.disciplinas = disciplinas;
	}

	
	
	@Override
	public String toString() {
		return "Sala [id=" + id + ", codigo=" + codigo + ", capacidade="
				+ capacidade + ", possuiQuadroBranco=" + possuiQuadroBranco
				+ ", possuiDataShow=" + possuiDataShow + ", possuiComputador="
				+ possuiComputador + ", observacao=" + observacao + ", status="
				+ status + ", dataTerminoManutencao=" + dataTerminoManutencao
				+ "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Sala other = (Sala) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
