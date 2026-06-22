import java.nio.file.*;
import java.io.IOException;

public class ExemploNIO {
    public static void main(String[] args) {
        Path path = Paths.get("arquivo.txt");

        try {
            // Escrevendo no arquivo
            Files.write(path, "Olá, mundo!".getBytes());

            // Lendo de um arquivo
            byte[] bytes = Files.readAllBytes(path);

            String content = new String(bytes);

            System.out.println(content);

        } catch (IOException e) {
            System.out.println("Problema de IO: " + e.getMessage());
        }
    }
}