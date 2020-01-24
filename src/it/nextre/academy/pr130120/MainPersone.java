package it.nextre.academy.pr130120;

import it.nextre.academy.pr130120.model.Direttore;
import it.nextre.academy.pr130120.model.Persona;

public class MainPersone {

    public static void main(String[] args) {

        Persona p1 = new Persona("Valerio","Radice");

        Direttore d1 = new Direttore("Mirko","Cuneo","God Mode ON");

        d1.setEmail("mirko.cuneo@nextre.it");
        d1.setEta(40);
        System.out.println(d1);
/*
Object
    --Persona           --Number  --String  --System
        --Direttore        --Long
*/

    }//end main

}//end class
