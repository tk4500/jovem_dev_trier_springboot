package jv.triersistemas.prova_2.service.impl;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jv.triersistemas.prova_2.dto.MercadoDto;
import jv.triersistemas.prova_2.entity.MercadoEntity;
import jv.triersistemas.prova_2.repository.MercadoRepository;
import jv.triersistemas.prova_2.service.MercadoService;

@Service
public class MercadoServiceImpl implements MercadoService{
	
	@Autowired
	MercadoRepository repository;

	@Override
	public MercadoDto cadastrarMercado(MercadoDto mercado) throws IllegalArgumentException{
		verificaCnpj(mercado);
		var merEnt = new MercadoEntity(mercado);
		merEnt = repository.save(merEnt);
		return new MercadoDto(merEnt);
	}

	private void verificaCnpj(MercadoDto mercado) throws IllegalArgumentException{
		if(repository.existsByCnpj(mercado.getCnpj())) {
			throw new IllegalArgumentException("cnpj já cadastrado");
		}
		
	}

	@Override
	public List<BigDecimal> getFaturamentoDoDia(LocalDate data, Long id) {
		findById(id).orElseThrow(()-> new IllegalArgumentException("mercado não encontrado"));
		return repository.valorDeVendasByData(data, id);
	}

	@Override
	public Optional<MercadoEntity> findById(Long mercadoId) {
		return repository.findById(mercadoId);
	}

}
