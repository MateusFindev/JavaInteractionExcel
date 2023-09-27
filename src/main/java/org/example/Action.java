package org.example;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Logger;

public class Action {
    private Logger log = Logger.getLogger(String.valueOf(this.getClass()));

    public List<Raffle> readFile (List<Raffle> raffleList, BufferedInputStream db) {
        log.info("Lendo arquivo com dados dos sorteios da Mega-Sena!");
        try {
            XSSFWorkbook wb = new XSSFWorkbook(db);
            Sheet sheet = wb.getSheetAt(0);
            Iterator<Row> rowIterator = sheet.rowIterator();

            log.info("Aberto arquivo.\nSerá iniciado a leitura de concurso por concurso.");

            while (rowIterator.hasNext()) {
                Row linha = rowIterator.next();
                Iterator<Cell> cellIterator = linha.cellIterator();

                Raffle raffle = new Raffle();

                while (cellIterator.hasNext()) {
                    Cell cell = cellIterator.next();
                    int z = cell.getColumnIndex();

                    switch (z) {
                        case 0:
                            raffle.setIdContest(cell.toString());
                            break;
                        case 1:
                            raffle.setContestDate(cell.toString());
                            break;
                        case 2:
                            raffle.setBall1(cell.toString());
                            break;
                        case 3:
                            raffle.setBall2(cell.toString());
                            break;
                        case 4:
                            raffle.setBall3(cell.toString());
                            break;
                        case 5:
                            raffle.setBall4(cell.toString());
                            break;
                        case 6:
                            raffle.setBall5(cell.toString());
                            break;
                        case 7:
                            raffle.setBall6(cell.toString());
                            break;
                        case 8:
                            raffle.setWinnersAmt6(cell.toString());
                            break;
                        case 10:
                            raffle.setDistribution6(cell.toString());
                            break;
                        case 11:
                            raffle.setWinnersAmt5(cell.toString());
                            break;
                        case 12:
                            raffle.setDistribution5(cell.toString());
                            break;
                        case 13:
                            raffle.setWinnersAmt4(cell.toString());
                            break;
                        case 14:
                            raffle.setDistribution4(cell.toString());
                            break;
                    }

                    raffleList.add(raffle);
                }
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return raffleList;
    }
}
