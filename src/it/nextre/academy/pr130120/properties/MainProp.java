package it.nextre.academy.pr130120.properties;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.*;
import java.util.prefs.BackingStoreException;
import java.util.prefs.Preferences;

public class MainProp {

    public static void main(String[] args) {

        Map<String, String> envs = System.getenv();
        //System.out.println(envs);
        envs.forEach((chiave, valore)->{
            System.out.println(chiave + " ---> " + valore);
        });

        //envs.values().forEach(System.out::println);

        Set<String> keys = envs.keySet();
        Iterator<String> keysIterator = keys.iterator();
        while(keysIterator.hasNext()){
            String key = keysIterator.next();
            //System.out.println(key + " ---> " + envs.get(key));
        }

        Properties props = System.getProperties();
        //props.list(System.out);
        //System.out.println(props.getProperty("path.separator"));
        Set<Map.Entry<Object, Object>>  entries = props.entrySet();
        entries.forEach(e->{
//            System.out.println(e.getKey());
//            System.out.println(e.getValue());
//            System.out.println("");
        });


        Enumeration propKeys= props.keys();
        while(propKeys.hasMoreElements()){
            //System.out.println(propKeys.nextElement());
            propKeys.nextElement();
        }
        Enumeration propNames = props.propertyNames();
        while(propNames.hasMoreElements()){
            System.out.println(propNames.nextElement());
        }
        // Gestito in un formato che dipende dalla macchina su cui è in esecuzione, al contrario i Porperties vengono salvati su file XML accessibili all'utente
        Preferences pref = Preferences.userRoot();
        //pref.put("datetime", LocalDateTime.now().toString());
        //pref.putInt("livello",24);
        System.out.println(pref.get("datetime","---"));
        System.out.println(pref.getInt("livello",0));



        Runtime r = Runtime.getRuntime();
        try {
            r.exec("C:\\Program Files\\Microsoft VS Code\\bin\\code.cmd");
            Thread.sleep(200);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        try {
            Class stringa = Class.forName("java.lang.String");
            // utile per la reflection
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


    }//end main
}//end class
