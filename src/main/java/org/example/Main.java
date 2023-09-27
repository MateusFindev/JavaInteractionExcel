package org.example;

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



public class Main {
    private static List<Raffle> raffleList = new ArrayList<>();
    private static String file = "./src/main/java/org/example/Mega-Sena.xlsx";
    public static void main(String[] args) {
        System.out.println("Hello world!");
        BufferedInputStream db=null;

        try {
            db = new BufferedInputStream(new FileInputStream(new File(file)));
        } catch (IOException e) {
            System.out.println("Erro ao ler o arquivo: " + e.getMessage());
        }

        Action action = new Action();
        action.readFile(raffleList, db);
    }
}