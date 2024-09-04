package jv.triersistemas.projeto_restaurante.repository;

import java.time.LocalDate;
import java.util.List;

import jv.triersistemas.projeto_restaurante.entity.MesaEntity;

public interface MesaRepositoryCustom {

	List<MesaEntity> searchMesasByCapacidadePessoasandDataReserva(Long restauranteId, LocalDate dataReserva, Integer capacidadePessoas);
	

}
