import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class ManipulacaoArquivos {
    public static void main(String[] args) {
        // Caminho do arquivo 
        String caminhoArquivo = "C:/Users/davim/OneDrive/Documentos/projeto_Input_Output_Java/arquivoIO.txt";
        String textoParaGravar = "Olá pessoal!";

        // Chama o método para escrever
        escreverNoArquivo(caminhoArquivo, textoParaGravar);

        // chama o métoto para ler e exibir 
        System.out.print("Conteúdo lido do arquivo: ");
        lerDoArquivo(caminhoArquivo);
    }

    // Método para escrever no arquivo
    public static void escreverNoArquivo(String nomeArquivo, String conteudo) {
        try {
            FileWriter writer = new FileWriter("arquivoIO.txt");

            writer.write(conteudo);

            writer.close(); // no java IO sempre fechar o arquivo ao escrever 

        } catch (IOException e) { 
            System.out.println("Erro de IO: " + e.getMessage());
        }
    }

    // Método para ler no arquivo
    public static void lerDoArquivo(String nomeArquivo) {
        try {
            FileReader reader = new FileReader("arquivoIO.txt");

            int data = reader.read();

            while (data != -1) {
                System.out.print((char)data);
                data = reader.read();
            }

            reader.close(); // no java IO sempre fechar após leitura

        } catch (IOException e) {
            System.out.println("Erro de IO: " + e.getMessage());
        }
    }
}
