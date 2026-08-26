# Fundamentos de Desenvolvimento de Software

- Prof. Bernardo Copstein

## Exercício sobre controle de versões usando Git

Use este exercício/roteiro para verificar sua compreensão acerca dos itens 2.1, 2.2 e 2.3 do capítulo 2 do livro PRO-GIT.

1. Recupere o exercício que foi usado para testar o ambiente de trabalho ou crie uma pasta para o projeto e insira um arquivo com o código Java que segue:

   ```java
   public static void main(String[] args) throws Exception {
       System.out.println("\nHi!");
       String version = System.getProperty("java.version");
       System.out.println("Running Java Version "+version+"\n");
   }
   ```

2. Transforme a pasta do projeto em um repositório Git.

3. Acrescente um arquivo “.gitignore” prevendo que será um projeto Java usando o VSCode (ou o IDE de sua preferência). Para gerar este arquivo sugerimos utilizar o serviço gitignore.io - Crie Arquivos .gitignore úteis para seu projeto. (total.com).

4. Compile e execute o projeto. Se estiver tudo correto, crie a primeira versão deste projeto (primeiro “commit”).

5. Altere o código do projeto de maneira que além da versão do Java ele imprima também a versão do sistema operacional. Consulte a documentação do Java para tanto. Compile e execute o projeto e gere uma nova versão.

6. Altere uma vez mais o projeto exibindo outras informações de sua preferência. Da mesma forma que no passo 5 crie outra versão do projeto.

7. Verifique a lista de versões usando o comando “git log”.

8. Navegue entre as versões usando “git checkout”. Verifique o conteúdo dos arquivos, compile e execute.

9. Retorne para a última versão usando “git checkout main”. Verifique o conteúdo dos arquivos.

10. Procure verificar se você entendeu bem o mecanismo de versionamento do Git. Ele permite que você recupere um estado anterior do seu trabalho em caso de necessidade.
