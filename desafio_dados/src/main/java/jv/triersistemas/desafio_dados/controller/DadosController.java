package jv.triersistemas.desafio_dados.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import jv.triersistemas.desafio_dados.dto.DadosDto;
import jv.triersistemas.desafio_dados.service.DadosService;

@RestController
@RequestMapping("/dados")
public class DadosController {

	@Autowired
	private DadosService dadosService;
	
	@PostMapping
	public ResponseEntity<DadosDto> PostDados(@RequestParam int qtdDados,@RequestParam int valorDados) {
		return dadosService.lancaDados(qtdDados, valorDados).map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null));
		
	}
	
}
