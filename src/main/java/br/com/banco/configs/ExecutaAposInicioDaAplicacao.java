package br.com.banco.configs;

import java.util.List;

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
		
		List<ContaEntity> listaContas = contaService.listaTodas();
		
		if(listaContas.isEmpty()) {
			ContaEntity conta01 = new ContaEntity();
			ContaEntity conta02 = new ContaEntity();
			
			conta01.setNomeResponsavel("Fulano");
			conta01.setSaldo((float) 0.00);
			conta02.setNomeResponsavel("Sicrano");
			conta02.setSaldo((float) 0.0);
			
			contaService.criaConta(conta01);
			contaService.criaConta(conta02);
		}
	}
}
