package br.com.banco.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.banco.entities.TransferenciaEntity;

@Repository
public interface TransferenciaRepository extends JpaRepository<TransferenciaEntity, Long> {

}
