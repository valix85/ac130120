package it.nextre.academy.pr130120.enums;

import it.nextre.academy.pr130120.myutils.Operations;

public class MainEnum {

    public static void main(String[] args) {

        Taxi taxi1 = Taxi.createTaxi("city");
        // double eurokm = calcolaPrezzoBase(taxi1);
        // double eurokm = NON SERVE PIU' ogni taxi avrà il suo valore
        double totKmCorsa = taxi1.viaggia();
        System.out.println(taxi1.getTotaleCorsa(totKmCorsa));


        System.out.println(Carburante.valueOf("GPL").getEurokm());
        for(Carburante tmp : Carburante.values()){
            System.out.println(tmp.ordinal()+" "+tmp.name()+" {"+tmp+"}");
        }

    }//end main

    // Inutile perchè spostata la logica direttamente in enum
    private static double calcolaPrezzoBase(Taxi taxi) {
        switch (taxi.getCarburante()){
            case BENZINA:   return 1.89;
            case DIESEL:    return 1.72;
            case GPL:       return 1.62;
            case METANO:    return 1.66;
            case ELETTRICO: return 1.58;
            default:        return 2;
        }
    }

}//end class


class Taxi {
    private Carburante carburante;
    private Taxi(Carburante carburante){
        this.carburante=carburante;
    }

    public Carburante getCarburante() {
        return carburante;
    }

    public static Taxi createTaxi(String categoria){
        switch (categoria){
            case "people": return new Taxi(Carburante.DIESEL);
            case "business" : return new Taxi(Carburante.BENZINA);
            case "travel": return new Taxi(Carburante.GPL);
            case "city": return new Taxi(Carburante.ELETTRICO);
            case "oldTown" : return new Taxi(Carburante.METANO);
        }
        throw new RuntimeException("Carburante non valido, taxi non disponibile");
    }

    public double viaggia() {
        return Operations.getRandomDouble(3,20);
    }

    public double getTotaleCorsa(double kmCorsa) {
        return 5.49+(this.carburante.getEurokm()*kmCorsa);
    }
}