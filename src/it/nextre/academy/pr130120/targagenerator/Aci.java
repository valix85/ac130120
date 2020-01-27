package it.nextre.academy.pr130120.targagenerator;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Aci {

    private static Aci instance;
    private List<String> targhe;


    private Aci() {
        targhe = new ArrayList<>();
    }

    public static synchronized Aci getInstance() {
        if (instance == null)
            instance = new Aci();
        return instance;
    }


    private char l1 = 'A';
    private char l2 = 'A';
    private int num = 300;
    private static final int incremento = 50;

    // genera la prossima targa
    private String next() {
        String tmp = "invalid targa";
        if (l1 <= 'Z' && l2 <= 'Z' && num < 1000) {
            tmp=""+l1+formattaNumero(num)+l2;
            num+=incremento;
            if (num>999){
                l2+=1;
                num=0;
                if (l2>'Z'){
                    l1+=1;
                    l2='A';
                }
            }
        }
        return tmp;
    }

    private String formattaNumero(int num) {
        //String out = "";
        //if (num<10) return "00"+num;  //8   --> 008
        //if (num<100) return "0"+num;  //10  --> 010
        //return ""+num;                //100 --> 100

        return String.format("%03d",num);
    }

    public String getNuovaTarga() {
        String targa = next();
        //String targa = nextRandom();
        // tengo traccia di quello che ho generato in passato
        /*
        if (targhe.contains(targa))
            return getNuovaTarga();
        else
            targhe.add(targa);

         */
        // fintantoché la targa esiste ne genero una nuova
        while(targhe.contains(targa)){
            System.out.println("targa esistente: "+ targa);
            targa = next();
            //targa = nextRandom();
        }
        targhe.add(targa);

        return targa;
    }

    private String nextRandom() {
        Random r = new Random();
        return ""+l1+l2+formattaNumero(r.nextInt(10));
    }
}//end class
