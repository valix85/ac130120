package it.nextre.academy.pr130120.lambda;

import it.nextre.academy.pr130120.pattern.builder.Telefono;
import it.nextre.academy.pr130120.pattern.builder.TelefonoBuilder;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class MainTelefoni {

    public static void main(String[] args) {

        List<Telefono> negozio = new ArrayList<>();

        negozio.add(new TelefonoBuilder()
                .setMarca("apple")
                .setModello("XS")
                .setMemoriaGb(64)
                .setColore("nero")
                .setTipoSchermo("AMOLED")
                .setSchermo("6")
                .setMhBatteria(3300)
                .getTelefono());


        negozio.add(new TelefonoBuilder()
                .setMarca("apple")
                .setModello("11")
                .setMemoriaGb(128)
                .setColore("nero")
                .setTipoSchermo("AMOLED")
                .setSchermo("6,5")
                .setMhBatteria(3800)
                .getTelefono());


        negozio.add(new TelefonoBuilder()
                .setMarca("Huawei")
                .setModello("P30 Lite")
                .setMemoriaGb(64)
                .setColore("blu")
                .setTipoSchermo("AMOLED")
                .setSchermo("6")
                .setMhBatteria(4300)
                .getTelefono());


        negozio.add(new TelefonoBuilder()
                .setMarca("Samsung")
                .setModello("A50")
                .setMemoriaGb(32)
                .setColore("bianco")
                .setTipoSchermo("IPS")
                .setSchermo("6")
                .setMhBatteria(3500)
                .getTelefono());


        negozio.add(new TelefonoBuilder()
                .setMarca("OnePlus")
                .setModello("7 pro")
                .setMemoriaGb(256)
                .setColore("nero")
                .setTipoSchermo("AMOLED")
                .setSchermo("6,8")
                .setMhBatteria(4500)
                .getTelefono());


        System.out.println(negozio);


        System.out.println("---".repeat(10)+"\n");

        negozio.stream()
                .filter(t->t.getColore().toLowerCase().contains("blu"))
                .collect(Collectors.toList())
                .forEach(System.out::println);




        System.out.println("---".repeat(10)+"\n");

        negozio.stream()
                .filter(t->t.getMarca().equalsIgnoreCase("apple"))
                //.filter(t->NegozioTelefonia.getApple(t))
                //.filter(NegozioTelefonia::getApple)
                .collect(Collectors.toList())
                .forEach(System.out::println);




        System.out.println("---".repeat(10)+"\n");

        negozio.stream()
                .filter(NegozioTelefonia::getSamsung)
                .collect(Collectors.toList())
                .forEach(System.out::println);



        System.out.println("---".repeat(10)+"\n");

        negozio.stream()
                .filter(t->NegozioTelefonia.getByMarca(t,"OnePlus"))
                .collect(Collectors.toList())
                .forEach(System.out::println);




        System.out.println("---".repeat(10)+"\n");
        // partition usa un booleano per dividere il gruppo
        // appartiene o no sulla base di una codizione stipulata da un predicato
        // es: tutti i telefoni apple e gli altri--> isApple?
        Map<Boolean, List<Telefono>> isApple =
        negozio.stream()
                .collect(Collectors.partitioningBy(NegozioTelefonia::getApple));

        System.out.println(isApple.get(true).size());



        System.out.println("---".repeat(10)+"\n");
        // grouping usa un valore per dividere il gruppo
        // appartiene o no a un gruppo sulla base di un identificatore del gruppo
        // es: tutti i telefoni divisi per colore
        Map<String, List<Telefono>> byColor =
                negozio.stream()
                        .collect(Collectors.groupingBy(t->t.getColore(), Collectors.toList()));

        System.out.println(byColor.keySet());

        System.out.println("---".repeat(10)+"\n");
        // grouping usa un valore per dividere il gruppo
        // appartiene o no a un gruppo sulla base di un identificatore del gruppo
        // es: quanti sono i telefoni, divisi per colore
        Map<String, Long> byColorCount =
                negozio.stream()
                        .collect(Collectors.groupingBy(t->t.getColore(), Collectors.counting()));

        System.out.println(byColorCount);




        System.out.println("---".repeat(10)+"\n");
        // grouping usa un valore per dividere il gruppo
        // appartiene o no a un gruppo sulla base di un identificatore del gruppo
        // es: quanti sono i telefoni di ogni marca
        Map<String, Long> byMarcaCount =
                negozio.stream()
                        .map(t->t.getMarca())
                        .collect(Collectors.groupingBy(t->t, Collectors.counting()));

        System.out.println(byMarcaCount);




        System.out.println("---".repeat(10)+"\n");
        // grouping usa un valore per dividere il gruppo
        // appartiene o no a un gruppo sulla base di un identificatore del gruppo
        // es: quanti sono i telefoni di marca apple
        Map<String, Long> byMarcaAppleCount =
                negozio.stream()
                        .map(t->t.getMarca())
                        .collect(Collectors.groupingBy(m->
                                m.equalsIgnoreCase("apple")?"apple":"altri"
//                            {
//                                if (m.equalsIgnoreCase("apple")){
//                                    return "apple";
//                                }else{
//                                    return "altri";
//                                }
//                            }
                            , Collectors.counting()));

        System.out.println(byMarcaAppleCount);



    }//end main

}//end class



class NegozioTelefonia {

    public static boolean getApple(Telefono t){
        return t.getMarca().equalsIgnoreCase("apple");
    }

    public static boolean getSamsung(Telefono t){
        return t.getMarca().equalsIgnoreCase("Samsung");
    }

    public static boolean getHuawei(Telefono t){
        return t.getMarca().equalsIgnoreCase("Huawei");
    }

    public static boolean getByMarca(Telefono t, String marca){
        return t.getMarca().equalsIgnoreCase(marca);
    }

}
