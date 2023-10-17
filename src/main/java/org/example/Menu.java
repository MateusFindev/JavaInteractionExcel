package org.example;

import java.util.List;
import java.util.Scanner;

public class Menu {
    public void menuInicial(Action action, List<Raffle> megaSena) throws InterruptedException {
        Scanner scan = new Scanner(System.in);

        System.out.println("\nQual informação gostaria de saber?\n" +
                "[ 1 ] Quantidade de concursos sem ganhadores\n" +
                "[ 2 ] O MENOR valor pago para apostas com 4 dezenas sorteadas\n" +
                "[ 3 ] O MENOR valor pago para apostas com 5 dezenas sorteadas\n" +
                "[ 4 ] O MENOR valor pago para apostas com 6 dezenas sorteadas\n" +
                "[ 5 ] O MAIOR valor pago para apostas com 4 dezenas sorteadas\n" +
                "[ 6 ] O MAIOR valor pago para apostas com 5 dezenas sorteadas\n" +
                "[ 7 ] O MAIOR valor pago para apostas com 6 dezenas sorteadas\n" +
                "[ 8 ] A quantidade de ganhadores com 4 dezenas em todos os concurso\n" +
                "[ 9 ] A quantidade de ganhadores com 5 dezenas em todos os concurso\n" +
                "[ 10 ] A quantidade de ganhadores com 6 dezenas em todos os concurso\n" +
                "[ 11 ] A quantidade de vezes que cada número foi sorteado\n" +
                "[ 12 ] Verificar minha sequencia de números já foi sorteada\n");

        System.out.print("Digite a opção:");
        int resposta = scan.nextInt();

        switch (resposta) {
            case 1 -> System.out.println("Quantidade de concursos sem ganhadores: " + action.semGanhador(megaSena));
            case 2 -> System.out.println("O MENOR valor pago para apostas com 4 dezenas sorteadas: " + action.menorValor(megaSena, 4));
            case 3 -> System.out.println("O MENOR valor pago para apostas com 5 dezenas sorteadas: " + action.menorValor(megaSena, 5));
            case 4 -> System.out.println("O MENOR valor pago para apostas com 6 dezenas sorteadas: " + action.menorValor(megaSena, 6));
            case 5 -> System.out.println("O MAIOR valor pago para apostas com 4 dezenas sorteadas: " + action.maiorValor(megaSena, 4));
            case 6 -> System.out.println("O MAIOR valor pago para apostas com 5 dezenas sorteadas: " + action.maiorValor(megaSena, 5));
            case 7 -> System.out.println("O MAIOR valor pago para apostas com 6 dezenas sorteadas: " + action.maiorValor(megaSena, 6));
            case 8 -> System.out.println("A quantidade de ganhadores com 4 dezenas em todos os concursos: " + action.qtdGanhadores(megaSena, 4));
            case 9 -> System.out.println("A quantidade de ganhadores com 5 dezenas em todos os concursos: " + action.qtdGanhadores(megaSena, 5));
            case 10 -> System.out.println("A quantidade de ganhadores com 6 dezenas em todos os concursos: " + action.qtdGanhadores(megaSena, 6));
            case 11 -> action.qtdVezesNumero(megaSena);
            case 12 -> action.buscarSorteio(megaSena,action.pedirTesteSorteio());
            default -> System.out.println("Selecione uma alternativa válida\n");
        }

        Thread.sleep(1000);
        menuInicial(action,megaSena);
    }
}
