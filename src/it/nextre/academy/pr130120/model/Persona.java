package it.nextre.academy.pr130120.model;

public class Persona {
    private String nome;
    private String cognome;
    private int eta;
    private String email;
    private String cf;
    private double salario;

    // public Persona(){}
    public Persona(String nome, String cognome){
        this.nome=nome;
        this.cognome=cognome;
    }

    // inizializzatore di istanza => ogni nuovo oggetto
    {
        System.out.println("Sto per creare un oggetto persona");
    }


    // inizializzatore di classe => una volta sola
    static {
        System.out.println("Caricata la classe Persona");
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public int getEta() {
        return eta;
    }

    public void setEta(int eta) {
        this.eta = eta;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCf() {
        return cf;
    }

    public void setCf(String cf) {
        if (cf!=null && cf.length()==16)
            this.cf = cf;
        else
            System.err.println("cf non valido"); // todo exception...
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    @Override
    public String toString() {
        return "Persona{" +
                "nome='" + nome + '\'' +
                ", cognome='" + cognome + '\'' +
                ", eta=" + eta +
                ", email='" + email + '\'' +
                ", cf='" + cf + '\'' +
                ", salario=" + salario +
                '}';
    }
}//end class
