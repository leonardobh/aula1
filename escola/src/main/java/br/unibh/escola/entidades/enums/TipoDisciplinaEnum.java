package br.unibh.escola.entidades.enums;

public enum TipoDisciplinaEnum {
	
	PRESENCIAL(1,"Presencial"),
	EAD(2,"À Distancia"),
	PEAD(3,"Presencial e à distância");

	private int valor;
	private String descricao;
	
	private TipoDisciplinaEnum(int valor, String descricao) {
		this.valor = valor;
		this.descricao = descricao;
	}
	public int getValor() {
		return valor;
	}
	public void setValor(int valor) {
		this.valor = valor;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public static TipoDisciplinaEnum getEnumByValor(int valor) {
		for(TipoDisciplinaEnum tipoDisciplina : TipoDisciplinaEnum.values()) {
			if(valor == tipoDisciplina.valor) {
				return tipoDisciplina;
			}
		}
		return null;
	}

	
}
