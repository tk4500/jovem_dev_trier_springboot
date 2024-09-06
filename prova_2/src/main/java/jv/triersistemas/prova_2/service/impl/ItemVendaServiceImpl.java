package jv.triersistemas.prova_2.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jv.triersistemas.prova_2.dto.ItemVendaDto;
import jv.triersistemas.prova_2.entity.ItemVendaEntity;
import jv.triersistemas.prova_2.repository.ItemVendaRepository;
import jv.triersistemas.prova_2.service.ItemVendaService;
import jv.triersistemas.prova_2.service.ProdutoService;
import jv.triersistemas.prova_2.service.VendaService;

@Service
public class ItemVendaServiceImpl implements ItemVendaService{

	@Autowired
	ItemVendaRepository repository;
	@Autowired
	VendaService veService;
	@Autowired
	ProdutoService peService;
	@Override
	public ItemVendaDto adicionarItem(ItemVendaDto itemVenda) {
		var iteEnt = new ItemVendaEntity(itemVenda);
		iteEnt.setProduto(peService.findById(itemVenda.getProdutoId()).orElseThrow(()-> new IllegalArgumentException("produto não cadastrado")));
		iteEnt.setVenda(veService.findById(itemVenda.getVendaId()).orElseThrow(()-> new IllegalArgumentException("produto não cadastrado")));
		iteEnt.setValorTotal();
		return null;
	}

	@Override
	public ItemVendaDto removerItem(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

}
