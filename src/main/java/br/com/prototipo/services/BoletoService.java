package br.com.prototipo.services;

import java.util.Calendar;
import java.util.Date;

import org.springframework.stereotype.Service;

import br.com.prototipo.domain.PagamentoComBoleto;

@Service
public class BoletoService {

	//TEM QUE IMPLEMENTAR UM WEBSERVICE QUE GERE UM BOLETO
	public void preencherPagamentoComBoleto(PagamentoComBoleto pagto, Date instanteDoPedido) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(instanteDoPedido);
		calendar.add(Calendar.DAY_OF_MONTH, 30);
		pagto.setDataVencimento(calendar.getTime());
		
	}
}
