package it.nextre.academy.pr130120.enums.tapparella;

public enum Posizione {

    CHIUSO(0), UN_QUARTO(0.25), UN_MEZZO(0.5), TRE_QUARTI(0.75), APERTO(1);

    private double posizione;
    Posizione(double pos){
        this.posizione=pos;
    }
    public double getPosizione(){
        return this.posizione;
    }

}
