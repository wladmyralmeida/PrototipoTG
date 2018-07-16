package br.com.prototipo.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.prototipo.domain.Usuario;
import br.com.prototipo.services.UsuarioService;

@RestController
@RequestMapping(value="/usuarios")
public class UsuarioResource {

	@Autowired
	private UsuarioService service;
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<Usuario> find(@PathVariable Integer id) {
		
		Usuario usuario = service.find(id);
		return ResponseEntity.ok().body(usuario);
		
	}
}


//O controlador REST acessa os Services, os Services acessam os Repositories. 

//No End Point /Usuarios, além de buscar a Usuario, também deve buscar pelo seu /id.

//Para que o spring saiba que o id da url é do id da variável, tem que incluir PathVariable.

//ResponseEntity encapsula informações de uma resposta http para um serviço REST.