package jv.triersistemas.primeiro_projeto.dto;

import java.time.LocalDate;


import jv.triersistemas.primeiro_projeto.entity.TarefaEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class TarefaDto {
	private Long id;
	private String titulo;
	private String descricao;
	private boolean completa;
	private CategoriaDto categoria;
	private LocalDate dataCriacao;
	private LocalDate dataExpiracao;
	private Long idCategoria;
	private String nomeCategoria;

	public TarefaDto(TarefaEntity entity) {
		this.id = entity.getId();
		this.titulo = entity.getTitulo();
		this.descricao = entity.getDescricao();
		this.completa = entity.getCompleta();
		this.categoria = new CategoriaDto(entity.getCategoria());
		this.dataCriacao = entity.getDataCriacao();
		this.dataExpiracao = entity.getDataExpiracao();
	}
}