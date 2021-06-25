package org.gaming.controller;

import org.gaming.model.Generos;
import org.gaming.model.Juegos;
import org.gaming.repository.IClasificacionRepository;
import org.gaming.repository.IEdicionRepository;
import org.gaming.repository.IGeneros_JuegosRepository;
import org.gaming.repository.IJuegosRepository;
import org.gaming.repository.IPlataformaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class JuegosController {

	@Autowired
	private IJuegosRepository repo;
	@Autowired
	private IGeneros_JuegosRepository repo_generos_juegos;
	@Autowired
	private IPlataformaRepository repo_plataformas;
	@Autowired
	private IClasificacionRepository repo_clasificacion;
	@Autowired
	private IEdicionRepository repo_ediciones;
	
	

	
	@GetMapping("/cargarJuego")
	public String cargarJuego(Model model) {

		model.addAttribute("juegos", new Juegos());
		model.addAttribute("ListGenJuego", repo_generos_juegos.findAll());
		model.addAttribute("ListPlataform", repo_plataformas.findAll());
		model.addAttribute("ListClasifi", repo_clasificacion.findAll());
		model.addAttribute("ListEdicion", repo_ediciones.findAll());
		return "Registrar_Juegos";
	} 
	
	@PostMapping("/grabarJuego")
	public String guardarJuegos(@ModelAttribute Juegos juegos, Model model,  BindingResult bindingResult, RedirectAttributes redirectAttrs) throws Exception{	
		
		System.out.println(juegos.getIdjuego());
		System.out.println(repo.findById(juegos.getIdjuego()));
		 if (bindingResult.hasErrors()) {
		        return "Registrar_Juegos";
	    }
	    if (repo.findFirstByIdjuego(juegos.getIdjuego()) != null) {
	    	 repo.save(juegos);
	        redirectAttrs
	                .addFlashAttribute("mensaje", "Este Id ya se encuentra registrado")
	                .addFlashAttribute("clase", "warning");
	        return "Editar_Juegos";
	    }
	    repo.save(juegos);
	    redirectAttrs
	            .addFlashAttribute("mensaje", "Agregado correctamente")
	            .addFlashAttribute("clase", "success");
	    return "redirect:/cargarJuego";
		
		/*
		
		System.out.println(juegos);
		ModelAndView vista = new ModelAndView();
		repo.save(juegos);
		if (repo.findById(juegos.getIdjuego()).isPresent()){
			vista.addObject("mensaje", "Modificado Correctamente");
			vista.setViewName("Registrar_Juegos");		
			return vista;
		}else {
			vista.addObject("mensaje", "Error");
			vista.setViewName("Registrar_Juegos");		

			return vista;
		}*/
		
	}

	@GetMapping("/listarJuego")
	public String listadoJuegos(Model model) {
		model.addAttribute("lstJuegos", repo.findAll());
		model.addAttribute("ListGenJuego", repo_generos_juegos.findAll());
		model.addAttribute("ListPlataform", repo_plataformas.findAll());
		model.addAttribute("ListClasifi", repo_clasificacion.findAll());
		model.addAttribute("ListEdicion", repo_ediciones.findAll());
		return "Listar_Juegos";
	}
	
	@PostMapping("/eliminarJuego")
	public String eliminarJuego(@ModelAttribute Juegos j, Model model) {
		System.out.println(j);
		repo.delete(j);
		model.addAttribute("juegos",repo.findById(j.getIdjuego()));
		return "Listar_Juegos";
	}
	@PostMapping("/buscarJuego")
	public String buscarJuego(@ModelAttribute Juegos j,  Model model) {
		System.out.println(j);
		model.addAttribute("juegos",repo.findById(j.getIdjuego()));
		model.addAttribute("ListGenJuego", repo_generos_juegos.findAll());
		model.addAttribute("ListPlataform", repo_plataformas.findAll());
		model.addAttribute("ListClasifi", repo_clasificacion.findAll());
		model.addAttribute("ListEdicion", repo_ediciones.findAll());
		return "Editar_Juegos";
	}

	@PostMapping("/editar")
	public ModelAndView actualizarJuego(@ModelAttribute  Juegos juego, Model model, BindingResult bindingResult) throws Exception{	
		System.out.println(juego);
		ModelAndView vista = new ModelAndView();
		repo.save(juego);
		Juegos posibleJuegoExistente = repo.findFirstByIdjuego(juego.getIdjuego());
		if (posibleJuegoExistente != null && !(posibleJuegoExistente.getIdjuego() ==juego.getIdjuego())){
			vista.addObject("mensaje", "Error");
			vista.addObject("clase", "danger");
			vista.addObject("ListGenJuego", repo_generos_juegos.findAll());
			vista.addObject("ListPlataform", repo_plataformas.findAll());
			vista.addObject("ListClasifi", repo_clasificacion.findAll());
			vista.addObject("ListEdicion", repo_ediciones.findAll());	
			vista.setViewName("Editar_Juegos");		
			return vista;
		}
		vista.addObject("mensaje", "Registrado Correctamente");
		vista.addObject("clase", "success");
		vista.addObject("ListGenJuego", repo_generos_juegos.findAll());
		vista.addObject("ListPlataform", repo_plataformas.findAll());
		vista.addObject("ListClasifi", repo_clasificacion.findAll());
		vista.addObject("ListEdicion", repo_ediciones.findAll());	
		vista.setViewName("Editar_Juegos");		
		return vista;
		
	}
	
	
}
