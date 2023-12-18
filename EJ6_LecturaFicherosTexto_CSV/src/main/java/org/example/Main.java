package org.example;

import java.io.IOException;
import java.nio.file.Path;



public class Main {
    public static void main(String[] args) throws IOException {
        ColecciondeProduct cproducts = new ColecciondeProduct(Path.of(".", "src", "main", "resources", "LeerFichero.csv"));


//        //Imprimir los nombres de los productos
//     cproducts.imprimirLosNombresProductos();
//
//        //Imprimir los nombres de los productos cuyas unidades en stock sean menor que 10
//        cproducts.imprimirLosNombresProductosStockmenorDiez();
//
//         /*Imprimir el nombre de los productos con unidades en stock mayor de 10 ordenados por unidad de
//    stock de forma descendente*/
//        cproducts.imprimirLosNombresProductosStockmeyorDiez();
//
//        //Imprimir el número de productos agrupados por proveedor
//        cproducts.imprimirNumeroProductoProveedor();
//
//
//        ////Imprimir el producto con el precio unitario más alto
//
//        cproducts.imprimirProductoMasCaro();
//
//        // Imprimir el promedio de existencias en almacén
//
//        cproducts.promedioalmacen();
    }
}