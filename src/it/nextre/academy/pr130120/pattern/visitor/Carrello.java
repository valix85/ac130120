package it.nextre.academy.pr130120.pattern.visitor;

import java.util.ArrayList;
import java.util.List;

public class Carrello {

    private List<Acquistabile> prodotti;

    public Carrello(){
        prodotti = new ArrayList<>();
    }

    public List<Acquistabile> getItems() {
        return prodotti;
    }

    public int getQta(){
        return prodotti.size();
    }

    public void add(Acquistabile prodotto){
        prodotti.add(prodotto);
    }



}//end class
