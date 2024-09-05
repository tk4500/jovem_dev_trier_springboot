package jv.triersistemas.projeto_restaurante.repository;

import java.util.List;

import jv.triersistemas.projeto_restaurante.entity.ClienteEntity;

public interface ClienteRepositoryCustom {

	List<ClienteEntity> findByRestauranteId(Long restauranteId);
	
}
