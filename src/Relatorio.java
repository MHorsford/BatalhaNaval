public class Relatorio {
    public static void gerarRelatorio(Jogador jogador1, Jogador jogador2) {
        System.out.println("\n--- Relatório Final ---");
        System.out.println(jogador1.getNome() + ":");
        jogador1.getTabuleiro().exibirCenario(false);

        System.out.println("\n" + jogador2.getNome() + ":");
        jogador2.getTabuleiro().exibirCenario(false);
    }
}
