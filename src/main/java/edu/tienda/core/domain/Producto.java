package edu.tienda.core.domain;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Producto {

    private Integer id;

    private String nombre;

    private Double precio;

    private Integer stock;

}
