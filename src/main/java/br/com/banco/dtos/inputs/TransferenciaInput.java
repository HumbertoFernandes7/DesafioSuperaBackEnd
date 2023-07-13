package br.com.banco.dtos.inputs;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TransferenciaInput {

	private Float valor;
	
	private String tipo;
	
	private String nomeOperadorTransacao;
	
	private Long contaId;
}
