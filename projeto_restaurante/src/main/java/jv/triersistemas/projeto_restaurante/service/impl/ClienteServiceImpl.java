package jv.triersistemas.projeto_restaurante.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jv.triersistemas.projeto_restaurante.dto.ClienteDto;
import jv.triersistemas.projeto_restaurante.entity.ClienteEntity;
import jv.triersistemas.projeto_restaurante.repository.ClienteRepository;
import jv.triersistemas.projeto_restaurante.service.ClienteService;
import jv.triersistemas.projeto_restaurante.service.RestauranteService;

@Service
public class ClienteServiceImpl implements ClienteService {

	@Autowired
	private ClienteRepository clRepository;
	@Autowired
	private RestauranteService restauranteService;

	@Override
	public List<ClienteDto> getClientes(Long restauranteId) {
		var cliEnt = clRepository.findByRestauranteId(restauranteId);
		return cliEnt.stream().map(ClienteDto::new).toList();
	}

	@Override
	public ClienteDto cadastroCliente(Long restauranteId, ClienteDto cliente) {
		var cliEnt = new ClienteEntity(cliente);
		cliEnt.setRestaurante(restauranteService.findById(restauranteId).orElseThrow(()->new IllegalArgumentException("id do restaurante invalido")));
		clRepository.save(cliEnt);
		return new ClienteDto(cliEnt);
	}

	@Override
	public ClienteDto alteraCliente(ClienteDto cliente) {
		var cliEnt = clRepository.findById(cliente.getId()).orElseThrow(()->new IllegalArgumentException("id do cliente invalido"));
		 cliEnt.alteraCliente(cliente);
		 clRepository.save(cliEnt);
		 return new ClienteDto(cliEnt);
	}

	@Override
	public Optional<ClienteEntity> findById(Long clienteId) {
		return clRepository.findById(clienteId);
	}


}
