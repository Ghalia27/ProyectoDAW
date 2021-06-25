package org.gaming.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class IndexController {

    @GetMapping("/Index")
    public String homePage() {
        return "index2";
    }

    @GetMapping("/contact")
    public String contactPage() {
        return "contact";
    }

    @GetMapping("/about")
    public String aboutPage() {
        return "about";
    }
    /*
    @GetMapping("/juegos")
    public String juegosPage() {
        return "juegos";
    }*/
}