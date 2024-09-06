package jv.triersistemas.prova_2.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import jv.triersistemas.prova_2.dto.ItemVendaDto;
import jv.triersistemas.prova_2.dto.VendaDto;
import jv.triersistemas.prova_2.enums.StatusEnum;
import jv.triersistemas.prova_2.service.VendaService;

@RestController
@RequestMapping("/venda")
public class VendaController {

	@Autowired
	VendaService vendaService;

	// 14
	@GetMapping
	public ResponseEntity<?> listarVenda(@RequestParam(defaultValue = "0", required = false) Integer page,
			@RequestParam(defaultValue = "10", required = false) Integer size,
			@RequestParam(required = false) Long idProduto, @RequestParam(required = false) StatusEnum status) {
		try {
			return ResponseEntity.ok(vendaService.listarVenda(Pageable.ofSize(size).withPage(page), idProduto, status));
		} catch (IllegalArgumentException e) {
			return ResponseEntity.status(404).body(e.getMessage());
		}
	}

	// 8
	@PostMapping
	public ResponseEntity<?> cadastrarVenda(@RequestBody VendaDto venda) {
		try {
			return ResponseEntity.ok(vendaService.cadastrarVenda(venda));
		} catch (IllegalArgumentException e) {
			return ResponseEntity.status(404).body(e.getMessage());
		}
	}

	// 9
	@PostMapping("/finalizada")
	public ResponseEntity<?> cadastrarVendaFinalizada(@RequestBody List<ItemVendaDto> itensVenda) {
		try {
			return ResponseEntity.ok(vendaService.cadastrarVendaFinalizada(itensVenda));
		} catch (IllegalArgumentException e) {
			return ResponseEntity.status(404).body(e.getMessage());
		}
	}

	// 13
	@PutMapping("/finalizar/{id}")
	public ResponseEntity<?> finalizarVenda(@PathVariable Long id) {
		try {
			return ResponseEntity.ok(vendaService.finalizarVenda(id));
		} catch (IllegalArgumentException e) {
			return ResponseEntity.status(404).body(e.getMessage());
		}
	}

	// 12
	@DeleteMapping("/{id}")
	public ResponseEntity<?> removerVenda(@PathVariable Long id) {
		try {
			return ResponseEntity.ok(vendaService.removerVenda(id));
		} catch (IllegalArgumentException e) {
			return ResponseEntity.status(404).body(e.getMessage());
		}
	}

}
