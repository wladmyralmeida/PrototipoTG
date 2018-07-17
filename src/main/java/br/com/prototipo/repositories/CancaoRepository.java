package br.com.prototipo.repositories;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.prototipo.domain.Cancao;
import br.com.prototipo.domain.Categoria;

@Repository
public interface CancaoRepository extends JpaRepository<Cancao, Integer>{

	@Transactional(readOnly=true)
	Page<Cancao> findDistinctByTituloContainingAndCategoriasIn(String titulo, List<Categoria> categorias, Pageable pageRequest);

}
