# Roteiro de Leitura: Introdução aos Sistemas de Controle de versão e Git
- Prof. Bernardo Copstein

Use este questionário como roteiro de leitura do capítulo 1 do livro “PRO-GIT”:
“Getting Started” (pg. 9)

1. O que vem a ser controle de versões?

    R: É um sistema que registra as mudanças feitas em arquivos ao longo do tempo, permitindo voltar a versões anteriores e comparar alterações.

2. De que maneira os VCS costumam armazenar as diferentes versões de um
arquivo?

    R: Em geral, eles armazenam as diferenças entre as versões ou mantêm cópias do arquivo em cada revisão, permitindo reconstruir o histórico.

3. Como os VCS lidam com a necessidade de colaboração entre diferentes
desenvolvedores?

    R: Eles permitem que várias pessoas trabalhem no mesmo projeto, sincronizando mudanças, criando branchs de trabalho e depois integrando tudo por meio de merge.

4. Qual o principal problema dos VCS centralizados e como os VCS distribuídos
lidam com a questão?

    R: O principal problema dos centralizados é a dependência de um único servidor.
    Nos distribuídos, cada desenvolvedor tem uma cópia completa do repositório, o que reduz essa dependência e permite trabalho offline.

5. Qual a diferença na forma de armazenamento dos dados entre o Git e os
outros CVS?

    R: O Git armazena os dados como snapshots do estado dos arquivos, em vez de guardar apenas diferenças entre versões como muitos outros sistemas.

6. Quais são os 3 estados em que um arquivo gerenciado pelo Git pode se
encontrar?

    R: Modificado (modified), preparado (staged) e commitado (committed).

7. Qual a sequência clássica de uso do Git?

R: git pull
git status
git add .
git commit -m "Descrição das alterações"
git push
