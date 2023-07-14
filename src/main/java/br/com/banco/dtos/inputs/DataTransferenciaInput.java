package br.com.banco.dtos.inputs;

import java.time.LocalDate;

import javax.validation.constraints.NotBlank;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DataTransferenciaInput {

	@NotBlank(message = "data é obrigatória")
	private LocalDate data;
}
