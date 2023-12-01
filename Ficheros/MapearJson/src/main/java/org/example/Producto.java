package org.example;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class Producto {
    private String Nombre;
    private String Modelo;
    private int precio;
    private float valoracion;


}
