package jv.triersistemas.projeto_restaurante.dto;

import java.util.List;

import jv.triersistemas.projeto_restaurante.entity.RestauranteEntity;
import jv.triersistemas.projeto_restaurante.enums.TipoComidaEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class RestauranteDto {
	
	private Long id;
	private String nome;
	private String cnpj;
	private Integer estrelas;
	private TipoComidaEnum tipoComida;
	
	
	public RestauranteDto(RestauranteEntity entity) {
		id = entity.getId();
		nome  = entity.getNome();
		cnpj = entity.getCnpj();
		estrelas = entity.getEstrelas();
		tipoComida = entity.getTipoComida();
	}

}
