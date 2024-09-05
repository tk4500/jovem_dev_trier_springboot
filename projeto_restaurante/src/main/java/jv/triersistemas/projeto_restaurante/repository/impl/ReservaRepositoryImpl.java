package jv.triersistemas.projeto_restaurante.repository.impl;

import java.util.List;

import com.querydsl.jpa.impl.JPAQuery;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jv.triersistemas.projeto_restaurante.entity.QMesaEntity;
import jv.triersistemas.projeto_restaurante.entity.QReservaEntity;
import jv.triersistemas.projeto_restaurante.entity.QRestauranteEntity;
import jv.triersistemas.projeto_restaurante.entity.ReservaEntity;
import jv.triersistemas.projeto_restaurante.enums.StatusEnum;
import jv.triersistemas.projeto_restaurante.repository.ReservaRepositoryCustom;

public class ReservaRepositoryImpl implements ReservaRepositoryCustom{

	@PersistenceContext
	private EntityManager em;
	
	final QRestauranteEntity restaurante = QRestauranteEntity.restauranteEntity;
	final QReservaEntity reserva = QReservaEntity.reservaEntity;
	final QMesaEntity mesa = QMesaEntity.mesaEntity;
	
	@Override
	public List<ReservaEntity> findByRestauranteIdAndStatus(Long restauranteId, StatusEnum status) {
		var query = new JPAQuery<ReservaEntity>(em);
		query.select(reserva).distinct()
		.from(mesa)
		.join(mesa.reservas, reserva)
		.where(mesa.id.in(findMesaByRestaurante(restauranteId)).and(reserva.status.eq(status)));
		return query.fetch();
	}
	
	private List<Long> findMesaByRestaurante(Long restauranteId){
		var query = new JPAQuery<Long>(em);
		query.select(reserva.mesa.id)
        .from(reserva)
        .join(reserva.mesa, mesa)
        .join(mesa.restaurante, restaurante)
        .where(restaurante.id.eq(restauranteId));
		
		return query.fetch();
	}

}
