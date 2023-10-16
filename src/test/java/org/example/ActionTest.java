package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class ActionTest {
    @Test
    void create_QuandoReceberListaNula_NaoRetornarListaVazia() {
        List<Raffle> megaSena = new ArrayList<>();
        Action action = new Action();
        Assertions.assertFalse(action.create(megaSena).isEmpty());
    }

    @org.junit.jupiter.api.Test
    void toList() {

    }

    @org.junit.jupiter.api.Test
    void imprimir() {
    }

    @org.junit.jupiter.api.Test
    void semGanhador() {
    }

    @org.junit.jupiter.api.Test
    void menorValor() {
    }

    @org.junit.jupiter.api.Test
    void maiorValor() {
    }

    @org.junit.jupiter.api.Test
    void qtdGanhadores() {
    }

    @org.junit.jupiter.api.Test
    void buscarSorteio() {
    }

    @org.junit.jupiter.api.Test
    void pedirTesteSorteio() {
    }

    @org.junit.jupiter.api.Test
    void qtdVezesNumero() {
    }
}
