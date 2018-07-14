package br.com.prototipo;

import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.prototipo.domain.Cancao;
import br.com.prototipo.domain.Categoria;
import br.com.prototipo.domain.Servico;
import br.com.prototipo.domain.Usuario;
import br.com.prototipo.domain.enums.TipoUsuario;
import br.com.prototipo.repositories.CancaoRepository;
import br.com.prototipo.repositories.CategoriaRepository;
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

	public static void main(String[] args) {
		SpringApplication.run(PrototipoTgApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

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

		Usuario usu1 = new Usuario(null, "wlad almeida", 32, "www", "TG-07002", "Charlie", "Cabo",
				"A+", TipoUsuario.ADMINISTRADOR, true);
		
		Usuario usu2 = new Usuario(null, "almeida32", 23, "wlad23", "TG-07002", "Bravo", "Sub-Tenente",
				"O-", TipoUsuario.ADMINISTRADOR, true);
		
		Servico s1 = new Servico(null, new SimpleDateFormat("dd/MM/yyyy").parse("09/10/2018"));
		Servico s2 = new Servico(null, new SimpleDateFormat("dd/MM/yyyy").parse("20/10/2017"));
		Servico s3 = new Servico(null, new SimpleDateFormat("dd/MM/yyyy").parse("11/05/2018"));
		
		usu1.getServicos().addAll(Arrays.asList(s1,s2));
		usu2.getServicos().addAll(Arrays.asList(s3));
		
		usu1.getTelefones().addAll(Arrays.asList("3421-1114", "98713-7778"));
		usu2.getTelefones().addAll(Arrays.asList("3423-1123", "98630-7204"));
	
		s1.getUsuarios().addAll(Arrays.asList(usu1, usu2));
		s2.getUsuarios().addAll(Arrays.asList(usu2));


		usuarioRep.saveAll(Arrays.asList(usu1, usu2));
		categoriaRep.saveAll(Arrays.asList(cat1, cat2, cat3, cat4, cat5));
		cancaoRep.saveAll(Arrays.asList(c1, c2, c3));
		servicoRep.saveAll(Arrays.asList(s1, s2, s3));

	}
}