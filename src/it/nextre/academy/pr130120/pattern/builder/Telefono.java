package it.nextre.academy.pr130120.pattern.builder;

public class Telefono {

    private String marca;       // da builder
    private String modello;     // da builder
    private String colore;
    private String schermo;
    private String tipoSchermo;
    private int mhBatteria;

    private double memoriaGb;   // da builder


    private Telefono(){};
    Telefono(TelefonoBuilder builder){
        this.marca=builder.getMarca();
        this.modello=builder.getModello();
        this.colore=builder.getColore();
        this.memoriaGb=builder.getMemoriaGb();

        this.tipoSchermo=builder.getTipoSchermo();
        this.schermo=builder.getSchermo();
        this.mhBatteria=builder.getMhBatteria();
    };
    // MAI COSTRUTTORI PUBBLICI !!! MAI !
    // portano a incosistenza
    /*
    public Telefono(TelefonoBuilder builder, String tipoSchermo){
        this(builder);
        this.tipoSchermo=schermo;
    }
    */


    public String getMarca() {
        return marca;
    }

    public String getModello() {
        return modello;
    }

    public String getColore() {
        return colore;
    }

    public String getSchermo() {
        return schermo;
    }

    public String getTipoSchermo() {
        return tipoSchermo;
    }

    public int getMhBatteria() {
        return mhBatteria;
    }

    public double getMemoriaGb() {
        return memoriaGb;
    }

    @Override
    public String toString() {
        return "Telefono{" +
                "marca='" + marca + '\'' +
                ", modello='" + modello + '\'' +
                ", colore='" + colore + '\'' +
                ", schermo='" + schermo + '\'' +
                ", tipoSchermo='" + tipoSchermo + '\'' +
                ", mhBatteria=" + mhBatteria +
                ", memoriaGb=" + memoriaGb +
                '}';
    }
}//end class


