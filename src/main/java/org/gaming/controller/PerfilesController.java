package org.gaming.controller;

import org.gaming.model.Perfiles;
import org.gaming.repository.IPerfilesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PerfilesController {
	
	@Autowired
	private IPerfilesRepository repo;
	
	@GetMapping("/cargarPerfil")
	public String cargarPerfil(Model model) {
		model.addAttribute("perfiles", new Perfiles());
		return "Mantener_Perfiles";
	}
	
	@PostMapping("/grabarPerfil")
	public String guardarPerfil(@ModelAttribute Perfiles perfiles, Model model) throws Exception{	
		System.out.println(perfiles);
		String message = null;
		ModelAndView vista = new ModelAndView();
		try {
			repo.save(perfiles);
			System.out.println("BIEN.X2......");
			//model.addAttribute("message","Baeldung");
			vista.setViewName("Mantener_Perfiles");
			vista.addObject("mensaje", "Insertado Correctamente");
		}catch(Exception e) {
			System.out.println("ERROR.......");
			
		};
		return "Mantener_Perfiles";
	}
	
	@GetMapping("/listarPerfil")
	public String listadoPerfil(Model model) {	
		model.addAttribute("lstPerfil", repo.findAll());
		return "Listar_Perfiles";
	}
	
	
	@PostMapping("/buscarPerfil")
	public String buscarPerfil(@ModelAttribute Perfiles p, Model model) {
		System.out.println(p);
		model.addAttribute("perfiles",repo.findById(p.getIdperfil()));
		return "Mantener_Perfiles";
	}
	
	// Evaluar si va a haber un eliminar 
	@PostMapping("/eliminarPerfil")
	public String eliminarPerfil(@ModelAttribute Perfiles p, Model model) {
		System.out.println(p);
		repo.delete(p);
		model.addAttribute("perfiles",repo.findById(p.getIdperfil()));
		return "Mantener_Perfiles";
	}
}
