package org.example;

import java.io.IOException;


public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        Action action = new Action();
        Menu menu = new Menu();

        action.create();
        menu.menuInicial(action);

    }
}