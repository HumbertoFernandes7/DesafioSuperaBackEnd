package br.com.banco.dtos.inputs;

import javax.validation.constraints.NotBlank;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TransferenciaInput {

	@NotBlank(message = "valor é obrigatório")
	private Float valor;
	
	@NotBlank(message = "nomeOperadorTransacao é obrigatório")
	private String nomeOperadorTransacao;
	
	@NotBlank(message = "contaId é obrigatório")
	private Long contaId;
}
