package it.nextre.academy.pr130120.pattern;

import it.nextre.academy.pr130120.pattern.singleton.Tomboliere;

public class TombolaMain {
    public static void main(String[] args) {

        Tomboliere urna = Tomboliere.getInstance();

        while (!urna.isEmpty()) {
            System.out.println(urna.estrai());
        }//end for



    }//end main
}//end class
