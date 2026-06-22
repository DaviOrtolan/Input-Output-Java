import java.io.*;

public class GerenciadorLog {
    public static void main(String[] args) {
        String arquivoLog = "arquivo_log.txt";

        System.out.println("--- Registrando Eventos ---");
        // passando o arquivo e a mensagem que quero salvar 
        registrarLog(arquivoLog,"[INFO] Sistema iniciado com sucesso.\n");
        registrarLog(arquivoLog, "[AVISO] Memória acima de 80%.\n");
        registrarLog(arquivoLog, "[ERRO] Falha ao conectar no banco de dados.\n");

        System.out.println("\n--- Lendo o histórico de Logs ---");
        // passsando o arquivo que queremos ler 
        exibirLogs(arquivoLog);
    }

    public static void registrarLog(String nomeArquivo, String mensagem) {
        try {
            FileWriter writer = new FileWriter(nomeArquivo, true);

            // gravando a mensagem que veio por parâmetro
            writer.write(mensagem);

            writer.close();
            System.out.println("Log salvo com sucesso!");
        } catch (IOException e) {
            System.out.println("Erro ao salvar log: " + e.getMessage());
        }
    }

    public static void exibirLogs(String nomeArquivo) {
        try {
            FileReader reader = new FileReader(nomeArquivo);

            int data = reader.read();

            while (data != -1) {
                System.out.print((char)data);
                data = reader.read();
            }

            reader.close();
        } catch (IOException e) {
            System.out.println("Erro ao ler log: " + e.getMessage());
        }
    }
}
