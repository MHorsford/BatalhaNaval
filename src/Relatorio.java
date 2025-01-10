/**
 * Classe para gerar o relatório final do jogo, exibindo os tabuleiros dos dois jogadores.
 */
public class Relatorio {
    /**
     * Gera o relatório final do jogo, exibindo os tabuleiros dos dois jogadores.
     *
     * @param jogador1 O primeiro jogador.
     * @param jogador2 O segundo jogador.
     */
    public static void gerarRelatorio(Jogador jogador1, Jogador jogador2) {
        System.out.println("\n--- Relatório Final ---");
        System.out.println(jogador1.getNome() + ":");
        jogador1.getTabuleiro().exibirCenario(false);

        System.out.println("\n" + jogador2.getNome() + ":");
        jogador2.getTabuleiro().exibirCenario(false);
    }
}
