package br.com.prototipo.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import br.com.prototipo.domain.enums.Perfil;
import br.com.prototipo.domain.enums.TipoUsuario;

@Entity
public class Usuario implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nome;
	private Integer numero;
	
	private String email;
	private String senha;
	private String organizacaoMilitar;
	private String pelotao;
	private String patente;
	private String tipoSangue;
	private Integer tipoUsuario;
	private boolean status;

	@ElementCollection
	@CollectionTable(name = "TELEFONE")
	private Set<String> telefones = new HashSet<>();

	@ManyToMany(mappedBy = "usuarios")
	private List<Servico> servicos = new ArrayList<>();

	@JsonIgnore
	@OneToOne(cascade = CascadeType.ALL, mappedBy = "usuarioDesempenho")
	private Desempenho desempenho;

	@JsonIgnore
	@OneToOne(cascade = CascadeType.ALL, mappedBy = "usuarioRelatorio")
	private Relatorio relatorio;

	@JsonIgnore
	@OneToMany(mappedBy = "usuario")
	private List<Pedido> pedido = new ArrayList<>();
	
	@ElementCollection(fetch=FetchType.EAGER)
	@CollectionTable(name="PERFIS")
	private Set<Integer> perfis = new HashSet<>();

	public Usuario() {

	}

	public Usuario(Integer id, String nome, Integer numero, String email, String senha, String organizacaoMilitar, String pelotao,
			String patente, String tipoSangue, TipoUsuario tipoUsuario, boolean status) {
		super();
		this.id = id;
		this.nome = nome;
		this.numero = numero;
		this.email = email;
		this.senha = senha;
		this.organizacaoMilitar = organizacaoMilitar;
		this.pelotao = pelotao;
		this.patente = patente;
		this.tipoSangue = tipoSangue;
		this.tipoUsuario = (tipoUsuario == null) ? null : tipoUsuario.getCod();
		this.status = status;
		addPerfil(Perfil.CLIENTE);
	}

	public Set<Perfil> getPerfis() {
		return perfis.stream().map(x -> Perfil.toEnum(x)).collect(Collectors.toSet());
	}
	
	public void addPerfil(Perfil perfil) {
		perfis.add(perfil.getCod());
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

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
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

	public TipoUsuario getTipoUsuario() {
		return TipoUsuario.toEnum(tipoUsuario);
	}

	public void setTipoUsuario(TipoUsuario tipoUsuario) {
		this.tipoUsuario = tipoUsuario.getCod();
	}

	public Set<String> getTelefones() {
		return telefones;
	}

	public void setTelefones(Set<String> telefones) {
		this.telefones = telefones;
	}
	
	@JsonBackReference
	public List<Servico> getServicos() {
		return servicos;
	}

	public void setServicos(List<Servico> servicos) {
		this.servicos = servicos;
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

	public Desempenho getDesempenho() {
		return desempenho;
	}

	public void setDesempenho(Desempenho desempenho) {
		this.desempenho = desempenho;
	}

	@JsonBackReference
	public Relatorio getRelatorio() {
		return relatorio;
	}

	public void setRelatorio(Relatorio relatorio) {
		this.relatorio = relatorio;
	}
	
	@JsonBackReference
	public List<Pedido> getPedidos() {
		return pedido;
	}

	public void setPedidos(List<Pedido> pedido) {
		this.pedido = pedido;
	}

	public List<Pedido> getPedido() {
		return pedido;
	}

	public void setPedido(List<Pedido> pedido) {
		this.pedido = pedido;
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
		Usuario other = (Usuario) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}
