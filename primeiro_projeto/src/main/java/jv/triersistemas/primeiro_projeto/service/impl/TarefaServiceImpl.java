package jv.triersistemas.primeiro_projeto.service.impl;


import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jv.triersistemas.primeiro_projeto.dto.CategoriaDto;
import jv.triersistemas.primeiro_projeto.dto.TarefaDto;
import jv.triersistemas.primeiro_projeto.entity.TarefaEntity;
import jv.triersistemas.primeiro_projeto.repository.CategoriaRepository;
import jv.triersistemas.primeiro_projeto.repository.TarefaRepository;
import jv.triersistemas.primeiro_projeto.service.TarefaService;


@Service
public class TarefaServiceImpl implements TarefaService {
	
	@Autowired
	private TarefaRepository repository;
	
	@Autowired
	private CategoriaRepository catRepository;
    
	@Override
	public List<TarefaDto> getTodasTarefas() {
		return repository.findAll().stream().map(TarefaDto::new).toList();
	}
	
	@Override
	public TarefaDto findById(Long id) throws IllegalArgumentException {
		return new TarefaDto(repository.findById(id).orElseThrow(()-> new IllegalArgumentException("não foi possivel encontrar o id")));
	}
	
	@Override
	public TarefaDto adicionarTarefa(TarefaDto novaTarefa) throws IllegalArgumentException{		
		novaTarefa.setDataCriacao(LocalDate.now());
		if(novaTarefa.getDataExpiracao().isBefore(novaTarefa.getDataCriacao()))
			new IllegalArgumentException("data de Expiração invalida");
		try {
			novaTarefa.getIdCategoria().equals(null);
			novaTarefa.setCategoria(getCategoria(novaTarefa.getIdCategoria()));
		} catch (NullPointerException e) {
			novaTarefa.setCategoria(getCategoria(novaTarefa.getNomeCategoria()));
		}
		var entidadePersistida = repository.save(new TarefaEntity(novaTarefa));
		return new TarefaDto(entidadePersistida);
	}
	
	@Override
	public TarefaDto atualizarTarefa(TarefaDto tarefaAtualizada) throws IllegalArgumentException {
		findById(tarefaAtualizada.getId());
		if(tarefaAtualizada.getDataExpiracao().isBefore(tarefaAtualizada.getDataCriacao()))
			new IllegalArgumentException("data de Expiração invalida");
		try {
			tarefaAtualizada.getIdCategoria().equals(null);
			tarefaAtualizada.setCategoria(getCategoria(tarefaAtualizada.getIdCategoria()));
		} catch (NullPointerException e) {
			tarefaAtualizada.setCategoria(getCategoria(tarefaAtualizada.getNomeCategoria()));
		}
		var entidadePersistida = repository.save(new TarefaEntity(tarefaAtualizada));
        return new TarefaDto(entidadePersistida);
	}

	@Override
	public void removerTarefa(Long id) throws IllegalArgumentException {
		findById(id);
		repository.deleteById(id);
	}


	private CategoriaDto getCategoria(String categoria) throws IllegalArgumentException {
		var catOpt = catRepository.findByNome(categoria).map(CategoriaDto::new);
		var catDto = catOpt.orElseThrow(()-> new IllegalArgumentException("não foi possivel encontrar a categoria"));
		return catDto;
	}
	private CategoriaDto getCategoria(Long id) throws IllegalArgumentException {
		var catOpt = catRepository.findById(id).map(CategoriaDto::new);
		var catDto = catOpt.orElseThrow(()-> new IllegalArgumentException("não foi possivel encontrar a categoria"));
		return catDto;
	}

	@Override
	public List<TarefaDto> getIncompleta(TarefaDto tarefaIncompleta) {
		
		try {
			tarefaIncompleta.getIdCategoria().equals(null);
			var catDto = getCategoria(tarefaIncompleta.getIdCategoria());
		}catch (NullPointerException e) {
			var catDto = getCategoria(tarefaIncompleta.getNomeCategoria());
		}
		return null;
	}





	

}
