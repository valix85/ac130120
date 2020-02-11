package it.nextre.academy.pr130120.file;

import javax.security.auth.login.AccountLockedException;
import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileMain {

    public static void main(String[] args) {
        // File di testo = Stringhe = 16bit x volta = 2Byte = 1 char
        //      -> si suffix reader / Writer

        // File binari   = byte = 8bit x volta = 1Byte
        //      -> no suffix reader / writer

        Path sorgente = Paths.get("test.txt");
        File f1 = new File(sorgente.normalize().toString());
        File f2 = new File("./test.txt");
        File f3 = new File("c:\\Academy\\test.txt"); // NO!!!!
        File f4 = new File("c:"+File.separator+"Academy"+File.separator+"test.txt"); // meglio
        File f5 = new File(Paths.get("c","Academy","test.txt").toString()); // meglio

        System.out.println(Paths.get("C:","Academy","test.txt").normalize().toString());
        System.out.println(Paths.get("C:","Academy","test.txt").toUri());

        System.out.println(f2);


        if (!f2.exists()) {
            try {
                f2.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }else{
            if (f2.delete()){
                try {
                    f2.createNewFile();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }


        try(Reader r1 = new FileReader(f2);
            BufferedReader br1 = new BufferedReader(r1);
            Writer w1 = new FileWriter(f2, true)) {

            w1.write("Ciao");
            w1.flush(); // scarica i dati sul disco

            String riga = null;
            while( (riga=br1.readLine())!=null ){
                System.out.println(riga);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // USARE TRY-WITH-RESOURCES
        }







    }//end main

}//end class
