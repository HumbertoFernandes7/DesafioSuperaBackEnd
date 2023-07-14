package br.com.banco.dtos.inputs;

import javax.validation.constraints.NotBlank;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NomeOperadorInput {

	@NotBlank(message = "nomeOperadorTransacao é obrigatório")
	private String nomeOperadorTransacao;
}
