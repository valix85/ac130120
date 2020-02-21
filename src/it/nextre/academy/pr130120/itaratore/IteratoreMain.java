package it.nextre.academy.pr130120.itaratore;

import it.nextre.academy.pr130120.myutils.Generator;
import it.nextre.academy.pr130120.myutils.Operations;

import java.util.*;

public class IteratoreMain {

    public static void main(String[] args) {

        Set<String> nomi = new HashSet<>();
        nomi.add(Generator.generaNome());
        nomi.add(Generator.generaNome());
        nomi.add(Generator.generaNome());
        nomi.add(Generator.generaNome());
        nomi.add(Generator.generaNome());

        /*
        for(String nome : nomi){
            System.out.println(nome);
        }
        */
        // senza forEach devo usare un iteratore
        Iterator<String> it = nomi.iterator();
        while(it.hasNext()){
            System.out.println(it.next());
        }


    }//end main

}//end class
