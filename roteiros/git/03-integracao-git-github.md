# Fundamentos de Desenvolvimento de Software

- Prof. Bernardo Copstein

## Exercício sobre integração Git/GitHub

Use este exercício/roteiro para entender o uso básico do Git integrado com o GitHub.

1. Crie uma pasta na sua máquina local que irá conter o projeto que pretendes gerenciar pelo GitHub. Copie um ou dois arquivos Java para esta pasta.

   **Sugestão:** use o mesmo projeto desenvolvido no roteiro 2.

2. Crie uma conta no GitHub (os recursos necessários para a disciplina são todos cobertos pela assinatura gratuita).

3. Edite seu profile.

4. Crie seu primeiro repositório e de um nome para ele (não acrescente nenhum arquivo neste repositório).

5. Vincule este repositório a sua pasta de trabalho local (as instruções relativas as letras de “a” até “c” só são necessárias se o seu projeto ainda não for gerenciado pelo Git local):

   a. Use `git init` para inicializar o repositório git local.

   b. Use `git add --all` para “estagiar” todos os arquivos.

   c. Use `git commit -m “first commit”` para criar a primeira versão do seu trabalho.

   d. Use `git remote add origin <endereço do seu projeto no GitHub>` para vincular a pasta local com o GitHub.

   e. Use `git push -u origin master` para “subir” todos os seus arquivos para o GitHub.

6. Faça um “refresh” da página do GitHub e veja seu primeiro “commit” no repositório.

7. Altere algum dos arquivos, faça um novo commit e um novo push e observe o resultado no GitHub (sempre faça refresh da página).

8. Altere um dos arquivos diretamente no GitHub.

9. Use `git pull` para sincronizar o conteúdo que foi alterado no GitHub com o conteúdo da sua pasta local.

10. Crie um arquivo `.gitignore` para definir que tipos de arquivos não devem ser armazenados no repositório do GitHub (arquivos `.class`, por exemplo). Use o site “gitignore.io” para ajudar nesta tarefa. Indique, por exemplo, que seu projeto irá usar Java e VSCode (ou outro IDE). Veja o tipo de conteúdo que é gerado. Armazene este conteúdo em um arquivo chamado `.gitignore` e salve-o na raiz do projeto.

11. Compile e execute seu programa; crie um commit e então execute um `push` e observe que apenas os arquivos cujas terminações não estão listadas no `.gitignore` são armazenados no GitHub.
