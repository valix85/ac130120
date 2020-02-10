package it.nextre.academy.pr130120.polimorfismo;

public interface Volante {

    default void decolla(){
        System.out.println("decolla da interfaccia");
    };
    void atterra();

}
