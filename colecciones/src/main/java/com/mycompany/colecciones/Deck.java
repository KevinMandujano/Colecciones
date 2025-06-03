package com.mycompany.colecciones;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Deck {
    private ArrayList<Card> cartas;

    public Deck() {
        cartas = new ArrayList<>();
        inicializarDeck();
    }

    private void inicializarDeck() {
        String[] palos = {"Treboles", "Corazones", "Picas", "Diamantes"};
        String[] valores = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "A", "J", "Q", "K"};
        for (String palo : palos) {
            String color = (palo.equals("Treboles") || palo.equals("Picas")) ? "Negro" : "Rojo";
            for (String valor : valores) {
                cartas.add(new Card(palo, color, valor));
            }
        }
    }

    public void shuffle() {
        Collections.shuffle(cartas);
        System.out.println("Se mezclo el Deck.");
    }

    public void head() {
        if (cartas.isEmpty()) {
            System.out.println("No hay cartas en el deck");
            return;
        }
        Card carta = cartas.remove(0);
        System.out.println(carta);
        System.out.println("Quedan " + cartas.size() + " cartas en deck");
    }

    public void pick() {
        if (cartas.isEmpty()) {
            System.out.println("No hay cartas en el deck");
            return;
        }
        Random rand = new Random();
        Card carta = cartas.remove(rand.nextInt(cartas.size()));
        System.out.println(carta);
        System.out.println("Quedan " + cartas.size() + " cartas en deck");
    }

    public void hand() {
        if (cartas.size() < 5) {
            System.out.println("No hay suficientes cartas en el deck");
            return;
        }
        for (int i = 0; i < 5; i++) {
            Card carta = cartas.remove(0);
            System.out.println(carta);
        }
        System.out.println("Quedan " + cartas.size() + " cartas en deck");
    }
}
