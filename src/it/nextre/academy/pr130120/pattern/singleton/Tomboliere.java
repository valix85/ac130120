package it.nextre.academy.pr130120.pattern.singleton;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Tomboliere {

    private static Tomboliere instance;

    private List<Integer> numeri = new ArrayList<>();
    private static Random r = new Random();

    private Tomboliere(){
        resetta();
    }

    public void resetta() {
        numeri.clear();
        for (int i = 1; i <=90 ; i++) {
            numeri.add(i);
        }//end for
    }

    public static Tomboliere getInstance(){
        if (instance==null)
            instance = new Tomboliere();
        return instance;
    }

    public int estrai(){
        if (numeri.size()>0)
            return numeri.remove(r.nextInt(numeri.size()));
        throw new RuntimeException("Tomboliere vuoto");
    }

    public boolean isEmpty() {
        return numeri.isEmpty();
    }
}//end class
