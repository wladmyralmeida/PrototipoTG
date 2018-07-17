package br.com.prototipo.dto;

import java.io.Serializable;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import br.com.prototipo.services.validation.UsuarioInsert;


@UsuarioInsert
public class UsuarioNewDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@NotEmpty(message="Preenchimento obrigatório")
	@Length(min=5, max=120, message="O tamanho deve ser entre 5 e 120 caracteres")
	private String nome;
	private Integer numero;

	@Email
	private String email;
	private String organizacaoMilitar;
	private String pelotao;
	private String patente;
	private String tipoSangue;
	private boolean status;
	private Integer tipo;
	@NotEmpty(message="Preenchimento obrigatório")
	private String senha;
	
	@NotEmpty(message="Preenchimento obrigatório")
	private String telefone1;

	private String telefone2;
	
	private String telefone3;
	
	public UsuarioNewDTO() {
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getOrganizacaoMilitar() {
		return organizacaoMilitar;
	}

	public void setOrganizacaoMilitar(String organizacaoMilitar) {
		this.organizacaoMilitar = organizacaoMilitar;
	}

	public String getPelotao() {
		return pelotao;
	}

	public void setPelotao(String pelotao) {
		this.pelotao = pelotao;
	}

	public String getPatente() {
		return patente;
	}

	public void setPatente(String patente) {
		this.patente = patente;
	}

	public String getTipoSangue() {
		return tipoSangue;
	}

	public void setTipoSangue(String tipoSangue) {
		this.tipoSangue = tipoSangue;
	}

	public boolean getStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public Integer getTipo() {
		return tipo;
	}

	public void setTipo(Integer tipo) {
		this.tipo = tipo;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getTelefone1() {
		return telefone1;
	}

	public void setTelefone1(String telefone1) {
		this.telefone1 = telefone1;
	}

	public String getTelefone2() {
		return telefone2;
	}

	public void setTelefone2(String telefone2) {
		this.telefone2 = telefone2;
	}

	public String getTelefone3() {
		return telefone3;
	}

	public void setTelefone3(String telefone3) {
		this.telefone3 = telefone3;
	}
}
