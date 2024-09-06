package jv.triersistemas.prova_2.dto;

import java.math.BigDecimal;

import jv.triersistemas.prova_2.entity.ProdutoEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProdutoDto {

	private Long id;
	private Long mercadoId;
	private String nome;
	private Integer estoque;
	private BigDecimal valorUnitario;
	public ProdutoDto(ProdutoEntity entity) {
		id = entity.getId();
		nome = entity.getNome();
		estoque = entity.getEstoque();
		valorUnitario = entity.getValorUnitario();
		mercadoId = entity.getMercado().getId();
	}
}
