package it.nextre.academy.pr130120.locale;

import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Locale;
import java.util.Properties;
import java.util.ResourceBundle;

public class MainLocale {

    public static void main(String[] args) {

        System.out.println(Locale.getDefault());
        System.out.println(Locale.getDefault().getLanguage());
        System.out.println(Locale.getDefault().getCountry());
        System.out.println(Locale.getDefault().getISO3Language());
        System.out.println(Locale.getDefault().getISO3Country());

        LocalDate today = LocalDate.now();
        String oggi = "";

        oggi = today.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL));
        System.out.println(oggi);

        Locale.setDefault(Locale.ENGLISH);
        oggi = today.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL));
        System.out.println(oggi);




        System.out.println(
                today.format(DateTimeFormatter.ofPattern("EEEE-MMMM", Locale.ITALIAN))+"\n"+
                today.format(DateTimeFormatter.ofPattern("EEEE-MMMM", Locale.ENGLISH))+"\n"+
                today.format(DateTimeFormatter.ofPattern("EEEE-MMMM", Locale.FRENCH))+"\n"+
                today.format(DateTimeFormatter.ofPattern("EEEE-MMMM", Locale.GERMAN))+"\n"
        );



        Locale.setDefault(Locale.ITALY);
        // creazione del Resource Bundle
        ResourceBundle rb = ResourceBundle.getBundle("lang/testi");
        System.out.println(rb.getString("home.title"));
        // al cambio della locale devo RICARICARE il resource bundle corretto
        Locale.setDefault(Locale.ENGLISH);
        rb = ResourceBundle.getBundle("lang/testi");
        System.out.println(rb.getString("home.title"));


        Properties lang = new Properties();
        try {
            lang.load(new FileReader("./resources/lang/testi_it.properties"));
            lang.forEach((k,v)->System.out.println(k+"-->"+v));
            System.out.println(lang.getProperty("home.description","..."));
        } catch (IOException e) {
            e.printStackTrace();
        }


    }//end main

}//end class
