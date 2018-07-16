package br.com.prototipo.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.prototipo.domain.Pagamento;
import br.com.prototipo.services.PagamentoService;

@RestController
@RequestMapping(value="/pagamentos")
public class PagamentoResource {

	@Autowired
	private PagamentoService service;
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<Pagamento> find(@PathVariable Integer id) {
		
		Pagamento cancao = service.find(id);
		return ResponseEntity.ok().body(cancao);
		
	}
}