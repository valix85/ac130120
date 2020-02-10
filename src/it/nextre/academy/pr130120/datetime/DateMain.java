package it.nextre.academy.pr130120.datetime;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAccessor;
import java.util.*;

public class DateMain {

    public static void main(String[] args) {

        Date d1 = new Date(System.currentTimeMillis());
        System.out.println(d1);

        Calendar c1 = new GregorianCalendar();
        System.out.println(c1.toString());

        LocalDate ld1 = LocalDate.now();
        LocalDateTime ldt1 = LocalDateTime.now();
        LocalDateTime ldt2 = LocalDateTime.now(ZoneId.of("Australia/Sydney"));
        System.out.println(ldt1);
        System.out.println(ldt2);
        //27/04/1987
        LocalDate dob = LocalDate.of(1987, 4,27);
        System.out.println(dob.format(DateTimeFormatter.ofPattern("EEEE")));

        LocalDate dob2 = LocalDate.parse(
                "27/04/1987",
                DateTimeFormatter.ofPattern("dd/MM/uuuu")
                );
        System.out.println(dob2);
        System.out.println(dob2.getYear());
        System.out.println(dob2.getMonth().getValue());
        System.out.println(dob2.getDayOfMonth());
        dob2=dob2.withYear(Year.now().getValue());
        System.out.println(dob2);
        System.out.println(dob2.format(DateTimeFormatter.ofPattern("EEEE")));

        Instant epoch = Instant.EPOCH;
        System.out.println(epoch);
        Instant now = Instant.now();
        System.out.println(now);
        System.out.println();
        System.out.println(
                Duration.ofMillis(epoch.until(now,ChronoUnit.MILLIS))
                        .toDays()
        );



        // ciclare su una data
        Map<Integer, String> myComple = new HashMap<>();
        LocalDate myDob = LocalDate.of(1985,7,7);
        Year startY = Year.of(myDob.getYear());
        for(;startY.getValue()<=2100;){
            String giorno = myDob.withYear(startY.getValue()).format(DateTimeFormatter.ofPattern("EEEE"));
            myComple.put(startY.getValue(),giorno);
            /*
            System.out.println("anno "+
                    myDob.withYear(startY.getValue()).format(DateTimeFormatter.ofPattern("uuuu -> EEEE dd MMMM"))
            );
            */
            startY=startY.plus(1, ChronoUnit.YEARS);
        }


        //myComple.forEach((k,v)->System.out.println(k+" - "+v));

        Integer[] chiavi = myComple.keySet().toArray(new Integer[0]);
        List<Integer> listaChiavi = Arrays.asList(chiavi);
        listaChiavi.sort(Integer::compareTo);
//        for(Integer anno : listaChiavi){
////            System.out.println(anno + " " + myComple.get(anno));
////        }
        listaChiavi.forEach(k-> System.out.println(k + " " + myComple.get(k)));

    }//end main

}//end class
