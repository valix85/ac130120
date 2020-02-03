package it.nextre.academy.pr130120.generici;

public class MainLockBox {

    public static void main(String[] args) {

        LockBox<String> pin = new LockBox<>();
        String pwd = pin.setItem("123456");
        System.out.println(pin);
        try {
            System.out.println(pin.getItem(pwd));
        } catch (WrongPasswordException e) {
            System.out.println(e.getMessage());
        }


    }//end main

}//end class
