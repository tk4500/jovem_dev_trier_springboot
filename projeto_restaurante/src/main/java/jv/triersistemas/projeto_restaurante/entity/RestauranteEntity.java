package jv.triersistemas.projeto_restaurante.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jv.triersistemas.projeto_restaurante.dto.RestauranteDto;
import jv.triersistemas.projeto_restaurante.enums.TipoComidaEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Entity(name = "restaurante")
public class RestauranteEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Column(nullable = false)
	private String nome;
	@Column(length = 14, unique = true, nullable = false)
	private String cnpj;
	@Column(columnDefinition = "TINYINT" , nullable = false)
	private Integer estrelas = 0;
	@Enumerated(EnumType.ORDINAL)
	private TipoComidaEnum tipoComida;
	@OneToMany(mappedBy = "restaurante", cascade = CascadeType.DETACH)
	private List<FuncionarioEntity> funcionarios;
	@OneToMany(mappedBy = "restaurante", cascade = CascadeType.DETACH)
	private List<ClienteEntity> clientes;
	@OneToMany(mappedBy = "restaurante", cascade = CascadeType.DETACH)
	private List<MesaEntity> mesas;
	
	public RestauranteEntity(RestauranteDto dto) {
		nome = dto.getNome();
		cnpj = dto.getCnpj();
		estrelas = dto.getEstrelas();
	}

}
