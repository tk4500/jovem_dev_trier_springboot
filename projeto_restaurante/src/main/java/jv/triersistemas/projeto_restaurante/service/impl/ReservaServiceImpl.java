package jv.triersistemas.projeto_restaurante.service.impl;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jv.triersistemas.projeto_restaurante.dto.ReservaDto;
import jv.triersistemas.projeto_restaurante.entity.ReservaEntity;
import jv.triersistemas.projeto_restaurante.enums.StatusEnum;
import jv.triersistemas.projeto_restaurante.repository.ReservaRepository;
import jv.triersistemas.projeto_restaurante.service.ReservaService;

@Service
public class ReservaServiceImpl implements ReservaService {

	@Autowired
	ReservaRepository reRepository;


	@Override
	public String getDisponibilidade(Integer mesa, LocalDate data) throws IllegalArgumentException {
		testeMesa(mesa);
		if (!isDisponivel(mesa, data)) {
			return "Mesa " + mesa + " já cadastrada para o dia";
		}
		return "Mesa " + mesa + " ainda está disponivel";
	}

	private void testeMesa(Integer mesa) throws IllegalArgumentException {
		if (mesa < 1 || mesa > 20)
			throw new IllegalArgumentException("Numero da Mesa Invalido");
	}

	private boolean isDisponivel(Integer mesa, LocalDate reserva) {
		var reList = reRepository.existsByNumeroMesaAndDataReserva(mesa, reserva);
		return !reList;
	}
	
	@Override
	public ReservaDto postReserva(ReservaDto reserva) {
		// TODO Auto-generated method stub
		return null;
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
	


}
