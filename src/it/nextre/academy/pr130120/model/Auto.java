package it.nextre.academy.pr130120.model;

public class Auto extends Veicolo{
    String marca;
    String modello;
    String alimentazione;

    public Auto(){
        this("undefined","undefined");
    }
    public Auto(String marca, String modello){
        this(marca,modello,"undefined");
    }
    public Auto(String marca, String modello, String alimentazione){
      this(marca,modello,alimentazione,0);
    }
    public Auto(String marca, String modello, String alimentazione, int posti){
        super(posti);
        this.marca=marca;
        this.modello=modello;
        this.alimentazione=alimentazione;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModello() {
        return modello;
    }

    public void setModello(String modello) {
        this.modello = modello;
    }

    public String getAlimentazione() {
        return alimentazione;
    }

    public void setAlimentazione(String alimentazione) {
        this.alimentazione = alimentazione;
    }

    @Override
    public void setNumero_posti(int posti){
        System.out.println("Setter di Auto");
        if (posti<9) {
            super.setNumero_posti(posti);
        }
    }

    @Override
    public String toString() {
        return "Auto{" +
                "marca='" + marca + '\'' +
                ", modello='" + modello + '\'' +
                ", alimentazione='" + alimentazione + '\'' +
                ", posti=" + super.getNumero_posti() +
                '}';
    }


    @Override
    public void faiRifornimento() {
        System.out.println("faccio "+this.alimentazione);
    }

    public static void main(String[] args) {

        Auto a1 = new Auto();
        System.out.println(a1);
        a1.setNumero_posti(7);
        System.out.println(a1);

    }//end main

}//end class






