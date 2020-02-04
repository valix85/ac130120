package it.nextre.academy.pr130120.enums.lampada;

public class InterruttoreDimmerabile extends Interruttore {
    public InterruttoreDimmerabile(LampadinaDimmerabile acc) {
        super(acc);
    }

    public void alzaLivello() {
        int stato = carico.getStato().ordinal();
        int idxMax = StatoLampada.values().length -1; // -1 ordinale
        int idxMin = 2;
        if (stato==1)
            stato = idxMax;
        if (stato+1>idxMax){
            System.out.println("carico al massimo");
        }else{
            ((LampadinaDimmerabile)carico).setStato(StatoLampada.getByOrdinal(stato+1));
        }
    }


    public void abbassaLivello() {
        int stato = carico.getStato().ordinal();
        int idxMax = StatoLampada.values().length -1; // -1 ordinale
        int idxMin = 2;
        if (stato==1)
            stato = idxMax;
        if (stato-1<idxMin){
            System.out.println("carico al minimo");
        }else{
            ((LampadinaDimmerabile)carico).setStato(StatoLampada.getByOrdinal(stato-1));
        }
    }
}//end class
