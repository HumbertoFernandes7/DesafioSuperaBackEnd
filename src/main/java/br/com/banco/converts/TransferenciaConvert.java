package br.com.banco.converts;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.banco.dtos.inputs.TransferenciaInput;
import br.com.banco.dtos.outputs.TransferenciaOutput;
import br.com.banco.entities.TransferenciaEntity;

@Component
public class TransferenciaConvert {

	@Autowired
	private ModelMapper modelMapper;
	
	
	public TransferenciaOutput entityToOutput(TransferenciaEntity transferenciaEntity) {
		return modelMapper.map(transferenciaEntity, TransferenciaOutput.class);
	}
	
	public List<TransferenciaOutput> ListEntityToListOutput(List<TransferenciaEntity> transferenciaEntity) {
		return transferenciaEntity.stream().map(a -> this.entityToOutput(a)).collect(Collectors.toList());
	}

	public TransferenciaEntity InputToEntity(TransferenciaInput transferenciaInput) {
		return modelMapper.map(transferenciaInput, TransferenciaEntity.class) ;
	}
}
