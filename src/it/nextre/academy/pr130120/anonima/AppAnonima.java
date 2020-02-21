package it.nextre.academy.pr130120.anonima;

public class AppAnonima {

    public static void main(String[] args) {

        Libro paperinik = new Libro("Paperinik","Paperino Nik",0,119);

        System.out.println(paperinik.sfoglia());


        Libro imparaAscoltando = new Libro("English for Dummies","IKEA", 0,10){
            @Override
            public int sfoglia() {
                setPagina(getPagina()+1);
                System.out.println("leggo il capitolo" + getPagina());
                leggi();
                return getPagina();
            }

            public void leggi(){
                System.out.println("riproduco audio capitolo");
            }
        };

        imparaAscoltando.sfoglia();

    }//end main


}//end class


class Libro{
    private String titolo;
    private String autore;
    private int pagina = 0;
    private int pagine = 0;

    public Libro(String titolo, String autore, int pagina, int pagine) {
        this.titolo = titolo;
        this.autore = autore;
        this.pagina = pagina;
        this.pagine = pagine;
    }

    public Libro(String titolo, String autore) {
        this.titolo = titolo;
        this.autore = autore;
    }

    public Libro() {
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

    public int getPagina() {
        return pagina;
    }

    public void setPagina(int pagina) {
        this.pagina = pagina;
    }

    public int getPagine() {
        return pagine;
    }

    public void setPagine(int pagine) {
        this.pagine = pagine;
    }

    public int sfoglia(){
        System.out.println("pagina successiva" + ++pagina);
        return pagina;
    }

    @Override
    public String toString() {
        return "Libro{" +
                "titolo='" + titolo + '\'' +
                ", autore='" + autore + '\'' +
                '}';
    }
}