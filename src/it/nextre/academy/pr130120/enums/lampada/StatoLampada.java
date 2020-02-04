package it.nextre.academy.pr130120.enums.lampada;

public enum StatoLampada {
    OFF(0),ON(1), MIN(0.7), MEDIUM(0.85), MAX(1);

    private double tensione;
    StatoLampada(double tensione){
        this.tensione=tensione;
    }
    public double getTensione(){
        return this.tensione;
    }
    static public StatoLampada getByOrdinal(int idx){
          return StatoLampada.values()[idx];
    }
}
