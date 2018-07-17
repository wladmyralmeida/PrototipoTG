package br.com.prototipo.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.prototipo.domain.Cancao;
import br.com.prototipo.dto.CancaoDTO;
import br.com.prototipo.resources.utils.URL;
import br.com.prototipo.services.CancaoService;;

@RestController
@RequestMapping(value="/cancoes")
public class CancaoResource {

	@Autowired
	private CancaoService service;
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<Cancao> find(@PathVariable Integer id) {
		Cancao cancao = service.find(id);
		return ResponseEntity.ok().body(cancao);
		
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<Page<CancaoDTO>> findPage(
			@RequestParam(value="titulo", defaultValue="0") String titulo,
			@RequestParam(value="categorias", defaultValue="0") String categorias,
			@RequestParam(value="page", defaultValue="0") Integer page,
			@RequestParam(value="linesPerPage", defaultValue="24") Integer linesPerPage,
			@RequestParam(value="orderBy", defaultValue="arma") String orderBy, 
			@RequestParam(value="direction", defaultValue="ASC") String direction) {
		
		String tituloDecoded = URL.decodeParam(titulo);
		List<Integer> ids = URL.decodeIntList(categorias);
		Page<Cancao> list = service.search(tituloDecoded, ids, page, linesPerPage, orderBy, direction);
		
		Page<CancaoDTO> listDTO = list.map(obj -> new CancaoDTO(obj));
		return ResponseEntity.ok().body(listDTO);
	}
}