package it.nextre.academy.pr130120.generici;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Urna<T> {
    private List<T> mem;
    private Random r;

    public Urna () {
        mem = new ArrayList<>();
        r = new Random();
    }

    public void add(T item){
        mem.add(item);
    }

    public T extract () {
        int pos = r.nextInt(mem.size());
        return mem.remove(pos);
    }

    public boolean isEmpty(){
        return mem.isEmpty();
    }
}//end class
