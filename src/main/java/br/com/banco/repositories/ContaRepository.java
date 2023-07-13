package br.com.banco.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.banco.entities.ContaEntity;

@Repository
public interface ContaRepository extends JpaRepository<ContaEntity, Long> {

}
