package edu.tienda.core.controllers;

import edu.tienda.core.configurations.ConfigurationParameters;
import edu.tienda.core.domain.Producto;
import edu.tienda.core.services.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/productos")
public class ProductosControllerRest {

    //Se instancia la clase de servicio al estilo "Java puro".
    @Autowired
    @Lazy
    private ProductoService productosService;

    @Autowired
    private ConfigurationParameters configurationParameters;

    @GetMapping
    public ResponseEntity<?> getProductos() {

        System.out.println("params: "+configurationParameters.toString());

        //Se recuperan todos los productos del sercicio
        List<Producto> productos = productosService.getProductos();

        //Retornamos los productos del servicio en el body de la respuesta.
        return ResponseEntity.ok(productos);
    }

    @GetMapping("/fake-productos")
    public ResponseEntity<?> fakeProductoAPI() {

        List<Producto> productos = new ArrayList<>(Arrays.asList(
                new Producto(1,"Camiseta Juventus",1200.0,4),
                new Producto(2,"Camiseta River Plate",1000.0,8),
                new Producto(3,"Camiseta Boca Juniors",900.0,1)
        ));

        //Retornamos los productos del servicio en el body de la respuesta
        return ResponseEntity.ok(productos);
    }

}
