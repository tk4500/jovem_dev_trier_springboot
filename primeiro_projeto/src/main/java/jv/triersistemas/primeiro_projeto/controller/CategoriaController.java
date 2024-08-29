package jv.triersistemas.primeiro_projeto.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jv.triersistemas.primeiro_projeto.dto.CategoriaDto;
import jv.triersistemas.primeiro_projeto.service.CategoriaService;


@RestController
@RequestMapping("/categoria")
public class CategoriaController {
	@Autowired
	private CategoriaService categoriaService;
	
	@GetMapping
	public List<CategoriaDto> getCategorias() {
		return categoriaService.getTodasCategorias();
	}
	@GetMapping("/{id}")
	public ResponseEntity<?> getCategoriaPorId(@PathVariable Long id) {
		try {
			return ResponseEntity.ok(categoriaService.findById(id));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
		}
	}
	
	@PostMapping
	public CategoriaDto adicionarCategoria(@RequestBody CategoriaDto novaCategoria) {
		return categoriaService.adicionarCategoria(novaCategoria);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> atualizarCategoria(@PathVariable Long id, @RequestBody CategoriaDto categoriaAtualizada) {
		try {
			return ResponseEntity.ok(categoriaService.atualizarCategoria(id, categoriaAtualizada));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
		}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<String> removerCategoria(@PathVariable Long id) {
		try {
			categoriaService.removerCategoria(id);
			return ResponseEntity.ok().body("{\n	\"result\" : \"" + id + " removido com sucesso\" \n}");
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
		}
	}
}
