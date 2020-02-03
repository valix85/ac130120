package it.nextre.academy.pr130120;


import it.nextre.academy.pr130120.model.Auto;

import java.util.ArrayList;
import java.util.List;

public class interne {

    public static void main(String[] args) {

        A1 statale = new A1();
        A1.A2 area_di_sosta = statale.new A2();


        Autostrada a4 = new Autostrada();
        //System.out.println(a4.getLimite());
        // poi = point of interest
        List<Autostrada.Ristoro> poi = new ArrayList<>();
        poi.add(a4.new Ristoro());
        poi.add(a4.new Ristoro());
        poi.add(a4.new Ristoro());
        for(Autostrada.Ristoro tmp : poi){
            System.out.println(tmp.getLimite());
        }

        Autostrada.Autovelox tutor1 = new Autostrada.Autovelox();
        tutor1.registra();

        Eseguibile scansioneRadar = new Eseguibile() {
            @Override
            public void fai() {
                System.out.println("Radar rileva velocità attivato...");
            }
        };



        Bottone stampa = new Bottone() {
            @Override
            public void click() {
                System.out.println("... stampa in corso");
            }
        };

        Cliccabile menu = new Cliccabile() {
            @Override
            public void click() {
                System.out.println("toggle menu");
            }
        };

        Cliccabile apri = () -> System.out.println("apro il menu di navigazione del filesystem");







    }//end main

}//end class


class A1 {
    class A2{} // è una classe innestata

}
class B1 extends A1{}


class Autostrada {

    private int limite = 130;
    // Autostrada instance = this; // non serve questo accrocchio *1

    class Ristoro {
        int limite = 30;
        public String getLimite(){
            //return limite; // variabile locale di Ristoro
            return ""+Autostrada.this.limite; // *1 modo corretto
            //return instance.limite+" "+limite; // accrocchio errato
        }
    }

    public int getLimite(){
        return limite;
    }

    static class Autovelox {
        int limite= 138;

        Eseguibile faiFoto = new Eseguibile() {
            @Override
            public void fai() {
                System.out.println("Scatto la foto");
            }
        };

        public void registra(){
            faiFoto.fai();
            System.out.println(faiFoto.getClass());
        }
    }

}

interface Eseguibile{
    void fai();
}


interface Cliccabile{
 void click();
}

abstract class Bottone implements Cliccabile{}
