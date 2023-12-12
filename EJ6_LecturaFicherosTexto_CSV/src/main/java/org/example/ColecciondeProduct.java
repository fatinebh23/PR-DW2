package org.example;

import java.io.IOException;
import java.io.Serializable;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.nio.file.Files.lines;

public class ColecciondeProduct implements Serializable {
    final String COMMA_DELIMITER = ",";
    List<Product> listaCSV = new ArrayList<>();

    List<Product> listaCSV2 = new ArrayList<Product>();

    public ColecciondeProduct(Path path) throws IOException {
        //Leer el fichero de funkos.csv y crear una lista de objetos main.Product

        // Imprimir la lista de productos y pasar la lista de strings a lo que toca ---IMPORTANTE---
        try (Stream<String> contenidoFichero3 = Files.lines(path);) {

            List<String> linea = Files.readAllLines(Path.of(".", "src", "main", "resources", "LeerFichero.csv"));
            String[] fun;
            System.out.println("Toda la info: ");

            for (int i = 1; i < linea.size(); i++) {
                Product productoo = new Product();
                fun = linea.get(i).split(",");
                productoo.setId(Integer.parseInt(fun[0]));
                productoo.setName(fun[1]);
                productoo.setSupplier(Integer.parseInt(fun[2]));
                productoo.setCategory(Integer.parseInt(fun[3]));
                productoo.setUnitPrice(Double.parseDouble(fun[5]));
                productoo.setUnitsInStock(Integer.parseInt(fun[6]));
                listaCSV2.add(productoo);
                System.out.println(productoo.toString());
            }


        } catch (
                IOException e) {
            e.printStackTrace(System.out);
        }
    }

    public ColecciondeProduct(List<Product> listaCSV) {
        this.listaCSV = listaCSV;
    }

    //Imprimimos el funko más caro. Opción 1
    public void imprimirLosNombresProductos() {
        //opción 1
        System.out.println("LOS NOMBRES DE LOS PRODUCTOS SON : ");
        listaCSV2.stream()
                .map(Product::getName)
                .forEach(System.out::println);
    }

    //Imprimir los nombres de los productos cuyas unidades en stock sean menor que 10
    public void imprimirLosNombresProductosStockmenorDiez() {

        // unitsInStock> 10: NOMBRE DEL PRODUCTO
        System.out.println("PRODUCTOS CUYAS UNIDADES EN STOCK SEAN MENOR QUE 10: ");
        listaCSV2.stream()
                .filter(Product -> Product.getUnitsInStock() < 10)
                .map(Product::getName)
                .forEach(System.out::println);

    }

    /*Imprimir el nombre de los productos con unidades en stock mayor de 10 ordenados por unidad de
    stock de forma descendente*/
    public void imprimirLosNombresProductosStockmeyorDiez() {

        // unitsInStock> 10: NOMBRE DEL PRODUCTO
        System.out.println("PRODUCTOS CUYAS UNIDADES EN STOCK SEAN MAAYOR QUE 10: ");
        listaCSV2.stream()
                .filter(Product -> Product.getUnitsInStock() > 10)
                .sorted(Comparator.comparingInt(Product::getUnitsInStock).reversed())
                .map(Product::getName)
                .forEach(System.out::println);

    }

    //Imprimir el número de productos agrupados por proveedor

    public void imprimirNumeroProductoProveedor() {
        Map<Integer, Long> modeloCountMap = listaCSV2.stream()
                .collect(Collectors.groupingBy(Product::getSupplier, Collectors.counting()));
        System.out.println("EL NUMERO DE PRODUCTOS AGRUPADOS POR PROVEEDOR SON:  ");
        // Imprime el resultado.
        modeloCountMap
                .forEach((supplier, count) -> System.out.println("PROVEEDOR: " + supplier + ", CANTIDAD: " + count));

    }

    //Imprimir el producto con el precio unitario más alto

    public void imprimirProductoMasCaro() {

        System.out.println("El producto con el precio unitario más alto es : ");
        System.out.println(listaCSV2.stream()
                .max(Comparator.comparingDouble(Product::getUnitPrice))
                .map(Product::getName).get());

    }
    // Imprimir el promedio de existencias en almacén
    public void promedioalmacen() {
        System.out.println("Promedio de existencias en el  almacén:");
        System.out.format("%.2f \n", listaCSV2.stream()
                .mapToInt(Product::getUnitsInStock)
                .average()
                .getAsDouble());

    }


}