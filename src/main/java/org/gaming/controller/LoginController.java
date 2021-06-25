package org.gaming.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {

	
	@GetMapping({"/","/login"})
	public String index() {
		return "index";
	}
	
	@GetMapping({"/menu"})
	public String hello() {
		return "menu";
	}
	@GetMapping({"/user"})
	public String user() {
		return "user";
	}
	@GetMapping({"/admin"})
	public String admin() {
		return "admin";
	}
	@RequestMapping("/default")
    public String defaultAfterLogin(HttpServletRequest request) {
        if (request.isUserInRole("ADMIN")) {
            return "admin";
        }
        return "redirect:/juegos";
    }
}
