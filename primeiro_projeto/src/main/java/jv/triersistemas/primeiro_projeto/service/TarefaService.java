package jv.triersistemas.primeiro_projeto.service;

import java.util.List;

import jv.triersistemas.primeiro_projeto.dto.TarefaDto;


public interface TarefaService {
	
	List<TarefaDto> getTodasTarefas();
	
	TarefaDto findById(Long id);
	
	TarefaDto atualizarTarefa(TarefaDto tarefaAtualizada);
	
	void removerTarefa(Long id);

	TarefaDto adicionarTarefa(TarefaDto novaTarefa);

	List<TarefaDto> getIncompleta(TarefaDto tarefaIncompleta);
}