package it.nextre.academy.pr130120.enums.lampada;

public abstract class LampadinaDimmerabile extends Lampadina implements Dimmerabile {
    public LampadinaDimmerabile(double volt, double watt, String attacco, String colore) {
        super(volt, watt, attacco, colore);
    }
    public void setStato(StatoLampada stato){
        super.setStato(stato);
    };
}//end class
