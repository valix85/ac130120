package it.nextre.academy.pr130120.pattern.visitor;

public class Gadget implements Acquistabile {
    private String nome;
    private String descrizione;
    private double prezzo;

    public Gadget(String nome, String descrizione, double prezzo) {
        this.nome=nome;
        this.descrizione=descrizione;
        this.prezzo=prezzo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public double getPrezzo() {
        return prezzo;
    }

    public void setPrezzo(double prezzo) {
        this.prezzo = prezzo;
    }

    @Override
    public String toString() {
        return "Gadget{" +
                "nome='" + nome + '\'' +
                ", descrizione='" + descrizione + '\'' +
                ", prezzo=" + prezzo +
                '}';
    }

    @Override
    public void accept(ProdottoVisitor prod) {
        prod.visit(this);
    }
}//end class
