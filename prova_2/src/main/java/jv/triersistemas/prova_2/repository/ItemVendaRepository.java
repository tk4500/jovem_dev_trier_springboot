package jv.triersistemas.prova_2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import jv.triersistemas.prova_2.entity.ItemVendaEntity;

@Repository
public interface ItemVendaRepository extends JpaRepository<ItemVendaEntity, Long> {

}
