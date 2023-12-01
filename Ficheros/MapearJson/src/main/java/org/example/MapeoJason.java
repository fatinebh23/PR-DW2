package org.example;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;


public class MapeoJason {


    private static final ObjectMapper JSON_MAPPER = new ObjectMapper();

    public static void main(String[] args) throws Exception {

        try {
            Path ficheroPersonaJson = Path.of(".", "src", "main", "resources", "Personas.json");

            //arrayList persona
            ArrayList<Persona> personas = JSON_MAPPER.readValue(ficheroPersonaJson.toFile(), new TypeReference<>() {});

            personas.forEach(System.out::println);


            Path ficheroProductoJson = Path.of(".", "src", "main", "resources", "Productos.json");

            ////arrayList persona

            ArrayList<Persona> productos = JSON_MAPPER.readValue(ficheroProductoJson.toFile(), new TypeReference<>() {
            });
            productos.forEach(System.out::println);


        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
