package jv.triersistemas.projeto_restaurante.service;

import java.time.LocalDate;

import jv.triersistemas.projeto_restaurante.dto.ReservaDto;
import jv.triersistemas.projeto_restaurante.enums.StatusEnum;

public interface ReservaService {

	String getDisponibilidade(Integer mesa, LocalDate data);

	ReservaDto postReserva(ReservaDto reserva);

	ReservaDto putReserva(Long id, StatusEnum status);

}
