package jv.triersistemas.prova_2.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import jv.triersistemas.prova_2.dto.ProdutoDto;

public interface ProdutoRepositoryCustom {

	Page<ProdutoDto> buscaProduto(Pageable withPage, String nome);
}
