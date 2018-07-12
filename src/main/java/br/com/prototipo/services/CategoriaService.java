package br.com.prototipo.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.prototipo.domain.Categoria;
import br.com.prototipo.repositories.CategoriaRepository;

@Service
public class CategoriaService {

	//Automaticamente instanciado.
	@Autowired
	private CategoriaRepository repository;
	
	public Categoria buscarPorId(Integer id) {
		Optional<Categoria> cat =  repository.findById(id);
		return cat.orElse(null);
		
	}
}
