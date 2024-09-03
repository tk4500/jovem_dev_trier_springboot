package jv.triersistemas.projeto_restaurante.dto;

import java.util.List;

import jv.triersistemas.projeto_restaurante.entity.MesaEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class MesaDto {
	private Long id;
	private Integer numero;
	private Integer capacidadePessoas;
	private RestauranteDto restaurante;
	
	MesaDto(MesaEntity entity){
		id = entity.getId();
		numero = entity.getNumero();
		capacidadePessoas = entity.getCapacidadePessoas();
		restaurante = new RestauranteDto(entity.getRestaurante());
	}
}
