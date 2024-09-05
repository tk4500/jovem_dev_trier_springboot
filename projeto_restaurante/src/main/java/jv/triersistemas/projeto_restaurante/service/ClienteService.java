package jv.triersistemas.projeto_restaurante.service;

import java.util.List;
import java.util.Optional;

import jv.triersistemas.projeto_restaurante.dto.ClienteDto;
import jv.triersistemas.projeto_restaurante.entity.ClienteEntity;

public interface ClienteService {

	List<ClienteDto> getClientes(Long restauranteId);
	
	ClienteDto cadastroCliente(Long restauranteId, ClienteDto cliente);

	ClienteDto alteraCliente(ClienteDto cliente);

	Optional<ClienteEntity> findById(Long clienteId);

}
