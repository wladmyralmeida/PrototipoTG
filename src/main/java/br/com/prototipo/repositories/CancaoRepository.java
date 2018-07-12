package br.com.prototipo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.prototipo.domain.Cancao;

@Repository
public interface CancaoRepository extends JpaRepository<Cancao, Integer>{

}
