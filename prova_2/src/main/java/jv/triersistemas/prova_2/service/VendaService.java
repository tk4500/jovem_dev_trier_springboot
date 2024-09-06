package jv.triersistemas.prova_2.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import jv.triersistemas.prova_2.dto.ItemVendaDto;
import jv.triersistemas.prova_2.dto.VendaDto;
import jv.triersistemas.prova_2.entity.VendaEntity;
import jv.triersistemas.prova_2.enums.StatusEnum;

public interface VendaService {

	VendaDto cadastrarVenda(VendaDto venda);

	VendaDto cadastrarVendaFinalizada(List<ItemVendaDto> itensVenda);

	VendaDto removerVenda(Long id);

	Page<VendaDto> listarVenda(Pageable withPage, Long idProduto, StatusEnum status);

	VendaDto finalizarVenda(Long id);

	Optional<VendaEntity> findById(Long vendaId);

}
