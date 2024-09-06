package jv.triersistemas.prova_2.service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import jv.triersistemas.prova_2.dto.MercadoDto;
import jv.triersistemas.prova_2.entity.MercadoEntity;

public interface MercadoService {

	MercadoDto cadastrarMercado(MercadoDto mercado);

	List<BigDecimal> getFaturamentoDoDia(LocalDate data, Long id);

	Optional<MercadoEntity> findById(Long mercadoId);

}
