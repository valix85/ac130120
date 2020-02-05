package it.nextre.academy.pr130120.eccezioni;

import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.Random;

public class PingPong {

    public static void main(String[] args) {

        Ping mittente = new Ping();
        Pong destinatario = new Pong();
        for (int i = 0; i < 10; i++) {
            try {
                mittente.send(destinatario);
            }
            catch(NetworkException e){
                System.out.println("Catturata NetworkException");
                System.out.println("\t"+e.getSystemErrorCode()+"\n");
            }
            //se nessuno la lancia è codice irraggiungibile=>errore di compilazione
            //catch (SQLException e){}
            catch (Exception e){
                System.out.println("Catturata Exception");
            }
        }//end for

    }//end main


}//end class



class Ping{
    public void send(Pong to) throws NetworkException{
        Random r = new Random();
        String response = to.receive(r.nextInt(100));
        if (response.equals("OK")){
            System.out.println("Comunicazione riuscita");
        }else{

            NetworkException tmp = new NetworkException("Errore di comunicazione "+response);
            tmp.setSystemErrorCode("503: Unknown error");
            throw tmp;

        }
    }
}
class Pong{
    public String receive(int data){
        // simulo l'errore di rete (NON SO QUANDO ACCADRA')
        // se il numero è pari rispondo con OK
        // se è dispari ho un errore di comunicazione
        if (data%2==0){
            return "OK";
        }else{
            return "ERROR";
        }
    }
}


class NetworkException extends Exception{
    public NetworkException(String msg){super(msg);}
    public NetworkException(){this("network error");}

    private String systemErrorCode;
    public String getSystemErrorCode() {
        return systemErrorCode;
    }
    public void setSystemErrorCode(String systemErrorCode) {
        this.systemErrorCode = systemErrorCode;
    }
}// end class