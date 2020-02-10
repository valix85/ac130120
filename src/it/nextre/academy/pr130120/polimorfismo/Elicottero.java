package it.nextre.academy.pr130120.polimorfismo;

public class Elicottero extends Aeromobile implements Volante{

    @Override
    public void decolla(){
        System.out.println("Aumenta la velocità di rotazione delle pale e mi alzo in volo");
    }

    @Override
    public void atterra() {
        System.out.println("Scendo verticalmente senza capirci un'H");
    }
}//end class
