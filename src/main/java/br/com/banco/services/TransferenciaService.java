package br.com.banco.services;

import java.time.LocalDate;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.banco.entities.ContaEntity;
import br.com.banco.entities.TransferenciaEntity;
import br.com.banco.exceptions.TransferenciaException;
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
	public TransferenciaEntity realizaTransferenciaDeposito(TransferenciaEntity transferenciaEntity, Long contaId) {
		ContaEntity contaEncontrada = contaService.buscaContaPeloId(contaId);
		transferenciaEntity.setContaId(contaEncontrada);
		contaEncontrada.setSaldo(contaEncontrada.getSaldo() + transferenciaEntity.getValor());
		transferenciaEntity.setDataTransferencia(LocalDate.now());
		transferenciaEntity.setTipo("Deposito");
		return transferenciaRepository.save(transferenciaEntity);
	}

	@Transactional
	public TransferenciaEntity realizaTransferenciaRetirada(TransferenciaEntity transferenciaEntity, Long contaId) {
		ContaEntity contaEncontrada = contaService.buscaContaPeloId(contaId);
		transferenciaEntity.setContaId(contaEncontrada);
		if (contaEncontrada.getSaldo() > transferenciaEntity.getValor()) {
			contaEncontrada.setSaldo(contaEncontrada.getSaldo() - transferenciaEntity.getValor());
			transferenciaEntity.setDataTransferencia(LocalDate.now());
			transferenciaEntity.setTipo("Retirada");
			return transferenciaRepository.save(transferenciaEntity);
		} else {
			throw new TransferenciaException("Erro na transferência: saldo insuficiente.");
		}
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

	public List<TransferenciaEntity> buscaTransferenciasPeloNomeOperador(String string) {
		return transferenciaRepository.findByNomeOperadorTransacao(string);
	}
}
