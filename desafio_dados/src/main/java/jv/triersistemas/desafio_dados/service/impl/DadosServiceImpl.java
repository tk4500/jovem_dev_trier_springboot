package jv.triersistemas.desafio_dados.service.impl;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jv.triersistemas.desafio_dados.dto.DadosDto;
import jv.triersistemas.desafio_dados.service.DadosService;

@Service
public class DadosServiceImpl implements DadosService {

	@Autowired
	private DadosDto dado;
	@Autowired
	List<Integer> dados;

	@Override
	public Optional<DadosDto> lancaDados(int qtdDados, int valorDados) {
		if (!isBetween(valorDados, qtdDados, qtdDados * 6) || !isBetween(qtdDados, 1, 4))
			return Optional.empty();
		dados.clear();
		for (int i = 0; i < qtdDados; i++) {
			dados.add(((int) (Math.random() * 6 + 1)));
		}
		dado.setDados(Arrays.toString(dados.toArray()));
		dado.setSoma(dados.stream().mapToDouble(i -> i).sum());
		dado.setPercentual(String.format("%.2f%%", (dado.getSoma() / valorDados) * 100));
		return Optional.of(dado);
	}

	private boolean isBetween(int comparator, int min, int max) {
		if (comparator >= min && comparator <= max)
			return true;
		return false;
	}

}
