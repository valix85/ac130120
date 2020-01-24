package it.nextre.academy.pr130120.model;

public class Direttore extends Persona {

    private String benefits;

    public Direttore(String nome, String cognome, String benefits){
        super(nome, cognome);
        this.benefits=benefits;
    }

    public String getBenefits() {
        return benefits;
    }

    public void setBenefits(String benefits) {
        this.benefits = benefits;
    }

    @Override
    public String toString() {
        return "Direttore{" +
                "nome='" + super.getNome() + '\'' +
                ", cognome='" + super.getCognome() + '\'' +
                ", eta=" + super.getEta() +
                ", email='" + super.getEmail() + '\'' +
                ", cf='" + super.getCf() + '\'' +
                ", salario=" + super.getSalario() +
                ", benefits='" + benefits + '\'' +
                '}';
    }
}//end class
