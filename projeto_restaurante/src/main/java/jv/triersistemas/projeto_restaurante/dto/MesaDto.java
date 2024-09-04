package jv.triersistemas.projeto_restaurante.dto;


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
	
	public MesaDto(MesaEntity entity){
		id = entity.getId();
		numero = entity.getNumero();
		capacidadePessoas = entity.getCapacidadePessoas();
	}
}
