package org.example;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

import static org.example.Operaciones_JSON.*;

public class Main {

    public static void main(String[] args) throws Exception {

        Path rutaDepoJSON = Path.of(".", "src", "main", "resources", "deportistas_femeninas.json");
        DeportistaFemenina deportista1 = new DeportistaFemenina("fatine","futbol",19,"marruecos");
        DeportistaFemenina deportista2 = new DeportistaFemenina("patri","voley",20,"españa");

        List<DeportistaFemenina> deportistas = List.of(deportista1, deportista2);

        System.out.println("\n**** Escritura de lista de objetos JSON a fichero ****");
        escribirListaObjetosJson(deportistas, rutaDepoJSON);


      
        System.out.println("\n**** Lectura de array de objetos JSON desde fichero ****");
        leerArrayObjetosJson(rutaDepoJSON).forEach(System.out::println);



       




    }
}