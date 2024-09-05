package jv.triersistemas.projeto_restaurante.repository;

import java.time.LocalDate;
import java.util.List;

import jv.triersistemas.projeto_restaurante.entity.MesaEntity;

public interface MesaRepositoryCustom {

	List<MesaEntity> searchMesasByCapacidadePessoasAndDataReserva(Long restauranteId, LocalDate dataReserva, Integer capacidadePessoas);
	
	List<MesaEntity> findByRestauranteId(Long restauranteId);

}
