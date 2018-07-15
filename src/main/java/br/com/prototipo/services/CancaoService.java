package br.com.prototipo.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.prototipo.domain.Cancao;
import br.com.prototipo.repositories.CancaoRepository;
import br.com.prototipo.services.exception.ObjectNotFoundException;

@Service
public class CancaoService {

	@Autowired
	private CancaoRepository repository;

	public Cancao buscarPorId(Integer id) {
		Optional<Cancao> object = repository.findById(id);
		return object.orElseThrow(() -> new ObjectNotFoundException(
				"Desculpe, seu objeto não foi encontrado! Id: " + id + ", Tipo: " + Cancao.class.getName()));
	}
}
