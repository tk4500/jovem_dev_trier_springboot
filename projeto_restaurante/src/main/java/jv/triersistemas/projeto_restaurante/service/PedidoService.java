package jv.triersistemas.projeto_restaurante.service;

import java.util.List;

import jv.triersistemas.projeto_restaurante.dto.PedidoDto;

public interface PedidoService {

	List<PedidoDto> getPedidos(Long reservaId);

	PedidoDto fazerPedido(PedidoDto pedido);

	PedidoDto alteraPedido(PedidoDto pedido);

}
