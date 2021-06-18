package org.gaming.controller;


import org.gaming.model.Generos_juegos;
import org.gaming.model.Juegos;
import org.gaming.repository.IClasificacionRepository;
import org.gaming.repository.IEdicionRepository;
import org.gaming.repository.IGeneros_JuegosRepository;
import org.gaming.repository.IJuegosRepository;
import org.gaming.repository.IPlataformaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class JuegosController {

	@Autowired
	private IJuegosRepository repoJuegos;
	@Autowired
	private IGeneros_JuegosRepository repoGenJuegos;
	@Autowired
	private IEdicionRepository repoEdicion;
	@Autowired
	private IClasificacionRepository repoClasificacion;
	@Autowired
	private IPlataformaRepository repoPlataforma;
	
	
	
	@GetMapping("/listJuegos")
	public String listadoGenJuegos(Model model) {
		
		
		model.addAttribute("lstJuegos", repoJuegos.findAll());
		
		
		
		return "List_Juegos";
	}
	
	@PostMapping("/RgstJuegos")
	public String guardarPerfil(@ModelAttribute Juegos Juego, Model model) throws Exception{	
		System.out.println(Juego);
		String message = null;
		ModelAndView vista = new ModelAndView();
		try {
			repoJuegos.save(Juego);
			System.out.println("BIEN.X2......");
			
			vista.setViewName("Registrar_Juegos");
			vista.addObject("mensaje", "Insertado Correctamente");
		}catch(Exception e) {
			System.out.println("ERROR.......");
			
		};
		model.addAttribute("Juego", repoJuegos.findById(Juego.getIdjuego()));
		return "Registrar_Juegos";
	}
	@PostMapping("/buscarJuego")
	public String buscarJuego(@ModelAttribute Juegos  gj, Model model) {
		
		System.out.println(gj);
		model.addAttribute("ListGenJuego", repoGenJuegos.findAll());
		model.addAttribute("ListEdicion", repoEdicion.findAll());
		model.addAttribute("ListPlataform", repoPlataforma.findAll());
		model.addAttribute("ListClasifi", repoClasificacion.findAll());
		model.addAttribute("Juego", repoJuegos.findById(gj.getIdgenero()));
		int a =repoJuegos.findAll().size()+1;
		model.addAttribute("id", a);
		model.addAttribute("opcion", 1);
		return "Registrar_Juegos";
		
	
	}
	@GetMapping("/eliminarJue")
	public String eliminarPerfil(@ModelAttribute Juegos p, Model model) {
		System.out.println(p);
		repoJuegos.delete(p);
		model.addAttribute("Juego",repoJuegos.findById(p.getIdgenero()));
		model.addAttribute("lstJuegos", repoJuegos.findAll());
		return "List_Juegos";
	}
	
}
