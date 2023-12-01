package org.example;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Arrays;
import java.util.List;

import static jdk.internal.net.http.common.Log.logError;

public class Main {
    public static void main(String[] args) {

        BufferedWriter bw = null;
        PrintWriter printWriter = null;
        try {
///////////////////////////////////////////////////////////////////////////////////////////
            //Files.writeString y Files.write añaden el argumento
            //StandardOpenOption.APPEND durante la escritura.

        //Files.writeString añaden el argumento
            //StandardOpenOption.APPEND durante la escritura.
            Files.writeString(Paths.get("/home/daw2/Escriptori/fichero_WriteString.txt"), "Hola Files.writeString",  StandardOpenOption.APPEND);


            // Files.write: Desde Java 7. Escribe tanto caracteres como datos
            // binarios.
            //Files.write añaden el argumento
            List<String> lines = Arrays.asList("Hola", "Files.write");
            Path fileW = Paths.get("/home/daw2/Escriptori/fichero_Files.write.txt");
            Files.write(fileW, lines, StandardCharsets.UTF_8,StandardOpenOption.APPEND);

            // FileWriter: Escribe directamente a fichero enteros, arrays de
            // bytes o String.

            FileWriter myWriter = new FileWriter("/home/daw2/Escriptori/fichero_FileWriter.txt",true);
            myWriter.write("Hola FileWriter");
            myWriter.close();

            //FileWriter, segundo argumento como true
            // Crea un BufferedWriter que envuelve el FileWriter
            //BufferedWriter y PrintWriter, envuelven un recurso FileWriter, el
            //cuál debe tener el segundo argumento como true.
            BufferedWriter bufferedWriter = new BufferedWriter(myWriter);

            String mycontent = "Hola BufferedWriter";
            File fileBW = new File("/home/daw2/Escriptori/fichero_BufferedWriter.txt");
            FileWriter fw = new FileWriter(fileBW,true);
            bufferedWriter.write("Este es un ejemplo de BufferedWriter.");
            bufferedWriter.newLine();
            bufferedWriter.close();


            // Crea un PrintWriter que envuelve el FileWriter

            PrintWriter printWriter1= new PrintWriter(myWriter);
            printWriter.println("Este es un ejemplo de PrintWriter.");

            // Asegúrate de cerrar los recursos cuando hayas terminado
            printWriter.close();


        } catch (IOException e) {
            e.getMessage();
        } finally {
            if (printWriter != null) {
                printWriter.close();
            }
            try {
                if (bw != null) {
                    bw.close();
                }
            } catch (Exception var28) {
                System.out.println("Error in closing the BufferedWriter" + var28);
            }
        }
    }
}