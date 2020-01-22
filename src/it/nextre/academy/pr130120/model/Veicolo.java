package it.nextre.academy.pr130120.model;

public abstract class Veicolo {
    private int numero_posti;

    public Veicolo(int numero_posti){
        this.numero_posti=numero_posti;
    }


    public int getNumero_posti() {
        return numero_posti;
    }

    public void setNumero_posti(int numero_posti) {
        System.out.println("Setter di Veicolo");
        if (numero_posti>=0)
            this.numero_posti = numero_posti;

    }


    public abstract void faiRifornimento();
}//end class
