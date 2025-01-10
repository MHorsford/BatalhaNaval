/**
 * Representa as cores usadas no jogo Batalha Naval.
 *
 * Esta classe contém constantes de cor para facilitar a estilização da saída
 * no terminal, associando cores específicas a diferentes estados do jogo, como
 * navios, acertos, erros e água.
 *
 * As cores são representadas por códigos ANSI e são aplicadas ao texto impresso
 * no console para dar feedback visual ao jogador durante o jogo.
 */
public class Cores {
    /**
     * Reseta a cor para o padrão do terminal.
     *
     * Esta constante é usada para remover qualquer cor anterior e retornar ao
     * estilo padrão do terminal.
     */
    public static final String RESET = "\u001B[0m";
    /**
     * Define a cor verde.
     *
     * Utilizada para representar os navios que não foram atingidos, ajudando a
     * distinguir os navios do jogador.
     */
    public static final String VERDE = "\u001B[32m";
    /**
     * Define a cor vermelha.
     *
     * Utilizada para representar acertos ("X"), indicando que um navio foi atingido
     * pelo jogador.
     */
    public static final String VERMELHO = "\u001B[31m";
    /**
     * Define a cor amarela.
     *
     * Utilizada para representar erros ("0"), indicando que a água foi atingida e
     * nenhum navio foi encontrado naquele local.
     */
    public static final String AMARELO = "\u001B[33m";
    /**
     * Define a cor azul.
     *
     * Utilizada para representar a água ("~"), indicando posições onde não há navios
     * nem acertos durante o jogo.
     */
    public static final String AZUL = "\u001B[34m";
}

