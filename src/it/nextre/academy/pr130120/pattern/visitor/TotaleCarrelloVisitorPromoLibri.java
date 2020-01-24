package it.nextre.academy.pr130120.pattern.visitor;

public class TotaleCarrelloVisitorPromoLibri implements ProdottoVisitor{

    private double totale;
    private Carrello cart;

    public TotaleCarrelloVisitorPromoLibri(Carrello cart) {
        this.cart=cart;
    }

    @Override
    public void visit(Gadget prodotto) {
        totale+=prodotto.getPrezzo();
    }

    @Override
    public void visit(Libro prodotto) {
        // PROMO SCONTO 50%
        totale+=(prodotto.getPrezzo()/2.0);
    }

    public double getTotale(){
        for(Acquistabile item : cart.getItems()){
            item.accept(this);
        }
        return totale;
    }
}//end class
