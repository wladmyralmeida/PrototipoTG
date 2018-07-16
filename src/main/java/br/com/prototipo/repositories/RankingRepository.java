package br.com.prototipo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.prototipo.domain.Ranking;

@Repository
public interface RankingRepository extends JpaRepository<Ranking, Integer>{

}
