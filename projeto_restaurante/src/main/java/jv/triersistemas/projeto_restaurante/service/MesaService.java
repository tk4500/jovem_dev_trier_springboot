package jv.triersistemas.projeto_restaurante.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import jv.triersistemas.projeto_restaurante.dto.MesaDto;
import jv.triersistemas.projeto_restaurante.entity.MesaEntity;

public interface MesaService {

	List<MesaDto> getMesasDisponiveis(Long id, Integer quantidadePessoas, LocalDate data);

	List<MesaDto> getMesas(Long restauranteId) ;

	MesaDto cadastroMesa(Long restauranteId, MesaDto mesa);

	MesaDto alteraMesa(MesaDto mesa);

	Optional<MesaEntity> findById(Long mesaId);

}
