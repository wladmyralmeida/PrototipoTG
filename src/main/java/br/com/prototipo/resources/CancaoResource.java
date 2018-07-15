package br.com.prototipo.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.prototipo.domain.Cancao;
import br.com.prototipo.services.CancaoService;;

@RestController
@RequestMapping(value="/cancoes")
public class CancaoResource {

	@Autowired
	private CancaoService service;
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<?> find(@PathVariable Integer id) {
		
		Cancao cancao = service.buscarPorId(id);
		return ResponseEntity.ok().body(cancao);
		
	}
}