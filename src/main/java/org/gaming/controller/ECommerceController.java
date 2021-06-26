package org.gaming.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.gaming.model.Carrito;
import org.gaming.model.DetalleCabecera;
import org.gaming.model.Ediciones;
import org.gaming.model.Juegos;
import org.gaming.repository.IClasificacionRepository;
import org.gaming.repository.IECommerceRepository;
import org.gaming.repository.IEdicionRepository;
import org.gaming.repository.IGeneros_JuegosRepository;
import org.gaming.repository.IJuegosRepository;
import org.gaming.repository.IPlataformaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class ECommerceController {
	@Autowired
	private IECommerceRepository repo_commecer;
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
	
	@GetMapping("/ListaProductos")
	public String listadoJuegos(Model model) {
		model.addAttribute("lstJuegos", repo.findAll());
		model.addAttribute("ListGenJuego", repo_generos_juegos.findAll());
		model.addAttribute("ListPlataform", repo_plataformas.findAll());
		model.addAttribute("ListClasifi", repo_clasificacion.findAll());
		model.addAttribute("ListEdicion", repo_ediciones.findAll());
		return "Listar_JuegosECommerce";
	}
	
	private ArrayList<Carrito> obtenerCarrito(HttpServletRequest request) {
	    ArrayList<Carrito> carrito = (ArrayList<Carrito>) request.getSession().getAttribute("carrito");
	    if (carrito == null) {
	        carrito = new ArrayList<>();
	    }
	    return carrito;
	}

	private void guardarCarrito(ArrayList<Carrito> carrito, HttpServletRequest request) {
	    request.getSession().setAttribute("carrito", carrito);
	}
	@GetMapping("/greeting")
	public String saludos(Model model) {
		// lo que tenga que hacer // envia atributos a las páginas
		return "vender"; // nombre de la página de resultado
	}

	
	@GetMapping("/vender")
	public String interfazVender(Model model, HttpServletRequest request) {
	    model.addAttribute("juegos", new Juegos());
	    float total = 0;
	    ArrayList<Carrito> carrito = this.obtenerCarrito(request);
	    for (Carrito p: carrito) total += p.getTotal();
	    model.addAttribute("total", total);
	    return "vender";
	}
	
	@PostMapping(value = "/agregarVenta")
	public String agregarAlCarrito(@ModelAttribute Juegos juego, HttpServletRequest request, RedirectAttributes redirectAttrs) {
	    ArrayList<Carrito> carrito = this.obtenerCarrito(request);
	    Juegos productoBuscadoPorCodigo = repo.findFirstByIdjuego(juego.getIdjuego());
	    if (repo.findById(juego.getIdjuego()) == null) {
	        redirectAttrs
	                .addFlashAttribute("mensaje", "El producto con el código " + juego.getIdjuego() + " no existe")
	                .addFlashAttribute("clase", "warning");
	        return "redirect:/vender/";
	    }
	    boolean encontrado = false;
	    for (Carrito productoParaVenderActual : carrito) {
	        if (productoParaVenderActual.getIdjuego() == productoBuscadoPorCodigo.getIdjuego()) {
	            productoParaVenderActual.aumentarCantidad();
	            encontrado = true;
	            break;
	        }
	    }
	    if (!encontrado) {
	        carrito.add(new Carrito(productoBuscadoPorCodigo.getTitulo(), productoBuscadoPorCodigo.getIdjuego(), productoBuscadoPorCodigo.getPrecio(), productoBuscadoPorCodigo.getStock(), 1f));
	    }
	    this.guardarCarrito(carrito, request);
	    return "redirect:/vender/";
	}
	
	@PostMapping(value = "/quitar/{indice}")
	public String quitarDelCarrito(@PathVariable int indice, HttpServletRequest request) {
	    ArrayList<Carrito> carrito = this.obtenerCarrito(request);
	    if (carrito != null && carrito.size() > 0 && carrito.get(indice) != null) {
	        carrito.remove(indice);
	        this.guardarCarrito(carrito, request);
	    }
	    return "redirect:/vender/";
	}
	
	private void limpiarCarrito(HttpServletRequest request) {
	    this.guardarCarrito(new ArrayList<>(), request);
	}

	@GetMapping(value = "/limpiarVenta")
	public String cancelarVenta(HttpServletRequest request, RedirectAttributes redirectAttrs) {
	    this.limpiarCarrito(request);
	    redirectAttrs
	            .addFlashAttribute("mensaje", "Venta cancelada")
	            .addFlashAttribute("clase", "info");
	    return "redirect:/vender/";
	}
	

	
}
