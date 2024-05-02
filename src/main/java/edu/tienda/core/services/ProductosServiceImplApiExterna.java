package edu.tienda.core.services;

import edu.tienda.core.domain.Producto;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service("API")
@ConditionalOnProperty(
        value = "productos.estrategia",
        havingValue = "EN_OTRA_API")
public class ProductosServiceImplApiExterna implements ProductoService{

    @Override
    public List<Producto> getProductos() {

        RestTemplate restTemplate = new RestTemplate();

        ResponseEntity<List<Producto>> response = restTemplate.
                exchange("http://localhost:8080/tienda/api/v1/productos/fake-productos",
                        HttpMethod.GET,null,new ParameterizedTypeReference<List<Producto>>(){});

        List<Producto> productos = response.getBody();

        return productos;
    }
}
