package jv.triersistemas.projeto_restaurante.service.impl;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jv.triersistemas.projeto_restaurante.dto.MesaDto;
import jv.triersistemas.projeto_restaurante.repository.MesaRepository;
import jv.triersistemas.projeto_restaurante.service.MesaService;
@Service
public class MesaServiceImpl implements MesaService{

	@Autowired
	private MesaRepository mesaRepository;
	@Override
	public List<MesaDto> getMesasDisponiveis(Long id, Integer quantidadePessoas, LocalDate data) {
		var mesaEnt = mesaRepository.searchMesasByCapacidadePessoasandDataReserva(id, data, quantidadePessoas);
		return mesaEnt.stream().map(MesaDto::new).toList();
	}

}
