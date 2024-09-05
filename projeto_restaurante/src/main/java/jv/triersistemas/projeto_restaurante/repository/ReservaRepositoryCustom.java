package jv.triersistemas.projeto_restaurante.repository;

import java.util.List;

import jv.triersistemas.projeto_restaurante.entity.ReservaEntity;
import jv.triersistemas.projeto_restaurante.enums.StatusEnum;

public interface ReservaRepositoryCustom {
	List<ReservaEntity> findByRestauranteIdAndStatus(Long restauranteId, StatusEnum status);
}
