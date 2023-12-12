package org.example;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class Main {

    //https://www.thesportsdb.com/api/v1/json/3/search_all_teams.php?l=English%20Premier%20League
    static List<Team> ListaTeams;
    static ObjectMapper objectMapper = new ObjectMapper().registerModule(new JavaTimeModule());

    public static void main(String[] args) throws IOException {
        //El método objectMapper .readTree nos devuelve un objeto de tipo JsonNode-

        JsonNode ruta = objectMapper.readTree(new URL("https://www.thesportsdb.com/api/v1/json/3/search_all_teams.php?l=English%20Premier%20League"));


        ListaTeams=objectMapper.readValue(ruta.get("teams").traverse(), new TypeReference<>(){});

        ListaTeams.forEach(System.out::println);

        Path ficheroJson =Path.of(".","src","main","resources","teams.json");

        escribirJSON(ficheroJson);


    }

    private static void escribirJSON(Path ruta ) {
        try {
            Files.deleteIfExists(ruta);
            ObjectMapper objectMapper = new ObjectMapper();
            // La siguiente línea es opcional, pero hace que el JSON se muestre con formato
            objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
            objectMapper.writeValue(ruta.toFile(), ListaTeams);
        } catch (IOException e) {
            System.out.println("El fichero no existe");
        }

    }
}