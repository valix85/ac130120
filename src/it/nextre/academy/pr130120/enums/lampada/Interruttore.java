package it.nextre.academy.pr130120.enums.lampada;

public class Interruttore implements Switchable{

    Lampadina carico;

    public Interruttore(Lampadina acc){
        this.carico = acc;
    }

    @Override
    public void switchState() {
        carico.switchState();
    }
}//end class
