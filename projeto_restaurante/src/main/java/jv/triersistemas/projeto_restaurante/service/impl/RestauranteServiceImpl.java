package jv.triersistemas.projeto_restaurante.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jv.triersistemas.projeto_restaurante.dto.RestauranteDto;
import jv.triersistemas.projeto_restaurante.repository.RestauranteRepository;
import jv.triersistemas.projeto_restaurante.service.RestauranteService;

@Service
public class RestauranteServiceImpl implements RestauranteService{

	@Autowired
	RestauranteRepository restauranteRepository;
	
	@Override
	public List<RestauranteDto> getRestaurantes() {
		var resEntList =restauranteRepository.findAll();
		return resEntList.stream().map(RestauranteDto::new).toList();
	}

	@Override
	public RestauranteDto newRestaurante(RestauranteDto restaurante) {
		// TODO Auto-generated method stub
		return null;
	}

}
