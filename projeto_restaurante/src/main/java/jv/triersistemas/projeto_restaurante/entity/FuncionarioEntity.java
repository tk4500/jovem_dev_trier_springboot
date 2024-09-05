package jv.triersistemas.projeto_restaurante.entity;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Optional;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jv.triersistemas.projeto_restaurante.dto.FuncionarioDto;
import jv.triersistemas.projeto_restaurante.enums.CargoEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Entity(name = "funcionario")
public class FuncionarioEntity extends PessoaBaseEntity{
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Column(nullable = false)
	private LocalDate dataAdimissao;
	@Enumerated(EnumType.ORDINAL)
	private CargoEnum cargo;
	@Column(nullable = false)
	private BigDecimal salario;
	private Integer cargaHoraria;
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.DETACH)
	@JoinColumn(name = "restaurante_id", nullable = false)
	private RestauranteEntity restaurante;
	
	
	public FuncionarioEntity(FuncionarioDto dto) {
		 this.nome = dto.getNome();
		 this.cpf = dto.getCpf();
		 this.sobrenome = dto.getSobrenome();
		 this.dataNascimento = dto.getDataNascimento();
		 this.sexo = dto.getSexo();
		 this.telefone = dto.getTelefone();
		 this.dataAdimissao = dto.getDataAdimissao();
		 this.cargo = dto.getCargo();
		 this.cargaHoraria = dto.getCargaHoraria();
	}
	
	public void setRestaurante(RestauranteEntity restaurante) {
		this.restaurante = restaurante;
	}

	public void alteraFuncionario(FuncionarioDto dto) {
		 this.nome = Optional.ofNullable(dto.getNome()).orElse(this.nome);
		 this.cpf = Optional.ofNullable(dto.getCpf()).orElse(this.cpf);
		 this.sobrenome = Optional.ofNullable(dto.getSobrenome()).orElse(this.sobrenome);
		 this.dataNascimento = Optional.ofNullable(dto.getDataNascimento()).orElse(this.dataNascimento);
		 this.sexo = Optional.ofNullable(dto.getSexo()).orElse(this.sexo);
		 this.telefone = Optional.ofNullable(dto.getTelefone()).orElse(this.telefone);
		 this.dataAdimissao = Optional.ofNullable(dto.getDataAdimissao()).orElse(this.dataAdimissao);
		 this.cargo = Optional.ofNullable(dto.getCargo()).orElse(this.cargo);
		 this.cargaHoraria = Optional.ofNullable(dto.getCargaHoraria()).orElse(this.cargaHoraria);
		
	}
}
