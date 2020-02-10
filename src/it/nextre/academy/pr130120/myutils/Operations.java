package it.nextre.academy.pr130120.myutils;

import it.nextre.academy.pr130120.eccezioni.DownloadException;

import java.util.Arrays;
import java.util.Scanner;

public class Operations {
    public static double getAverage(Double[] values){
        if (values!=null && values.length>0) {
            Double sum = 0d;
            for (Double value : values) {
                sum += value;
            }
            return sum / values.length;
        }
        return 0; // change with exception
    }

    public static double[] getMin(Double[] values){
        // idea di tornare in:
        // - pos 0 il valore
        // - pos 1 la posizione

        double minimo = Double.MAX_VALUE;
        int posizione = -1;

        if (values!=null && values.length>0){
            // se l'insieme in ingresso è valido
            for (int i = 0; i < values.length; i++) {
                if (values[i]<minimo){
                    minimo=values[i];
                    posizione=i;
                }
            }//end for
        }
        //System.out.println("Il valore minimo è: "+minimo+" alla posizione "+posizione);
        return new double[]{minimo,posizione};
    }

    public static double[] getMax(Double[] values){
        // idea di tornare in:
        // - pos 0 il valore
        // - pos 1 la posizione

        double valore = Double.MIN_VALUE;
        int posizione = -1;

        if (values!=null && values.length>0){
            // se l'insieme in ingresso è valido
            for (int i = 0; i < values.length; i++) {
                if (values[i]>valore){
                    valore=values[i];
                    posizione=i;
                }
            }//end for
        }
        //System.out.println("Il valore massimo è: "+valore+" alla posizione "+posizione);
        return new double[]{valore,posizione};

    }

    public static void printMatrixInt(int[][] mat) {
        for (int riga = 0; riga < mat.length; riga++) {
            for (int colonna = 0; colonna < mat[riga].length; colonna++) {
                System.out.print(mat[riga][colonna] + " ");
            }
            System.out.println("");
        }
    }

    /*
    * Normalizzazione di un random su di un range
    * */
    public static double getRandomDouble(double min, double max){
        return min+(Math.random()*(max-min));
    }

    public static int getRandomInt(int min, int max){
        return (int)(min+(Math.random()*(max-min)));
    }

    public static String readRow() {
        Scanner s = new Scanner(System.in);
        return s.nextLine();
    }

    public static int readIntNumber() {
        // Scanner s = new Scanner(System.in);
        // return s.nextInt();
        String input = readRow();

        // modo 1
        // for (int i = 0; i < input.length(); i++) {
        //     if (i==0 && (input.charAt(i) == '-' || input.charAt(i) == '+') ){
        //         continue;
        //     }
        //     if (!Character.isDigit(input.charAt(i))){
        //         System.out.println("input non valido, riprova");
        //         return readIntNumber();
        //     }
        // }//end for

        // modo 2
        String ok = "0123456789";
        // for (int i = 0; i < input.length(); i++) {
        //     char tmp = input.charAt(i);
        //     if (i==0 && (tmp == '+' || tmp=='-')){
        //         continue;
        //     }
        //     if (ok.indexOf(tmp)<0){
        //         // il carattere non è presente
        //         System.out.println("input non valido, riprova");
        //         return readIntNumber();
        //     }
        // }//end for

        // modo 3
        // for (int i = 0; i < input.length(); i++) {
        //     char tmp = input.charAt(i);
        //     if (i==0 && (tmp == '+' || tmp=='-')){
        //         continue;
        //     }
        //     if (tmp<48 || tmp >57){
        //         // il carattere non è valido
        //         System.out.println("input non valido, riprova");
        //         return readIntNumber();
        //     }
        // }//end for

        // modo 4
        try{
            return Integer.parseInt(input);
        }catch(NumberFormatException ex){
            System.out.println("input non valido, riprova");
            return readIntNumber();
        }

        //return Integer.parseInt(input);
    }

    public static int readPositiveIntNumber() {
        int val = readIntNumber();
        if (val<0){
            System.out.println("input non valido, inserire un valore positivo");
            return readPositiveIntNumber();
        }
        return val;
    }

    public static void printArray(Object[] arr){
        for (Object tmp : arr)
            System.out.println(tmp);
    }

    public static void printArray(int[] numbers){
        System.out.println(Arrays.toString(numbers));
    }

    public static String reverseString(String text){
        return new StringBuilder(text).reverse().toString();
        /*
        String out = "";
        for (int i = text.length() - 1; i>=0;i--) {
            out+=text.charAt(i);
        }//end for
        return out;
         */
    }

    public static String cleanVowel(String text) {
        /*
        String out = "";
        String vocali = "AEIOUaeiou";
        for (int i =0; i< text.length() ; i++) {
            String tmp = ""+text.charAt(i);
            if (vocali.contains(tmp)){continue;}
            if (vocali.indexOf(tmp)>=0){continue;}
            out+=tmp;
        }//end for
        return out;
        */
        return text.replaceAll("[AEIOUaeiou]","");
    }

    public static void ordinaArrayInt(int[] array,  boolean crescente){
        //bubble sort
        if (array.length<=1) return;boolean scambio = true;
        while(scambio){
            scambio=false;
            for (int i = 0; i < array.length -1; i++) {
                // crescente ASC
                if(crescente && array[i]>array[i+1]){
                    int tmp = array[i];
                    array[i]=array[i+1];
                    array[i+1]=tmp;
                    scambio=true;
                }
                // descrescente DESC
                if(!crescente && array[i]<array[i+1]){
                    int tmp = array[i];
                    array[i]=array[i+1];
                    array[i+1]=tmp;
                    scambio=true;
                }
            }//end for
        }
    }

    public static String formattaDouble(double num, int decimali){
        if (decimali<0){decimali=2;}
        return String.format("%."+decimali+"f",num);
    }

    public static String formattaDouble(double num){
        return formattaDouble(num,2);
    }
}//end class
