package it.nextre.academy.pr130120.targagenerator;

public class Veicolo {

    private String targa;
    private String autista;
    private String patente;

    public Veicolo() {
        this.targa = Aci.getInstance().getNuovaTarga();
    }

    public String getTarga() {
        return targa;
    }

    private void setTarga(String targa) {
        this.targa = targa;
    }

    public String getAutista() {
        return autista;
    }

    public void setAutista(String autista) {
        this.autista = autista;
    }

    public String getPatente() {
        return patente;
    }

    public void setPatente(String patente) {
        this.patente = patente;
    }

    @Override
    public String toString() {
        return "Veicolo{" +
                "targa='" + targa + '\'' +
                ", autista='" + autista + '\'' +
                ", patente='" + patente + '\'' +
                '}';
    }
}//end class
