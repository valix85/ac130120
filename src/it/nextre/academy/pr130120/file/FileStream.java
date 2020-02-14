package it.nextre.academy.pr130120.file;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

public class FileStream {

    public static void main(String[] args) {


        // step 1
        // caricare un file di testo bello pesante...



        try(
                FileReader fr = new FileReader("./origineSmall.txt");
                BufferedReader bfr = new BufferedReader(fr);
                FileOutputStream fos = new FileOutputStream("./origine_copia.txt");
                DataOutputStream dos = new DataOutputStream(fos);

                FileInputStream fis = new FileInputStream("./origine_copia.txt");
                DataInputStream dis = new DataInputStream(fis);
                //BufferedInputStream bis = new BufferedInputStream(das);

                BufferedReader bfr2 = new BufferedReader(new FileReader("./origine_copia.txt", StandardCharsets.UTF_16));

            ) {
            String riga = "";
            long start = System.nanoTime();
            while( (riga=bfr.readLine()) != null ){
                riga+="\r\n";
                //fos.write(riga.getBytes());
                dos.writeChars(riga); // raddoppia la grandezza del file!
            }
            dos.flush();
            System.out.println(dis.readLine());
            System.out.println(bfr2.readLine());

            System.exit(9);

            long duration = System.nanoTime() - start;
            System.out.println("Tempo in ns: "+ duration);



        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }//end main
}//end class
