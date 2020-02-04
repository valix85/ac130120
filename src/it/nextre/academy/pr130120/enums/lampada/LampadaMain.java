package it.nextre.academy.pr130120.enums.lampada;

public class LampadaMain {

    public static void main(String[] args) {

        LampadinaDimmerabile led1 = new Led(220,20,"E27","Naturale");
        Lampadina neon1 = new Neon(220,23,"T8","Bianco freddo");



        InterruttoreDimmerabile int1 = new InterruttoreDimmerabile(led1);
        System.out.println("spenta: "+led1.getLumen());
        led1.accendi();
        System.out.println("accesa al max: "+led1.getLumen());
        int1.alzaLivello();
        System.out.println("Alza livello: "+led1.getLumen());
        int1.abbassaLivello();
        System.out.println("Abbasso il livello 1 "+led1.getLumen());
        int1.abbassaLivello();
        System.out.println("Abbasso il livello 2 "+led1.getLumen());
        int1.abbassaLivello();
        System.out.println("Abbasso il livello 3 "+led1.getLumen());
        int1.abbassaLivello();
        System.out.println("Abbasso il livello 4 "+led1.getLumen());
        int1.alzaLivello();
        System.out.println("Alza livello 1: "+led1.getLumen());
        int1.alzaLivello();
        System.out.println("Alza livello 2: "+led1.getLumen());
        int1.alzaLivello();
        System.out.println("Alza livello 3: "+led1.getLumen());

        System.out.println("---- NEON");
        Interruttore int2 = new Interruttore(neon1);
        System.out.println(neon1.getStato());
        int2.switchState();
        System.out.println(neon1.getStato());
        System.out.println(neon1.getLumen());


    }//end main

}//end class
