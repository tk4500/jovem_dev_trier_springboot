package jv.triersistemas.prova_2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import jv.triersistemas.prova_2.dto.ProdutoDto;
import jv.triersistemas.prova_2.service.ProdutoService;

@RestController
@RequestMapping("/produto")
public class ProdutoController {

	@Autowired
	ProdutoService produtoService;
	//2
	@GetMapping("/mais_vendido")
	public ResponseEntity<?> getProdutoMaisVendido() {
		try {
			return ResponseEntity.ok(produtoService.getMaisVendido());
		} catch (IllegalArgumentException e) {
			return ResponseEntity.status(404).body(e.getMessage());
		}
	}
	
	//5
	@GetMapping
	public ResponseEntity<?> listarProduto(@RequestParam(defaultValue = "0", required = false) Integer page,@RequestParam(defaultValue = "10", required = false)Integer size, @RequestParam(required = false)String nome) {
		try {
			return ResponseEntity.ok(produtoService.listarProduto(Pageable.ofSize(size).withPage(page), nome));
		} catch (IllegalArgumentException e) {
			return ResponseEntity.status(404).body(e.getMessage());
		}
	}
	
	//4
	@PostMapping
	public ResponseEntity<?> cadastrarProduto(@RequestBody ProdutoDto produto) {
		try {
			return ResponseEntity.ok(produtoService.cadastrarProduto(produto));
		} catch (IllegalArgumentException e) {
			return ResponseEntity.status(404).body(e.getMessage());
		}
	}
	
	//6
	@PutMapping("/estoque")
	public ResponseEntity<?> alterarEstoque(@RequestBody ProdutoDto produto) {
		try {
			return ResponseEntity.ok(produtoService.alterarEstoque(produto));
		} catch (IllegalArgumentException e) {
			return ResponseEntity.status(404).body(e.getMessage());
		}
	}
	
	//7
	@PutMapping("/valor")
	public ResponseEntity<?> alterarValor(@RequestBody ProdutoDto produto) {
		try {
			return ResponseEntity.ok(produtoService.alterarValor(produto));
		} catch (IllegalArgumentException e) {
			return ResponseEntity.status(404).body(e.getMessage());
		}
	}
	
}
