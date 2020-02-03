package it.nextre.academy.pr130120.pecs;

import java.util.ArrayList;
import java.util.List;

// https://stackoverflow.com/questions/2723397/what-is-pecs-producer-extends-consumer-super


public class PecsMain {

    public static void main(String[] args) {

        List<B> lb = new ArrayList<>();
        //lb.add(new A());
        lb.add(new B());
        lb.add(new C());
        lb.add(new D());


        List<D> ld = new ArrayList<>();
        //elaboraE(lb); // no per wildcard upper bounded
        elaboraE(ld);

        elaboraS(lb);
        //elaboraS(ld); // no per wildcard lower bounded

       //List<String> stringhe = new ArrayList<>();
       //elaboraS(stringhe);

    }//end main

    // Accetto oggetti pari a C o figli quindi:
    // C -> D  e via...
    // sicuramente non potrò aggiungere NIENTE! ogni tipo figlio dovrò garantire di avere tutta la logica di tutti i figli, che però sono INIFNITI.
    // viceversa posso estrarre con la garanzia che il tipo sia almeno quello che estende, sicuramente C, o un suo qualunque padre
    // PRODUCER -> EXTENDS
    public static  void elaboraE(List<? extends C> lista){
        //lista.add(new B());
        //lista.add(new C());
        C tmp1 = lista.get(0);
        B tmp2 = lista.get(0);
        A tmp3 = lista.get(0);
        Object tmp4 = lista.get(0);
    }

    // Accetto oggetti pari a C o padri quindi:
    // Object -> A -> B -> C STOP!
    // CONSUMER -> SUPER
    public static  void elaboraS(List<? super C> lista){
        //lista.add(new B());
        lista.add(new D());
        //C tmp = lista.get(3);
        lista.add(new C()); // da C in giù ho garanzia che siano tutti almeno di tipo C e quindi saranno anche B A e object, di conseguenza qualunque lista io stia utilizzando mi garantisce che da C in giù son tutti suoi figli, ma B, A e Object non possono essere accettati: nel caso mi arrivasse una lista di A o di B il compilatore a priori non lo può sapere, ma sa per certo che qualunque cosa possa essere inserita dovà essere figlia di C per poterci accedere.
        Object tmp = lista.get(0); // posso estrarre l'unico tipo che di per certo è comune a tutti, ovvero Object


    }

}//end class



class A{}
class B extends A{}
class C extends B{}
class D extends C{}