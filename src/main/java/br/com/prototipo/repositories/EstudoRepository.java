package br.com.prototipo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.prototipo.domain.Estudo;

@Repository
public interface EstudoRepository extends JpaRepository<Estudo, Integer>{

}
