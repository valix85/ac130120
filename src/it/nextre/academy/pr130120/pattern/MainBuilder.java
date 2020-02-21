package it.nextre.academy.pr130120.pattern;

import it.nextre.academy.pr130120.pattern.builder.Telefono;
import it.nextre.academy.pr130120.pattern.builder.TelefonoBuilder;

public class MainBuilder {
    public static void main(String[] args) {

        TelefonoBuilder tb = new TelefonoBuilder().setMarca("One Plus").setModello("7").setMemoriaGb(256);

        Telefono op7 = tb.getTelefono();

        Telefono iPhone8s = new TelefonoBuilder()
                .setMarca("apple")
                .setModello("8s")
                .setMemoriaGb(64)
                .getTelefono();


        System.out.println(op7);
        System.out.println(iPhone8s);

    }//end main
}//end class
