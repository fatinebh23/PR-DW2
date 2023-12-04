package org.example;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        //Mapear la lista de objetos AtletaFemenina a un archivo XML llamado atletas_femeninas.xml.

        Path miRutaAtletas = Path.of(".", "src", "main", "resources", "atletas_femeninas.xml");



        AtletaFemenina atleta1 = new AtletaFemenina("fatine",List.of("uno","dos","tres"),19,"españa");
        AtletaFemenina atleta2 = new AtletaFemenina("basma",List.of("uno","dos","tres"),19,"españa");
        AtletaFemenina atleta3 = new AtletaFemenina("yousra",List.of("uno","dos","tres"),19,"españa");


        List<AtletaFemenina> atletas = List.of(atleta1, atleta2,atleta3);
        ListasAtleta coleccionAtletas= new ListasAtleta(atletas);

        escribirListaObjetos(coleccionAtletas.getListaAtletas(),miRutaAtletas);

        List<AtletaFemenina> listaAtletasPasado=  leerArrayObjetosXml(miRutaAtletas);
        //Comprobar la funcionalidad deserialización (lectura) de objetos en el archivo XML
        listaAtletasPasado.stream()
                .map(AtletaFemenina::getNombre)
                .forEach(System.out::println);

        //2.Asegurarte de que el archivo XML generado contenga información detallada sobre las atletas,incluyendo sus nombres, deportes, edades y países de origen.
        //3. Crea un método que extraiga una lista de objetos AtletaFemenina a partir de un archivo XML.
        //Verifica la funcionalidad de serialización (escritura) y deserialización (lectura) de objetos en el archivo XML


    }
    public static void escribirListaObjetos(List listaAtletas, Path ruta) {

        try {
            Files.deleteIfExists(ruta);
            XmlMapper xmlMapper = new XmlMapper();
            // La siguiente línea es opcional, pero hace que el JSON se muestre con formato
            xmlMapper.enable(SerializationFeature.INDENT_OUTPUT);
            xmlMapper.writeValue(ruta.toFile(), listaAtletas);
        } catch (IOException e) {
            System.out.println("El fichero no existe");
        }
    }

    //
    public static List<AtletaFemenina> leerArrayObjetosXml(Path ruta) {
        try {
            XmlMapper xmlMapper = new XmlMapper();
            // return xmlMapper.readValue(ruta.toFile(), new TypeReference<List<Lenguaje2>>() { });
            return xmlMapper.readValue(ruta.toFile(), new TypeReference<>() { });
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}