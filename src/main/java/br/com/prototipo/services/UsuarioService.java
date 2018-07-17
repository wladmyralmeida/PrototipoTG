package br.com.prototipo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.prototipo.domain.Usuario;
import br.com.prototipo.domain.enums.TipoUsuario;
import br.com.prototipo.dto.UsuarioDTO;
import br.com.prototipo.dto.UsuarioNewDTO;
import br.com.prototipo.repositories.UsuarioRepository;
import br.com.prototipo.services.exception.DataIntegrityException;
import br.com.prototipo.services.exception.ObjectNotFoundException;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository repository;

	public Usuario find(Integer id) {
		Optional<Usuario> object = repository.findById(id);
		return object.orElseThrow(() -> new ObjectNotFoundException(
				"Desculpe, seu objeto não foi encontrado! Id: " + id + ", Tipo: " + Usuario.class.getName()));
	}

	@Transactional
	public Usuario insert(Usuario obj) {
		obj.setId(null);
		return repository.save(obj);
	}

	// Instacia o obj a partir do banco de dados (monitorado pelo jpa)
	// Pega o obj e atualizo os dados com o obj enviado na requisição
	// salva o newobj na base de dados.
	public Usuario update(Usuario obj) {
		Usuario newObj = find(obj.getId());
		updateData(newObj, obj);
		return repository.save(newObj);
	}

	public void delete(Integer id) {
		find(id);
		try {
			repository.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Não é possível excluir porque há domínios relacionados.");
		}
	}

	public List<Usuario> findAll() {
		return repository.findAll();
	}

	public Page<Usuario> findPage(Integer page, Integer linesPerPage, String orderBy, String direction) {
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		return repository.findAll(pageRequest);
	}

	public Usuario fromDTO(UsuarioDTO objDTO) {
		return new Usuario(objDTO.getId(), objDTO.getNome(), objDTO.getNumero(), null, objDTO.getOrganizacaoMilitar(),
				objDTO.getPelotao(), objDTO.getPatente(), objDTO.getTipoSangue(), null, objDTO.getStatus());
	}

	public Usuario fromDTO(UsuarioNewDTO objDTO) {
		Usuario usu = new Usuario(null, objDTO.getNome(), objDTO.getNumero(), objDTO.getSenha(),
				objDTO.getOrganizacaoMilitar(), objDTO.getPelotao(), objDTO.getPatente(), objDTO.getTipoSangue(),
				TipoUsuario.toEnum(objDTO.getTipo()), objDTO.getStatus());
		usu.getTelefones().add(objDTO.getTelefone1());
		if (objDTO.getTelefone2() != null) {
			usu.getTelefones().add(objDTO.getTelefone2());
		}
		if (objDTO.getTelefone3() != null) {
			usu.getTelefones().add(objDTO.getTelefone3());
		}
		return usu;
	}

	private void updateData(Usuario newObj, Usuario obj) {
		newObj.setNome(obj.getNome());
		newObj.setNumero(obj.getNumero());
		newObj.setOrganizacaoMilitar(obj.getOrganizacaoMilitar());
		newObj.setPelotao(obj.getPelotao());
		newObj.setPatente(obj.getPatente());
		newObj.setTipoSangue(obj.getTipoSangue());
		newObj.setStatus(obj.getStatus());
	}
}
