package br.com.prototipo;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.prototipo.domain.Cancao;
import br.com.prototipo.domain.Categoria;
import br.com.prototipo.repositories.CancaoRepository;
import br.com.prototipo.repositories.CategoriaRepository;

@SpringBootApplication
public class PrototipoTgApplication implements CommandLineRunner {

	@Autowired
	private CategoriaRepository categoriaRep;
	@Autowired
	private CancaoRepository cancaoRep;

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

		// As categorias com suas respectivas canções.
		cat1.getCancoes().addAll(Arrays.asList(c1, c3));
		cat5.getCancoes().addAll(Arrays.asList(c2));

		// As canções com suas respectivas categorias.
		c1.getCategorias().addAll(Arrays.asList(cat1, cat5));
		c2.getCategorias().addAll(Arrays.asList(cat5));
		c3.getCategorias().addAll(Arrays.asList(cat1));

		categoriaRep.saveAll(Arrays.asList(cat1, cat2, cat3, cat4, cat5));
		cancaoRep.saveAll(Arrays.asList(c1, c2, c3));
	}
}