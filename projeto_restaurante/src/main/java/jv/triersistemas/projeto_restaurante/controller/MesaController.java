package jv.triersistemas.projeto_restaurante.controller;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import jv.triersistemas.projeto_restaurante.dto.MesaDto;
import jv.triersistemas.projeto_restaurante.service.MesaService;

@RestController
@RequestMapping("/mesa")
public class MesaController {

	@Autowired
	MesaService mesaService;
	
	@GetMapping("/reserva/{idRestaurante}")
	public ResponseEntity<?> mesasDisponiveis(@PathVariable Long idRestaurante,@RequestParam("quantidadePessoas") Integer quantidadePessoas,
			@RequestParam("data") LocalDate data) {
		try {
			return ResponseEntity.ok(mesaService.getMesasDisponiveis(idRestaurante,quantidadePessoas,data));
		} catch (Exception e) {
			return ResponseEntity.status(500).body(e.getMessage());
		}
	}
	
	@GetMapping("/{restauranteId}")
	public ResponseEntity<?> getMesas(@PathVariable Long restauranteId) {
		try {
			return ResponseEntity.ok(mesaService.getMesas(restauranteId));
		} catch (IllegalArgumentException e) {
			return ResponseEntity.status(404).body(e.getMessage());
		}
	}
	
	@PostMapping("/{restauranteId}")
	public ResponseEntity<?> cadastroMesa(@PathVariable Long restauranteId,@RequestBody MesaDto Mesa) {
		try {
			return ResponseEntity.ok(mesaService.cadastroMesa(restauranteId, Mesa));
		} catch (IllegalArgumentException e) {
			return ResponseEntity.status(404).body(e.getMessage());
		}
	}

	@PutMapping
	public ResponseEntity<?> alteraMesa(@RequestBody MesaDto Mesa) {
		try {
			return ResponseEntity.ok(mesaService.alteraMesa(Mesa));
		} catch (IllegalArgumentException e) {
			return ResponseEntity.status(404).body(e.getMessage());
		}
	}
	
	
	
}
