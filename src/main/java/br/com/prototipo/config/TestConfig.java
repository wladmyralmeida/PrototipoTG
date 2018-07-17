package br.com.prototipo.config;

import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import br.com.prototipo.services.DBService;

@Configuration
@Profile("test")
public class TestConfig {

	@Autowired
	private DBService dbService;
	@Bean
	public boolean instanciateDatabase() throws ParseException {
		dbService.instanciateTestDatabase();
		return true;
	}
}
