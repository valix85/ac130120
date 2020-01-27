package it.nextre.academy.pr130120.eccezioni;

import java.io.File;
import java.io.IOException;
import java.rmi.server.ExportException;
import java.sql.SQLException;

public class EccMain {

    static String word;

    public static void main(String[] args) {

        // eccezioni 2 tipi:
        // - checked (tutte le exception e figlie tranne runtime)
        // - UNchecked (Runtime e figlie)

        // UNchecked
        // word.length(); // NullPoiterException, mai inizializzata
        // System.out.println(3/0); // ArithmeticException: / by zero


        // checked
        File f1 = new File("tr:\\test.txt"); //tr non è un hdd valido
        try {
            System.out.println("Prima di scrivere");
            // f1=null;
            f1.createNewFile();
            System.out.println("Dopo che ho scritto");
        } catch (IOException | IllegalAccessError err){
            System.err.println("Errore di scrittura: "+err.getMessage());
            err.printStackTrace();
            // System.exit(505); // non farà il blocco finally
        } catch (NullPointerException err){
            System.out.println("Oggetto nullo!");
        } catch (Exception err){

        }finally {
            System.out.println("Operazione critica terminata");
        }


        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        // uso del throw e throws

        // simulo un compito che una volta su 5 dovrà fallire per cause esterne
        // es: scaricare un file ma perdo il WiFi

        try {
            String data = scaricaFile("http://www.lorem.com/it/data.zip");
        } catch (RuntimeException e){
            System.err.println("RT: ERRORE NEL DOWNLOAD DEL FILE, riprovare più tardi");
        } catch (DownloadException e) {
            System.err.println("CUSTOM: ERRORE NEL DOWNLOAD DEL FILE, riprovare più tardi");
        } catch (Exception e){
            System.err.println("EX: ERRORE NEL DOWNLOAD DEL FILE, riprovare più tardi");
        }




        System.out.println("Fine programma");

    }//end main

    private static String scaricaFile(String path) throws DownloadException {
        // 1 volta su 5 deve fallire (20% di fallimento ... 0.2)
        if (Math.random()<0.2){
            // fallimento
            //throw new RuntimeException("RT: Network Error: invalid socket address");
            //throw new Exception("EX: Network Error: invalid socket address");
            throw new DownloadException("CUSTOM: Network Error: invalid socket address");
        }else {
            return "dati scaricati con successo...";
        }
    }
}//end class
