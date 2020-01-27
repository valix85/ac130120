package it.nextre.academy.pr130120.targagenerator;

public class MainTarghe {

    // numero di veicoli da creare
    public static final int N_VEICOLI = 21;


    public static void main(String[] args) {

        // ogni veicolo dovrà avere una targa differente
        Veicolo[] veicoli = new Veicolo[N_VEICOLI];

        // genero i veicoli
        for (int i =0; i<N_VEICOLI; i++){
            Veicolo tmp = new Veicolo();
            tmp.setAutista("Autista "+(i+1));
            tmp.setPatente("Patente "+(i+1));
            veicoli[i] = tmp;
        }

        // stampo i veicoli
        for(Veicolo v : veicoli)
            System.out.println(v);

    }//end main
}//end class
