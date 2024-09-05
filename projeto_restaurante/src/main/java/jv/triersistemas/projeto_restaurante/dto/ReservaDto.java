package jv.triersistemas.projeto_restaurante.dto;

import java.time.LocalDate;

import jv.triersistemas.projeto_restaurante.entity.ReservaEntity;
import jv.triersistemas.projeto_restaurante.enums.StatusEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ReservaDto {
	private Long id;
	private LocalDate dataReserva;
	private Integer quantidadePessoas;
	private StatusEnum status;
	private String observacao;
	private Long clienteId;
	private Long mesaId;
	
	public ReservaDto(ReservaEntity entity){
		id = entity.getId();
		dataReserva = entity.getDataReserva();
		quantidadePessoas = entity.getQuantidadePessoas();
		status = entity.getStatus();
		observacao = entity.getObservacao();
		clienteId = entity.getCliente().getId();
		mesaId = entity.getMesa().getId();
	}

}
