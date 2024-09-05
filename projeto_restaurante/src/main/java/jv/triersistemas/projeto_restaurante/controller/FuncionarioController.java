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

import jv.triersistemas.projeto_restaurante.dto.FuncionarioDto;
import jv.triersistemas.projeto_restaurante.service.FuncionarioService;

@RestController
@RequestMapping("/funcionario")
public class FuncionarioController {
	@Autowired
	FuncionarioService funcionarioService;
	
	@GetMapping("/{restauranteId}")
	public ResponseEntity<?> getFuncionarios(@PathVariable Long restauranteId) {
		try {
			return ResponseEntity.ok(funcionarioService.getFuncionarios(restauranteId));
		} catch (IllegalArgumentException e) {
			return ResponseEntity.status(404).body(e.getMessage());
		}
	}
	
	@PostMapping("/{restauranteId}")
	public ResponseEntity<?> cadastroFuncionario(@PathVariable Long restauranteId,@RequestBody FuncionarioDto funcionario) {
		try {
			return ResponseEntity.ok(funcionarioService.cadastroFuncionario(restauranteId, funcionario));
		} catch (IllegalArgumentException e) {
			return ResponseEntity.status(404).body(e.getMessage());
		}
	}

	@PutMapping
	public ResponseEntity<?> alteraFuncionario(@RequestBody FuncionarioDto funcionario) {
		try {
			return ResponseEntity.ok(funcionarioService.alteraFuncionario(funcionario));
		} catch (IllegalArgumentException e) {
			return ResponseEntity.status(404).body(e.getMessage());
		}
	}
}
