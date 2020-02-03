package it.nextre.academy.pr130120.generici;

public class WrongPasswordException extends Exception {
    public WrongPasswordException(String mex) {
        super(mex);
    }
    public WrongPasswordException() {
        this("wrong password");
    }
}//end class
