package br.com.banco.entities;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "tb_transferencia")
public class TransferenciaEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@Column(name = "dataTransferencia")
	private LocalDate dataTransferencia;
	
	@Column(name = "valor")
	private Float valor;
	
	@Column(name = "tipo")
	private String tipo;
	
	@Column(name = "nomeOperadorTransacao")
	private String nomeOperadorTransacao;
	
	@ManyToOne
	@JoinColumn(name = "contaId")
	private ContaEntity contaId;
}
