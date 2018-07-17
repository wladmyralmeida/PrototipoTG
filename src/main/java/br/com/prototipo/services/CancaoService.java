package br.com.prototipo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import br.com.prototipo.domain.Cancao;
import br.com.prototipo.domain.Categoria;
import br.com.prototipo.repositories.CancaoRepository;
import br.com.prototipo.repositories.CategoriaRepository;
import br.com.prototipo.services.exception.ObjectNotFoundException;

@Service
public class CancaoService {

	@Autowired
	private CancaoRepository repository;

	@Autowired
	private CategoriaRepository categoriaRepository;
	
	public Cancao find(Integer id) {
		Optional<Cancao> object = repository.findById(id);
		return object.orElseThrow(() -> new ObjectNotFoundException(
				"Desculpe, seu objeto não foi encontrado! Id: " + id + ", Tipo: " + Cancao.class.getName()));
	}
	
	public Page<Cancao> search(String titulo, List<Integer> ids, Integer page, 
			Integer linesPerPage, String orderBy, String direction){
		
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		
		List<Categoria> categorias = categoriaRepository.findAllById(ids);
		return repository.findDistinctByTituloContainingAndCategoriasIn(titulo, categorias, pageRequest);
	}
}
