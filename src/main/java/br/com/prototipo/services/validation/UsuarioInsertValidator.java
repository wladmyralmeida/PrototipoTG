package br.com.prototipo.services.validation;

import java.util.ArrayList;
import java.util.List;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.prototipo.domain.Usuario;
import br.com.prototipo.dto.UsuarioNewDTO;
import br.com.prototipo.repositories.UsuarioRepository;
import br.com.prototipo.services.exception.FieldMessage;

public class UsuarioInsertValidator implements ConstraintValidator<UsuarioInsert, UsuarioNewDTO> {
	
	@Autowired
	private UsuarioRepository repository;
	
	@Override
	public void initialize(UsuarioInsert ann) {
	}

	@Override
	public boolean isValid(UsuarioNewDTO objDto, ConstraintValidatorContext context) {
		
		List<FieldMessage> list = new ArrayList<>();
		/*
		 * Inserir Erros
		if(objDto.getTipo().equals(TipoUsuario.ADMINISTRADOR.getCod() == 1)) {
			list.add(new FieldMessage("Tipo", "Tipo incompatível de Usuário"));
		}
		
		if(objDto.getTipo().equals(TipoUsuario.USUARIO.getCod() != 2)){
			list.add(new FieldMessage("Tipo", "Tipo incompatível de Usuário"));
		}
		 */
		
		Usuario u = repository.findByEmail(objDto.getEmail());
		if(u != null) {
			list.add(new FieldMessage("email", "Email já existente"));
		}
		
		//Pega cada objeto do field message e inserindo o erro correspondente, pegando a mensagem e o nome do campo.
		//Transporta os erros personalizados para a lista de erros do framework. Que será tratada no ExceptionHandler.
		
		for (FieldMessage e : list) {
			context.disableDefaultConstraintViolation();
			context.buildConstraintViolationWithTemplate(e.getMessage()).addPropertyNode(e.getFieldName())
					.addConstraintViolation();
		}
		return list.isEmpty();
	}
}