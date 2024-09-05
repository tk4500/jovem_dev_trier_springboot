package jv.triersistemas.projeto_restaurante.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jv.triersistemas.projeto_restaurante.dto.ClienteDto;
import jv.triersistemas.projeto_restaurante.service.ClienteService;

@RestController
@RequestMapping("/cliente")
public class ClienteController {

	@Autowired
	ClienteService clienteService;

	@GetMapping("/{restauranteId}")
	public ResponseEntity<?> getClientes(@PathVariable Long restauranteId) {
		try {
			return ResponseEntity.ok(clienteService.getClientes(restauranteId));
		} catch (IllegalArgumentException e) {
			return ResponseEntity.status(404).body(e.getMessage());
		}
	}
	
	@PostMapping("/{restauranteId}")
	public ResponseEntity<?> cadastroCliente(@PathVariable Long restauranteId,@RequestBody ClienteDto cliente) {
		try {
			return ResponseEntity.ok(clienteService.cadastroCliente(restauranteId, cliente));
		} catch (IllegalArgumentException e) {
			return ResponseEntity.status(404).body(e.getMessage());
		}
	}

	@PutMapping
	public ResponseEntity<?> alteraCliente(@RequestBody ClienteDto cliente) {
		try {
			return ResponseEntity.ok(clienteService.alteraCliente(cliente));
		} catch (IllegalArgumentException e) {
			return ResponseEntity.status(404).body(e.getMessage());
		}
	}
}
