package br.com.prototipo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.prototipo.domain.Relatorio;

@Repository
public interface RelatorioRepository extends JpaRepository<Relatorio, Integer>{

}
