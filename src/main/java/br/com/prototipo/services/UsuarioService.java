package br.com.prototipo.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.prototipo.domain.Usuario;
import br.com.prototipo.repositories.UsuarioRepository;
import br.com.prototipo.services.exception.ObjectNotFoundException;

@Service
public class UsuarioService {

	// Automaticamente instanciado.
	@Autowired
	private UsuarioRepository repository;

	public Usuario buscarPorId(Integer id) {
		Optional<Usuario> object = repository.findById(id);
		return object.orElseThrow(() -> new ObjectNotFoundException(
				"Desculpe, seu objeto não foi encontrado! Id: " + id + ", Tipo: " + Usuario.class.getName()));
	}
}
