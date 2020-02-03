package it.nextre.academy.pr130120.generici;

public class UrnaMain {

    public static void main(String[] args) {

        // UrnaArray<Integer> lotteria = new UrnaArray<>();
        Urna<Integer> lotteria = new Urna<>();

        lotteria.add(643);
        lotteria.add(289);
        lotteria.add(371);
        lotteria.add(846);
        lotteria.add(833);
        lotteria.add(005);

        while (!lotteria.isEmpty()){
            System.out.println(lotteria.extract());
        }


    }//end main

}//end class
