package it.nextre.academy.pr130120.pattern;

import java.util.Arrays;

public class SingletonMain {
    public static void main(String[] args) {
        ListaSingleton lista = ListaSingleton.getInstance();
        ListaSingleton lista2 = ListaSingleton.getInstance();

        System.out.println(lista==lista2);
        System.out.println(lista);
        System.out.println(lista2);

        lista.addNumber(5);
        lista2.addNumber(10);

        System.out.println(Arrays.toString(lista.getValues()));
        System.out.println(Arrays.toString(lista2.getValues()));

    }//end main
}//end class
