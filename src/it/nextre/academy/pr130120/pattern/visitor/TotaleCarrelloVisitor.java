package it.nextre.academy.pr130120.pattern.visitor;

public class TotaleCarrelloVisitor implements ProdottoVisitor {

    private double totale;
    private Carrello cart;

    public TotaleCarrelloVisitor(Carrello cart){
        totale=0;
        this.cart=cart;
    }

    @Override
    public void visit(Gadget prodotto) {
        totale+=prodotto.getPrezzo();
    }

    @Override
    public void visit(Libro prodotto) {
        totale+=prodotto.getPrezzo();
    }

    public double getTotale() {
        for(Acquistabile prodotto : cart.getItems()){
            prodotto.accept(this);
        }
        return totale;
    }
}//end class
