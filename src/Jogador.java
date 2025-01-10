import java.util.Random;
import java.util.Scanner;
/**
 * Representa um jogador no jogo Batalha Naval.
 *
 * Cada jogador possui um nome, um tabuleiro para posicionamento de navios e uma
 * lógica de jogada específica. Pode ser um jogador humano ou a máquina. O objetivo
 * de cada jogador é atacar o tabuleiro do adversário até afundar todos os seus navios.
 */
public class Jogador {
    /**
     * Nome do jogador.
     */
    private final String nome;
    /**
     * Indica se o jogador é uma máquina (IA) ou um jogador humano.
     */
    private final boolean isMaquina;
    /**
     * O tabuleiro do jogador, que contém os navios e registra os ataques realizados.
     */
    private final Tabuleiro tabuleiro;
    /**
     * Construtor que cria um jogador com o nome especificado e se é uma máquina ou não.
     *
     * @param nome      o nome do jogador.
     * @param isMaquina indica se o jogador é uma máquina (true) ou um jogador humano (false).
     */
    public Jogador(String nome, boolean isMaquina) {
        this.nome = nome;
        this.isMaquina = isMaquina;
        this.tabuleiro = new Tabuleiro();
    }
    /**
     * Retorna o nome do jogador.
     *
     * @return o nome do jogador.
     */
    public String getNome() {
        return nome;
    }
    /**
     * Realiza uma jogada no jogo, podendo ser feita pelo jogador humano ou pela máquina.
     *
     * @param adversario o jogador adversário contra quem o ataque será realizado.
     */
    public void realizarJogada(Jogador adversario) {
        if (isMaquina) {
            realizarJogadaMaquina(adversario);
        } else {
            realizarJogadaHumana(adversario);
        }
    }
    /**
     * Realiza a jogada de um jogador humano, que envolve escolher uma posição para atacar.
     *
     * Exibe o tabuleiro do jogador e do adversário, solicitando a posição do ataque ao
     * jogador humano.
     *
     * @param adversario o jogador adversário contra quem o ataque será realizado.
     */
    private void realizarJogadaHumana(Jogador adversario) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Seu tabuleiro:");
        tabuleiro.exibirCenario(false); // Altere para false, caso queira visualizar os navios

        System.out.println("\nTabuleiro do adversário:");
        adversario.tabuleiro.exibirCenario(true); // Altere para false, caso queira visualizar os navios

        System.out.print("Digite a linha (0-9): ");
        int linha = scanner.nextInt();
        System.out.print("Digite a coluna (0-9): ");
        int coluna = scanner.nextInt();

        adversario.tabuleiro.realizarAtaque(linha, coluna);
    }
    /**
     * Realiza a jogada da máquina, que escolhe uma posição aleatória para atacar.
     *
     * A máquina escolhe uma posição aleatória até acertar uma posição válida que ainda
     * não tenha sido atacada.
     *
     * @param adversario o jogador adversário contra quem o ataque será realizado.
     */
    private void realizarJogadaMaquina(Jogador adversario) {
        Random random = new Random();
        int linha, coluna;
        do {
            linha = random.nextInt(10);
            coluna = random.nextInt(10);
        } while (adversario.tabuleiro.realizarAtaque(linha, coluna));
        System.out.println("A máquina atacou a posição (" + linha + ", " + coluna + ")");
    }
    /**
     * Verifica se o jogador venceu o jogo, ou seja, se todas as embarcações do adversário
     * foram afundadas.
     *
     * @param adversario o jogador adversário.
     * @return true se o jogador venceu, ou seja, se o adversário teve todas suas embarcações
     *         afundadas, false caso contrário.
     */
    public boolean verificarVitoria(Jogador adversario) {
        return adversario.tabuleiro.todasEmbarcacoesAfundadas();
    }
    /**
     * Retorna o tabuleiro do jogador.
     *
     * @return o tabuleiro do jogador.
     */
    public Tabuleiro getTabuleiro() {
        return this.tabuleiro;
    }

}

