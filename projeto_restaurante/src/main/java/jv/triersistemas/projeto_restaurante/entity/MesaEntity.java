package jv.triersistemas.projeto_restaurante.entity;

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

}
