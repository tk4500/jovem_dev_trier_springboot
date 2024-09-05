package jv.triersistemas.projeto_restaurante.repository.impl;

import java.util.List;

import com.querydsl.jpa.impl.JPAQuery;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jv.triersistemas.projeto_restaurante.entity.ClienteEntity;
import jv.triersistemas.projeto_restaurante.entity.QClienteEntity;
import jv.triersistemas.projeto_restaurante.entity.QRestauranteEntity;
import jv.triersistemas.projeto_restaurante.repository.ClienteRepositoryCustom;

public class ClienteRepositoryImpl implements ClienteRepositoryCustom{

	@PersistenceContext
	private EntityManager em;
	
	final QRestauranteEntity restaurante = QRestauranteEntity.restauranteEntity;
	final QClienteEntity cliente = QClienteEntity.clienteEntity;
	
	@Override
	public List<ClienteEntity> findByRestauranteId(Long restauranteId) {
		var query = new JPAQuery<ClienteEntity>(em);
		query.select(cliente).distinct()
		.from(restaurante)
		.join(restaurante.clientes, cliente)
		.where(restaurante.id.eq(restauranteId));
		return query.fetch();
	}

}
