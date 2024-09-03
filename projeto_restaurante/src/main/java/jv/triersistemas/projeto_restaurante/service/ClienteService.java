package jv.triersistemas.projeto_restaurante.service;

import java.util.List;

import jv.triersistemas.projeto_restaurante.dto.ClienteDto;
import jv.triersistemas.projeto_restaurante.dto.ReservaDto;

public interface ClienteService {

	List<ReservaDto> getReservas(Long id);

	ClienteDto postCliente(ClienteDto cliente);

	ClienteDto putCliente(ClienteDto cliente);

}
