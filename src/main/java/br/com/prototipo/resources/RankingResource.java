package br.com.prototipo.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.prototipo.domain.Ranking;
import br.com.prototipo.services.RankingService;

@RestController
@RequestMapping(value="/ranking")
public class RankingResource {

	@Autowired
	private RankingService service;
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<?> find(@PathVariable Integer id) {
		
		Ranking ranking = service.buscarPorId(id);
		return ResponseEntity.ok().body(ranking);
		
	}
}