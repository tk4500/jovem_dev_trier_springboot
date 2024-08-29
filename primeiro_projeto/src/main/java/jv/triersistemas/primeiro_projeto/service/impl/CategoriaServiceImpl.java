package jv.triersistemas.primeiro_projeto.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jv.triersistemas.primeiro_projeto.dto.CategoriaDto;
import jv.triersistemas.primeiro_projeto.entity.CategoriaEntity;
import jv.triersistemas.primeiro_projeto.repository.CategoriaRepository;
import jv.triersistemas.primeiro_projeto.service.CategoriaService;
@Service
public class CategoriaServiceImpl implements CategoriaService{
	
	@Autowired
	private CategoriaRepository repository;
	
	@Override
	public List<CategoriaDto> getTodasCategorias() {
		return repository.findAll().stream().map(CategoriaDto::new).toList();
	}

	@Override
	public CategoriaDto findById(Long id) {
		return new CategoriaDto(repository.findById(id).orElseThrow(()-> new IllegalArgumentException("não foi possivel encontrar o id")));
	}

	@Override
	public CategoriaDto adicionarCategoria(CategoriaDto novaCategoria) {
		var entidadePersistida = repository.save(new CategoriaEntity(novaCategoria));
		return new CategoriaDto(entidadePersistida);
	}

	@Override
	public CategoriaDto atualizarCategoria(Long id, CategoriaDto categoriaAtualizada) {
		findById(id);
		var entidadePersistida = repository.save(new CategoriaEntity(categoriaAtualizada));
        return new CategoriaDto(entidadePersistida);
	}

	@Override
	public void removerCategoria(Long id) {
		findById(id);
		repository.deleteById(id);
	}

}
