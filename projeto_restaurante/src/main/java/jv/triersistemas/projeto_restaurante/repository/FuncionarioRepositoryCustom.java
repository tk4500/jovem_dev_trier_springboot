package jv.triersistemas.projeto_restaurante.repository;

import java.util.List;

import jv.triersistemas.projeto_restaurante.entity.FuncionarioEntity;

public interface FuncionarioRepositoryCustom {

	
	List<FuncionarioEntity> findByRestauranteId(Long restauranteId);
}
