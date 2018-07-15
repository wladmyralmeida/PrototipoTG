package br.com.prototipo.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.prototipo.domain.Desempenho;
import br.com.prototipo.services.DesempenhoService;

@RestController
@RequestMapping(value="/desempenhos")
public class DesempenhoResource {

	@Autowired
	private DesempenhoService service;
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<?> find(@PathVariable Integer id) {
		
		Desempenho desempenho = service.buscarPorId(id);
		return ResponseEntity.ok().body(desempenho);
		
	}
}