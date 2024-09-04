package jv.triersistemas.projeto_restaurante.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jv.triersistemas.projeto_restaurante.dto.ClienteDto;
import jv.triersistemas.projeto_restaurante.dto.ReservaDto;
import jv.triersistemas.projeto_restaurante.entity.ClienteEntity;
import jv.triersistemas.projeto_restaurante.repository.ClienteRepository;
import jv.triersistemas.projeto_restaurante.service.ClienteService;

@Service
public class ClienteServiceImpl implements ClienteService {

	@Autowired
	private ClienteRepository clRepository;

	@Override
	public List<ReservaDto> getReservas(Long id) throws IllegalArgumentException {
		var clEnt = findById(id);
		return null;
	}

	@Override
	public ClienteDto postCliente(ClienteDto cliente) throws IllegalArgumentException {
		var cliEnt = clRepository.save(new ClienteEntity(cliente));
		return new ClienteDto(cliEnt);

	}

	@Override
	public ClienteDto putCliente(ClienteDto cliente) throws IllegalArgumentException {
		return null;
	}

	private ClienteEntity findById(Long id) throws IllegalArgumentException {
		return clRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Valor do id invalido"));
	}

	private boolean emailExists(String email) {
		return clRepository.findByEmail(email).isPresent();
	}

	private boolean emailEqualsId(String email, Long id) {
		var clOpt = clRepository.findByEmail(email);
		var clBool = clOpt.map(l -> l.getId().equals(id));
		return clBool.orElse(true);
	}


}
