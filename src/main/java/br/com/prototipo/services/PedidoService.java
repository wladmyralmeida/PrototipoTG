package br.com.prototipo.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.prototipo.domain.Pedido;
import br.com.prototipo.repositories.PedidoRepository;
import br.com.prototipo.services.exception.ObjectNotFoundException;

@Service
public class PedidoService {

	@Autowired
	private PedidoRepository repository;

	public Pedido buscarPorId(Integer id) {
		Optional<Pedido> object = repository.findById(id);
		return object.orElseThrow(() -> new ObjectNotFoundException(
				"Desculpe, seu objeto não foi encontrado! Id: " + id + ", Tipo: " + Pedido.class.getName()));
	}
}
