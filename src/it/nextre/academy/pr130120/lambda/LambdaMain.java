package it.nextre.academy.pr130120.lambda;

import it.nextre.academy.pr130120.myutils.Operations;

import java.util.*;
import java.util.function.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class LambdaMain {

    public static void main(String[] args) {
        List<Integer> step = new ArrayList<>();
        step.addAll(Arrays.asList(3,2,6,5,2,7,3,5,8,3,2,7));

        Supplier<Integer> genInteger = () -> Operations.getRandomInt(1,101);
        IntSupplier getInt = () -> Operations.getRandomInt(1,101);

        Predicate<Integer> isEven = x -> x%2==0;
        Predicate<Integer> isOdd = x -> x%2!=0;

        //Consumer<Integer> print = item -> System.out.println(item);
        Consumer<Integer> print = System.out::println;
        Consumer<Integer> printDebug = item -> System.out.println("DEBUG: "+item);

        Function<Integer, Integer> raddoppia = n->n*2;
        Function<Integer, Integer> quadrato = n->n*n;

        UnaryOperator<Integer> triplica = x->x*3;



        System.out.println(
                step.stream()
                    .filter(isEven)
                    .peek(item -> System.out.println("DEBUG: "+item))
                    .map(n->n*2)
                    .map(triplica)
                    .peek(item -> System.out.println("DEBUG: "+item))
                    //.filter(x->x%2!=0)
                    //.peek(x->System.out.println("-----------"))
                    .filter(n->n>=25)
                    .count()
        );
                //.forEach(System.out::println);


        System.out.println("\n".repeat(10));


        Map<Integer, Cantante> classifica = new HashMap<>();
        classifica.put(1, new Cantante("Diodato","Fai rumore",39.26));
        classifica.put(2, new Cantante("Francesco Gabbani","Viceversa",33.94));
        classifica.put(3, new Cantante("Pinguini Tattici Nucleari","Ringo Stars",26.80));
        classifica.put(4, new Cantante("Le Vibrazioni","Dov'è",25.50));
        classifica.put(5, new Cantante("Piero Pelù","Gigante",24.82));

        //BiConsumer
        //classifica.forEach( (k , v) -> System.out.println(""+k+" "+v));

        // titoli più lunghi di 6 caratteri
        List<String> titoliOK =
                classifica.values().stream()
                        .map(c->c.getTitolo())
                        .filter(x->x.length()>6)
                        //.peek(System.out::println)
                .collect(Collectors.toList());

        titoliOK.forEach(System.out::println);

        //trovare l'elenco dei cantanti dalla classifica
        List<String> cantanti = classifica.values()
                .stream()
                .map(x->x.getArtista())
                //.map(Cantante::getArtista)
                .collect(Collectors.toList());

        cantanti.forEach(System.out::println);




    }//end main

}//end class

class Cantante{
    private String artista;
    private String titolo;
    private Double punteggio;

    public Cantante(String artista, String titolo, Double punteggio) {
        this.artista = artista;
        this.titolo = titolo;
        this.punteggio = punteggio;
    }

    public String getArtista() {
        return artista;
    }

    public void setArtista(String artista) {
        this.artista = artista;
    }

    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public Double getPunteggio() {
        return punteggio;
    }

    public void setPunteggio(Double punteggio) {
        this.punteggio = punteggio;
    }

    @Override
    public String toString() {
        return "Cantante{" +
                "artista='" + artista + '\'' +
                ", titolo='" + titolo + '\'' +
                ", punteggio=" + punteggio +
                '}';
    }
}
