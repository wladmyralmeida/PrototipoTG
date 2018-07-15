package br.com.prototipo;

import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.prototipo.domain.Cancao;
import br.com.prototipo.domain.Categoria;
import br.com.prototipo.domain.Desempenho;
import br.com.prototipo.domain.Estudo;
import br.com.prototipo.domain.ItemPedido;
import br.com.prototipo.domain.Pagamento;
import br.com.prototipo.domain.PagamentoComBoleto;
import br.com.prototipo.domain.PagamentoComCartao;
import br.com.prototipo.domain.Pedido;
import br.com.prototipo.domain.Relatorio;
import br.com.prototipo.domain.Servico;
import br.com.prototipo.domain.Usuario;
import br.com.prototipo.domain.enums.EstadoPagamento;
import br.com.prototipo.domain.enums.TipoUsuario;
import br.com.prototipo.repositories.CancaoRepository;
import br.com.prototipo.repositories.CategoriaRepository;
import br.com.prototipo.repositories.DesempenhoRepository;
import br.com.prototipo.repositories.EstudoRepository;
import br.com.prototipo.repositories.ItemPedidoRepository;
import br.com.prototipo.repositories.PagamentoRepository;
import br.com.prototipo.repositories.PedidoRepository;
import br.com.prototipo.repositories.RelatorioRepository;
import br.com.prototipo.repositories.ServicoRepository;
import br.com.prototipo.repositories.UsuarioRepository;

@SpringBootApplication
public class PrototipoTgApplication implements CommandLineRunner {

	@Autowired
	private CategoriaRepository categoriaRep;
	@Autowired
	private CancaoRepository cancaoRep;
	@Autowired
	private ServicoRepository servicoRep;
	@Autowired
	private UsuarioRepository usuarioRep;
	@Autowired
	private DesempenhoRepository desempenhoRep;
	@Autowired
	private RelatorioRepository relatorioRep;
	@Autowired
	private EstudoRepository estudoRep;
	@Autowired
	private PedidoRepository pedRep;
	@Autowired
	private PagamentoRepository pagRep;
	@Autowired
	private ItemPedidoRepository itemPedRep;

	public static void main(String[] args) {
		SpringApplication.run(PrototipoTgApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");

		Categoria cat1 = new Categoria(null, "Infantaria");
		Categoria cat2 = new Categoria(null, "Cavalaria");
		Categoria cat3 = new Categoria(null, "Artilharia");
		Categoria cat4 = new Categoria(null, "Comunicações");
		Categoria cat5 = new Categoria(null, "Diversas");

		Cancao c1 = new Cancao(null, "Olha a Dona Mag",
				"Olha a Dona MAG no Terreno camuflada, Pronta para ser a qualquer hora acionada.");

		Cancao c2 = new Cancao(null, "Olê mulher rendeira",
				"Olê mulher rendeira, Olê mulher rendá, Tu me ensina a fazer renda.");

		Cancao c3 = new Cancao(null, "Fui chamado pra guerrear",
				"Fui chamado para guerrear mas na hora h, quem diria.");

		cat1.getCancoes().addAll(Arrays.asList(c1, c3));
		cat5.getCancoes().addAll(Arrays.asList(c2));

		c1.getCategorias().addAll(Arrays.asList(cat1, cat5));
		c2.getCategorias().addAll(Arrays.asList(cat5));
		c3.getCategorias().addAll(Arrays.asList(cat1));

		Usuario usu1 = new Usuario(null, "wlad almeida", 32, "www", "TG-07002", "Charlie", "Cabo", "A+",
				TipoUsuario.ADMINISTRADOR, true);

		Usuario usu2 = new Usuario(null, "almeida32", 23, "wlad23", "TG-07002", "Bravo", "Sub-Tenente", "O-",
				TipoUsuario.ADMINISTRADOR, true);

		Servico s1 = new Servico(null, sdf.parse("09/10/2018 07:00"));
		Servico s2 = new Servico(null, sdf.parse("20/10/2018 19:00"));
		Servico s3 = new Servico(null, sdf.parse("11/05/2018 07:00"));

		usu1.getServicos().addAll(Arrays.asList(s1, s2));
		usu2.getServicos().addAll(Arrays.asList(s3));

		usu1.getTelefones().addAll(Arrays.asList("3421-1114", "98713-7778"));
		usu2.getTelefones().addAll(Arrays.asList("3423-1123", "98630-7204"));

		s1.getUsuarios().addAll(Arrays.asList(usu1, usu2));
		s2.getUsuarios().addAll(Arrays.asList(usu1));
		s3.getUsuarios().addAll(Arrays.asList(usu2));

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

		Estudo e1 = new Estudo(null, "Provas", "Prova EsFCEx");
		Estudo e2 = new Estudo(null, "Slides", "Slide Escolta Ofensiva");
		Estudo e3 = new Estudo(null, "Material Diverso", "Como calcular Azimute");

		usuarioRep.saveAll(Arrays.asList(usu1, usu2));
		desempenhoRep.saveAll(Arrays.asList(dp1, dp2));
		relatorioRep.saveAll(Arrays.asList(r1, r2));
		categoriaRep.saveAll(Arrays.asList(cat1, cat2, cat3, cat4, cat5));
		cancaoRep.saveAll(Arrays.asList(c1, c2, c3));
		servicoRep.saveAll(Arrays.asList(s1, s2, s3));
		estudoRep.saveAll(Arrays.asList(e1, e2, e3));

		// PARTE DE PAGAMENTO
		Pedido ped1 = new Pedido(null, sdf.parse("31/10/2018 17:20"), usu2);
		Pedido ped2 = new Pedido(null, sdf.parse("01/10/2018 13:00"), usu1);

		Pagamento pgt1 = new PagamentoComCartao(null, EstadoPagamento.QUITADO, ped1, 12);
		ped1.setPagamento(pgt1);
		Pagamento pgt2 = new PagamentoComBoleto(null, EstadoPagamento.PENDENTE, ped2, sdf.parse("02/02/2019 12:00"),
				sdf.parse("01/01/2019 00:00"));
		ped2.setPagamento(pgt2);

		usu1.getPedidos().addAll(Arrays.asList(ped2));
		usu2.getPedidos().addAll(Arrays.asList(ped1));

		pedRep.saveAll(Arrays.asList(ped1, ped2));
		pagRep.saveAll(Arrays.asList(pgt1, pgt2));

		ItemPedido ip1 = new ItemPedido(ped1, c1, 1, 10.00, 20.00);
		ItemPedido ip2 = new ItemPedido(ped2, c2, 2, 15.00, 30.00);
		ItemPedido ip3 = new ItemPedido(ped2, c3, 3, 20.00, 50.00);

		ped1.getItens().addAll(Arrays.asList(ip1));
		ped2.getItens().addAll(Arrays.asList(ip2, ip3));

		c1.getItens().addAll(Arrays.asList(ip1));
		c2.getItens().addAll(Arrays.asList(ip2, ip3));
		
		itemPedRep.saveAll(Arrays.asList(ip1, ip2, ip3));
	}
}