package br.com.banco.repositories;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.banco.entities.ContaEntity;
import br.com.banco.entities.TransferenciaEntity;

public interface TransferenciaRepository extends JpaRepository<TransferenciaEntity, Long> {

	List<TransferenciaEntity> findByContaId(ContaEntity contaEntity);

	List<TransferenciaEntity> findByDataTransferencia(LocalDate localDate);

	List<TransferenciaEntity> findByNomeOperadorTransacao(String string);

}