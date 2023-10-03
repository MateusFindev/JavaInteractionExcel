package org.example;

import java.util.Scanner;

public class Menu {
    public void menuInicial(Action action) throws InterruptedException {
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
            case 1:
                System.out.println("Quantidade de concursos sem ganhadores: " + action.semGanhador());
                break;
            case 2:
                System.out.println("O MAIOR valor pago para apostas com 4 dezenas sorteadas: " + action.maiorValor(4));
                break;
            case 3:
                System.out.println("O MENOR valor pago para apostas com 5 dezenas sorteadas: " + action.menorValor(5));
                break;
            case 4:
                System.out.println("O MENOR valor pago para apostas com 6 dezenas sorteadas: " + action.menorValor(6));
                break;
            case 5:
                System.out.println("O MAIOR valor pago para apostas com 4 dezenas sorteadas: " + action.maiorValor(4));
                break;
            case 6:
                System.out.println("O MAIOR valor pago para apostas com 5 dezenas sorteadas: " + action.maiorValor(5));
                break;
            case 7:
                System.out.println("O MAIOR valor pago para apostas com 6 dezenas sorteadas: " + action.maiorValor(6));
                break;
            case 8:
                System.out.println("A quantidade de ganhadores com 4 dezenas em todos os concursos: " + action.qtdGanhadores(4));
                break;
            case 9:
                System.out.println("A quantidade de ganhadores com 5 dezenas em todos os concursos: " + action.qtdGanhadores(5));
                break;
            case 10:
                System.out.println("A quantidade de ganhadores com 6 dezenas em todos os concursos: " + action.qtdGanhadores(6));
                break;
            case 11:
                action.qtdVezesNumero();
                break;
            case 12:
                action.buscarSorteio();
                break;
            default:
                System.out.println("Selecione uma alternativa válida\n");
        }

        Thread.sleep(1000);
        menuInicial(action);
    }
}
