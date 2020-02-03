package it.nextre.academy.pr130120.generici;

import java.lang.reflect.Array;
import java.util.Random;

public class UrnaArray<T> {

    private T[] mem;
    private Random r;


    public UrnaArray(){
        mem = (T[])Array.newInstance(Object.class, 0);
        r=new Random();
        System.out.println(mem.getClass());
    }



    public void add(T item){
        T[] tmps = (T[])Array.newInstance(Object.class, mem.length+1);
        for (int i = 0; i < mem.length; i++) {
            tmps[i]=mem[i];
        }// end for
        tmps[mem.length]=item;
        mem=tmps;
    }

    public T extract(){
        int pos = r.nextInt(this.mem.length);
        T item = this.mem[pos];
        T[] tmps = (T[])Array.newInstance(Object.class, this.mem.length-1);
        for (int i = 0; i < this.mem.length; i++) {
            if(i<pos){
                tmps[i]=this.mem[i];
            }
            if(i==pos){
                continue;
            }
            if(i>pos){
                tmps[i-1]=this.mem[i];
            }
        }// end for
        this.mem=tmps;
        return item;
    }


    public boolean isEmpty(){
        return mem.length==0;
    }

}//end class
