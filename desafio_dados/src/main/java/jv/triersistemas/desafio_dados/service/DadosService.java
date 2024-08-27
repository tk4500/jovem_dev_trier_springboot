package jv.triersistemas.desafio_dados.service;

import java.util.Optional;

import jv.triersistemas.desafio_dados.dto.DadosDto;

public interface DadosService {
	Optional<DadosDto> lancaDados(int qtdDados,int valorDados);
		
}
