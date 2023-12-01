package org.example;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class Operaciones_JSON {
    private static final ObjectMapper JSON_MAPPER = new ObjectMapper();
    public static DeportistaFemenina leerObjetoJson(Path ruta) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            return objectMapper.readValue(ruta.toFile(), DeportistaFemenina.class);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static List<DeportistaFemenina> leerArrayObjetosJson(Path ruta) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();

            return objectMapper.readValue(ruta.toFile(), new TypeReference<>() { });
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    public static String escribirObjetoJson(DeportistaFemenina deportista) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            // La siguiente línea es opcional, pero hace que el JSON se muestre con formato
            objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
            return objectMapper.writeValueAsString(deportista);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static String escribirListaObjetosJson(List<DeportistaFemenina> deportistas) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            // La siguiente línea es opcional, pero hace que el JSON se muestre con formato
            objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
            return objectMapper.writeValueAsString(deportistas);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public static void escribirListaObjetosJson(List<DeportistaFemenina> deportistas, Path ruta) {

        try {
            Files.deleteIfExists(ruta);
            ObjectMapper objectMapper = new ObjectMapper();
            // La siguiente línea es opcional, pero hace que el JSON se muestre con formato
            objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
            objectMapper.writeValue(ruta.toFile(), deportistas);
        } catch (IOException e) {
            System.out.println("El fichero no existe");
        }
    }
}
