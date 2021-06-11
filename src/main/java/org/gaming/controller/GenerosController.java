package org.gamingaddicted.controller;

import org.gamingaddicted.model.Generos;
import org.gamingaddicted.repository.IGenerosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class GenerosController {
	@Autowired
	private IGenerosRepository repo;
	
	@GetMapping("/cargarGenero")
	public String cargarGeneros(Model model) {
		model.addAttribute("generos", new Generos());
		return "Mantener_Generos";
	}
	
	@PostMapping("/grabarGenero")
	public String guardarGeneros(@ModelAttribute Generos generos, Model model) throws Exception{	
		System.out.println(generos);
		String message = null;
		ModelAndView vista = new ModelAndView();
		try {
			repo.save(generos);
			System.out.println("BIEN.X2......");
			//model.addAttribute("message","Baeldung");
			vista.setViewName("Mantener_Perfiles");
			vista.addObject("mensaje", "Insertado Correctamente");
		}catch(Exception e) {
			System.out.println("ERROR.......");
			
		};
		return "Mantener_Generos";
	}
	
	@GetMapping("/listarGenero")
	public String listadoGeneros(Model model) {	
		model.addAttribute("lstGeneros", repo.findAll());
		return "Listar_Generos";
	}
	
	
	@PostMapping("/buscarGenero")
	public String buscarGeneros(@ModelAttribute Generos g, Model model) {
		System.out.println(g);
		model.addAttribute("generos",repo.findById(g.getIdgenero()));
		return "Mantener_Generos";
	}
}
