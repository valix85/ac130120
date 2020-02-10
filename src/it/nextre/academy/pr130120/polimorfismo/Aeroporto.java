package it.nextre.academy.pr130120.polimorfismo;

public class Aeroporto   {

    public static void main(String[] args) {


        Aeromobile velivolo1 = new Aeromobile();
        Aeromobile velivolo2 = new Elicottero();
        //Volante ufo = velivolo2; // Aeromobile NON implementa volante
        Volante ufo2 = new Elicottero(); // Elicottero implementa volante

       //velivolo1.decolla();
        velivolo2.decolla();
        ufo2.decolla();


    }//end main

}//end class
