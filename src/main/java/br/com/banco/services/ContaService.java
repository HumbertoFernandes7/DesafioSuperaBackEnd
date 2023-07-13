package br.com.banco.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.banco.entities.ContaEntity;
import br.com.banco.repositories.ContaRepository;

@Service
public class ContaService {

	@Autowired
	private ContaRepository contaRepository;
	
	public ContaEntity criaConta(ContaEntity conta) {
		return contaRepository.save(conta);
	}
}
