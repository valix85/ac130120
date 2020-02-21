package it.nextre.academy.pr130120.datetime;

import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalQueries;
import java.time.temporal.TemporalQuery;
import java.time.temporal.TemporalUnit;
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
        listaChiavi.forEach(k->System.out.println(k + " " + myComple.get(k)));




        // scomode... usare LocalDate
        Date ieri = new Date();
        long giorno = 24*60*60*1000L;
        ieri.setTime(System.currentTimeMillis()-(24*60*60*1000));
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        System.out.println(sdf.format(ieri));
        Date marzo0385 = new Date();
        int ggPassati = 0;
        while (!sdf.format(marzo0385).equals("03-03-1985")){
            marzo0385 = new Date(marzo0385.getTime()-giorno);
            ggPassati++;
        }
        System.out.println("ms di adesso: " + new Date().getTime());
        System.out.println("ms del 03-03-1985 "+marzo0385.getTime());
        System.out.println("sono passati " + ggPassati + " giorni");


        //Usiamo le LocalDate
        LocalDate adesso = LocalDate.now();
        LocalDate ld3marzo85 = LocalDate.of(1985,Month.MARCH,3);
        System.out.println(
                ld3marzo85.atTime(LocalTime.now())
                        //.toInstant(ZoneOffset.ofHours(1))
                        //.toInstant(OffsetDateTime.now().getOffset())
                        .toInstant(ZonedDateTime.now().getOffset())
                        .toEpochMilli());
        System.out.println(ZonedDateTime.now().getOffset());
        System.out.println(""+
                ld3marzo85.until(adesso).get(ChronoUnit.YEARS)+"-"+
                ld3marzo85.until(adesso).get(ChronoUnit.MONTHS)+"-"+
                ld3marzo85.until(adesso).get(ChronoUnit.DAYS));
        System.out.println(""+
                Duration.between(ld3marzo85.atStartOfDay(),adesso.atStartOfDay()).toDays() );
        System.out.println(ChronoUnit.DAYS.between(ld3marzo85,adesso));
        System.out.println(ChronoUnit.MILLIS.between(LocalDate.EPOCH.atStartOfDay(),ld3marzo85.atStartOfDay()));
        System.out.println(ChronoUnit.MILLIS.between(ld3marzo85.atTime(LocalTime.now()),adesso.atTime(LocalTime.now())));



        // https://docs.oracle.com/javase/tutorial/datetime/iso/queries.html
        // Temporal Queries
        TemporalQuery<TemporalUnit> query = TemporalQueries.precision();
        System.out.printf("LocalDate precision is %s%n",
                LocalDate.now().query(query));
        System.out.printf("LocalDateTime precision is %s%n",
                LocalDateTime.now().query(query));
        System.out.printf("Year precision is %s%n",
                Year.now().query(query));
        System.out.printf("YearMonth precision is %s%n",
                YearMonth.now().query(query));
        System.out.printf("Instant precision is %s%n",
                Instant.now().query(query));


        System.out.println(LocalDate.now().query(TemporalQueries.offset()));
        System.out.println(LocalDateTime.now().query(TemporalQueries.offset()));
        System.out.println(ZonedDateTime.now().query(TemporalQueries.offset()));
        System.out.println(OffsetDateTime.now().query(TemporalQueries.offset()));

        System.out.println(LocalDateTime.now().query(TemporalQueries.localTime()));
        System.out.println(LocalDateTime.now().toLocalTime());
        System.out.println(adesso.plus(3, ChronoUnit.DAYS));
        System.out.println(adesso.plus(3, ChronoUnit.DAYS));



    }//end main

}//end class
