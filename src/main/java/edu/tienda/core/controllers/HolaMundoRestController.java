package edu.tienda.core.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HolaMundoRestController {

    @GetMapping("/hola/{nombreUsuario}")
    public String saludo(@PathVariable String nombreUsuario){
        System.out.println("Ejecutando el método saludo");
        return "Hola, "+nombreUsuario;
    }

}
