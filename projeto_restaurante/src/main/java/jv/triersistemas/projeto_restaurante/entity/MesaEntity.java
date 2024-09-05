package jv.triersistemas.projeto_restaurante.entity;

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
import jv.triersistemas.projeto_restaurante.dto.MesaDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Entity(name = "mesa")
public class MesaEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Column(unique = true, nullable = false)
	private Integer numero;
	@Column(nullable = false)
	private Integer capacidadePessoas;
	@OneToMany(mappedBy = "mesa", cascade = CascadeType.DETACH)
	private List<ReservaEntity> reservas;
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.DETACH)
	@JoinColumn(name = "restaurante_id", nullable = false)
	private RestauranteEntity restaurante;
	
	public void setRestaurante(RestauranteEntity restaurante) {
		this.restaurante = restaurante;	
	}
	
	public MesaEntity(MesaDto dto) {
		 this.numero = dto.getNumero();
		 this.capacidadePessoas = dto.getCapacidadePessoas();
	}
	
	public void alteraMesa(MesaDto dto) {
		this.numero = Optional.ofNullable(dto.getNumero()).orElse(this.numero);
		 this.capacidadePessoas = Optional.ofNullable(dto.getCapacidadePessoas()).orElse(this.capacidadePessoas);
		
	}

}
