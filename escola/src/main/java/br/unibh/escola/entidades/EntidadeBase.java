package br.unibh.escola.entidades;

import javax.persistence.MappedSuperclass;
import javax.persistence.Version;

@MappedSuperclass
public class EntidadeBase {
	
	@Version
	private int versao;

	public int getVersao() {
		return versao;
	}

	public void setVersao(int versao) {
		this.versao = versao;
	}
}
