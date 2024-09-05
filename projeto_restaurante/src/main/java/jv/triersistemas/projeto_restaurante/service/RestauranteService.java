package jv.triersistemas.projeto_restaurante.service;

import java.util.List;
import java.util.Optional;

import jv.triersistemas.projeto_restaurante.dto.RestauranteDto;
import jv.triersistemas.projeto_restaurante.entity.RestauranteEntity;

public interface RestauranteService {

	List<RestauranteDto> getRestaurantes();

	RestauranteDto newRestaurante(RestauranteDto restaurante);

	Optional<RestauranteEntity> findById(Long restauranteId);

}
