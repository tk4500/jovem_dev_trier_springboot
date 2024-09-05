package jv.triersistemas.projeto_restaurante.service.impl;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jv.triersistemas.projeto_restaurante.dto.MesaDto;
import jv.triersistemas.projeto_restaurante.entity.MesaEntity;
import jv.triersistemas.projeto_restaurante.repository.MesaRepository;
import jv.triersistemas.projeto_restaurante.service.MesaService;
import jv.triersistemas.projeto_restaurante.service.RestauranteService;
@Service
public class MesaServiceImpl implements MesaService{

	@Autowired
	private MesaRepository meRepository;
	@Autowired
	private RestauranteService restauranteService;
	
	@Override
	public List<MesaDto> getMesasDisponiveis(Long id, Integer quantidadePessoas, LocalDate data) {
		var mesaEnt = meRepository.searchMesasByCapacidadePessoasAndDataReserva(id, data, quantidadePessoas);
		return mesaEnt.stream().map(MesaDto::new).toList();
	}
	@Override
	public List<MesaDto> getMesas(Long restauranteId) {
		var meEnt = meRepository.findByRestauranteId(restauranteId);
		return meEnt.stream().map(MesaDto::new).toList();
	}
	@Override
	public MesaDto cadastroMesa(Long restauranteId, MesaDto mesa) {
		var meEnt = new MesaEntity(mesa);
		meEnt.setRestaurante(restauranteService.findById(restauranteId).orElseThrow(()->new IllegalArgumentException("id do restaurante invalido")));
		meRepository.save(meEnt);
		return new MesaDto(meEnt);
	}
	@Override
	public MesaDto alteraMesa(MesaDto mesa) {
		var meEnt = meRepository.findById(mesa.getId()).orElseThrow(()->new IllegalArgumentException("id da mesa invalido"));
		 meEnt.alteraMesa(mesa);
		 meRepository.save(meEnt);
		 return new MesaDto(meEnt);
	}
	@Override
	public Optional<MesaEntity> findById(Long mesaId) {
		return meRepository.findById(mesaId);
	}

}
