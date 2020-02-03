package it.nextre.academy.pr130120.generici;

// convenzione di nomenclatura per i generici
// T = Type
// K = Key
// V = Value
// E = Element
// N = Number

// questa classe permette il blocco e lo sblocco del contenuto attraverso una password
// eventuale extra: criptare/decriptare il contenuto

import it.nextre.academy.pr130120.myutils.Generator;

import java.util.Random;

public class LockBox<T> {

    private T item;
    private String password;
    private boolean lock;

    public LockBox(T item, String password){
        if (item == null)
            throw new RuntimeException("Invalid item");
        isValidPassword(password);

        this.item=item;
        this.password=password;
        this.lock=true;
    }

    public LockBox(){
        this.lock=false;
    }


    public String setItem(T item){
        if (item == null)
            throw new RuntimeException("Invalid item");
        this.password = getPassword();
        this.item = item;
        this.lock=true;
        return this.password;
    }


    public T getItem(){
        if (!this.lock)
            return this.item;
        throw new RuntimeException("Box locked");
    }

    public boolean isLock(){
        return this.lock;
    }

    public boolean lock(String password){
        isValidPassword(password);
        if (this.password.equals(password)){
            this.lock=!this.lock;
            return true;
        }
        return false;
    }

    // simulo apertura e chiusura in una sola operazione, indipendentemente dal fatto che la scatola sia aperta o chiusa
    public synchronized T getItem(String password) throws WrongPasswordException{
        isValidPassword(password);
        if (this.password.equals(password)){
            return this.item;
        }
        throw new WrongPasswordException("Wrong password");
    }

    private boolean isValidPassword(String password) {
        if (password == null || password.length()==0)
            throw new RuntimeException("Invalid password");
        return true;
    }


    private String getPassword(){
        String pool = "ABCDEFGHIJKLMNOPQRSTUVWXYZqwertyuiopasdfghjklzxcvbnm1234567890$!%@#?";
        int lunghezza = 6;
        String pwd = "";
        Random r = new Random();
        while (pwd.length()<lunghezza){
            pwd+=pool.charAt(r.nextInt(pool.length()));
        }
        return pwd;
    }


    @Override
    public String toString() {
        return "LockBox{" +
                "item=" + (item !=null ? "present ":"not present") +
                ", lock=" + lock +
                '}';
    }
}//end class
