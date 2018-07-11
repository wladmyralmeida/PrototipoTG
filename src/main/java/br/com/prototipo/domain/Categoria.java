package br.com.prototipo.domain;

import java.io.Serializable;

public class Categoria implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;
	private String arma;
	
	public Categoria() {
		
	}
	
	public Categoria(int id, String arma) {
		super();
		this.id = id;
		this.arma = arma;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getArma() {
		return arma;
	}

	public void setArma(String arma) {
		this.arma = arma;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
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
		Categoria other = (Categoria) obj;
		if (id != other.id)
			return false;
		return true;
	}
	
	
	
}
