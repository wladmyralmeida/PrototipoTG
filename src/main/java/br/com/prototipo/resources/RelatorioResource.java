package br.com.prototipo.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.prototipo.domain.Relatorio;
import br.com.prototipo.services.RelatorioService;

@RestController
@RequestMapping(value="/relatorios")
public class RelatorioResource {

	@Autowired
	private RelatorioService service;
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<Relatorio> find(@PathVariable Integer id) {
		
		Relatorio relatorio = service.find(id);
		return ResponseEntity.ok().body(relatorio);
		
	}
}