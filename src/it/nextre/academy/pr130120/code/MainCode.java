package it.nextre.academy.pr130120.code;

import java.util.*;

public class MainCode {
    public static void main(String[] args) {

        Queue<String> prenotazioni = new ArrayDeque<>();
        //Queue<String> prenotazioni = new LinkedList<>();

        // metodi con eccezione:        add     remove  element
        // metodi con speciale ritorno: offer   poll    peek


        prenotazioni.add("A");
        prenotazioni.add("B");
        prenotazioni.add("C");
        //prenotazioni.offer(null);
        //prenotazioni.add(null);
        // leggo l'elemento dalla coda (non rimuovono)
        System.out.println(prenotazioni.element());
        System.out.println(prenotazioni.peek());
        // estrarre e leggere il valore dalla coda
        System.out.println(prenotazioni.remove());
        System.out.println(prenotazioni.poll());
        System.out.println(prenotazioni.poll());
        // elementi finiti
        System.out.println(prenotazioni.peek()); // valore specifico null
        System.out.println(prenotazioni.poll()); // valore specifico null

        //System.out.println(prenotazioni.element()); // eccezione
        //System.out.println(prenotazioni.remove()); // eccezione

        System.out.println("--------------------");

        Deque<String> parcheggio = new ArrayDeque<>();

        parcheggio.add("A");
        parcheggio.add("B");
        System.out.println(parcheggio);
        parcheggio.addFirst("C");
        System.out.println(parcheggio);
        parcheggio.addLast("D");
        System.out.println(parcheggio);
        System.out.println(parcheggio.peek()); // = peekFirst primo elemento della testa
        System.out.println(parcheggio.peekLast()); // = primo elemento dalla coda, ovvero ultimo elemento dalla testa



    }//end main
}//end class
