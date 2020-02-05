package it.nextre.academy.pr130120.enums.tapparella;

public class Binario {

    private double lunghezza;
    private double passo;       //il passo è in percentuale sulla lunghezza
    private Posizione stato;
    private double posizione;   // percentuale sulla lunghezza in cui si trova il binario

    private final double erroreRelativo = 0.001;

    public Binario(double lunghezza, double passo){
        this(lunghezza, passo, Posizione.CHIUSO);
    }
    public Binario(double lunghezza, double passo, Posizione stato){
        this.lunghezza=lunghezza;
        this.passo=arrotonda(passo/lunghezza); //il passo è in percentuale
        this.stato=stato;
        this.posizione=stato.getPosizione();
        System.out.println(passo);
    }










    public void vaiA(Posizione destinazione){
        vaiA(destinazione.getPosizione());
        stato=destinazione;
        posizione=stato.getPosizione(); //fix per decimali in esubero
    }
    public void vaiA(double destinazione){
        if (destinazione < 0 || destinazione>1 ){return;}

        if (posizione==destinazione){
            System.out.println("Sono già in posizione");
            return;
        }

        int k = 0; // contatore iterazioni per debug
        if (posizione<destinazione){
            //devo andare avanti
            while(posizione+erroreRelativo<destinazione){
                avanza(); k++;
            }
            posizione=destinazione; //fix per decimali in esubero
        }else{
            //devo andare indietro
            while(posizione-erroreRelativo>destinazione){
                retrai();
                k++;
            }
            posizione=destinazione; //fix per decimali in esubero
        }
        System.out.println("iterazioni: "+k);

    }

    public void avanza(){
        if (this.posizione<1)
            this.posizione+=this.passo;
        this.posizione = arrotonda(this.posizione);

        graficaBinario();
    }

    public void retrai(){
        if (this.posizione>0)
            this.posizione-=this.passo;
        this.posizione = arrotonda(this.posizione);

        graficaBinario();
    }


    //fix per decimali in esubero
    private static double arrotonda (double input){
        //return Double.parseDouble(String.format("%.10f",input).replaceAll(",","."));
        return Math.round(input * 10000000000000.0) / 10000000000000.0;
    }

    public void graficaBinario(){
        //System.out.println(this);
        String out = "|";
        int dimensione = 30;
        int pieni= (int)( (posizione+erroreRelativo)*dimensione);
        //System.out.println(pieni);
        for (int i = 0; i < pieni; i++) {
            out+="#";
        }//end for
        for (int i = 0; i < dimensione - pieni; i++) {
            out+="_";
        }//end for
        out+="|";
        System.out.println(out);
        try {
            Thread.sleep(20);
        } catch (InterruptedException e) {}
    };

    @Override
    public String toString() {
        return "Binario{" +
                "lunghezza=" + lunghezza +
                ", passo=" + passo +
                ", stato=" + stato +
                ", posizione=" + posizione +
                ", posizioneAssoluta=" + posizione * lunghezza +
                '}';
    }
}//end class
