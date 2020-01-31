package it.nextre.academy.pr130120.myutils;

public class Generator {

    public static final String[] nomi={"Alessandro","Alessia","Alessio","Alfio","Alfonsina","Alfonso","Alvaro","Alvina","Amalia","Andromeda","Arabella","Edoardo","Aquilino","Fosco","Tirone","Feliciano","Democrito","Siricio","Vladimiro","Filomeno","Egeo","Cremenzio","Giada","Tecla","Fiore","Ildegonda","Fedora","Federica","Liliana","Palladia","Olinda","Abbondanza","Fiorella","Bartolomea","Foca","Quartilla","Elena","Mimma","Olimpia","Alice","Glenda","Solocone","Massimiliano","Abibo","Adalardo","Sigismondo","Alvise","Giove","Bino","Cesario","Eulalia","Italia","Ludovica","Ottilia","Cassiopea","Egizia","Samanta","Armida","Ondina","Viliberto","Folco","Pasquale","Giosuele","Umile","Ultimo","Gordiano","Guelfo","Metello","Adelgardo"};

    public static final String[] cognomi={"Rossi","Ferrari","Russo","Bianchi","Romano","Gallo","Costa","Fontana","Cointi","Esposito","Ricci","Tortorello","Laura","Taddei","Scavuzzo","Vittori","Inglese","Fittipaldi","Gardella","Frate","Zuccaro","Talerico","Fracassi","Valenzano","Centore","Marcella","Tudisco","Zumpano","Scalice","Zarro","Gugino","Menotti","Grandi","Guzzi","Maranto","Marocco","Poveromo","Delucia","Marsella","Monterosso","D'Alessandro","Mangino","Lipari","D'Aquila","Rado","Petruccelli","Livolsi","Bernardi","Foppiano","Figone","Catizone","Granucci","Eppolito","Magrini","Turturro","Vaccariello","Cimaglia","Spadaro","Cara","Accomando","LaMacchia","Blandino","Ognibene","Paliotta","Mastrogiacomo","Scarpaci","Biscardi","Landini"};



    public static final String[] domini={"gmail","aruba","outlook","yahoo","hotmail","alice","tiscali"};
    public static final String[] suffissi={"com","it","net","de","uk","org"};
    public static final String[] indirizzo={"Via","Piazza","Viale","Alzaia","Strada privata","Vicolo","Recinto"};

    public static String generaTelefono(){
        return generaSequenzaNumerica(8);
    }
    public static String generaSequenzaNumerica(int lunghezza){
        String out="";
        for (int i = 0; i < lunghezza; i++) {
            out+=Operations.getRandomInt(0,10);
        }//end for
        return out;
    }
    public static String generaTelefono(int lunghezza, String prefix){
        if (prefix == null)prefix="";
        return prefix + generaSequenzaNumerica(lunghezza);
    }
    public static String generaCap(){
        return generaSequenzaNumerica(5);
    }
    public static String genaraStringa(int lunghezza,boolean toUpperCase){
        String stringa="";
        for (int i = 0; i < lunghezza; i++) {
            int carattere=Operations.getRandomInt(97,123);
            stringa+=((char)carattere);
        }//end for
        if(toUpperCase){
            stringa=stringa.toUpperCase();
        }
        return stringa;
    }
    public static String genaraStringa(int lunghezza){
        String stringa="";
        for (int i = 0; i < lunghezza; i++) {
            int carattere=Operations.getRandomInt(97,123);
            stringa+=((char)carattere);
        }//end for
        return stringa;
    }
    public static String generaPassword(int lunghezza){
        lunghezza=(lunghezza>=8)?lunghezza:8;
        String password = "";
        for (int i = 0; i < lunghezza; i++) {
            int elemento=Operations.getRandomInt(33,127);
            password+=((char)elemento);
        }//end for
        return password;
    }
    public static String generaMail(String nomi, String cognomi){

        String nome=nomi.toLowerCase();
        String cognome= cognomi.toLowerCase();
        int dominiIndex=Operations.getRandomInt(0,(domini.length));
        int suffissiIndex=Operations.getRandomInt(0,(suffissi.length));
        String email=nome+"."+cognome+"@"+domini[dominiIndex]+"."+suffissi[suffissiIndex];
        return email.toLowerCase();
    }
    public static String generaMail(){
        return generaMail(generaNome(),generaCognome());
    }
    public static String generaNome(){

        int nomiIndex=Operations.getRandomInt(0,(nomi.length));
        String nome=nomi[nomiIndex];
        return nome;
    }
    public static String generaCognome(){

        int cognomiIndex=Operations.getRandomInt(0,(cognomi.length));
        String cognome=cognomi[cognomiIndex];
        return cognome;
    }
    public static String generaVia(){

        int indirizzoIndex=Operations.getRandomInt(0,indirizzo.length);
        return indirizzo[indirizzoIndex]+" "+generaNome()+" "+generaCognome()+", "+Operations.getRandomInt(1,301);
    }
    public static int generaEta(){
        return Operations.getRandomInt(0,120);
    }
    public static String generaGenre(){
        int eta=Operations.getRandomInt(0,3);
        if(eta==0){
            return "Uomo";
        }else if (eta==2){
            return "Donna";
        }else {
            return "Altro";
        }
    }


}//end class
