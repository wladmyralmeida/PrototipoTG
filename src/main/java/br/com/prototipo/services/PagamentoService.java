package br.com.prototipo.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.prototipo.domain.Pagamento;
import br.com.prototipo.repositories.PagamentoRepository;
import br.com.prototipo.services.exception.ObjectNotFoundException;

@Service
public class PagamentoService {

	@Autowired
	private PagamentoRepository repository;

	public Pagamento find(Integer id) {
		Optional<Pagamento> object = repository.findById(id);
		return object.orElseThrow(() -> new ObjectNotFoundException(
				"Desculpe, seu objeto não foi encontrado! Id: " + id + ", Tipo: " + Pagamento.class.getName()));
	}
}
