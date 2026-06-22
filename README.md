# Java I/O vs. Java N/O (New I/O)

Este repositório foi criado para demonstrar as diferenças conceituais, arquiteturais e de performance entre as duas principais APIs de manipulação de entrada e saída de dados no ecossistema Java: **Java I/O (Classic I/O)** e **Java NIO (New I/O)**.

---

## 📌 Visão Geral

A manipulação de arquivos e fluxos de rede é essencial em qualquer aplicação. O Java oferece duas abordagens principais para resolver esse problema, cada uma ideal para cenários específicos.

### 1. Java I/O (Stream-Oriented)
Lançado nas primeiras versões do Java, o modelo clássico é baseado em **Streams (Fluxos de Dados)**. Ele trabalha de forma sequencial e síncrona.
* **Orientado a Streams:** Os dados são lidos byte a byte ou caractere por caractere. Não é possível mover-se livremente para frente e para trás no fluxo de dados.
* **Bloqueante (Blocking):** Quando uma thread inicia uma operação de leitura ou escrita (ex: `InputStream.read()`), ela fica travada (bloqueada) até que a operação seja concluída.

### 2. Java NIO (Buffer-Oriented)
Introduzido no Java 1.4, o NIO trouxe uma nova abordagem focada em performance, escalabilidade e operações **não bloqueantes**.
* **Orientado a Buffers:** Os dados não são lidos diretamente do fluxo; eles são lidos de um canal para um bloco de memória (`Buffer`). Você pode navegar pelos dados no buffer livremente.
* **Não Bloqueante (Non-blocking):** Uma thread pode solicitar a leitura de dados de um canal e receber apenas o que estiver disponível, ou continuar fazendo outra coisa se não houver dados.
* **Seletores (Selectors):** Permite que uma única thread monitore múltiplos canais de comunicação (como conexões de rede), tornando-o ideal para aplicações de alta concorrência.

---

## 📊 Tabela Comparativa

| Característica | Java I/O (Tradicional) | Java NIO (New I/O) |
| :--- | :--- | :--- |
| **Abordagem** | Orientado a Stream (Fluxo) | Orientado a Buffer (Bloco) |
| **Estilo de Operação** | Bloqueante (Blocking) | Não Bloqueante (Non-blocking) |
| **Canais (`Channels`)** | Não possui | Usa canais bidirecionais |
| **Seletores (`Selectors`)** |
