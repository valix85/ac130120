package it.nextre.academy.pr130120.pattern.visitor;

public class TotaleCarrelloPromoRomanzi30 implements ProdottoVisitor{

    private double totale;
    private Carrello cart;

    public TotaleCarrelloPromoRomanzi30(Carrello cart) {
        this.cart=cart;
    }

    @Override
    public void visit(Gadget prodotto) {
        totale+=prodotto.getPrezzo();
    }

    @Override
    public void visit(Libro prodotto) {
        System.out.println("prezzo libro: "+prodotto.getTitolo()+" "+prodotto.getPrezzo());
        if (prodotto instanceof Romanzo){
            visit((Romanzo)prodotto);
        }else {
            totale += prodotto.getPrezzo();
        }
    }

    public void visit(Romanzo prodotto) {
        System.out.println("Sconto promo romanzo 30%");
        totale+=(prodotto.getPrezzo()-(prodotto.getPrezzo()*0.3));
    }

    public double getTotale(){
        for(Acquistabile item : cart.getItems()){
            item.accept(this);
        }
        return totale;
    }
}//end class
