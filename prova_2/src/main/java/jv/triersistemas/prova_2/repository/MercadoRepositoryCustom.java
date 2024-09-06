package jv.triersistemas.prova_2.repository;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;


public interface MercadoRepositoryCustom {

	List<BigDecimal> valorDeVendasByData(LocalDate data, Long id);
}
