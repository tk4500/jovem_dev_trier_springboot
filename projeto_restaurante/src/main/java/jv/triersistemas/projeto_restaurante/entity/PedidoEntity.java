package jv.triersistemas.projeto_restaurante.entity;

import java.math.BigDecimal;
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
import jv.triersistemas.projeto_restaurante.dto.PedidoDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Entity(name = "pedido")
public class PedidoEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Column(columnDefinition = "TEXT", nullable = false)
	private String descricao;
	@Column(nullable = false)
	private BigDecimal valor;
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.DETACH)
	@JoinColumn(name = "reserva_id", nullable = false)
	private ReservaEntity reserva;
	
	public void setReserva(ReservaEntity reserva) {
		this.reserva = reserva;
	}
	
	public PedidoEntity(PedidoDto pedido) {
		this.descricao = pedido.getDescricao();
		this.valor = pedido.getValor();
	}

	public void alteraPedido(PedidoDto pedido) {
		this.descricao = Optional.ofNullable(pedido.getDescricao()).orElse(this.descricao);
		this.valor = Optional.ofNullable(pedido.getValor()).orElse(this.valor);
	}
}
