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

import jv.triersistemas.projeto_restaurante.dto.PedidoDto;
import jv.triersistemas.projeto_restaurante.service.PedidoService;

@RestController
@RequestMapping("/pedido")
public class PedidoController {
	@Autowired
	PedidoService pedidoService;
	
	@GetMapping("/{reservaId}")
	public ResponseEntity<?> getPedidos(@PathVariable Long reservaId) {
		try {
			return ResponseEntity.ok(pedidoService.getPedidos(reservaId));
		} catch (IllegalArgumentException e) {
			return ResponseEntity.status(404).body(e.getMessage());
		}
	}

	@PostMapping
	public ResponseEntity<?> fazerPedido(@RequestBody PedidoDto pedido) {
		try {
			return ResponseEntity.ok(pedidoService.fazerPedido(pedido));
		} catch (Exception e) {
			return ResponseEntity.status(404).body(e.getMessage());
		}
	}
	
	@PutMapping
	public ResponseEntity<?> alteraPedido(@RequestBody PedidoDto pedido) {
		try {
			return ResponseEntity.ok(pedidoService.alteraPedido(pedido));
		} catch (IllegalArgumentException e) {
			return ResponseEntity.status(404).body(e.getMessage());
		}
	}
}
