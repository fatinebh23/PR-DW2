package org.example;

import com.fasterxml.jackson.core.exc.StreamWriteException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args)  throws IOException {

        Path rutaJSON = Path.of(".", "src", "main", "resources", "libros.json");

        //2. Crea una lista de libros (puedes utilizar una lista de objetos Book) y agrégale algunos libros de
       // ejemplo.
        List<Book> listaBook = new ArrayList<>() {
            {
                add(new Book("SOL", "ana", 7895, 1999, 500));
                add(new Book("MAR", "maria", 5695, 2009, 966));
                add(new Book("LUNA", "sara", 7562, 2022, 522));
                add(new Book("NUBE", "carol", 8946, 1985, 1000));
            }

    };
    //ORDEN CORRECTO
        //primero el menu
        menu(listaBook);
        //segundo serializar
        escribirJSON(rutaJSON, listaBook);
        //por ultimo deserializar
        List<Book> jsonDeserializado = leerJSON(rutaJSON);
        jsonDeserializado.forEach(System.out::println);

    }

   /* 6. Proporciona un menú interactivo para que el usuario pueda agregar nuevos libros, buscar libros y
    ver la lista de todos los libros almacenados (ten en cuenta si debes permitir la opción de agregar un
            libro ya existente)*/

    //CREAR UN METODO MENU

    private static void menu(List<Book> listaBook) throws IOException {
        Scanner reader =new Scanner(System.in);
        int opcion;
        do{
            System.out.println("-----MENU----");
            System.out.println("1. Añadir libro");
            System.out.println("2. Buscar libro");
            System.out.println("3. Mostrar todos los libros");
            System.out.println("4. Salir");
            System.out.print("Opcion: ");
            opcion = reader.nextInt();
            switch (opcion) {
                case 1:
                    System.out.println("Introduce el título del libro :");
                    String titulo = reader.nextLine();
                    reader.nextLine();
                    System.out.println("Introduce el autor del libro:");
                    String autor = reader.nextLine();
                    System.out.println("Introduce el ISBN del libro:");
                    int isbn = reader.nextInt();
                    System.out.println("Introduce el año del libro:");
                    int year = reader.nextInt();
                    System.out.println("Introduce el número de páginas del libro :");
                    int pages = reader.nextInt();
                    listaBook.add(new Book(titulo, autor, isbn, year, pages));
                    break;
                case 2:
                    System.out.println("Quieres buscar por titulo o por autor?");
                    String busqueda = reader.nextLine();
                    switch (busqueda) {
                        case "titulo":
                            System.out.println("Introduce el título del libro :");
                            String tituloBusqueda =reader.nextLine();
                            System.out.println(buscarLibroPorTituloOAutor(tituloBusqueda, null, listaBook));
                            break;
                        case "autor":
                            System.out.println("Introduce el autor del libro :");
                            String autorBusqueda = reader.nextLine();
                            System.out.println(buscarLibroPorTituloOAutor(null, autorBusqueda, listaBook));
                            break;
                    }
                    break;
                case 3:
                    for (Book books : listaBook) {
                        System.out.println(books.toString());
                    }
                    break;
                default:
                    break;
            }
        }while (opcion != 4) ;
    }


//4. Luego, deserializa el archivo JSON de nuevo en una lista de libros.
    private static List<Book> leerJSON(Path ruta) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(ruta.toFile(), new TypeReference<>() {
        });
    }
    //3.Utiliza la librería Jackson para serializar la lista de libros a un archivo JSON.
    private static void escribirJSON(Path rutaJSON, List<Book> listaBook) {
        try{
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
            objectMapper.writeValue(rutaJSON.toFile(), listaBook);
        } catch (StreamWriteException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

//5. Implementa una función que permita buscar libros por título o autor y mostrar los resultados.
    private static String buscarLibroPorTituloOAutor(String titulo, String autor, List<Book> listaBook) {
        for (Book book : listaBook) {
            if (book.getTitle().equals(titulo) || book.getAuthor().equals(autor)) {
                return book.toString();
            }
        }
        return null;
    }}



