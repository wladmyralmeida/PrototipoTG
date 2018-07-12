package br.com.prototipo.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.prototipo.domain.Categoria;
import br.com.prototipo.repositories.CategoriaRepository;
import br.com.prototipo.services.exception.ObjectNotFoundException;

@Service
public class CategoriaService {

	// Automaticamente instanciado.
	@Autowired
	private CategoriaRepository repository;

	public Categoria buscarPorId(Integer id) {
		Optional<Categoria> object = repository.findById(id);
		return object.orElseThrow(() -> new ObjectNotFoundException(
				"Desculpe, seu objeto não foi encontrado! Id: " + id + ", Tipo: " + Categoria.class.getName()));
	}
}
