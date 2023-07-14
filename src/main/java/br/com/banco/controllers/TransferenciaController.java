package br.com.banco.controllers;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.banco.converts.TransferenciaConvert;
import br.com.banco.dtos.inputs.DataTransferenciaInput;
import br.com.banco.dtos.inputs.TransferenciaInput;
import br.com.banco.dtos.outputs.TransferenciaOutput;
import br.com.banco.entities.TransferenciaEntity;
import br.com.banco.services.TransferenciaService;

@RestController
@RequestMapping("/transferencias")
public class TransferenciaController {

	@Autowired
	private TransferenciaService transferenciaService;

	@Autowired
	private TransferenciaConvert transferenciaConvert;

	@GetMapping
	public List<TransferenciaOutput> listaTodasTransferencias() {
		List<TransferenciaEntity> transferenciasEncontradas = transferenciaService.listaTodas();
		List<TransferenciaOutput> transferenciasConvertida = transferenciaConvert
				.ListEntityToListOutput(transferenciasEncontradas);
		return transferenciasConvertida;
	}

	@PostMapping
	public ResponseEntity<TransferenciaOutput> realizaTransferencia(@RequestBody TransferenciaInput transferenciaInput,
			UriComponentsBuilder uriBuilder) {
		TransferenciaEntity transferenciaEntity = transferenciaConvert.InputToEntity(transferenciaInput);
		TransferenciaEntity transferenciaCadastrada = transferenciaService.realizaTransferencia(transferenciaEntity,
				transferenciaInput.getContaId());
		URI uri = uriBuilder.path("/transferencias").buildAndExpand(transferenciaCadastrada.getId()).toUri();
		TransferenciaOutput transferenciaConvertida = transferenciaConvert.entityToOutput(transferenciaCadastrada);
		return ResponseEntity.created(uri).body(transferenciaConvertida);
	}

	@GetMapping("/{id}")
	public List<TransferenciaOutput> buscaTransferenciasPeloContaId(@PathVariable Long id) {
		List<TransferenciaEntity> transferenciasEntity = transferenciaService.buscaTransferenciasPeloContaId(id);
		return transferenciaConvert.ListEntityToListOutput(transferenciasEntity);
	}
	
	@GetMapping("data")
	public List<TransferenciaOutput> buscaTransferenciasPelaDataRealizada(@RequestBody DataTransferenciaInput dataTransferenciaInput) {
		List<TransferenciaEntity> transferenciasEntity = transferenciaService.buscaTransferenciasPelaDataRealizada(dataTransferenciaInput.getData());
		return transferenciaConvert.ListEntityToListOutput(transferenciasEntity);
	}
}
