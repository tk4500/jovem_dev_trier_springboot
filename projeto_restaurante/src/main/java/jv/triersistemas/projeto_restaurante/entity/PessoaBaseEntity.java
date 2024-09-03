package jv.triersistemas.projeto_restaurante.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.MappedSuperclass;
import jv.triersistemas.projeto_restaurante.enums.SexoEnum;
import lombok.Getter;
@Getter
@MappedSuperclass
public class PessoaBaseEntity {
	@Column(nullable = false)
	protected String nome;
	@Column(length = 11, unique = true)
	protected String cpf;
	@Column(nullable = false)
	protected String sobrenome;
	@Column(nullable = false)
	protected LocalDate dataNascimento;
	@Enumerated(EnumType.ORDINAL)
	protected SexoEnum sexo;
	@Column(nullable = false, unique = true)
	protected String telefone;
}
