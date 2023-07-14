package br.com.banco.dtos.inputs;

import java.time.LocalDate;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DataTransferenciaInput {

	private LocalDate data;
}
