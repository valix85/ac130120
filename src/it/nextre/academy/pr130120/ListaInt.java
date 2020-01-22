package it.nextre.academy.pr130120;

import it.nextre.academy.pr130120.myutils.Operations;

public class ListaInt {

    private int[] mem = new int[0];

    public void add(int num) {
        int[] tmp = new int[mem.length + 1];
        for (int i = 0; i < mem.length; i++) {
            tmp[i] = mem[i];
        }//end for
        tmp[mem.length] = num;
        mem = tmp;
    }

    public int[] getValues(){
        return mem.clone();
    }

    public void print() {
        Operations.printArray(mem);
    }

}//end class
