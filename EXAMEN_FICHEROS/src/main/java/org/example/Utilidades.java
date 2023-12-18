package org.example;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;

/*deberás crearte una clase llamada Utilidades, en la cual crearás todos los métodos necesarios para
manipular la información que necesites de las clases anteriores.*/
public class Utilidades implements Serializable {

    private final static String COMMA_DELIMITER = ";";
    List<PeliculaOscarizada> listaCSV = new ArrayList<>();

    List<PeliculaOscarizada> listaCSV2f = new ArrayList<>();
    List<PeliculaOscarizada> listaCSV2m = new ArrayList<>();





    }
public static List deserializacionDesdeCsv(String ruta) throws IOException {
    List<PeliculaOscarizada> lista= new ArrayList<>();
    try (Stream<String> contenidoFichero = Files.lines(Paths.get(ruta))) {

        List<String> linea = Files.readAllLines(Path.of(".", "src", "main", "resources", "oscar_age_female.csv"));

        for (int i = 1; i < linea.size(); i++) {

            List<String> pelioscarizada = linea.get(i);

            PeliculaOscarizada ejemplo = new PeliculaOscarizada();
            ejemplo.setAnyo(Integer.parseInt(pelioscarizada.get(1)));
            ejemplo.setEdad(Integer.parseInt(pelioscarizada.get(2)));
            ejemplo.setActor(pelioscarizada.get(3));
            ejemplo.setActor(pelioscarizada.get(4));



            lista.add(ejemplo);
        }
    } catch (IOException e) {
        e.printStackTrace(System.out);
    }
    return lista;
}

    public void actoresConMasdeUnOscar(List<Actor> lista) {


        System.out.println("ActoresConMasdeUnOscar: ");
        lista.stream()
                .filter(actor -> actor.getPeliculas()>1)
                .map(Actor::getNombre)
                .forEach(System.out::println);

    }

    public void actoresMasJovenesEnGanarUnOscar(List<Actor> lista) {


        System.out.println("actoresMasJovenesEnGanarUnOscar: ");
        list.stream()

                .map(Actor::getNombre)
                .forEach(System.out::println);

    }
}


}
