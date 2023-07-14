package br.com.banco.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.banco.entities.ContaEntity;
import br.com.banco.exceptions.TransferenciaException;
import br.com.banco.repositories.ContaRepository;

@Service
public class ContaService {

	@Autowired
	private ContaRepository contaRepository;

	@Transactional
	public ContaEntity criaConta(ContaEntity conta) {
		return contaRepository.save(conta);
	}

	public List<ContaEntity> listaTodas() {
		return contaRepository.findAll();
	}

	public ContaEntity buscaContaPeloId(Long contaId) {
		return contaRepository.findById(contaId)
				.orElseThrow(() -> new TransferenciaException("Não foi encontrado conta pelo id: " + contaId));
	}
}
