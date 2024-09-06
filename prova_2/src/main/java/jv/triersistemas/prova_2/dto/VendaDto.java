package jv.triersistemas.prova_2.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

import jv.triersistemas.prova_2.entity.VendaEntity;
import jv.triersistemas.prova_2.enums.StatusEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class VendaDto {

	private Long id;
	private BigDecimal valorTotal;
	private LocalDate dataCriacao;
	private StatusEnum status;
	private Long mercadoId;
	public VendaDto(VendaEntity entity) {
		id = entity.getId();
		valorTotal = entity.getValorTotal();
		dataCriacao = entity.getDataCriacao();
		status = entity.getStatus();
		mercadoId = entity.getMercado().getId();
	}
}
