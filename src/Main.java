
public class Main {
    public static void main(String[] args) {
        System.out.println("Bem-vindo ao Jogo Batalha Naval!");

        // Criação dos jogadores
        Jogador jogador1 = new Jogador("Jogador 1", false); // Humano
        Jogador maquina = new Jogador("Máquina", true);    // Máquina

        boolean fimDoJogo = false;
        Jogador vencedor = null;

        // Loop principal do jogo
        while (!fimDoJogo) {
            // Turno do Jogador 1
            System.out.println("\nTurno do " + jogador1.getNome());
            jogador1.realizarJogada(maquina);

            if (jogador1.verificarVitoria(maquina)) {
                fimDoJogo = true;
                vencedor = jogador1;
                break;
            }

            // Turno da Máquina
            System.out.println("\nTurno da " + maquina.getNome());
            maquina.realizarJogada(jogador1);

            if (maquina.verificarVitoria(jogador1)) {
                fimDoJogo = true;
                vencedor = maquina;
                break;
            }
        }

        System.out.println("\nO vencedor é: " + vencedor.getNome());
        Relatorio.gerarRelatorio(jogador1, maquina);
    }
}
