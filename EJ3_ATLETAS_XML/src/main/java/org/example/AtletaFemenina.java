package org.example;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class AtletaFemenina {
    private String nombre;
    private List<String> prueba;
    private int edad;
    private String pais;
}
