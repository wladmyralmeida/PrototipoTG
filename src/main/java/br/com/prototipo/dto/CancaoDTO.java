package br.com.prototipo.dto;

import java.io.Serializable;

import br.com.prototipo.domain.Cancao;

public class CancaoDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String titulo;
	private String descricao;
	
	public CancaoDTO() {
		
	}
	
	public CancaoDTO(Cancao obj) {
		id = obj.getId();
		titulo = obj.getTitulo();
		descricao = obj.getDescricao();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
}
