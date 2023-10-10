package org.example;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        Action action = new Action();
        Menu menu = new Menu();

        List<Raffle> megaSena = new ArrayList<>();

        megaSena = action.create(megaSena);
        menu.menuInicial(action,megaSena);

    }
}