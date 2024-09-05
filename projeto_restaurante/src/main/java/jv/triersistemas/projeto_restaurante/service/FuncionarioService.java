package jv.triersistemas.projeto_restaurante.service;

import java.util.List;


import jv.triersistemas.projeto_restaurante.dto.FuncionarioDto;

public interface FuncionarioService {

	List<FuncionarioDto> getFuncionarios(Long restauranteId);

	FuncionarioDto cadastroFuncionario(Long restauranteId, FuncionarioDto funcionario);

	FuncionarioDto alteraFuncionario(FuncionarioDto funcionario);

}
