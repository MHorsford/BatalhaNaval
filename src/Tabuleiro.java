import java.util.Random;

public class Tabuleiro {
    private final char[][] cenario;
    private final boolean[][] ataquesRealizados;
    public static final char AGUA = '~';
    public static final char NAVIO = 'N';
    public static final char ACERTO = 'X';
    public static final char ERRO = 'O';

    public Tabuleiro() {
        this.cenario = new char[10][10];
        this.ataquesRealizados = new boolean[10][10];
        inicializarCenario();
        posicionarNavios();
    }

    private void inicializarCenario() {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                cenario[i][j] = AGUA;
            }
        }
    }

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
