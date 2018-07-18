package br.com.prototipo.services;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import br.com.prototipo.domain.Cancao;
import br.com.prototipo.domain.Categoria;
import br.com.prototipo.domain.Desempenho;
import br.com.prototipo.domain.Estudo;
import br.com.prototipo.domain.ItemPedido;
import br.com.prototipo.domain.Pagamento;
import br.com.prototipo.domain.PagamentoComBoleto;
import br.com.prototipo.domain.PagamentoComCartao;
import br.com.prototipo.domain.Pedido;
import br.com.prototipo.domain.Ranking;
import br.com.prototipo.domain.Relatorio;
import br.com.prototipo.domain.Servico;
import br.com.prototipo.domain.Usuario;
import br.com.prototipo.domain.enums.EstadoPagamento;
import br.com.prototipo.domain.enums.Perfil;
import br.com.prototipo.domain.enums.TipoUsuario;
import br.com.prototipo.repositories.CancaoRepository;
import br.com.prototipo.repositories.CategoriaRepository;
import br.com.prototipo.repositories.ItemPedidoRepository;
import br.com.prototipo.repositories.PagamentoRepository;
import br.com.prototipo.repositories.PedidoRepository;
import br.com.prototipo.repositories.UsuarioRepository;

@Service
public class DBService {

	@Autowired
	private BCryptPasswordEncoder pe;
	@Autowired
	private CategoriaRepository categoriaRepository;
	@Autowired
	private CancaoRepository produtoRepository;
	@Autowired
	private UsuarioRepository usuarioRepository;
	@Autowired
	private PedidoRepository pedidoRepository;
	@Autowired
	private PagamentoRepository pagamentoRepository;
	@Autowired
	private ItemPedidoRepository itemPedidoRepository;
	
	public void instantiateTestDatabase() throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");

		Categoria cat1 = new Categoria(null, "Infantaria");
		Categoria cat2 = new Categoria(null, "Cavalaria");
		Categoria cat3 = new Categoria(null, "Artilharia");
		Categoria cat4 = new Categoria(null, "Comunicações");
		Categoria cat5 = new Categoria(null, "Polícia Militar");
		Categoria cat6 = new Categoria(null, "Diversas");

		Cancao c1 = new Cancao(null, "Olha a Dona Mag",
				"Olha a Dona MAG no Terreno camuflada, Pronta para ser a qualquer hora acionada.", 12.0);

		Cancao c2 = new Cancao(null, "Olê mulher rendeira",
				"Olê mulher rendeira, Olê mulher rendá, Tu me ensina a fazer renda.", 10.0);

		Cancao c3 = new Cancao(null, "Fui chamado pra guerrear", "Fui chamado para guerrear mas na hora h, quem diria.",
				15.0);

		cat1.getCancoes().addAll(Arrays.asList(c1, c3));
		cat5.getCancoes().addAll(Arrays.asList(c2));

		c1.getCategorias().addAll(Arrays.asList(cat1, cat5));
		c2.getCategorias().addAll(Arrays.asList(cat5));
		c3.getCategorias().addAll(Arrays.asList(cat1));


		Servico s1 = new Servico(null, sdf.parse("09/10/2018 07:00"));
		Servico s2 = new Servico(null, sdf.parse("20/10/2018 19:00"));
		Servico s3 = new Servico(null, sdf.parse("11/05/2018 07:00"));

		
		Estudo e1 = new Estudo(null, "Provas", "Prova EsFCEx");
		Estudo e2 = new Estudo(null, "Slides", "Slide Escolta Ofensiva");
		Estudo e3 = new Estudo(null, "Material Diverso", "Como calcular Azimute");

		categoriaRepository.saveAll(Arrays.asList(cat1, cat2, cat3, cat4, cat5, cat6));
		produtoRepository.saveAll(Arrays.asList(c1, c2, c3));
		
		
		Usuario usu1 = new Usuario(null, "wlad almeida", 32, "wladmyr@gmail.com", "www", "TG-07002", "Charlie", "Cabo",
				"A+", TipoUsuario.ADMINISTRADOR, true);

		Usuario usu2 = new Usuario(null, "almeida32", 23, "www@gmail.com", "wlad23", "TG-07002", "Bravo", "Sub-Tenente",
				"O-", TipoUsuario.ADMINISTRADOR, true);
		usu2.addPerfil(Perfil.ADMIN);
		
		usu1.getServicos().addAll(Arrays.asList(s1, s2));
		usu2.getServicos().addAll(Arrays.asList(s3));

		usu1.getTelefones().addAll(Arrays.asList("3421-1114", "98713-7778"));
		usu2.getTelefones().addAll(Arrays.asList("3423-1123", "98630-7204"));

		s1.getUsuarios().addAll(Arrays.asList(usu1, usu2));
		s2.getUsuarios().addAll(Arrays.asList(usu1));
		s3.getUsuarios().addAll(Arrays.asList(usu2));
		
		Ranking rk1 = new Ranking(null, "Conjunto Completo Exército Brasileiro");
		rk1.getUsuarios().add(usu1);
		rk1.getUsuarios().add(usu2);
		
		Desempenho dp1 = new Desempenho(null, "4 Km de Corrida", "7 Km de Corrida", 45, 30, 4.5, 15,
				"Melhorar Abdominais", usu1);
		Desempenho dp2 = new Desempenho(null, "3 Séries de 5 Barras", "3 Séries de 8 Barras", 25, 100, 7.0, 10,
				"Melhorar Flexões", usu2);

		usu1.setDesempenho(dp1);
		usu2.setDesempenho(dp2);

		Relatorio r1 = new Relatorio(null, "0", "1", "Participou da Corrida da Fogueira", usu1);
		Relatorio r2 = new Relatorio(null, "1", "0", "Puxou TFM, Doou Sangue", usu2);

		usu1.setRelatorio(r1);
		usu2.setRelatorio(r2);

		usuarioRepository.saveAll(Arrays.asList(usu1, usu2));
		
		Pedido ped1 = new Pedido(null, sdf.parse("30/09/2017 10:32"), usu1);
		Pedido ped2 = new Pedido(null, sdf.parse("10/10/2017 19:35"), usu1);
		
		Pagamento pagto1 = new PagamentoComCartao(null, EstadoPagamento.QUITADO, ped1, 6);
		ped1.setPagamento(pagto1);
		
		Pagamento pagto2 = new PagamentoComBoleto(null, EstadoPagamento.PENDENTE, ped2, sdf.parse("20/10/2017 00:00"), null);
		ped2.setPagamento(pagto2);
		
		usu1.getPedidos().addAll(Arrays.asList(ped1, ped2));
		
		pedidoRepository.saveAll(Arrays.asList(ped1, ped2));
		pagamentoRepository.saveAll(Arrays.asList(pagto1, pagto2));
		
		ItemPedido ip1 = new ItemPedido(ped1, c1, 0.00, 1, 2000.00);
		ItemPedido ip2 = new ItemPedido(ped1, c3, 0.00, 2, 80.00);
		ItemPedido ip3 = new ItemPedido(ped2, c2, 100.00, 1, 800.00);
		
		ped1.getItens().addAll(Arrays.asList(ip1, ip2));
		ped2.getItens().addAll(Arrays.asList(ip3));
		
		c1.getItens().addAll(Arrays.asList(ip1));
		c2.getItens().addAll(Arrays.asList(ip3));
		c3.getItens().addAll(Arrays.asList(ip2));
		
		itemPedidoRepository.saveAll(Arrays.asList(ip1, ip2, ip3));		
	}
}
