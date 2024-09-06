package jv.triersistemas.prova_2.respository.impl;

import java.util.Objects;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQuery;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jv.triersistemas.prova_2.dto.ProdutoDto;
import jv.triersistemas.prova_2.entity.QMercadoEntity;
import jv.triersistemas.prova_2.entity.QProdutoEntity;
import jv.triersistemas.prova_2.repository.ProdutoRepositoryCustom;

public class ProdutoRepositoryImpl implements ProdutoRepositoryCustom{
	@PersistenceContext
	private EntityManager em;
	
	final QMercadoEntity mercado = QMercadoEntity.mercadoEntity;
	final QProdutoEntity produto = QProdutoEntity.produtoEntity;
	@Override
	public Page<ProdutoDto> buscaProduto(Pageable pageable, String nome) {
		BooleanBuilder condicoes = new BooleanBuilder();
		
		if(Objects.nonNull(nome) && !nome.isEmpty()) {
			condicoes.and(produto.nome.equalsIgnoreCase(nome));
		}
		var query = new JPAQuery<ProdutoDto>(em);
		query.select(Projections.constructor(ProdutoDto.class, produto))
		.from(mercado)
		.join(mercado.produtos, produto)
		.where(condicoes)
		.orderBy(produto.nome.asc(), produto.id.asc());
		query.limit(pageable.getPageSize());
		query.offset(pageable.getOffset());
		var fetch = query.fetch();
		return new PageImpl<>(fetch, pageable, fetch.size());
	}
}
