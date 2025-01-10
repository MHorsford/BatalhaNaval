import java.util.Random;
import java.util.Scanner;

public class Jogador {
    private final String nome;
    private final boolean isMaquina;
    private final Tabuleiro tabuleiro;

    public Jogador(String nome, boolean isMaquina) {
        this.nome = nome;
        this.isMaquina = isMaquina;
        this.tabuleiro = new Tabuleiro();
    }

    public String getNome() {
        return nome;
    }

    public void realizarJogada(Jogador adversario) {
        if (isMaquina) {
            realizarJogadaMaquina(adversario);
        } else {
            realizarJogadaHumana(adversario);
        }
    }

    private void realizarJogadaHumana(Jogador adversario) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Seu tabuleiro:");
        tabuleiro.exibirCenario(false);

        System.out.println("\nTabuleiro do adversário:");
        adversario.tabuleiro.exibirCenario(false);

        System.out.print("Digite a linha (0-9): ");
        int linha = scanner.nextInt();
        System.out.print("Digite a coluna (0-9): ");
        int coluna = scanner.nextInt();

        adversario.tabuleiro.realizarAtaque(linha, coluna);
    }

    private void realizarJogadaMaquina(Jogador adversario) {
        Random random = new Random();
        int linha, coluna;
        do {
            linha = random.nextInt(10);
            coluna = random.nextInt(10);
        } while (adversario.tabuleiro.realizarAtaque(linha, coluna));
        System.out.println("A máquina atacou a posição (" + linha + ", " + coluna + ")");
    }

    public boolean verificarVitoria(Jogador adversario) {
        return adversario.tabuleiro.todasEmbarcacoesAfundadas();
    }

    public Tabuleiro getTabuleiro() {
        return this.tabuleiro;
    }

}

