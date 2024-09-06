package jv.triersistemas.prova_2.controller;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import jv.triersistemas.prova_2.dto.MercadoDto;
import jv.triersistemas.prova_2.service.MercadoService;

@RestController
@RequestMapping("/mercado")
public class MercadoController {

	@Autowired
	MercadoService mercadoService;
	//3
	@GetMapping("/faturamento")
	public ResponseEntity<?> getFaturamentoDoDia(@RequestParam LocalDate data, @RequestParam Long id) {
		try {
			return ResponseEntity.ok(mercadoService.getFaturamentoDoDia(data, id));
		} catch (IllegalArgumentException e) {
			return ResponseEntity.status(404).body(e.getMessage());
		}
	}
	//1	
	@PostMapping
	public ResponseEntity<?> cadastrarMercado(@RequestBody MercadoDto mercado) {
		try {
			return ResponseEntity.ok(mercadoService.cadastrarMercado(mercado));
		} catch (IllegalArgumentException e) {
			return ResponseEntity.status(404).body(e.getMessage());
		}
	}
}
