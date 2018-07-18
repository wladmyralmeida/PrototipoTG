package br.com.prototipo.services;

import org.springframework.mail.SimpleMailMessage;

import br.com.prototipo.domain.Pedido;
import br.com.prototipo.domain.Usuario;

public interface EmailService {

	void sendOrderConfirmationEmail(Pedido obj);
	
	void sendEmail(SimpleMailMessage msg);
	
	void sendNewPasswordEmail(Usuario usuario, String newPass);
}
