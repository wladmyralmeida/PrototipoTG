package br.com.prototipo.domain;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Entity
public class ItemPedido implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private ItemPedidoPK id = new ItemPedidoPK();
	
	private Integer quantidade;
	private double desconto;
	private double preco;

	public ItemPedido() {
		
	}

	public ItemPedido(Pedido pedido, Cancao cancao, Integer quantidade, double desconto, double preco) {
		super();
		id.setPedido(pedido);
		id.setCancao(cancao);
		this.quantidade = quantidade;
		this.desconto = desconto;
		this.preco = preco;
	}

	public Pedido getPedido() {
		return id.getPedido();
	}
	
	public Cancao getCancao() {
		return id.getCancao();
	}
	
	public ItemPedidoPK getId() {
		return id;
	}

	public void setId(ItemPedidoPK id) {
		this.id = id;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public double getDesconto() {
		return desconto;
	}

	public void setDesconto(double desconto) {
		this.desconto = desconto;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
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
		ItemPedido other = (ItemPedido) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
}
