package br.com.prototipo.domain.enums;

public enum EstadoPagamento {

	PENDENTE(1, "Pendente"),
	QUITADO(2, "Quitado"), 
	CANCELADO(3, "Cancelado");
	
	private int cod;
	private String descricao;

	private EstadoPagamento(int cod, String descricao) {
		this.cod = cod;
		this.descricao = descricao;
	}

	public int getCod() {
		return cod;
	}

	public String getDescricao() {
		return descricao;
	}

	// Recebe um código e retorna um objeto do EstadoPagamento instanciada.
	public static EstadoPagamento toEnum(Integer cod) {

		if (cod == null) {
			return null;
		}
		for (EstadoPagamento tipo : EstadoPagamento.values()) {
			if (cod.equals(tipo.getCod())) {
				return tipo;
			}
		}
		throw new IllegalArgumentException("ID Inválido: " + cod);
	}
}
