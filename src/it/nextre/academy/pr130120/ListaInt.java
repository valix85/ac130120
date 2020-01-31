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

    public boolean contains(int num){
        for(int item : mem){
            if (item==num)
                return true;
        }
        return false;
    }

    public boolean isEmpty() {
        return mem.length==0;
    }

    public int getValueByIndex(int position){
        if (position>=0 && position<mem.length){
            return mem[position];
        }
        throw new IndexOutOfBoundsException("Position is too big");
    }

    public int getIndexByValue(int value){
        return indexOf(value);
    }

    public int indexOf(int value) {
        for (int i = 0; i < mem.length; i++) {
            if (mem[i]==value) return i;
        }//end for
        return -1;
    }

    public boolean remove(int value){
        if (contains(value)){
            return removeByIndex(getIndexByValue(value));
        }else{
            return false;
        }
    }

    public boolean removeByIndex(int position){
        if (position>=0 && position<mem.length){
            int[] arr = new int[mem.length-1];
            for (int i = 0; i < mem.length; i++) {
                if (i<position){
                    arr[i]=mem[i];
                }
                if (i==position){
                    continue;
                }
                if (i>position){
                    arr[i-1]=mem[i];
                }
            }//end for
            mem=arr;
            return true;
        }else{
            //System.out.println("position is too big");
        }
        return false;
    }

    public void clear(){
        mem = new int[0];
    }

    public int size() {
        return mem.length;
    }
}//end class
