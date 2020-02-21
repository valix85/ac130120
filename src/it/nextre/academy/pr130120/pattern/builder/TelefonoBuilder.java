package it.nextre.academy.pr130120.pattern.builder;

public class TelefonoBuilder{


    private String marca;
    private String modello;
    private double memoriaGb;
    private String colore;

    // nuovi parametri da passare poi all'oggetto Telefono
    private String schermo;
    private String tipoSchermo;
    private int mhBatteria;

    public TelefonoBuilder(){
        // setto tutto il necessario per evitare NullPointerException
        this.marca="undefined";
        this.modello="undefined";
        this.memoriaGb=-1;

        this.colore="undefined";
        this.schermo="undefined";
        this.tipoSchermo="undefined";
        this.mhBatteria=0;
    }

    public TelefonoBuilder setMarca(String marca) {
        this.marca = marca;
        return this;
    }

    public TelefonoBuilder setModello(String modello) {
        this.modello = modello;
        return this;
    }

    public TelefonoBuilder setColore(String colore) {
        this.colore = colore;
        return this;
    }

    public TelefonoBuilder setMemoriaGb(double memoriaGb) {
        this.memoriaGb = memoriaGb;
        return this;
    }

    public String getMarca() {
        return marca;
    }

    public String getModello() {
        return modello;
    }

    public double getMemoriaGb() {
        return memoriaGb;
    }

    public String getColore() {
        return colore;
    }

    public String getSchermo() {
        return schermo;
    }

    public TelefonoBuilder setSchermo(String schermo) {
        this.schermo = schermo;
        return this;
    }

    public String getTipoSchermo() {
        return tipoSchermo;
    }

    public TelefonoBuilder setTipoSchermo(String tipoSchermo) {
        this.tipoSchermo = tipoSchermo;
        return this;
    }

    public int getMhBatteria() {
        return mhBatteria;
    }

    public TelefonoBuilder setMhBatteria(int mhBatteria) {
        this.mhBatteria = mhBatteria;
        return this;
    }

    public Telefono getTelefono(){
        // todo logica di controllo per informazioni necessarie
        if (marca==null || marca.equals("undefined") || this.memoriaGb<0)
            throw new RuntimeException("Invalid Telefono Builder data");

        return new Telefono(this);
    }



}//end class
