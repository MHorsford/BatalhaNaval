import java.util.Random;
/**
 * Representa o tabuleiro de um jogo de Batalha Naval.
 *
 * Esta classe gerencia o cenário do jogo, o posicionamento dos navios, os ataques realizados,
 * e a exibição do estado atual do jogo. O tabuleiro é uma matriz 10x10, onde cada posição
 * pode conter água, um navio, um acerto ou um erro. O objetivo do jogo é afundar todos os
 * navios do adversário.
 */
public class Tabuleiro {
    /**
     * Representa o cenário do tabuleiro com 10x10 posições.
     * Cada posição pode conter água, um navio, um acerto ou um erro.
     */
    private final char[][] cenario;
    /**
     * Marca as posições que já foram atacadas no tabuleiro.
     * Cada posição é false por padrão, tornando-se true após um ataque.
     */
    private final boolean[][] ataquesRealizados;
    /**
     * Símbolo que representa a água no tabuleiro.
     */
    public static final char AGUA = '~';
    /**
     * Símbolo que representa um navio no tabuleiro.
     */
    public static final char NAVIO = 'N';
    /**
     * Símbolo que representa um acerto no tabuleiro.
     */
    public static final char ACERTO = 'X';
    /**
     * Símbolo que representa um erro no tabuleiro.
     */
    public static final char ERRO = 'O';
    /**
     * Construtor que inicializa o tabuleiro com água, posiciona os navios e
     * configura os ataques realizados.
     */
    public Tabuleiro() {
        this.cenario = new char[10][10];
        this.ataquesRealizados = new boolean[10][10];
        inicializarCenario();
        posicionarNavios();
    }
    /**
     * Inicializa o cenário preenchendo todas as posições com água (~).
     */
    private void inicializarCenario() {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                cenario[i][j] = AGUA;
            }
        }
    }
    /**
     * Posiciona os navios no tabuleiro aleatoriamente, garantindo que não haja
     * sobreposição ou ultrapassagem dos limites.
     * Tamanhos dos navios: 5, 4, 3, 2, 1.
     */
    private void posicionarNavios() {
        Random random = new Random();
        int[] tamanhos = {5, 4, 3, 2, 1};

        for (int tamanho : tamanhos) {
            boolean posicionado = false;
            while (!posicionado) {
                int linha = random.nextInt(10);
                int coluna = random.nextInt(10);
                boolean horizontal = random.nextBoolean();

                if (podePosicionarNavio(linha, coluna, tamanho, horizontal)) {
                    for (int i = 0; i < tamanho; i++) {
                        if (horizontal) {
                            cenario[linha][coluna + i] = NAVIO;
                        } else {
                            cenario[linha + i][coluna] = NAVIO;
                        }
                    }
                    posicionado = true;
                }
            }
        }
    }
    /**
     * Verifica se um navio pode ser posicionado na posição especificada.
     *
     * @param linha       a linha inicial.
     * @param coluna      a coluna inicial.
     * @param tamanho     o tamanho do navio.
     * @param horizontal  true para posicionamento horizontal, false para vertical.
     * @return true se o navio pode ser posicionado, false caso contrário.
     */
    private boolean podePosicionarNavio(int linha, int coluna, int tamanho, boolean horizontal) {
        if (horizontal) {
            if (coluna + tamanho > 10) return false;
            for (int i = 0; i < tamanho; i++) {
                if (cenario[linha][coluna + i] != AGUA) return false;
            }
        } else {
            if (linha + tamanho > 10) return false;
            for (int i = 0; i < tamanho; i++) {
                if (cenario[linha + i][coluna] != AGUA) return false;
            }
        }
        return true;
    }
    /**
     * Exibe o estado atual do tabuleiro.
     *
     * @param ocultarEmbarcacoes true para ocultar navios (exibindo apenas água),
     *                           false para exibir os navios.
     */
    public void exibirCenario(boolean ocultarEmbarcacoes) {
        // Exibir os números das colunas no topo
        System.out.print("  "); // Espaço inicial para alinhar com os números das linhas
        for (int coluna = 0; coluna < 10; coluna++) {
            System.out.print(coluna + " ");
        }
        System.out.println();

        // Exibir o tabuleiro com cores
        for (int linha = 0; linha < 10; linha++) {
            System.out.print(linha + " "); // Número da linha
            for (int coluna = 0; coluna < 10; coluna++) {
                char simbolo = cenario[linha][coluna];
                switch (simbolo) {
                    case NAVIO: // Navios
                        if (ocultarEmbarcacoes) {
                            System.out.print(Cores.AZUL + AGUA + " " + Cores.RESET);
                        } else {
                            System.out.print(Cores.VERDE + NAVIO + " " + Cores.RESET);
                        }
                        break;
                    case ACERTO: // Acerto (X)
                        System.out.print(Cores.VERMELHO + ACERTO + " " + Cores.RESET);
                        break;
                    case ERRO: // Erro (O)
                        System.out.print(Cores.AMARELO + ERRO + " " + Cores.RESET);
                        break;
                    default: // Água (~)
                        System.out.print(Cores.AZUL + AGUA + " " + Cores.RESET);
                        break;
                }
            }
            System.out.println(); // Nova linha
        }
    }
    /**
     * Realiza um ataque em uma posição específica do tabuleiro.
     *
     * @param linha  a linha a ser atacada.
     * @param coluna a coluna a ser atacada.
     * @return true se o ataque acertou um navio, false caso contrário.
     */
    public boolean realizarAtaque(int linha, int coluna) {
        if (ataquesRealizados[linha][coluna]) {
            System.out.println("Posição já atacada!");
            return false;
        }
        ataquesRealizados[linha][coluna] = true;

        if (cenario[linha][coluna] == NAVIO) {
            cenario[linha][coluna] = ACERTO;
            System.out.println("Acertou um navio!");
            return true;
        } else {
            cenario[linha][coluna] = ERRO;
            System.out.println("Errou!");
            return false;
        }
    }
    /**
     * Verifica se todas as embarcações foram afundadas.
     *
     * @return true se não houver mais navios no tabuleiro, false caso contrário.
     */
    public boolean todasEmbarcacoesAfundadas() {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (cenario[i][j] == NAVIO) {
                    return false;
                }
            }
        }
        return true;
    }

}
