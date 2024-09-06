package jv.triersistemas.prova_2.entity;

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
import jv.triersistemas.prova_2.dto.VendaDto;
import jv.triersistemas.prova_2.enums.StatusEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Entity(name = "venda")
public class VendaEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Column(nullable = false)
	private BigDecimal valorTotal;
	@Column(nullable = false)
	private LocalDate dataCriacao;
	@Column(nullable = false)
	private StatusEnum status;
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.DETACH)
	@JoinColumn(name = "mercado_id", nullable = false)
	private MercadoEntity mercado;
	@OneToMany(mappedBy = "venda", cascade = CascadeType.DETACH)
	private List<ItemVendaEntity> itensVenda;
	
	public VendaEntity(VendaDto venda) {
		valorTotal = venda.getValorTotal();
		dataCriacao = LocalDate.now();
		status = StatusEnum.EM_ABERTO;
	}
	public void setMercado(MercadoEntity mercado) {
		this.mercado = mercado;
	}
	public void finalizarVenda() {
	status = StatusEnum.FINALIZADO;
		
	}
}
