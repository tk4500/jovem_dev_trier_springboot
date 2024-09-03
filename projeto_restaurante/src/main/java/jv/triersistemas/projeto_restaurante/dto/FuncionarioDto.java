package jv.triersistemas.projeto_restaurante.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

import jv.triersistemas.projeto_restaurante.entity.FuncionarioEntity;
import jv.triersistemas.projeto_restaurante.enums.CargoEnum;
import jv.triersistemas.projeto_restaurante.enums.SexoEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class FuncionarioDto {
	private Long id;
	private String nome;
	protected String cpf;
	protected String sobrenome;
	protected LocalDate dataNascimento;
	protected SexoEnum sexo;
	protected String telefone;
	private LocalDate dataAdimissao;
	private CargoEnum cargo;
	private BigDecimal salario;
	private Integer cargaHoraria;
	private RestauranteDto restaurante;
	
	public FuncionarioDto(FuncionarioEntity entity) {
		id = entity.getId();
		nome = entity.getNome();
		cpf = entity.getCpf();
		sobrenome = entity.getSobrenome();
		dataNascimento = entity.getDataNascimento();
		sexo = entity.getSexo();
		telefone = entity.getTelefone();
		dataAdimissao = entity.getDataAdimissao();
		cargo = entity.getCargo();
		salario = entity.getSalario();
		cargaHoraria = entity.getCargaHoraria();
		restaurante = new RestauranteDto(entity.getRestaurante());
	}
}
