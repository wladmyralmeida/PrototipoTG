package br.com.prototipo.domain.enums;

public enum TipoUsuario {

	ADMINISTRADOR(1, "Administrador"), USUARIO(2, "Usuário");

	private int cod;
	private String descricao;

	private TipoUsuario(int cod, String descricao) {
		this.cod = cod;
		this.descricao = descricao;
	}

	public int getCod() {
		return cod;
	}

	public String getDescricao() {
		return descricao;
	}

	// Recebe um código e retorna um objeto do TipoUsuario instanciada.
	public static TipoUsuario toEnum(Integer cod) {

		if (cod == null) {
			return null;
		}
		for (TipoUsuario tipo : TipoUsuario.values()) {
			if (cod.equals(tipo.getCod())) {
				return tipo;
			}
		}
		throw new IllegalArgumentException("ID Inválido: " + cod);
	}
}
