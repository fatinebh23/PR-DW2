package org.example;

import java.io.IOException;
import java.io.Serializable;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

import static java.nio.file.Files.lines;

public class ColecciondeProduct implements Serializable {
    final String COMMA_DELIMITER = ",";
    List<Product> listaProduct = new ArrayList<>();
    public ColecciondeProduct(Path path) throws IOException {
        //Leer el fichero de product.csv y crear una lista de objetos main.product

        try(Stream<String> contenidoFichero = lines(path)) {

            listaProduct = contenidoFichero.skip(1)
                    .map(l -> Arrays.asList(l.split(COMMA_DELIMITER)))
                    .map(Product::new)
                    .toList();


           /* listaProduct = contenidoFichero.map(l -> Arrays.asList(l.split(COMMA_DELIMITER)))
                    .skip(1)
                    .map(l -> new Product(l.get(0),l.get(1),l.get(2),l.get(3),l.get(4),l.get(5),l.get(6),l.get(7),l.get(8),l.get(9).toList());*/


        } catch (IOException e) {
            e.printStackTrace(System.out);
        }
    }
}
