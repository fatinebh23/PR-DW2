package org.example;

import java.io.IOException;
import java.nio.file.Path;

public class Main {
    public static void main(String[] args) throws IOException {
        ColecciondeProduct cproducts = new ColecciondeProduct(Path.of(".", "src", "main", "resources", "LeerFichero.csv"));
    }
}