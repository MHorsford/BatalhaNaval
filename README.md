# Batalha Naval

Este é um jogo de **Batalha Naval** desenvolvido em Java, onde você pode jogar contra a máquina. O objetivo é afundar todos os navios do adversário, atacando posições no tabuleiro.

## Como Jogar

### Requisitos
- Java 8 ou superior

### Instruções de Jogo

1. **Objetivo**: O objetivo do jogo é afundar todos os navios do adversário.
2. **Jogadores**: Você pode jogar contra a máquina ou contra outro jogador humano.
3. **Tabuleiro**: O jogo utiliza um tabuleiro de 10x10 onde cada jogador posiciona seus navios.
4. **Navios**: São utilizados navios de tamanhos variados (1, 2, 3, 4 e 5 quadrados). Eles são posicionados aleatoriamente no tabuleiro.
5. **Ataques**: Em cada turno, o jogador pode atacar uma posição do tabuleiro adversário.
6. **Fim do Jogo**: O jogo termina quando todas as embarcações de um dos jogadores forem afundadas.

### Como Rodar

1. **Clonar o repositório**:
   Abra o terminal e exexute
    ```bash
    git clone https://github.com/MHorsford/BatalhaNaval.git
    ```
    ![image](https://github.com/user-attachments/assets/5528ea91-c273-46cd-9e6b-e4f66cc8900c)

    Depois de clonar o repositorio, navegue a usando cd BatalhaNaval/src
   ![image](https://github.com/user-attachments/assets/40b7dfec-b2da-43e0-82d8-2dc9cd0156c1)

3. **Compilar e rodar o projeto**:

    Se você estiver utilizando o **Maven**:
    ```bash
    mvn clean install
    mvn exec:java
    ```

    Se estiver utilizando apenas o **Java** diretamente:
    Compile o código:
    ```bash
    javac *.java
    ```
    ![image](https://github.com/user-attachments/assets/ff21b491-f115-41a8-9fc7-162f205be239)

    Em seguida, execute o código:
    ```bash
    java Main
    ```
    ![image](https://github.com/user-attachments/assets/8b3a7226-be2d-45de-96ce-cae4f4be93dc)

## Testes
1 - **Realizando alguns movimentos, pode-se ver que alguns ataques acertam a agua, mas a coordenada (0, 5) obtem sucesso
![image](https://github.com/user-attachments/assets/a2bf1b7e-c815-4c6e-a3b9-9b1c366cfa7e)

2 - **Realizando uma pequena alteração no codigo, trocamos o valor de true para false, exibindo as embaracações adversarias, para finalizar um jogo rapidamente e mostrar o relatorio (é necessario recompilar após a alteração).
![image](https://github.com/user-attachments/assets/e55598b6-48d1-43d4-99d0-d08854aefa06)

![image](https://github.com/user-attachments/assets/a3d736ca-f792-48ec-813f-821fd79cb0a4)
Voce pode conferir o teste [aqui](https://youtu.be/2JaKzF0wyGw)


## Estrutura do Projeto e documentação

O projeto é estruturado da seguinte forma:

## Classes

### `Main`
- Contém a lógica de execução do jogo. Aqui é onde o jogo começa, os jogadores são criados e as jogadas são alternadas entre os jogadores até que alguém vença.

### `Jogador`
- Representa um jogador no jogo. Pode ser um jogador humano ou uma máquina (IA).
- Contém a lógica para realizar jogadas, tanto para humanos quanto para máquinas.

### `Tabuleiro`
- Representa o tabuleiro de 10x10 onde os navios são posicionados.
- Gerencia os ataques, acertos e erros, e exibe o estado do jogo.

### `Cores`
- Define as cores usadas para exibir o tabuleiro e os resultados das jogadas (acertos, erros e água).
### Documentação
 - A documentação completa do projeto está disponível [aqui](https://mhorsford.github.io/BatalhaNaval/package-summary.html).
 - Criada apartir do javadoc.

## Licença

Este projeto está licenciado sob a [MIT License](LICENSE).


