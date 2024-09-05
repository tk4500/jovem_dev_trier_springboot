package jv.triersistemas.projeto_restaurante.entity;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jv.triersistemas.projeto_restaurante.dto.ClienteDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Entity(name = "cliente")
public class ClienteEntity extends PessoaBaseEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Column(nullable = false)
	private LocalDate dataCadastro;
	@Column(nullable = false)
	private Integer quantidadeReservas;
	@Column(nullable = false)
	private BigDecimal quantidadeValorGasto;
	@Column(nullable = false)
	private Boolean flgBloqueado;
	@OneToMany(mappedBy = "cliente", cascade = CascadeType.DETACH)
	private List<ReservaEntity> reservas;
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.DETACH)
	@JoinColumn(name = "restaurante_id", nullable = false)
	private RestauranteEntity restaurante;

	public ClienteEntity(ClienteDto dto) {
		 this.dataCadastro = LocalDate.now();
		 this.quantidadeReservas = 0;
		 this.quantidadeValorGasto = BigDecimal.valueOf(0);
		 this.flgBloqueado = false;
		 this.nome = dto.getNome();
		 this.cpf = dto.getCpf();
		 this.sobrenome = dto.getSobrenome();
		 this.dataNascimento = dto.getDataNascimento();
		 this.sexo = dto.getSexo();
		 this.telefone = dto.getTelefone();
	}
	
	public void setRestaurante(RestauranteEntity restaurante) {
		this.restaurante = restaurante;
	}

	public void alteraCliente(ClienteDto dto) {
		 this.flgBloqueado = Optional.ofNullable(dto.getFlgBloqueado()).orElse(this.flgBloqueado);
		 this.nome = Optional.ofNullable(dto.getNome()).orElse(this.nome);
		 this.cpf = Optional.ofNullable(dto.getCpf()).orElse(this.cpf);
		 this.sobrenome = Optional.ofNullable(dto.getSobrenome()).orElse(this.sobrenome);
		 this.dataNascimento = Optional.ofNullable(dto.getDataNascimento()).orElse(this.dataNascimento);
		 this.sexo = Optional.ofNullable(dto.getSexo()).orElse(this.sexo);
		 this.telefone = Optional.ofNullable(dto.getTelefone()).orElse(this.telefone);
		
	}

}
