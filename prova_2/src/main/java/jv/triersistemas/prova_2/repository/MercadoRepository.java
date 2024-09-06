package jv.triersistemas.prova_2.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import jv.triersistemas.prova_2.entity.MercadoEntity;

@Repository
public interface MercadoRepository extends JpaRepository<MercadoEntity, Long>, MercadoRepositoryCustom{

	boolean existsByCnpj(String cnpj);
}
