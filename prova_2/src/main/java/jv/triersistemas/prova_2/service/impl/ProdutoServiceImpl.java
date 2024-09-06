package jv.triersistemas.prova_2.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import jv.triersistemas.prova_2.dto.ProdutoDto;
import jv.triersistemas.prova_2.entity.ProdutoEntity;
import jv.triersistemas.prova_2.repository.ProdutoRepository;
import jv.triersistemas.prova_2.service.MercadoService;
import jv.triersistemas.prova_2.service.ProdutoService;

@Service
public class ProdutoServiceImpl implements ProdutoService{

	@Autowired
	ProdutoRepository repository;
	@Autowired
	MercadoService meService;
	@Override
	public ProdutoDto getMaisVendido() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ProdutoDto cadastrarProduto(ProdutoDto produto) throws IllegalArgumentException{
		var proEnt = new ProdutoEntity(produto);
		proEnt.setMercado(meService.findById(produto.getMercadoId()).orElseThrow(()-> new IllegalArgumentException("mercado não encontrado")));
		proEnt = repository.save(proEnt);
		return new ProdutoDto(proEnt);
	}

	@Override
	public Page<ProdutoDto> listarProduto(Pageable withPage, String nome) {
		var pag = repository.buscaProduto(withPage,nome);
		return pag;
	}

	@Override
	public ProdutoDto alterarEstoque(ProdutoDto produto) {
		var proEnt = repository.findById(produto.getId()).orElseThrow(()-> new IllegalArgumentException("produto não encontrado"));
		proEnt.alterarEstoque(produto.getEstoque());
		proEnt = repository.save(proEnt);
		return new ProdutoDto(proEnt);
	}

	@Override
	public ProdutoDto alterarValor(ProdutoDto produto) {
		var proEnt = repository.findById(produto.getId()).orElseThrow(()-> new IllegalArgumentException("produto não encontrado"));
		proEnt.alterarValor(produto.getValorUnitario());
		proEnt = repository.save(proEnt);
		return new ProdutoDto(proEnt);
	}

	@Override
	public Optional<ProdutoEntity> findById(Long produtoId) {
		return repository.findById(produtoId);
	}

}
