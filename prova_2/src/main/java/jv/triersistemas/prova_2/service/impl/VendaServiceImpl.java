package jv.triersistemas.prova_2.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import jv.triersistemas.prova_2.dto.ItemVendaDto;
import jv.triersistemas.prova_2.dto.VendaDto;
import jv.triersistemas.prova_2.entity.VendaEntity;
import jv.triersistemas.prova_2.enums.StatusEnum;
import jv.triersistemas.prova_2.repository.VendaRepository;
import jv.triersistemas.prova_2.service.MercadoService;
import jv.triersistemas.prova_2.service.VendaService;

@Service
public class VendaServiceImpl implements VendaService{

	@Autowired
	VendaRepository repository;
	@Autowired
	MercadoService meService;
	
	@Override
	public VendaDto cadastrarVenda(VendaDto venda) {
		var venEnt = new VendaEntity(venda);
		venEnt.setMercado(meService.findById(venda.getMercadoId()).orElseThrow(()-> new IllegalArgumentException("mercado não encontrado")));
		venEnt = repository.save(venEnt);
		return new VendaDto(venEnt);
	}

	@Override
	public VendaDto cadastrarVendaFinalizada(List<ItemVendaDto> itensVenda) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public VendaDto removerVenda(Long id) {
		var venEnt = repository.findById(id).orElseThrow(()-> new IllegalArgumentException("venda não encontrada"));
		repository.delete(venEnt);
		return new VendaDto(venEnt);
	}

	@Override
	public VendaDto finalizarVenda(Long id) {
		var venEnt = repository.findById(id).orElseThrow(()-> new IllegalArgumentException("venda não encontrada"));
		venEnt.finalizarVenda();
		venEnt = repository.save(venEnt);
		return new VendaDto(venEnt);
	}

	@Override
	public Page<VendaDto> listarVenda(Pageable withPage, Long idVenda, StatusEnum status) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public Optional<VendaEntity> findById(Long id){
		return repository.findById(id);
	}

}
