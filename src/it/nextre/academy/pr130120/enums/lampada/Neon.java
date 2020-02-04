package it.nextre.academy.pr130120.enums.lampada;

public class Neon extends Lampadina {
    public Neon(double volt, double watt, String attacco, String colore) {
        super(volt, watt, attacco, colore);
        super.setLumenWatt(69.57);
    }
}//end class
