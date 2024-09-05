package jv.triersistemas.projeto_restaurante.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jv.triersistemas.projeto_restaurante.dto.FuncionarioDto;
import jv.triersistemas.projeto_restaurante.entity.FuncionarioEntity;
import jv.triersistemas.projeto_restaurante.repository.FuncionarioRepository;
import jv.triersistemas.projeto_restaurante.service.FuncionarioService;
import jv.triersistemas.projeto_restaurante.service.RestauranteService;

@Service
public class FuncionarioServiceImpl implements FuncionarioService{

	@Autowired
	private RestauranteService restauranteService;
	@Autowired
	private FuncionarioRepository fuRepository;
	
	@Override
	public List<FuncionarioDto> getFuncionarios(Long restauranteId) {
		var fuEnt = fuRepository.findByRestauranteId(restauranteId);
		return fuEnt.stream().map(FuncionarioDto::new).toList();
	}

	@Override
	public FuncionarioDto cadastroFuncionario(Long restauranteId, FuncionarioDto funcionario) {
		var fuEnt = new FuncionarioEntity(funcionario);
		fuEnt.setRestaurante(restauranteService.findById(restauranteId).orElseThrow(()->new IllegalArgumentException("id do restaurante invalido")));
		fuRepository.save(fuEnt);
		return new FuncionarioDto(fuEnt);
	}

	@Override
	public FuncionarioDto alteraFuncionario(FuncionarioDto funcionario) {
		var fuEnt = fuRepository.findById(funcionario.getId()).orElseThrow(()->new IllegalArgumentException("id do fuente invalido"));
		 fuEnt.alteraFuncionario(funcionario);
		 fuRepository.save(fuEnt);
		 return new FuncionarioDto(fuEnt);
	}

}
