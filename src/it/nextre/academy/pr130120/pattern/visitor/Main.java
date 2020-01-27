package it.nextre.academy.pr130120.pattern.visitor;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        Libro lib1 = new Libro("Angeli e demoni", "Dan Brown", "811702131981",19.99);
        Libro lib2 = new Libro("Educazione Siberiana", "Piero Marzucchetti","813185148181",24.99);

        Gadget bic4colori = new Gadget("Bic 4 colori", "descrizione...",0.99);
        Gadget tazzaUnicorno = new Gadget("Tazza Corno", "per finti cornuti...",4.99);

        Carrello cart = new Carrello();
        cart.add(bic4colori);
        cart.add(lib1);


        TotaleCarrelloVisitor tot = new TotaleCarrelloVisitor(cart);
        System.out.println("Totale non scontato: "+tot.getTotale());

        TotaleCarrelloVisitorPromoLibri totPromo = new TotaleCarrelloVisitorPromoLibri(cart);
        System.out.println("Totale promo libri 50%: "+totPromo.getTotale());


        Romanzo rom1 = new Romanzo("Il rosso e il nero", "Standald A.","84648158254584",12.00);

        cart.add(rom1);
        TotaleCarrelloPromoRomanzi30 totPromo30 = new TotaleCarrelloPromoRomanzi30(cart);
        System.out.println("Totale promo romanzi 30%: "+totPromo30.getTotale());

    }//end main

}//end class
