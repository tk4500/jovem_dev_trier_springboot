package jv.triersistemas.projeto_restaurante.service;

import java.time.LocalDate;
import java.util.List;

import jv.triersistemas.projeto_restaurante.dto.MesaDto;

public interface MesaService {

	List<MesaDto> getMesasDisponiveis(Long id, Integer quantidadePessoas, LocalDate data);

}
