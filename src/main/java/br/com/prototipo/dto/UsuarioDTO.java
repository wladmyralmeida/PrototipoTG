package br.com.prototipo.dto;

import java.io.Serializable;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import br.com.prototipo.domain.Usuario;
import br.com.prototipo.services.validation.UsuarioUpdate;

@UsuarioUpdate
public class UsuarioDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private Integer id;
	
	@NotEmpty(message="Preenchimento Obrigatório")
	@Length(min=5, max=100, message="O tamanho deve ser entre 5 e 100 caracteres")
	private String nome;
	
	private Integer numero;
	
	@Email
	private String email;
	private String organizacaoMilitar;
	private String pelotao;
	private String patente;
	private String tipoSangue;
	private Integer tipoUsuario;
	private boolean status;
	
	public UsuarioDTO() {
		
	}

	public UsuarioDTO(Usuario obj) {
		id = obj.getId();
		nome = obj.getNome();
		numero = obj.getNumero();
		email = obj.getEmail();
		organizacaoMilitar = obj.getOrganizacaoMilitar();
		pelotao = obj.getPelotao();
		patente = obj.getPatente();
		//TA FALTANDO O TIPO DO USUARIO
		tipoSangue = obj.getTipoSangue();
		status = obj.getStatus();
	}

	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public Integer getTipoUsuario() {
		return tipoUsuario;
	}

	public void setTipoUsuario(Integer tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	}

	public boolean getStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}
}
