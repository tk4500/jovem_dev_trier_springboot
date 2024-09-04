package jv.triersistemas.projeto_restaurante.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jv.triersistemas.projeto_restaurante.dto.ReservaDto;
import jv.triersistemas.projeto_restaurante.dto.RestauranteDto;
import jv.triersistemas.projeto_restaurante.service.RestauranteService;

@RestController
@RequestMapping("/restaurante")
public class RestauranteController {

	@Autowired
	RestauranteService restauranteService;
	
	@GetMapping
	public List<RestauranteDto> getRestaurantes(){
		return restauranteService.getRestaurantes();
	}
	
	@PostMapping
	public ResponseEntity<?> novoRestaurante(@RequestBody RestauranteDto restaurante) {
		try {
			return ResponseEntity.ok(restauranteService.newRestaurante(restaurante));
		} catch (Exception e) {
			return ResponseEntity.status(404).body(e.getMessage());
		}
	}
}
