package it.nextre.academy.pr130120.pattern.singleton;


// https://refactoring.guru/design-patterns/singleton


import it.nextre.academy.pr130120.ListaInt;

public class ListaSingleton {

    // costruzione pattern singleton
    private static ListaSingleton instance = null;

    private ListaSingleton(){ }

    public static synchronized ListaSingleton getInstance(){
        if (instance==null){
            instance = new ListaSingleton();
        }
        return instance;
    }

    // metodi specifici dell'oggetto singleton
    private ListaInt elenco = new ListaInt();
    public void addNumber(int number){
        if (!contain(number))
            elenco.add(number);
    }
    public boolean contain(int number){
        for(int val : elenco.getValues()){
            if (val==number) return true;
        }
        return false;
    }
    public int[] getValues(){
        return elenco.getValues();
    }
}//end class



