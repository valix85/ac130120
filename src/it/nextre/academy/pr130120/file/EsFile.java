package it.nextre.academy.pr130120.file;

/*
*
* AQ_[A-Za-z0-9]{5}-VT[0-9]{1,2}.mp4

ex: "AQ_gj7Dn-VT6.mp4"
ex: "AQ_Px87r-VT28.mp4"

STEP1
generare 40 file vuoti secondo il pattern sopra mostrato, con numerazione univoca e progressiva.

STEP2
leggere dalla cartella l'elenco dei file e ordinarli per numero finale (dopo VT)

STEP3
copiare rinominando in ordine i file con nome, seguito dal numero finale (N): "Lezione_"{N}.mp4

ex: "Lezione_6.mp4"
ex: "Lezione_28.mp4"

STEP4
a partire da step2 o step3 (libera scelta), nominare i file in modo da avere prima il numero, il pattern " - " e poi il titolo della lezione preso da un indice creato a piacere.

ex: "06 - HTML for dummies.mp4"
ex: "28 - How to deploy a website.mp4"
*
* */


import it.nextre.academy.pr130120.myutils.Generator;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class EsFile {

    public static final Path DIRECTORY = Paths.get("C:","temp");
    public static final int NFILE = 40;

    public static void main(String[] args) {

        //System.out.println(DIRECTORY);

        // step0 : pulizia directory di lavoro
        step0(DIRECTORY, "mp4");

        // step1 : creazione 40 file
        step1(NFILE, DIRECTORY,"mp4");

        // step2 : lettura file nella cartella ed estrazione di lista Lezione oridinata
        List<Lezione> lezioni = step2(DIRECTORY, "mp4");
        //lezioni.forEach(System.out::println);

        // step3: rinominare i file come da specifica
        step3(lezioni);

        // step4: caricare i titoli da una lista su semplice file di testo (elenco.txt) ed assegnarli ai file
        step4();




    }//end main

    private static void step4() {
        //caricare lista da file
        List<String> titoli = caricaTitoliDaFile(new File("./resources/indice_es_lezioni.txt"));
        //titoli.forEach(System.out::println);
        List<Lezione> files = step2(DIRECTORY, "mp4");
        files = files.stream()
                //setto l'indice dal nome del file
                .map(l->{
                    String idx = l.getFilename()
                            .substring(l.getFilename().lastIndexOf("_")+1 )
                            .replaceAll(".mp4","");
                    l.setIdx(Integer.parseInt(idx));
                    return l;
                })
                //ordino la lista sulla base dell'indice
                .sorted(Comparator.comparingInt(Lezione::getIdx))
                //colleziono i risultati ordinati in una nuova lista
                .collect(Collectors.toList());
        //rinomino la lista dei file sulla base della lista dell'indice dei capitoli
        if (titoli.size()>=files.size()){
            for (int i = 0; i < files.size(); i++) {
                File tmpFile = new File(files.get(i).getFilename());
                String tmpTitolo = files.get(i).getIdx()+" - "+titoli.get(i)+".mp4";
                Path fdest = DIRECTORY.resolve(tmpTitolo);
                //System.out.println(fdest);
                tmpFile.renameTo(new File(fdest.toString()));

            }//end for
        }
    }

    private static List<String> caricaTitoliDaFile(File file) {
        List<String> righe = new ArrayList<>();
        try ( BufferedReader reader = new BufferedReader(new FileReader(file)) ) {
//            String riga="";
//            while( (riga=reader.readLine())!=null ){
//                riga=riga.trim();
//                riga=pulisciRiga(riga);
//                if (riga.length()>0)
//                    righe.add(riga);
//            }
            reader.lines()
                    .map(String::trim)
                    .map(EsFile::pulisciRiga)
                    .forEach(righe::add);
                    //.collect(Collectors.toList());

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return righe;
    }

    private static String pulisciRiga(String riga) {
        //tolgo tutto fino al primo spazio
        riga=riga.replaceAll("[^a-zA-Z0-9\\.\\-_#\\[\\]\\(\\)\\{\\}àèéìòù ]","");
        riga=riga.trim();
        if (riga != null && riga.length()>1 && riga.indexOf(" ")>=0){
            riga=riga.substring(riga.indexOf(" ")+1); // +1 per togliere lo spazio
        }
        return riga;
    }


    private static void step3(List<Lezione> lezioni) {
        lezioni.stream()
                .forEach(l->{
                    //trovare il percorso di dove salvare il file rinominato
                    File f = new File(l.getFilename());
                    Path dest = Paths.get(f.getPath()).getParent();
                    //System.out.println(dest);
                    String newFilename = "Lezione_"+l.getIdx()+".mp4";
                    //rinominare il file
                    Path fdest = dest.resolve(newFilename);
                    //System.out.println(fdest);
                    f.renameTo(new File(fdest.toString()));
                });
    }


    private static void step0(Path directory, String ext) {
        // se directory non esiste la creo
        File dir = new File(directory.toString());
        if (!dir.exists() || (dir.exists() && dir.isFile())){
            dir.mkdirs();
            System.out.println("directory creata");
        }else if (dir.isDirectory()) {
            // altrimenti
            // cancellare tutti i file .mp4 nella directory in input
            List<Path> filesToDelete = getFileIntoFolder(directory, ext);
            filesToDelete.stream()
                    .map(Path::toFile)
                    .forEach(File::delete);
        }
    }

    private static void step1(int nfile, Path dir, String estensione) {
        //  AQ_[A-Za-z0-9]{5}-VT[0-9]{1,2}.mp4
        for (int i = 0; i < nfile; i++) {
            String filename = "AQ_"+ Generator.generaPasswordSemplice(5)+"-VT"+String.format("%02d",(i+1))+"."+estensione;
            //System.out.println(filename);
            String destination = dir.resolve(Paths.get(filename)).toString();
            File tmp = new File(destination);
            try {
                tmp.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }//end for


        //RESOLVE -> sistema le barre nei Path con quelle del SO in uso
        // ass1(ass2) ---> ass2
        // ass1(rel2) ---> ass1+rel2
        // rel1(ass2) ---> ass2
        // rel1(rel2) ---> rel1+rel2

        //RELATIVIZE mi risolve il percorso per andare da A a B in modo relativo
        //da c:\temp\images --> c:\temp\video ---> ..\video
        //da c:\temp --> c:\temp\video ---> video
        //da c:\temp --> c:\temp\video\full ---> video\full
    }

    private static List<Lezione> step2(Path directory, String ext) {
        List<Path> files = getFileIntoFolder(directory, ext);
        List<Lezione> lezioni = files.stream()
                                    .map(item -> new Lezione(item.toString()))
                                    .sorted( (l1,l2)->l1.getIdx()-l2.getIdx() )
                                    .collect(Collectors.toList());

        //ordino direttamente mentre colleziono sopra
        //lezioni.sort( (l1,l2)->l1.getIdx()-l2.getIdx() );
        return lezioni;
    }


    private static List<Path> getFileIntoFolder(Path folder, String ext){
        List<Path> tmp = null;
        try {
            tmp = Files.list(folder)
                    .filter(item->item.toString().endsWith("."+ext))
                    .collect(Collectors.toList());
        } catch (IOException e) {
            //e.printStackTrace();
            throw new RuntimeException(e.getMessage());
        }
        return tmp;
    }


}//end class


class Lezione{
    private String filename;
    private int idx;

    public Lezione() {}

    public Lezione(String filename) {
        this.filename = filename;
        this.idx=trovaIndice(filename);
    }

    private static int trovaIndice(String filename) {
        String delimiter1 = "-VT";
        String tmp = filename.substring(filename.indexOf(delimiter1)+delimiter1.length());
        tmp = tmp.substring(0, tmp.indexOf("."));
        int idx = -1;
        try{
            idx = Integer.parseInt(tmp);
        }catch (RuntimeException ex){
            return idx;
        }
        return idx;
    }

    public Lezione(String filename, int idx) {
        this.filename = filename;
        this.idx = idx;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public int getIdx() {
        return idx;
    }

    public void setIdx(int idx) {
        this.idx = idx;
    }

    @Override
    public String toString() {
        return "Lezione{" +
                "filename='" + filename + '\'' +
                ", idx=" + idx +
                '}';
    }
}