package jv.triersistemas.projeto_restaurante.dto;

import java.math.BigDecimal;

import jv.triersistemas.projeto_restaurante.entity.PedidoEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PedidoDto {
	private Long id;
	private String descricao;
	private BigDecimal valor;
	private ReservaDto reserva;
	
	PedidoDto(PedidoEntity entity){
		id = entity.getId();
		descricao = entity.getDescricao();
		valor = entity.getValor();
		reserva = new ReservaDto(entity.getReserva());
	}
}
