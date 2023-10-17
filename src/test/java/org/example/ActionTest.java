package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ActionTest {
    Action action = new Action();

    @Test
    void create_QuandoReceberListaNula_NaoRetornarListaVazia() {
        List<Raffle> megaSena = new ArrayList<>();

        Assertions.assertFalse(action.create(megaSena).isEmpty());
    }


    @Test
    void semGanhador_QuandoReceberListaComGanhadores_RetornarVerdadeiro() {
        List<Raffle> list = new ArrayList<>();
        List<Integer> balls = new ArrayList<>();
        balls.add(15);

        list.add(new Raffle(1,"26/10/2022",balls,5,"0",5,"0",7,"0"));
        list.add(new Raffle(2,"26/10/2022",balls,9,"0",5,"0",7,"0"));
        list.add(new Raffle(3,"26/10/2022",balls,6,"0",5,"0",7,"0"));

        Assertions.assertTrue(action.semGanhador(list)==0);
    }

    @Test
    void menorValor_QuandoReceberUmRaffleComValorZero_RetornarMenorValorDiferenteZero() {
        List<Raffle> list = new ArrayList<>();
        List<Integer> balls = new ArrayList<>();
        balls.add(15);

        list.add(new Raffle(1,"26/10/2022",balls,5,"R$9,00",5,"R$0,00",7,"R$0,00"));
        list.add(new Raffle(2,"26/10/2022",balls,9,"R$0,00",5,"R$0,00",7,"R$0,00"));
        list.add(new Raffle(3,"26/10/2022",balls,6,"R$6,00",5,"R$0,00",7,"R$0,00"));

       Assertions.assertNotEquals(BigDecimal.ZERO,action.menorValor(list,6));
    }

    @Test
    void maiorValor_QuandoReceberValoresZero_RetornarNull() {
        List<Raffle> list = new ArrayList<>();
        List<Integer> balls = new ArrayList<>();
        balls.add(15);

        list.add(new Raffle(1,"26/10/2022",balls,5,"R$9,00",5,"R$0,00",7,"R$0,00"));
        list.add(new Raffle(2,"26/10/2022",balls,9,"R$0,00",5,"R$0,00",7,"R$0,00"));
        list.add(new Raffle(3,"26/10/2022",balls,6,"R$6,00",5,"R$0,00",7,"R$0,00"));

        Assertions.assertNull(action.maiorValor(list,5));
    }

    @Test
    void qtdGanhadores_QuandoPossuirInteiroNegativo_RetornarSemSubtrair() {
        List<Raffle> list = new ArrayList<>();
        List<Integer> balls = new ArrayList<>();
        balls.add(15);

        list.add(new Raffle(1,"26/10/2022",balls,5,"R$9,00",5,"R$0,00",7,"R$0,00"));
        list.add(new Raffle(2,"26/10/2022",balls,9,"R$0,00",-5,"R$0,00",7,"R$0,00"));
        list.add(new Raffle(3,"26/10/2022",balls,6,"R$6,00",5,"R$0,00",7,"R$0,00"));

        Assertions.assertEquals(10,action.qtdGanhadores(list,5));
    }

    @Test
    void buscarSorteio_QuandoReceberListaComTresConcursosIguais_RetornarStringEspecificada() {



        Assertions.assertEquals("Sim, 3 vezes", action.buscarSorteio(list,balls));
    }

    @Test
    void pedirTesteSorteio() {

    }

    @org.junit.jupiter.api.Test
    void qtdVezesNumero() {
    }
}
