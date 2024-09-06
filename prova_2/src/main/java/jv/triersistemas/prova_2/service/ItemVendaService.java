package jv.triersistemas.prova_2.service;

import jv.triersistemas.prova_2.dto.ItemVendaDto;

public interface ItemVendaService {

	ItemVendaDto adicionarItem(ItemVendaDto itemVenda);

	ItemVendaDto removerItem(Long id);

}
