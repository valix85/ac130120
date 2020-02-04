package it.nextre.academy.pr130120.enums.lampada;

public class Led extends LampadinaDimmerabile {
    //private StatoLampada stato;

    public Led(double volt, double watt, String attacco, String colore){
        super(volt,watt,attacco,colore);
        super.setLumenWatt(80);
    }

    public void cambiaColore(String colore){
        super.setColore(colore);
    }

    @Override
    public void setStato(StatoLampada stato) {
        super.setStato(stato);
    }

    @Override
    public StatoLampada getStato() {
        return super.getStato();
    }
}//end class
