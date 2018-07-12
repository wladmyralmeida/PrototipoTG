package br.com.prototipo.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.prototipo.domain.Categoria;
import br.com.prototipo.services.CategoriaService;

@RestController
@RequestMapping(value="/categorias")
public class CategoriaResource {

	@Autowired
	private CategoriaService service;
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<?> find(@PathVariable Integer id) {
		
		Categoria cat = service.buscarPorId(id);
		return ResponseEntity.ok().body(cat);
		
	}
}


//O controlador REST acessa os Services, os Services acessam os Repositories. 

//No End Point /categorias, além de buscar a categoria, também deve buscar pelo seu /id.

//Para que o spring saiba que o id da url é do id da variável, tem que incluir PathVariable.

//ResponseEntity encapsula informações de uma resposta http para um serviço REST.