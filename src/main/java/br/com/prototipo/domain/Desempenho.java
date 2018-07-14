package br.com.prototipo.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Desempenho implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String atual;
	private String objetivo;
	private Integer flexao;
	private Integer abdominal;
	private Double corrida;
	private Integer barra;
	private String alerta;

	@OneToOne
	private Usuario usuarioDesempenho;	

	@ManyToOne
	@JoinColumn(name="ranking_id")
	private Ranking desempenhoRanking;
	
	public Desempenho() {
		
	}
	
	public Desempenho(Integer id, String atual, String objetivo, Integer flexao, Integer abdominal, Double corrida,
			Integer barra, String alerta, Usuario usuarioDesempenho) {
		super();
		this.id = id;
		this.atual = atual;
		this.objetivo = objetivo;
		this.flexao = flexao;
		this.abdominal = abdominal;
		this.corrida = corrida;
		this.barra = barra;
		this.alerta = alerta;
		this.usuarioDesempenho = usuarioDesempenho;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getAtual() {
		return atual;
	}

	public void setAtual(String atual) {
		this.atual = atual;
	}

	public String getObjetivo() {
		return objetivo;
	}

	public void setObjetivo(String objetivo) {
		this.objetivo = objetivo;
	}

	public Integer getFlexao() {
		return flexao;
	}

	public void setFlexao(Integer flexao) {
		this.flexao = flexao;
	}

	public Integer getAbdominal() {
		return abdominal;
	}

	public void setAbdominal(Integer abdominal) {
		this.abdominal = abdominal;
	}

	public Double getCorrida() {
		return corrida;
	}

	public void setCorrida(Double corrida) {
		this.corrida = corrida;
	}

	public Integer getBarra() {
		return barra;
	}

	public void setBarra(Integer barra) {
		this.barra = barra;
	}

	public String getAlerta() {
		return alerta;
	}

	public void setAlerta(String alerta) {
		this.alerta = alerta;
	}

	public Usuario getUsuarioDesempenho() {
		return usuarioDesempenho;
	}

	public void setUsuarioDesempenho(Usuario usuarioDesempenho) {
		this.usuarioDesempenho = usuarioDesempenho;
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
		Desempenho other = (Desempenho) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
}
