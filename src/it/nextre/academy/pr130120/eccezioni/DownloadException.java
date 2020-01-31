package it.nextre.academy.pr130120.eccezioni;
// UNchecked
// public class DownloadException extends RuntimeException {
//    public DownloadException(){
//        this("Download Excpetion");
//    }
//    public DownloadException(String msg){
//        super(msg);
//    }
// }

// checked
public class DownloadException extends Exception {
    public DownloadException(){
        this("Download Excpetion");
    }
    public DownloadException(String msg){
        super(msg);
    }
}//end class
