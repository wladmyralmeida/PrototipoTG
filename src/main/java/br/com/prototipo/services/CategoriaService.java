package br.com.prototipo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import br.com.prototipo.domain.Categoria;
import br.com.prototipo.repositories.CategoriaRepository;
import br.com.prototipo.services.exception.DataIntegrityException;
import br.com.prototipo.services.exception.ObjectNotFoundException;

@Service
public class CategoriaService {

	@Autowired
	private CategoriaRepository repository;

	public Categoria find(Integer id) {
		Optional<Categoria> object = repository.findById(id);
		return object.orElseThrow(() -> new ObjectNotFoundException(
				"Desculpe, seu objeto não foi encontrado! Id: " + id + ", Tipo: " + Categoria.class.getName()));
	}

	public Categoria insert(Categoria cat) {
		cat.setId(null);
		return repository.save(cat);
	}

	public Categoria update(Categoria cat) {
		find(cat.getId());
		return repository.save(cat);
	}

	public void delete(Integer id) {
		find(id);
		try {
			repository.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Não é possível excluir uma Arma que contém Canção.");
		}
	}

	public List<Categoria> findAll() {
		return repository.findAll();	
	}
	
	public Page<Categoria> findPage(Integer page, Integer linesPerPage, String orderBy, String direction){
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		return repository.findAll(pageRequest);
	}
}
