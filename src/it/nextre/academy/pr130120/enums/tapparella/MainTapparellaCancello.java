package it.nextre.academy.pr130120.enums.tapparella;

public class MainTapparellaCancello {
    public static void main(String[] args) throws InterruptedException {

        Binario tapparella = new Binario(3000,10);

        tapparella.graficaBinario();
        System.out.println(tapparella);

        tapparella.vaiA(Posizione.APERTO);
        System.out.println(tapparella);

        Thread.sleep(1000);

        tapparella.vaiA(0.25);
        System.out.println(tapparella);



    }//end main
}//end class
