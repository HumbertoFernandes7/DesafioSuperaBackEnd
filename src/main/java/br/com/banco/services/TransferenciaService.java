package br.com.banco.services;

import java.time.LocalDate;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.banco.entities.TransferenciaEntity;
import br.com.banco.repositories.TransferenciaRepository;

@Service
public class TransferenciaService {

	@Autowired
	private TransferenciaRepository transferenciaRepository;

	public List<TransferenciaEntity> listaTodas() {
		return transferenciaRepository.findAll();
	}

	@Transactional
	public TransferenciaEntity realizaTransferencia(TransferenciaEntity transferenciaEntity) {
		transferenciaEntity.setDataTransferencia(LocalDate.now());
		return transferenciaRepository.save(transferenciaEntity);
	}
}
	