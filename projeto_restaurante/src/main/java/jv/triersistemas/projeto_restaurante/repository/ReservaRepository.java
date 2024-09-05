package jv.triersistemas.projeto_restaurante.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import jv.triersistemas.projeto_restaurante.entity.ReservaEntity;

@Repository
public interface ReservaRepository extends JpaRepository<ReservaEntity, Long>, ReservaRepositoryCustom {


	
}
