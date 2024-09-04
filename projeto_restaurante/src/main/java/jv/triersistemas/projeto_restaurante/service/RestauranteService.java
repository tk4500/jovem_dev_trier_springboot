package jv.triersistemas.projeto_restaurante.service;

import java.util.List;

import jv.triersistemas.projeto_restaurante.dto.RestauranteDto;

public interface RestauranteService {

	List<RestauranteDto> getRestaurantes();

	RestauranteDto newRestaurante(RestauranteDto restaurante);

}
