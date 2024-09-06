package jv.triersistemas.prova_2.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jv.triersistemas.prova_2.dto.ItemVendaDto;
import jv.triersistemas.prova_2.service.ItemVendaService;

@RestController
@RequestMapping("/item_venda")
public class ItemVendaController {

	@Autowired
	ItemVendaService itemVendaService;

	//10
	@PostMapping
	public ResponseEntity<?> adicionarItem(@RequestBody ItemVendaDto itemVenda) {
		try {
			return ResponseEntity.ok(itemVendaService.adicionarItem(itemVenda));
		} catch (IllegalArgumentException e) {
			return ResponseEntity.status(404).body(e.getMessage());
		}
	}
	//11
	@DeleteMapping("/{id}")
	public ResponseEntity<?> removerItem(@PathVariable Long id) {
		try {
			return ResponseEntity.ok(itemVendaService.removerItem(id));
		} catch (IllegalArgumentException e) {
			return ResponseEntity.status(404).body(e.getMessage());
		}
	}
}
