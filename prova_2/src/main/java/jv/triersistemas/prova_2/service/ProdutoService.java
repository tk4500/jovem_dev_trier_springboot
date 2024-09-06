package jv.triersistemas.prova_2.service;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import jv.triersistemas.prova_2.dto.ProdutoDto;
import jv.triersistemas.prova_2.entity.ProdutoEntity;

public interface ProdutoService {

	ProdutoDto getMaisVendido();

	ProdutoDto cadastrarProduto(ProdutoDto produto);

	Page<ProdutoDto> listarProduto(Pageable withPage, String nome);

	ProdutoDto alterarEstoque(ProdutoDto produto);

	ProdutoDto alterarValor(ProdutoDto produto);

	Optional<ProdutoEntity> findById(Long produtoId);

}
