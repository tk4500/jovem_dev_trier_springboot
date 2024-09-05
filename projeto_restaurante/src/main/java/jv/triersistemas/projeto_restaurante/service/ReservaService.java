package jv.triersistemas.projeto_restaurante.service;

import java.util.List;
import java.util.Optional;

import jv.triersistemas.projeto_restaurante.dto.ReservaDto;
import jv.triersistemas.projeto_restaurante.entity.ReservaEntity;
import jv.triersistemas.projeto_restaurante.enums.StatusEnum;

public interface ReservaService {

	ReservaDto alteraStatus(Long id, StatusEnum status);

	ReservaDto fazerReserva(ReservaDto reserva);

	List<ReservaDto> getReservas(Long restauranteId, StatusEnum status);

	Optional<ReservaEntity> findById(Long reservaId);

}
