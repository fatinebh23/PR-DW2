import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class Anyadir_datos_a_ficheros_texto {
    public static void main(String[] args)
    {
        Path path = Paths.get("demo.txt");
        String text = "…some text…";

        try {
            Files.write(path, text.getBytes(), StandardOpenOption.APPEND);
            System.out.println("Successfully written bytes to the file");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
