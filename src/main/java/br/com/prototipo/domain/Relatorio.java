package br.com.prototipo.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Relatorio implements Serializable{
	
private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String presenca;
	private String punicao;
	private String informacaoAdd;
	
	@OneToOne
	private Usuario usuarioRelatorio;
	
	public Relatorio() {
	}

	public Relatorio(Integer id, String presenca, String punicao, String informacaoAdd, Usuario usuarioRelatorio) {
		super();
		this.id = id;
		this.presenca = presenca;
		this.punicao = punicao;
		this.informacaoAdd = informacaoAdd;
		this.usuarioRelatorio = usuarioRelatorio;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getPresenca() {
		return presenca;
	}

	public void setPresenca(String presenca) {
		this.presenca = presenca;
	}

	public String getPunicao() {
		return punicao;
	}

	public void setPunicao(String punicao) {
		this.punicao = punicao;
	}

	public String getInformacaoAdd() {
		return informacaoAdd;
	}

	public void setInformacaoAdd(String informacaoAdd) {
		this.informacaoAdd = informacaoAdd;
	}

	public Usuario getUsuarioRelatorio() {
		return usuarioRelatorio;
	}

	public void setUsuarioRelatorio(Usuario usuarioRelatorio) {
		this.usuarioRelatorio = usuarioRelatorio;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
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
		Relatorio other = (Relatorio) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
}
