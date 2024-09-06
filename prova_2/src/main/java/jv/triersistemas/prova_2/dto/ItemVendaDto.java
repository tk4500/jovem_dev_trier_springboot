package jv.triersistemas.prova_2.dto;

import java.math.BigDecimal;

import jv.triersistemas.prova_2.entity.ItemVendaEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ItemVendaDto {
	private Long id;
	private Long vendaId;
	private Long produtoId;
	private Integer quantidade;
	private BigDecimal valorTotal;
	
	ItemVendaDto(ItemVendaEntity entity){
		id = entity.getId();
		vendaId = entity.getVenda().getId();
		produtoId = entity.getProduto().getId();
		quantidade = entity.getQuantidade();
		valorTotal = entity.getValorTotal();
	}


}


