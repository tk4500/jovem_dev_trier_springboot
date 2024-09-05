package jv.triersistemas.projeto_restaurante.dto;

import java.math.BigDecimal;
import java.time.LocalDate;
import jv.triersistemas.projeto_restaurante.entity.ClienteEntity;
import jv.triersistemas.projeto_restaurante.enums.SexoEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ClienteDto {
	private Long id;
	private String nome;
	protected String cpf;
	protected String sobrenome;
	protected LocalDate dataNascimento;
	protected SexoEnum sexo;
	protected String telefone;
	private LocalDate dataCadastro;
	private Integer quantidadeReservas;
	private BigDecimal quantidadeValorGasto;
	private Boolean flgBloqueado;
	
	public ClienteDto(ClienteEntity entity) {
		id = entity.getId();
		nome = entity.getNome();
		cpf = entity.getCpf();
		sobrenome = entity.getSobrenome();
		dataNascimento = entity.getDataNascimento();
		sexo = entity.getSexo();
		telefone = entity.getTelefone();
		dataCadastro = entity.getDataCadastro();
		quantidadeReservas = entity.getQuantidadeReservas();
		quantidadeValorGasto = entity.getQuantidadeValorGasto();
		flgBloqueado = entity.getFlgBloqueado();
	}
}
