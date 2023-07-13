package br.com.banco.dtos.outputs;

import java.time.LocalDate;

import br.com.banco.entities.ContaEntity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TransferenciaOutput {

	private Long id;

	private LocalDate dataTransferencia;

	private Float valor;

	private String tipo;

	private String nomeOperadorTransacao;

	private ContaEntity contaId;
}
