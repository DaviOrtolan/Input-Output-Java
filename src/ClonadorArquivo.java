import java.io.IOException;
import java.nio.channels.FileChannel;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class ClonadorArquivo {
    public static void main(String[] args) {
        String arquivoOrigem = "arquivoNIO.txt";
        String arquivoDestino = "arquivoNIO_copia.txt";

        System.out.println("Iniciando a cópia do arquivo...");
        duplicarArquivo(arquivoOrigem, arquivoDestino);
    }

    public static void duplicarArquivo(String origem, String destino) {
        // transformando as Strings em objetos Path no NIO
        Path pathOrigem = Paths.get(origem);
        Path pathDestino = Paths.get(destino);

        try {
            // abrindo os canais dentro do try(...) para que sejam fechados automaticamente
            FileChannel canalOrigem = FileChannel.open(pathOrigem, StandardOpenOption.READ);

            // abre o canal de escrita para o destino
            FileChannel canalDestino = FileChannel.open(pathDestino, StandardOpenOption.CREATE, StandardOpenOption.WRITE);

            // transfere os dados diretamente no nível do sistema operacional
            long posicaoInicial = 0;
            long tamanhoTotal = canalOrigem.size();

            canalOrigem.transferTo(posicaoInicial, tamanhoTotal, canalDestino);

            System.out.println("Arquivo duplicado com sucesso usando FileChannel!");

        } catch (IOException e) {
            System.out.println("Erro ao duplicar o arquivo: " + e.getMessage());
        }
        
    }
}
