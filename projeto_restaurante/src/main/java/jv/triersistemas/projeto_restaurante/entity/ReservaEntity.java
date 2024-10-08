package jv.triersistemas.projeto_restaurante.entity;

import java.time.LocalDate;
import java.util.List;
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
import jakarta.persistence.OneToMany;
import jv.triersistemas.projeto_restaurante.dto.ReservaDto;
import jv.triersistemas.projeto_restaurante.enums.StatusEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Entity(name = "reserva")
public class ReservaEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Column(nullable = false)
	private LocalDate dataReserva;
	@Column(nullable = false)
	private Integer quantidadePessoas;
	@Enumerated(EnumType.ORDINAL)
	@Column(nullable = false)
	private StatusEnum status;
	@Column(columnDefinition = "TEXT")
	private String observacao;
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.DETACH)
	@JoinColumn(name = "cliente_id", nullable = false)
	private ClienteEntity cliente;
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.DETACH)
	@JoinColumn(name = "mesa_id", nullable = false)
	private MesaEntity mesa;
	@OneToMany(mappedBy = "reserva", cascade = CascadeType.DETACH)
	private List<PedidoEntity> pedidos;
	
	public void atualizaStatus(StatusEnum status) {
		this.status = status;
	}
	
	public ReservaEntity(ReservaDto dto) {
		 this.dataReserva = dto.getDataReserva();
		 this.quantidadePessoas = dto.getQuantidadePessoas();
		 this.status = Optional.of(dto.getStatus()).orElse(StatusEnum.AGENDADA);
	}
	public void atualizaMesa(MesaEntity mesa) {
		this.mesa = mesa;
	}
	public void atualizaCliente(ClienteEntity cliente) {
		this.cliente = cliente;
	}
}
