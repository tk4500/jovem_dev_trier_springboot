package jv.triersistemas.primeiro_projeto.service;

import java.util.List;

import jv.triersistemas.primeiro_projeto.dto.CategoriaDto;

public interface CategoriaService {

	List<CategoriaDto> getTodasCategorias();

	CategoriaDto findById(Long id);

	CategoriaDto adicionarCategoria(CategoriaDto novaCategoria);

	CategoriaDto atualizarCategoria(Long id, CategoriaDto categoriaAtualizada);

	void removerCategoria(Long id);

}
