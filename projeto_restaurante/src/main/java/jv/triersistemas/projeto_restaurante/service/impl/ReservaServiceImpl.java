package jv.triersistemas.projeto_restaurante.service.impl;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jv.triersistemas.projeto_restaurante.dto.ReservaDto;
import jv.triersistemas.projeto_restaurante.entity.ReservaEntity;
import jv.triersistemas.projeto_restaurante.enums.StatusEnum;
import jv.triersistemas.projeto_restaurante.repository.ReservaRepository;
import jv.triersistemas.projeto_restaurante.service.ClienteService;
import jv.triersistemas.projeto_restaurante.service.MesaService;
import jv.triersistemas.projeto_restaurante.service.ReservaService;
import jv.triersistemas.projeto_restaurante.service.RestauranteService;

@Service
public class ReservaServiceImpl implements ReservaService {

	@Autowired
	ReservaRepository reRepository;
	@Autowired
	ClienteService clService;
	@Autowired
	MesaService meService;
	@Autowired
	RestauranteService restauranteService;
	
	@Override
	public ReservaDto fazerReserva(ReservaDto reserva) {
		var reEnt = new ReservaEntity(reserva);
		reEnt.atualizaCliente(clService.findById(reserva.getClienteId()).orElseThrow(()->new IllegalArgumentException("id do cliente invalido")));
		reEnt.atualizaMesa(meService.findById(reserva.getMesaId()).orElseThrow(()->new IllegalArgumentException("id da mesa invalido")));
		reRepository.save(reEnt);
		return new ReservaDto(reEnt);
	}

	@Override
	public ReservaDto alteraStatus(Long id, StatusEnum status) throws IllegalArgumentException {
		var resEnt = reRepository.findById(id).orElseThrow(()->new IllegalArgumentException("id da reserva invalido"));
		switch (status) {
		case CANCELADA:
			if(resEnt.getDataReserva().isBefore(LocalDate.now())) {
				return atualizaStatus(resEnt,status);
				
			}else {
				throw new IllegalArgumentException("Mesa não pode ser cancelada, o cancelamento deve ser feito com 1 dia de antecedência");
			}
		case CONCLUIDA:
			if(!resEnt.getDataReserva().isBefore(LocalDate.now())) {
				return atualizaStatus(resEnt,status);
			}else {
				throw new IllegalArgumentException("Mesa não pode ser concluida, a conclusão deve ser feita no mesmo dia ou posterior");
			}
		case INADIMPLENTE:
			throw new IllegalArgumentException("valor INADIMPLENTE não pode ser cadastrado manualmente");
		default:
			return atualizaStatus(resEnt,status);
		}
	}
	

	
	private ReservaDto atualizaStatus(ReservaEntity resEnt, StatusEnum status) {
		resEnt.atualizaStatus(status);
		return reservaSave(resEnt);
	}
	
	private ReservaDto reservaSave(ReservaEntity resEnt) {
		var resSave = reRepository.save(resEnt);
		return new ReservaDto(resSave);
	}

	@Override
	public List<ReservaDto> getReservas(Long restauranteId, StatusEnum status) {
		var reEnt = reRepository.findByRestauranteIdAndStatus(restauranteId,status);
		return reEnt.stream().map(ReservaDto::new).toList();
	}

	@Override
	public Optional<ReservaEntity> findById(Long reservaId) {
		return reRepository.findById(reservaId);
	}



	


}
