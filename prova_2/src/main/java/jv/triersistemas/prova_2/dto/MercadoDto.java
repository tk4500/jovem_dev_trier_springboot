package jv.triersistemas.prova_2.dto;

import jv.triersistemas.prova_2.entity.MercadoEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class MercadoDto {
	private Long id;
	private String nome;
	private String nomeFantasia;
	private String cnpj;
	
	public MercadoDto(MercadoEntity entity) {
		id = entity.getId();
		nome = entity.getNome();
		nomeFantasia = entity.getNomeFantasia();
		cnpj = entity.getCnpj();
		
	}
}
