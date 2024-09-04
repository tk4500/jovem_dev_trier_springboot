package jv.triersistemas.projeto_restaurante.repository.impl;

import java.time.LocalDate;
import java.util.List;

import com.querydsl.jpa.impl.JPAQuery;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jv.triersistemas.projeto_restaurante.entity.MesaEntity;
import jv.triersistemas.projeto_restaurante.entity.QMesaEntity;
import jv.triersistemas.projeto_restaurante.entity.QReservaEntity;
import jv.triersistemas.projeto_restaurante.entity.QRestauranteEntity;
import jv.triersistemas.projeto_restaurante.entity.ReservaEntity;
import jv.triersistemas.projeto_restaurante.repository.MesaRepositoryCustom;
public class MesaRepositoryImpl implements MesaRepositoryCustom{

	@PersistenceContext
	private EntityManager em;
	
	final QRestauranteEntity restaurante = QRestauranteEntity.restauranteEntity;
	final QReservaEntity reserva = QReservaEntity.reservaEntity;
	final QMesaEntity mesa = QMesaEntity.mesaEntity;
	@Override
	public List<MesaEntity> searchMesasByCapacidadePessoasandDataReserva(Long restauranteId,LocalDate dataReserva,
			Integer capacidadePessoas) {
		getMesasFromRestaurante(restauranteId)
		.where(mesa.in(getMesasFromDataReserva(dataReserva))
				.and(mesa.capacidadePessoas.goe(capacidadePessoas)));
		
		return null;
	}
	
	private JPAQuery<MesaEntity> getMesasFromRestaurante(Long restauranteId){
		var query = new JPAQuery<MesaEntity>(em);
		return query.select(mesa).distinct()
		.from(restaurante)
		.join(restaurante.mesas,mesa)
		.where(restaurante.id.eq(restauranteId));
	}
	private JPAQuery<MesaEntity> getMesasFromDataReserva(LocalDate dataReserva){
		var query = new JPAQuery<ReservaEntity>(em);
		return query.select(reserva.mesa)
				.from(reserva)
				.where(reserva.dataReserva.eq(dataReserva));
	}
	

	
	

	
	
	
	
}
