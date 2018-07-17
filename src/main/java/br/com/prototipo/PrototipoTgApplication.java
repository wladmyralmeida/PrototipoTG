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
import br.com.prototipo.domain.Ranking;
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
import br.com.prototipo.repositories.RankingRepository;
import br.com.prototipo.repositories.RelatorioRepository;
import br.com.prototipo.repositories.ServicoRepository;
import br.com.prototipo.repositories.UsuarioRepository;

@SpringBootApplication
public class PrototipoTgApplication implements CommandLineRunner {


	public static void main(String[] args) {
		SpringApplication.run(PrototipoTgApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

	}
}