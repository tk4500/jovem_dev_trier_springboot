package jv.triersistemas.projeto_restaurante.repository.impl;

import java.util.List;

import com.querydsl.jpa.impl.JPAQuery;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jv.triersistemas.projeto_restaurante.entity.FuncionarioEntity;
import jv.triersistemas.projeto_restaurante.entity.QFuncionarioEntity;
import jv.triersistemas.projeto_restaurante.entity.QRestauranteEntity;
import jv.triersistemas.projeto_restaurante.repository.FuncionarioRepositoryCustom;

public class FuncionarioRepositoryImpl implements FuncionarioRepositoryCustom{

	
	@PersistenceContext
	private EntityManager em;
	
	final QRestauranteEntity restaurante = QRestauranteEntity.restauranteEntity;
	final QFuncionarioEntity funcionario = QFuncionarioEntity.funcionarioEntity;
	@Override
	public List<FuncionarioEntity> findByRestauranteId(Long restauranteId) {
		var query = new JPAQuery<FuncionarioEntity>(em);
		query.select(funcionario).distinct()
		.from(restaurante)
		.join(restaurante.funcionarios, funcionario)
		.where(restaurante.id.eq(restauranteId));
		return query.fetch();
	}

}
