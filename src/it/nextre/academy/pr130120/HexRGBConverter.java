package it.nextre.academy.pr130120;

import java.util.Arrays;
import java.util.stream.Collectors;

public class HexRGBConverter {

    // realizzare un programma in grado di convertire valori HEX a RGB e viceversa.
    // il sistema dovrà essere in grado di convertire da valori decimali, da sei o tre cifre, a hex e viceversa;
    // es: #FFF === #FFFFFF <=> 255,255,255
    // es: #888 === #888888 <=> ...

    public static void main(String[] args) {
        System.out.println("To Hexadecimal");
        System.out.println("0 "+toHex(0));
        System.out.println("1 "+toHex(1));
        System.out.println("255 "+toHex(255));

        System.out.println("To Decimal");
        System.out.println("FF "+toDec("FF"));
        System.out.println("F "+toDec("F"));
        System.out.println("1 "+toDec("1"));
        System.out.println("0 "+toDec("0"));
        System.out.println("1G "+toDec("1G"));

        System.out.println("Colors");
        System.out.println("255,255,255 "+colorToHex("255,255,255"));
        System.out.println("0,0,0 "+colorToHex("0,0,0"));
        System.out.println("0,0,0,0 "+colorToHex("0,0,0,0"));
        System.out.println("128,128,128 "+colorToHex("128,128,128"));
        System.out.println("255,136,156 "+colorToHex("255,136,156"));



        System.out.println("FFFFFF "+colorToDec("FFFFFF"));
        System.out.println("FFF "+colorToDec("FFF"));
        System.out.println("000000 "+colorToDec("000000"));
        System.out.println("0010 "+colorToDec("0010"));
        System.out.println("FF889C "+colorToDec("FF889C"));
    }//end main

    private static String colorToDec(String coloreHex) {
        if (coloreHex==null){
            return "Formato colore non valido";
        }
        if ( !(coloreHex.length()==3 || coloreHex.length()==6) ){
            return "Formato colore non valido";
        }
        coloreHex=coloreHex.toUpperCase();
        String out="";
        String[] valoriRGB = new String[3];
        if (coloreHex.length()==3){
            // formato ristretto
            for (int i = 0; i < coloreHex.length(); i++) {
                valoriRGB[i]=toDec(coloreHex.charAt(i)+""+coloreHex.charAt(i));
            }//end for
        }else{
            // formato lungo
            // valoriRGB[0]=toDec(coloreHex.charAt(0)+""+coloreHex.charAt(1));
            // valoriRGB[1]=toDec(coloreHex.charAt(2)+""+coloreHex.charAt(3));
            // valoriRGB[2]=toDec(coloreHex.charAt(4)+""+coloreHex.charAt(5));
            valoriRGB[0]=toDec(coloreHex.substring(0,2));
            valoriRGB[1]=toDec(coloreHex.substring(2,4));
            valoriRGB[2]=toDec(coloreHex.substring(4));
        }

        // creazione output string
        // out= Arrays.asList(valoriRGB).stream().collect(Collectors.joining(","));
        for (int i = 0; i < valoriRGB.length; i++) {
            if (valoriRGB[i].equals("00")){
                out+="0";
            }else {
                out += valoriRGB[i];
            }
            if (i != valoriRGB.length - 1 ){
                out+= ",";
            }
        }//end for
        // return out.substring(0,out.length()-1);
        return out;
    }

    private static String colorToHex(String coloreDec) {
        if (coloreDec==null){return "Formato colore non valido";}
        String[] rgb = coloreDec.split(",");
        if (rgb.length!=3){
            return "Formato colore non valido";
        }
        String out="";
        for (int i = 0; i < rgb.length; i++) {
            int valore = Integer.parseInt(rgb[i]);
//            if (valore<0 || valore>255){
//                return "Errore di conversione, input non valido";
//            }
            if (valore<=0){
                out+="00";
            }else if (valore>=255){
                out+="FF";
            }else{
                out+=toHex(valore);
            }
        }//end for
        return out;
    }

    private static String toDec(String hex) {
        // modo 1
        // int x = Integer.parseInt(hex,16);
        // return x;
        // modo 2
        String digits = "0123456789ABCDEF";
        hex=hex.toUpperCase();
        int tmp = 0;
        for (int i = 0; i < hex.length(); i++)
        {
            char valore = hex.charAt(i);
            int pos = digits.indexOf(valore);
            if (pos>=0) {
                tmp = 16 * tmp + pos;
            }else{
                return "Errore di conversione, input non valido";
            }
        }
        return String.format("%2s",tmp).replaceAll(" ","0");
    }

    public static String toHex(int decimal){
        int rem;
        String hex="";
        char hexchars[]={'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};
        while(decimal>0){
            rem=decimal%16;
            hex=hexchars[rem]+hex;
            decimal=decimal/16;
        }
        hex=String.format("%2s",hex).replaceAll(" ","0");
        return hex;
    }

}//end class
