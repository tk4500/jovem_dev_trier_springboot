package jv.triersistemas.projeto_restaurante.entity;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

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
	private LocalDate dataCadastro = LocalDate.now();
	@Column(nullable = false)
	private Integer quantidadeReservas = 0;
	@Column(nullable = false)
	private BigDecimal quantidadeValorGasto = BigDecimal.valueOf(0);
	@Column(nullable = false)
	private Boolean flgBloqueado = false;
	@OneToMany(mappedBy = "cliente", cascade = CascadeType.DETACH)
	private List<ReservaEntity> reservas;
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.DETACH)
	@JoinColumn(name = "restaurante_id", nullable = false)
	private RestauranteEntity restaurante;
	
	public ClienteEntity(ClienteDto dto) {
		id = dto.getId();
		dataCadastro = dto.getDataCadastro();
		quantidadeReservas = dto.getQuantidadeReservas();
		quantidadeValorGasto = dto.getQuantidadeValorGasto();
		flgBloqueado = dto.getFlgBloqueado();
	}
	

}
