package it.nextre.academy.pr130120.pattern.visitor;

public class Libro implements Acquistabile{

    private String titolo;
    private String autore;
    private String isbn;
    private double prezzo;

    public Libro(String titolo, String autore, String isbn, double prezzo) {
        this.titolo = titolo;
        this.autore = autore;
        this.isbn = isbn;
        this.prezzo = prezzo;
    }

    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public String getAutore() {
        return autore;
    }

    public void setAutore(String autore) {
        this.autore = autore;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public double getPrezzo() {
        return prezzo;
    }

    public void setPrezzo(double prezzo) {
        this.prezzo = prezzo;
    }

    @Override
    public String toString() {
        return "Libro{" +
                "titolo='" + titolo + '\'' +
                ", autore='" + autore + '\'' +
                ", isbn='" + isbn + '\'' +
                ", prezzo=" + prezzo +
                '}';
    }

    @Override
    public void accept(ProdottoVisitor prod) {
        prod.visit(this);
    }
}//end class
