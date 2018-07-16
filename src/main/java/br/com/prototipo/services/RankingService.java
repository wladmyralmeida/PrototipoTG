package br.com.prototipo.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.prototipo.domain.Ranking;
import br.com.prototipo.repositories.RankingRepository;
import br.com.prototipo.services.exception.ObjectNotFoundException;

@Service
public class RankingService {

	@Autowired
	private RankingRepository repository;

	public Ranking buscarPorId(Integer id) {
		Optional<Ranking> object = repository.findById(id);
		return object.orElseThrow(() -> new ObjectNotFoundException(
				"Desculpe, seu objeto não foi encontrado! Id: " + id + ", Tipo: " + Ranking.class.getName()));
	}
}
