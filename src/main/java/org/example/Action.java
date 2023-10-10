package org.example;

import lombok.Cleanup;
import org.apache.commons.collections4.IteratorUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Logger;

public class Action {
    private Logger log = Logger.getLogger(String.valueOf(this.getClass()));

    public List<Raffle> create(List<Raffle> megaSena) throws IOException {

        @Cleanup
        FileInputStream file = new FileInputStream("src/main/resources/Mega-Sena.xlsx");

        Workbook workbook = new XSSFWorkbook(file);
        Sheet sheet = workbook.getSheetAt(0);
        List<Row> rowList = (List<Row>) toList(sheet.iterator());

        rowList.remove(0);

        rowList.forEach(row -> {
            List<Cell> cells = (List<Cell>) toList(row.cellIterator());

            List<Integer> tempBalls = new ArrayList<Integer>();
            tempBalls.add((int) cells.get(2).getNumericCellValue());
            tempBalls.add((int) cells.get(3).getNumericCellValue());
            tempBalls.add((int) cells.get(4).getNumericCellValue());
            tempBalls.add((int) cells.get(5).getNumericCellValue());
            tempBalls.add((int) cells.get(6).getNumericCellValue());
            tempBalls.add((int) cells.get(7).getNumericCellValue());

            Raffle raffle = Raffle.builder()
                    .idContest((int) cells.get(0).getNumericCellValue())
                    .contestDate(cells.get(1).getStringCellValue())
                    .balls(tempBalls)
                    .winnersAmt6((int) cells.get(8).getNumericCellValue())
                    .distribution6(cells.get(10).getStringCellValue())
                    .winnersAmt5((int) cells.get(11).getNumericCellValue())
                    .distribution5(cells.get(12).getStringCellValue())
                    .winnersAmt4((int) cells.get(13).getNumericCellValue())
                    .distribution4(cells.get(14).getStringCellValue())
                    .build();
            megaSena.add(raffle);
        });

        imprimir(megaSena);
        return megaSena;
    }

    public List<?> toList(Iterator<?> iterator) {
        return IteratorUtils.toList(iterator);
    }

    public void imprimir(List<Raffle> raffleList) {
        raffleList.forEach(System.out::println);
    }

    public Integer semGanhador(List<Raffle> megaSena) {
        Integer noWinnersAmt = 0;

        for (Raffle raffle : megaSena) {
            if (raffle.getWinnersAmt6() == 0) {
                noWinnersAmt++;
            }
        }

        return noWinnersAmt;
    }

    public BigDecimal menorValor(List<Raffle> megaSena, int ballAmt) {
        BigDecimal valor = BigDecimal.ZERO;
        BigDecimal menorValor = BigDecimal.ZERO;
        String stringTemp = "R$0.000,00";

        for (Raffle raffle : megaSena) {
            switch (ballAmt) {
                case 4 -> stringTemp = raffle.getDistribution4();
                case 5 -> stringTemp = raffle.getDistribution5();
                case 6 -> stringTemp = raffle.getDistribution6();
                default -> {
                }
            }

            stringTemp = stringTemp.replace("R$", "");
            stringTemp = stringTemp.replace(".", "");
            stringTemp = stringTemp.replace(",", ".");

            valor = new BigDecimal(stringTemp);

            if (menorValor.compareTo(BigDecimal.ZERO)==0) {
                menorValor = valor;
            }else if (valor.compareTo(BigDecimal.ZERO)>0) {
                if (menorValor.compareTo(valor) >= 0) {menorValor = valor;}
            }
        }
        return menorValor;
    }

    public BigDecimal maiorValor(List<Raffle> megaSena, int ballAmt) {
        BigDecimal valor;
        BigDecimal maiorValor = BigDecimal.ZERO;

        for (Raffle raffle : megaSena) {
            String stringTemp = "R$0.000,00";

            switch (ballAmt) {
                case 4 -> stringTemp = raffle.getDistribution4();
                case 5 -> stringTemp = raffle.getDistribution5();
                case 6 -> stringTemp = raffle.getDistribution6();
                default -> {
                }
            }

            stringTemp = stringTemp.replace("R$", "");
            stringTemp = stringTemp.replace(".", "");
            stringTemp = stringTemp.replace(",", ".");

            valor = new BigDecimal(stringTemp);


            if (maiorValor.equals(BigDecimal.ZERO) || maiorValor.compareTo(valor) < 0) {
                maiorValor = valor;
            }
        }
        System.out.println(maiorValor);
        return maiorValor;
    }

    public int qtdGanhadores(List<Raffle> megaSena, int ballAmt) {
        int winnersAmt = 0;

        for (Raffle raffle : megaSena) {
            switch (ballAmt) {
                case 4:
                    winnersAmt += raffle.getWinnersAmt4();
                    break;
                case 5:
                    winnersAmt += raffle.getWinnersAmt5();
                    break;
                case 6:
                    winnersAmt += raffle.getWinnersAmt6();
                    break;
            }
        }

        return winnersAmt;
    }

    public String buscarSorteio(List<Raffle> megaSena) {
        List<Integer> chosedBalls = pedirTesteSorteio(megaSena);
        Raffle tempRaffle = null;

        for (Raffle raffle : megaSena) {

            if (raffle.getBalls().get(0) == chosedBalls.get(0)) {
                if (raffle.getBalls().get(1) == chosedBalls.get(1)) {
                    if (raffle.getBalls().get(2) == chosedBalls.get(2)) {
                        if (raffle.getBalls().get(3) == chosedBalls.get(3)) {
                            if (raffle.getBalls().get(4) == chosedBalls.get(4)) {
                                if (raffle.getBalls().get(5) == chosedBalls.get(5)) {
                                    tempRaffle = raffle;
                                }
                            }
                        }
                    }
                }
            }
        }

        System.out.println(tempRaffle);
        return "Sim";
    }

    public List<Integer> pedirTesteSorteio(List<Raffle> megaSena) {
        Scanner scan = new Scanner(System.in);
        List<Integer> balls = new ArrayList<Integer>();
        int value = 0;

        for (int i = 0; i <= 5; i++) {
            System.out.println("Qual o número escolhido na bola " + (i + 1) + ":");
            System.out.print("Digite:");
            value = scan.nextInt();

            if (value > 1 && value < 100) {
                balls.add(value);
            } else {
                do {
                    System.out.println("Digite um número de 1 a 99.");
                    System.out.print("Digite:");
                    value = scan.nextInt();
                } while (value < 1 && value > 100);
            }
        }
        return balls;
    }

    public List<Integer> qtdVezesNumero(List<Raffle> megaSena) {
        List<Integer> options = new ArrayList<>();

        for (int i = 0; i <= 59; i++) {
            options.add(0);
        }


        for (Raffle raffle : megaSena) {
            for (Integer number : raffle.getBalls()) {
                int i = number - 1;
                options.set(i, options.get(i) + 1);
            }
        }

        int i = 0;
        for (Integer number : options) {
            i++;
            System.out.println("O número " + i + " foi sorteado " + number + " vezes.");
        }

        return options;
    }
}
