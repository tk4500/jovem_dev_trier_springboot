package jv.triersistemas.prova_2.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jv.triersistemas.prova_2.dto.MercadoDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Entity(name = "mercado")
public class MercadoEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Column(nullable = false)
	private String nome;
	@Column(nullable = false)
	private String nomeFantasia;
	@Column(length = 14,nullable = false, unique = true)
	private String cnpj;
	@OneToMany(mappedBy = "mercado", cascade = CascadeType.DETACH)
	private List<VendaEntity> vendas;
	@OneToMany(mappedBy = "mercado", cascade = CascadeType.DETACH)
	private List<ProdutoEntity> produtos;
	
	public MercadoEntity(MercadoDto dto) {
		this.nome = dto.getNome();
		this.nomeFantasia = dto.getNomeFantasia();
		this.cnpj = dto.getCnpj();
	}
}
