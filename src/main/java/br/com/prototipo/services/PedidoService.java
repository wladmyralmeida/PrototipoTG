package br.com.prototipo.services;

import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.prototipo.domain.ItemPedido;
import br.com.prototipo.domain.PagamentoComBoleto;
import br.com.prototipo.domain.Pedido;
import br.com.prototipo.domain.enums.EstadoPagamento;
import br.com.prototipo.repositories.ItemPedidoRepository;
import br.com.prototipo.repositories.PagamentoRepository;
import br.com.prototipo.repositories.PedidoRepository;
import br.com.prototipo.services.exception.ObjectNotFoundException;

@Service
public class PedidoService {

	@Autowired
	private PedidoRepository repository;

	@Autowired
	private BoletoService boletoService;

	@Autowired
	private PagamentoRepository pagamentoRepository;

	@Autowired
	private CancaoService cancaoService;

	@Autowired
	private ItemPedidoRepository ipRepository;

	public Pedido find(Integer id) {
		Optional<Pedido> object = repository.findById(id);
		return object.orElseThrow(() -> new ObjectNotFoundException(
				"Desculpe, seu objeto não foi encontrado! Id: " + id + ", Tipo: " + Pedido.class.getName()));
	}

	// PRECISANDO ATUALIZAR PREÇO NO PEDIDO;
	@Transactional
	public Pedido insert(Pedido obj) {
		obj.setId(null);
		obj.setInstante(new Date());

		obj.getPagamento().setEstado(EstadoPagamento.PENDENTE);
		obj.getPagamento().setPedido(obj);
		if (obj.getPagamento() instanceof PagamentoComBoleto) {
			PagamentoComBoleto pagto = (PagamentoComBoleto) obj.getPagamento();
			boletoService.preencherPagamentoComBoleto(pagto, obj.getInstante());
		}
		obj = repository.save(obj);
		pagamentoRepository.save(obj.getPagamento());

		for (ItemPedido ip : obj.getItens()) {
			ip.setDesconto(0.0);
			ip.setPreco(cancaoService.find(ip.getCancao().getId()).getPreco());
			ip.setPedido(obj);
		}
		ipRepository.saveAll(obj.getItens());
		return obj;

	}
}
