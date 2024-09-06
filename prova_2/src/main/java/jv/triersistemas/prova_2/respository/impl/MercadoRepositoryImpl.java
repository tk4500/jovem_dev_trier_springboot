package jv.triersistemas.prova_2.respository.impl;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import com.querydsl.jpa.impl.JPAQuery;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jv.triersistemas.prova_2.entity.QMercadoEntity;
import jv.triersistemas.prova_2.entity.QVendaEntity;
import jv.triersistemas.prova_2.repository.MercadoRepositoryCustom;


public class MercadoRepositoryImpl implements MercadoRepositoryCustom{

	@PersistenceContext
	private EntityManager em;
	
	final QMercadoEntity mercado = QMercadoEntity.mercadoEntity;
	final QVendaEntity venda = QVendaEntity.vendaEntity;
	
	@Override
	public List<BigDecimal> valorDeVendasByData(LocalDate data, Long id) {
		var query = new JPAQuery<BigDecimal>(em);
		query.select(venda.valorTotal)
		.from(mercado)
		.join(mercado.vendas, venda)
		.where(mercado.id.eq(id).and(venda.dataCriacao.eq(data)));
		
		return query.fetch();
	}

}
