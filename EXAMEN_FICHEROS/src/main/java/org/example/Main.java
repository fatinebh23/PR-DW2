package org.example;
import com.fasterxml.jackson.core.exc.StreamWriteException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.example.Actor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException{
        try {
            // ruta del mac
            String miRutaFpelisfem = "/home/daw2/IdeaProjects/PR-DW2/EXAMEN_FICHEROS/src/main/resources/oscar_age_female.csv";

            List<PeliculaOscarizada> peliculaOscarizadaLList = deserializacionDesdeCsv(miRutaFpelisfem);




        } catch (IOException e) {
            e.printStackTrace(System.out);
        }

        List<Actor> actoreslist = new ArrayList<>(){{
            add(new Actor("Sidney Poitier","H","1926","Lilies of the Field",));
            add(new Actor("Spencer Tracy","H","1926","");

        }};

        escribirJSON(ficheroJSON, actoreslist);
        List<Actor> jsonDeserializado = leerJSON(ficheroJSON);
        jsonDeserializado.forEach(System.out::println);
    }
    private static List<Actor> leerJSON(Path ruta) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(ruta.toFile(), new TypeReference<>() {
        });
    }

    private static void escribirJSON(Path ficheroJSON, List<Actor> actoreslist) {
        try{
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
            objectMapper.writeValue(ficheroJSON.toFile(), actoreslist);
        } catch (StreamWriteException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}