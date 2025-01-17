/**
 * Classe principal do jogo Batalha Naval.
 *
 * Este jogo simula uma partida entre um jogador humano e uma máquina, onde ambos
 * tentam acertar os navios do adversário. O jogo continua até que um dos jogadores
 * vença, o que é determinado quando todos os navios de um dos jogadores forem afundados.
 *
 * O fluxo do jogo alterna entre os turnos do jogador humano e da máquina, e ao final
 * do jogo é exibido o vencedor e um relatório com o desempenho da partida.
 */
public class Main {
    /**
     * Método principal que inicializa o jogo e gerencia o fluxo de turnos.
     *
     * Este método cria os dois jogadores (um humano e um computador), e então alterna
     * entre os turnos dos jogadores até que um deles vença. O vencedor é determinado
     * com base na condição de vitória de cada jogador.
     *
     * @param args Argumentos da linha de comando (não utilizados neste jogo).
     */
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
