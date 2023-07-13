package br.com.banco.configs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Configuration;

import br.com.banco.entities.ContaEntity;
import br.com.banco.services.ContaService;

@Configuration
public class ExecutaAposInicioDaAplicacao implements ApplicationRunner {

	@Autowired
	private ContaService contaService;
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		
		ContaEntity conta01 = new ContaEntity();
		ContaEntity conta02 = new ContaEntity();
		
		conta01.setNomeResponsavel("Fulano");
		conta02.setNomeResponsavel("Sicrano");
		
		contaService.criaConta(conta01);
		contaService.criaConta(conta02);
		
	}
}
