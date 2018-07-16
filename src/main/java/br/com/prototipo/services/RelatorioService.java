package br.com.prototipo.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.prototipo.domain.Relatorio;
import br.com.prototipo.repositories.RelatorioRepository;
import br.com.prototipo.services.exception.ObjectNotFoundException;

@Service
public class RelatorioService {

	@Autowired
	private RelatorioRepository repository;

	public Relatorio find(Integer id) {
		Optional<Relatorio> object = repository.findById(id);
		return object.orElseThrow(() -> new ObjectNotFoundException(
				"Desculpe, seu objeto não foi encontrado! Id: " + id + ", Tipo: " + Relatorio.class.getName()));
	}
}
