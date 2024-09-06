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
import jv.triersistemas.prova_2.dto.ProdutoDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Entity(name = "produto")
public class ProdutoEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.DETACH)
	@JoinColumn(name = "mercado_id", nullable = false)
	private MercadoEntity mercado;
	@Column(nullable = false)
	private String nome;
	@Column(nullable = false)
	private Integer estoque;
	@Column(nullable = false)
	private BigDecimal valorUnitario;
	public ProdutoEntity(ProdutoDto produto) {
		nome = produto.getNome();
		estoque = produto.getEstoque();
		valorUnitario = produto.getValorUnitario();
	}
	public void setMercado(MercadoEntity mercado) {
		this.mercado = mercado;
	}
	public void alterarEstoque(Integer estoque) {
		this.estoque = estoque;
	}
	public void alterarValor(BigDecimal valorUnitario) {
		this.valorUnitario = valorUnitario;
	}
}
