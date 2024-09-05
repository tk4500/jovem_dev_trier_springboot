package jv.triersistemas.projeto_restaurante.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jv.triersistemas.projeto_restaurante.dto.RestauranteDto;
import jv.triersistemas.projeto_restaurante.entity.RestauranteEntity;
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
	public RestauranteDto newRestaurante(RestauranteDto restaurante) throws IllegalArgumentException {
		verificaRestaurante(restaurante);
		var resEnt = new RestauranteEntity(restaurante);
		restauranteRepository.save(resEnt);
		return new RestauranteDto(resEnt);
	}

	private void verificaRestaurante(RestauranteDto restaurante) throws IllegalArgumentException {
		if(restaurante.getEstrelas()>3) {
			throw new IllegalArgumentException("Numero de Estrelas passou do valor permitido");
		}
		
	}

	@Override
	public Optional<RestauranteEntity> findById(Long restauranteId) {
		return restauranteRepository.findById(restauranteId);
	}
	
	

}
