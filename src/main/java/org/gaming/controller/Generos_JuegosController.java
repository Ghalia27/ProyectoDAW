package org.gaming.controller;

import org.gaming.repository.IGeneros_JuegosRepository;
import org.gaming.repository.IGeneros_JuegosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Generos_JuegosController {

	@Autowired
	private IGeneros_JuegosRepository repo;
	
	@GetMapping("/listGenJuegos")
	public String listadoGenJuegos(Model model) {
		
		
		model.addAttribute("lstGenJuegos", repo.findAll());
		
		
		
		return "List_GenJuegos";
	}
	
	@GetMapping("/RgstGenJuegos")
	public String RgstGenJuegos(Model model) {

		
		return "Registrar_GenJuegos";
	}
}
