package br.unibh.escola.entidades.enums;

public enum StatusEnum {
	
	ATIVO(1,"ATIVO"),
	MANUTENCAO(2,"EM MANUTENÇÃO"),
	DESATIVO(3,"DESATIVO");
	
	private int valor;
	private String descricao;

	private StatusEnum(int valor, String descricao) {
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
	
	public static StatusEnum getByValor(int valor) {
		for(StatusEnum sit : StatusEnum.values()) {
			if(sit.getValor() == valor) {
				return sit;
			}
		}
		return null;
	}
}
