package br.com.banco.services;

import java.time.LocalDate;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.banco.entities.ContaEntity;
import br.com.banco.entities.TransferenciaEntity;
import br.com.banco.repositories.TransferenciaRepository;

@Service
public class TransferenciaService {

	@Autowired
	private TransferenciaRepository transferenciaRepository;

	@Autowired
	private ContaService contaService;

	public List<TransferenciaEntity> listaTodas() {
		return transferenciaRepository.findAll();
	}

	@Transactional
	public TransferenciaEntity realizaTransferencia(TransferenciaEntity transferenciaEntity, Long contaId) {
		ContaEntity contaEncontrada = contaService.buscaContaPeloId(contaId);
		transferenciaEntity.setContaId(contaEncontrada);
		transferenciaEntity.setDataTransferencia(LocalDate.now());
		return transferenciaRepository.save(transferenciaEntity);
	}

	public List<TransferenciaEntity> buscaTransferenciasPeloContaId(Long id) {
		List<TransferenciaEntity> transferenciasEncontradas = transferenciaRepository
				.findByContaId(contaService.buscaContaPeloId(id));
		return transferenciasEncontradas;
	}

	public List<TransferenciaEntity> buscaTransferenciasPelaDataRealizada(LocalDate localDate) {
		List<TransferenciaEntity> transferenciasEncontradas = transferenciaRepository
				.findByDataTransferencia(localDate);
		return transferenciasEncontradas;
	}
}
