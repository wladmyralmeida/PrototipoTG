package br.com.prototipo.dto;

import java.io.Serializable;

import br.com.prototipo.domain.Categoria;

public class CategoriaDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer id;
	private String arma;
	
	public CategoriaDTO() {
		
	}
	public CategoriaDTO(Categoria obj) {
		id = obj.getId();
		arma = obj.getArma();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getArma() {
		return arma;
	}

	public void setArma(String arma) {
		this.arma = arma;
	}
}
