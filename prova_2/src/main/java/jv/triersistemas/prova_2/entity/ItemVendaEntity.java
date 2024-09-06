package jv.triersistemas.prova_2.entity;

import java.math.BigDecimal;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jv.triersistemas.prova_2.dto.ItemVendaDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Entity(name = "item_venda")
public class ItemVendaEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.DETACH)
	@JoinColumn(name = "venda_id", nullable = false)
	private VendaEntity venda;
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.DETACH)
	@JoinColumn(name = "produto_id", nullable = false)
	private ProdutoEntity produto;
	@Column(nullable = false)
	private Integer quantidade;
	@Column(nullable = false)
	private BigDecimal valorTotal;
	
	public ItemVendaEntity(ItemVendaDto itemVenda) {
		quantidade = itemVenda.getQuantidade();
	}

	public void setProduto(ProdutoEntity produto) {
		this.produto = produto;
	}
	public void setVenda(VendaEntity venda) {
		this.venda = venda;
	}

	public void setValorTotal() {
		valorTotal = produto.getValorUnitario().multiply(BigDecimal.valueOf(quantidade));
		
	}
}
