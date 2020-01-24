package it.nextre.academy.pr130120.pattern.visitor;

public class Romanzo extends Libro{
    public Romanzo(String titolo, String autore, String isbn, double prezzo) {
        super(titolo,autore,isbn,prezzo);
    }

    public String getSinossi(){
        // todo fare metodo
        System.out.println("contatto il server remoto per recuperare le informazioni...");
        // operazioni
        return "bla bla bla....";
    }


}//end class
