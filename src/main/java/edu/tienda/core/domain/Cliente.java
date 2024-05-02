package edu.tienda.core.domain;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Cliente {

    private String username;

    private String password;

    private String nombre;

}
