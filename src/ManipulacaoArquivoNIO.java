import java.io.*;
import java.nio.file.*;

public class ManipulacaoArquivoNIO {

    // Definimos o caminho como uma constante para que ambos os métodos usem o mesmo arquivo
    public static final Path path = Paths.get("arquivoNIO.txt");

    public static void main(String[] args) {

        // chama o método para escrever
        escreverNoArquivo();

        // chama o método de leitura
        System.out.println("Conteúdo encontrado no arquivo");
        lerArquivo();
    }    

    public static void escreverNoArquivo() {

        try {
            Files.write(path, "Exercício de NIO".getBytes());
            System.out.println("Arquivo gravado com sucesso!");
        } catch (IOException e) {
            System.out.println("Erro ao escrever no arquivo: " + e.getMessage());
        }
    }
    
    public static void lerArquivo() {
        try {
            // Leitura do Path
            byte[] bytes = Files.readAllBytes(path);
            // passamos para String novamente
            String conteudo = new String(bytes);
            System.out.println(conteudo);

        } catch (IOException e) {
            System.out.println("Erro ao ler arquivo: " + e.getMessage());
        }
    }
}
