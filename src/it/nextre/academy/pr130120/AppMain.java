package it.nextre.academy.pr130120;

import it.nextre.academy.pr130120.model.Persona;
import it.nextre.academy.pr130120.myutils.Operations;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.OptionalInt;
import java.util.stream.IntStream;

public class AppMain {

    static double d1;
    static float f1;

    public static void main(String[] args) {
        //System.out.println(d1); // 0.0
        //System.out.println(f1); // 0.0
        //strutture1();
        //array();
        //matrici();


        //System.out.println("Arguments: "+args.length);
        //for (String tmp : args){
        //    System.out.println(tmp);
        //}

        //System.out.print("inserisci il tuo nome: ");
        //System.out.println(Operations.readRow());


        testaListaInt();

    }//end main

    private static void testaListaInt() {
        ListaInt lista = new ListaInt();
        lista.add(3);
        assert lista.size()==1 : "Errore add";
        assert lista.contains(3) : "Errore add";

        lista.add(6);
        lista.add(9);
        lista.add(12);
        lista.add(8);

        assert lista.size()==5 : "Errore size";
        assert lista.contains(6)==true : "Errore contains";
        assert lista.contains(7)==false : "Errore contains";
        assert lista.getIndexByValue(6)==1 : "Errore getIndexByValue";
        assert lista.getValueByIndex(1)==6 : "Errore getValueByIndex";

        assert lista.indexOf(150)==-1 : "Errore indexOf";
        assert lista.indexOf(6)==1 : "Errore indexOf";
        assert lista.indexOf(6)>=0 : "Errore indexOf";


        assert lista.remove(0)==false : "Errore remove";
        assert lista.remove(8)==true : "Errore remove";
        assert lista.size()==4 : "Errore remove";



        assert lista.removeByIndex(10)==false : "Errore removeByIndex";



        assert lista.removeByIndex(1)==true : "Errore removeByIndex";
        assert lista.size()==3 : "Errore removeByIndex";


        lista.clear();
        assert lista.size()==0 : "Errore clear";


        Persona[] ps = new Persona[3];
        ps[0]=new Persona("valerio","radice");
        ps[1]=new Persona("giacomo","tondina");
        ps[2]=new Persona("paolo","ass");

        List<Persona> users = Arrays.asList(ps);

        OptionalInt indexOpt = IntStream.range(0, users.size())
                .filter(idx -> (users.get(idx).getNome().equals("giacomo")))
                .findFirst();


    }

    private static void matrici() {
        // [][][][][]

        //   0 1 2 3 4 5 6
        // 0 [][][][][]
        // 1 [][][][][][][]
        // 2 [][][][]

        int[][] mat = new int[5][0];

        mat[0] = new int[15];
        mat[1] = new int[0];
        mat[2] = new int[23];
        // System.out.println(mat.length);

        // printMatrixInt(mat);



        /*
        for (int i = 0; i < 10000; i++) {
            int tmp = Operations.getRandomInt(17,23);
            System.out.println(tmp);
            if (tmp<17.0 || tmp>23.0){
                System.out.println("ERRORE");
                break;
            }
        }//end for
        */





        // controllo uguaglianza array
        int[] arr1 = new int[3];
        int[] arr2 = new int[3];

        // if (arr1==arr2){ // sono diversi
        // if (arr1.equals(arr2)) { // sono diversi
        if (Arrays.equals(arr1,arr2)) {
            System.out.println("gli array sono uguali");
        } else {
            System.out.println("gli array sono diversi");
        }





    }



    private static void array() {
        double[] temps = new double[2];
        temps[0] = 8.5;  // Lunedì mattina ore 9:00
        temps[1] = 7.3;  // Martedì mattina ore 9:00
        System.out.println(temps);  // [D@....

        Object[] objs = new Object[3];
        System.out.println(objs);   // [Ljava.lang.Object;@...

        Double[] weights = {78.5, 60.0, 74.0, 75.0};
        System.out.println(weights); // [Ljava.lang.Double;@...
        System.out.println("Weights: " + weights.length);
        System.out.println(weights[0]);
        System.out.println(weights[1]);
        System.out.println(weights[2]);
        System.out.println(weights[3]);
        // System.out.println(weights[4]); // ArrayIndexOutOfBoundsException

        // calcolo la media dei pesi, il massimo e il minimo, e dire in che posizione si trovano.

        System.out.println("Average: " + Operations.getAverage(weights));
        System.out.println("Average: " + Operations.getAverage(new Double[]{}));  // NaN
        System.out.println("Average: " + Operations.getAverage(null));  //


        double[] min = Operations.getMin(weights);
        System.out.println("Il valore minimo è: " + min[0] + " alla posizione " + min[1]);

        double[] max = Operations.getMax(weights);
        System.out.println("Il valore massimo è: " + max[0] + " alla posizione " + max[1]);


        // functional programming for average
        Arrays.stream(weights)
                .mapToDouble(v -> v)
                .average()
                .ifPresent(System.out::println)
        ;

    }


    private static void strutture1() {

        //coversioni
        //25      //10^1*2 + 10^0 * 5
        //025     //8^1*2  +  8^0 * 5;
        //0xB25    //16^2*11 + 16^1*2 +  16^0 * 5;


        int val = 20;
        switch (val) {
            default:
                System.out.println("default");
                break; //Obbligatorio se default non è ultimo
            case 1:
                System.out.println("caso 1");
                break;
            case 2:
                System.out.println("caso 2");
                break;
            case 3:
                System.out.println("caso 3");
                break;
        }


        byte i = 0;
        for (int stop = 0, start = 1; stop != 1; start++) {
            if (i % 2 == 0) {
                i++;
                continue;
            }
            System.out.println(i + ")\tGiocatore: ...");
            if (i == 3)
                stop = 1;
            if (i == 2)  // messo qua non lo farà mai
                break;   // messo qua non lo farà mai
            i++;
            if (i == 2)  // per questo esempio o qui o all' inizio
                break;
        }//end for
        if (i == 3)  //verificare la corretta uscita dal ciclo
            System.out.println("fine ciclo for OK");
        else
            System.out.println("fine ciclo for KO");


        System.out.println("######################");
        System.out.println("ciclo while");
        System.out.println("######################");


        int giro = 0;
        while (giro < 3) {
            System.out.println("Giro numero: " + giro);
            giro++;
        }
        System.out.println("fine ciclo while");


        System.out.println("######################");
        System.out.println("ciclo do-while");
        System.out.println("######################");

        int salto = 0;
        do {
            System.out.println("Salto numero: " + salto);
            salto++;
        } while (salto < 3);
        System.out.println("fine ciclo do-while");
    }
}//end class
