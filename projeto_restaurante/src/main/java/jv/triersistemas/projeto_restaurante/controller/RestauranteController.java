package jv.triersistemas.projeto_restaurante.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jv.triersistemas.projeto_restaurante.service.RestauranteService;

@RestController
@RequestMapping("/restaurante")
public class RestauranteController {

	@Autowired
	RestauranteService restauranteService;
	
}
