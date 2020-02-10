package it.nextre.academy.pr130120.comparatore;

import it.nextre.academy.pr130120.myutils.Generator;
import it.nextre.academy.pr130120.myutils.Operations;
import jdk.jfr.DataAmount;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

public class Comp1 {

    String parola = "main";

    public static void main(String[] args) {

        Comp1 main = new Comp1();
        main.avvia();
    }

    public void avvia(){
        System.out.println("");
        Persona p1 = Persona.getOne();
        Persona p2 = Persona.getOne();
        Persona p3 = Persona.getOne();

        p1.setCognome("barni"); // B=66
        p2.setCognome("Dinelli"); // D=68

        p1.setNome("Mario");
        p2.setNome("Chiara");

        p1.setEta(50);
        p2.setEta(20);

        p1.setSalario(32000.0);
        p2.setSalario(32000.0);

        p1.setPeso(84.7);
        p2.setPeso(62.2);

        System.out.println(p1);
        System.out.println(p2);
        System.out.println(p3);
        System.out.println("-".repeat(30));
        System.out.println("");

        List<Persona> iscritti = new ArrayList<>();
        iscritti.add(p1);
        iscritti.add(p2);
        iscritti.add(p3);


        System.out.println(p1.compareTo(p2)); // se negativo l'istanza che sto controllando è più piccola di quella del confornto
        System.out.println(p2.compareTo(p2)); // se è 0 sono uguali
        System.out.println(p2.compareTo(p1)); // se positivo l'istanza che sto controllando è più grande di quella del confornto


        iscritti.sort(new PersonaEtaComparator());
        for(Persona tmp : iscritti)
            System.out.println(tmp);
        System.out.println("-".repeat(30));

        iscritti.sort(new PersonaSalarioNomeComparator().reversed());
        for(Persona tmp : iscritti)
            System.out.println(tmp);
        System.out.println("-".repeat(30));



        // proviamo a comparare al volo sull'altezza con lo stile pre java8
        System.out.println("pre java8 per altezza");
        iscritti.sort(new Comparator<Persona>() {
            String parola = "anonima";
            @Override
            public int compare(Persona o1, Persona o2) {
                System.out.println(this.parola);
                return Double.compare(o1.getAltezza(),o2.getAltezza());
            }
        });
        for(Persona tmp : iscritti)
            System.out.println(tmp);
        System.out.println("-".repeat(30));



        // proviamo a comparare al volo sull'altezza con lo stile post java8
        System.out.println("post java8 per altezza");
        iscritti.sort(
                //(o1, o2) -> Double.compare(o1.getAltezza(),o2.getAltezza())
                (o1, o2) -> {
                    System.out.println(this.parola);
                    return Double.compare(o1.getAltezza(),o2.getAltezza());
                }
        );
        //sorgente
        long n = iscritti.stream()
        //0+ operazioni intermedie
                .mapToDouble(item->item.getAltezza())
                .filter(val-> val>2)
                .peek(item -> System.out.println(item))
                .map(val -> val*2)
        //1 terminatore di flusso che lo attiva
                //.forEach(item -> System.out.println(item));
                //con :: il valore in ingresso è anche il valore passato al metodo
                //.forEach(System.out::println)
                .count()

        ;
        System.out.println(n); // necessario per attivare lo stream precedente

        // stream + lambda con referenza a metodo statico
        iscritti.stream()
                // Impure Functional Programming in Java, porta side effects
                // .peek(el->el.setAltezza(0))
                .forEach(System.out::println);
        System.out.println("-".repeat(30));

    }//end main

}//end class


class Persona implements Comparable<Persona>, Comparator<Persona> {
    private String nome;
    private String cognome;
    private int eta;
    private double peso;
    private double salario;
    private double altezza;

    public Persona(){}

    public Persona(String nome, String cognome, int eta, double peso, double salario, double altezza) {
        this.nome = nome;
        this.cognome = cognome;
        this.eta = eta;
        this.peso = peso;
        this.salario = salario;
        this.altezza = altezza;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getEta() {
        return eta;
    }

    public void setEta(int eta) {
        this.eta = eta;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public double getAltezza() {
        return altezza;
    }

    public void setAltezza(double altezza) {
        this.altezza = altezza;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    @Override
    public String toString() {
        return "Persona{" +
                "nome='" + nome + '\'' +
                ", cognome='" + cognome + '\'' +
                ", eta=" + eta +
                ", peso=" + Operations.formattaDouble(peso) + " Kg" +
                ", salario=" + Operations.formattaDouble(salario,0) + " €" +
                ", altezza=" + Operations.formattaDouble(altezza,1) + " cm" +
                '}';
    }

    public static Persona getOne(){
        return new Persona(
                Generator.generaNome(),
                Generator.generaCognome(),
                Operations.getRandomInt(18,60),
                Operations.getRandomDouble(48,108),
                Operations.getRandomDouble(22000,56800),
                Operations.getRandomDouble(160,210)
                );
    }


    // modo predefinito di comparare due persone è per cognome nome, in particolare un'istanza A con un'istanza B di questa classe
    @Override
    public int compareTo(Persona o) {
        return (this.cognome+" "+this.nome).compareToIgnoreCase(o.getCognome()+" "+o.getNome());
    }

    // spostare ogni comparatore di tipo su una classe ad hoc.
    // la classe persona non dovrebbe, salvo casi pigri, implementare un Comparator!
    @Override
    public int compare(Persona o1, Persona o2) {
        throw new RuntimeException("Stai usando il compare sbagliato");
    }
}


class PersonaEtaComparator implements Comparator<Persona> {
    @Override
    public int compare(Persona o1, Persona o2) {
        // Returns a negative integer, zero, or a positive integer as the first argument is less than, equal to, or greater than the second.

        return o1.getEta()-o2.getEta(); //se è positivo è più grande o1, se negativo è più grande 02 altrimenti se 0 sono uguali
    }
}


class PersonaSalarioComparator implements Comparator<Persona> {
    @Override
    public int compare(Persona o1, Persona o2) {
        // Returns a negative integer, zero, or a positive integer as the first argument is less than, equal to, or greater than the second.

        //se è positivo è più grande o1, se negativo è più grande 02 altrimenti se 0 sono uguali
        /*
        double diff = o1.getSalario()-o2.getSalario();
        if (diff < 0){
            return -1;
        } else if (diff > 0 ){
            return 1;
        }else {
            return 0;
        }
        */
        // via breve sfruttando comparator sui wrapper
        return Double.compare(o1.getSalario(),o2.getSalario());
    }
}

class PersonaSalarioNomeComparator implements Comparator<Persona> {
    @Override
    public int compare(Persona o1, Persona o2) {
        int diff = Double.compare(o1.getSalario(),o2.getSalario());
        // se hanno lo stesso salario, ordino per nome
        if (diff==0){
            return o1.getNome().compareToIgnoreCase(o2.getNome());
        }
        return diff;
    }
}