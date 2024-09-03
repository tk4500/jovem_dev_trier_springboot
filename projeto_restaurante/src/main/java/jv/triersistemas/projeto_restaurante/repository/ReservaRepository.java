package jv.triersistemas.projeto_restaurante.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import jv.triersistemas.projeto_restaurante.entity.ReservaEntity;

@Repository
public interface ReservaRepository extends JpaRepository<ReservaEntity, Long> {
	List<ReservaEntity> findByNumeroMesa(Integer numeroMesa);

	Boolean existsByNumeroMesaAndDataReserva(Integer numeroMesa, LocalDate reserva);
}
