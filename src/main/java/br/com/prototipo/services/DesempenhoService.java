package br.com.prototipo.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.prototipo.domain.Desempenho;
import br.com.prototipo.repositories.DesempenhoRepository;
import br.com.prototipo.services.exception.ObjectNotFoundException;

@Service
public class DesempenhoService {

	@Autowired
	private DesempenhoRepository repository;

	public Desempenho buscarPorId(Integer id) {
		Optional<Desempenho> object = repository.findById(id);
		return object.orElseThrow(() -> new ObjectNotFoundException(
				"Desculpe, seu objeto não foi encontrado! Id: " + id + ", Tipo: " + Desempenho.class.getName()));
	}
}
