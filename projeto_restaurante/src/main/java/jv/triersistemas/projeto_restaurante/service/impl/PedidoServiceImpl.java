package jv.triersistemas.projeto_restaurante.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jv.triersistemas.projeto_restaurante.dto.MesaDto;
import jv.triersistemas.projeto_restaurante.dto.PedidoDto;
import jv.triersistemas.projeto_restaurante.entity.PedidoEntity;
import jv.triersistemas.projeto_restaurante.repository.PedidoRepository;
import jv.triersistemas.projeto_restaurante.service.PedidoService;
import jv.triersistemas.projeto_restaurante.service.ReservaService;

@Service
public class PedidoServiceImpl implements PedidoService{

	
	@Autowired
	PedidoRepository peRepository;
	@Autowired
	ReservaService reService;
	
	
	@Override
	public List<PedidoDto> getPedidos(Long reservaId) {
		var reEnt = reService.findById(reservaId).orElseThrow(()-> new IllegalArgumentException("id da reserva não encontrado"));
		return reEnt.getPedidos().stream().map(PedidoDto::new).toList();
	}

	@Override
	public PedidoDto fazerPedido(PedidoDto pedido) {
		var peEnt = new PedidoEntity(pedido);
		peEnt.setReserva(reService.findById(pedido.getReservaId()).orElseThrow(()->new IllegalArgumentException("id da reserva não encontrado")));
		peRepository.save(peEnt);
		return new PedidoDto(peEnt);
	}

	@Override
	public PedidoDto alteraPedido(PedidoDto pedido) {
		var peEnt = peRepository.findById(pedido.getId()).orElseThrow(()->new IllegalArgumentException("id do pedido invalido"));
		 peEnt.alteraPedido(pedido);
		 peRepository.save(peEnt);
		 return new PedidoDto(peEnt);
	}

}
