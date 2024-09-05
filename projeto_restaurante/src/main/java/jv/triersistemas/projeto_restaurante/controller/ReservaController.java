package jv.triersistemas.projeto_restaurante.controller;

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

import jv.triersistemas.projeto_restaurante.dto.ReservaDto;
import jv.triersistemas.projeto_restaurante.enums.StatusEnum;
import jv.triersistemas.projeto_restaurante.service.ReservaService;

@RestController
@RequestMapping("/reserva")
public class ReservaController {

	@Autowired
	ReservaService reservaService;
	
	@GetMapping("/{restauranteId}")
	public ResponseEntity<?> getReservas(@PathVariable Long restauranteId,@RequestParam("status") StatusEnum status) {
		try {
			return ResponseEntity.ok(reservaService.getReservas(restauranteId, status));
		} catch (IllegalArgumentException e) {
			return ResponseEntity.status(404).body(e.getMessage());
		}
	}

	@PostMapping
	public ResponseEntity<?> fazerReserva(@RequestBody ReservaDto reserva) {
		try {
			return ResponseEntity.ok(reservaService.fazerReserva(reserva));
		} catch (Exception e) {
			return ResponseEntity.status(404).body(e.getMessage());
		}
	}

	@PutMapping("/status")
	public ResponseEntity<?> alteraStatus(@RequestParam("id") Long id, @RequestParam("status") StatusEnum status) {
		try {
			return ResponseEntity.ok(reservaService.alteraStatus(id, status));
		} catch (Exception e) {
			return ResponseEntity.status(404).body(e.getMessage());
		}
	}
}
