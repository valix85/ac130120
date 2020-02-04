package it.nextre.academy.pr130120.enums.lampada;

public abstract class Lampadina implements Accendibile, Switchable{

    private StatoLampada stato;
    private String colore;
    private double volt;
    private double ampere;
    private double lumenWatt;
    private String attacco;

    public Lampadina(double volt, double watt, String attacco, String colore){
        this.colore=colore;
        this.attacco=attacco;
        this.volt=volt;
        this.ampere=watt/volt;
        this.stato=StatoLampada.OFF;
    }

    public StatoLampada getStato() {
        return stato;
    }

    public String getColore() {
        return colore;
    }

    public double getVolt() {
        return volt;
    }

    public double getAmpere() {
        return ampere;
    }

    public double getLumenWatt() {
        return lumenWatt;
    }

    public String getAttacco() {
        return attacco;
    }


    // Solo le Dimmerabili lo avranno
    void setStato(StatoLampada stato) {
        this.stato = stato;
    }


    void setColore(String colore) {
        this.colore = colore;
    }

    public void setVolt(double volt) {
        this.volt = volt;
    }

    void setLumenWatt(double lumenWatt) {
        this.lumenWatt = lumenWatt;
    }

    @Override
    public void accendi() {
        this.stato=StatoLampada.ON;
        System.out.println("Lampadina acccesa");
    }

    @Override
    public void spegni() {
        this.stato=StatoLampada.OFF;
        System.out.println("Lampadina spenta");
    }

    @Override
    public void switchState() {
        if (stato.equals(StatoLampada.OFF)){
            accendi();
        }else{
            spegni();
        }
    }

    public double getLumen(){
        return (stato.getTensione()*this.volt)*this.ampere*this.lumenWatt;
    }
}//end class
