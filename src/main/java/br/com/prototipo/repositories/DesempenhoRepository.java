package br.com.prototipo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.prototipo.domain.Desempenho;

@Repository
public interface DesempenhoRepository extends JpaRepository<Desempenho, Integer>{

}
