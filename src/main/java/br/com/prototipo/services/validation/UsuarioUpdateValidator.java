package br.com.prototipo.services.validation;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerMapping;

import br.com.prototipo.domain.Usuario;
import br.com.prototipo.dto.UsuarioDTO;
import br.com.prototipo.repositories.UsuarioRepository;
import br.com.prototipo.resources.exception.FieldMessage;

public class UsuarioUpdateValidator implements ConstraintValidator<UsuarioUpdate, UsuarioDTO> {

	@Autowired
	private UsuarioRepository repository;
	
	@Autowired
	private HttpServletRequest request;

	@Override
	public void initialize(UsuarioUpdate ann) {
	}

	@Override
	public boolean isValid(UsuarioDTO objDto, ConstraintValidatorContext context) {

		@SuppressWarnings("unchecked")
		Map<String, String> map = (Map<String, String>) request.getAttribute(HandlerMapping.URI_TEMPLATE_VARIABLES_ATTRIBUTE);
		Integer uriId = Integer.parseInt(map.get("id"));
		
		List<FieldMessage> list = new ArrayList<>();
		
		//Tentando atualizar um Usuário contendo um email que já tinha em um outro Usuário. Não pode repetir.
		Usuario u = repository.findByEmail(objDto.getEmail());
		if(u != null && !u.getId().equals(uriId)) {
			list.add(new FieldMessage("email", "Email já existente"));
		}
		 
		for (FieldMessage e : list) {
			context.disableDefaultConstraintViolation();
			context.buildConstraintViolationWithTemplate(e.getMessage()).addPropertyNode(e.getFieldName())
					.addConstraintViolation();
		}
		return list.isEmpty();
	}
}