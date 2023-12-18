package org.example;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Actor {
    @JsonProperty("name")
private String nombre;
    @JsonProperty("sex")
private String sexo;
    @JsonProperty("yearOfBirth")
private LocalDate anyoNacimiento;
    @JsonProperty("movies")
private List<Pelicula> peliculas;

    @Override
    public String toString() {
        return "Actor{" +
                "nombre='" + nombre + '\'' +
                ", sexo='" + sexo + '\'' +
                ", anyoNacimiento=" + anyoNacimiento +
                ", peliculas=" + peliculas +
                '}';
    }
}
