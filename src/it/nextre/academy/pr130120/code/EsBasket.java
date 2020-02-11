package it.nextre.academy.pr130120.code;

import it.nextre.academy.pr130120.myutils.Generator;
import it.nextre.academy.pr130120.myutils.Operations;

import java.util.ArrayDeque;
import java.util.Queue;

public class EsBasket {

    public static final int N_GIOCATORI=5;

    public static void main(String[] args) {

        Queue<Giocatore> giocatori = new ArrayDeque<>();
        Queue<Giocatore> classifica = new ArrayDeque<>();
        for (int i = 0; i < N_GIOCATORI; i++) {
            giocatori.add(new Giocatore(Generator.generaNome()+" "+Generator.generaCognome()));
        }//end for
        // stampo la coda prima di iniziare a giocare
        giocatori.forEach(System.out::println);

        while(!giocatori.isEmpty()){
            Giocatore player = giocatori.poll();
            if (player.gioca()){
                // se true ha vinto e lo metto in classifica
                classifica.offer(player);
            }else{
                // se false ha sbagliato e rientra in coda
                giocatori.offer(player);
            }
        }

        // stampo la coda dopo la partita
        System.out.println("--- CLASSIFICA FINALE ---");
        giocatori.forEach(System.out::println);
        classifica.forEach(System.out::println);



    }//end main


}//end class

class Giocatore {
    private int tentativi;
    private int canestriDaFare = 3;
    private boolean vinto;
    private long inizio, durata;
    private String nome;

    public Giocatore(String nome) {
        this.nome = nome;
    }

    public boolean gioca(){
        if (tentativi==0)
            inizio=System.currentTimeMillis();
        tentativi++;
        while(this.canestriDaFare>0 || !vinto){
            // simulo la durata del tiro, se sbaglia torna in coda
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (Operations.getRandomInt(1,101)>50)
                canestriDaFare--;
            else {
                // sbagliato, ritorno in coda
                canestriDaFare = 3;
                return false;
            }
            if (canestriDaFare==0)
                vinto=true;
        }
        vinto=true;
        durata=System.currentTimeMillis()-inizio;
        return vinto;


    }

    @Override
    public String toString() {
        return "Giocatore{" +
                "nome='" + nome + '\'' +
                ", tentativi=" + tentativi +
                ", durata=" + durata + "ms" +
                '}';
    }
}