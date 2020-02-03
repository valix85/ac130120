package it.nextre.academy.pr130120.enums;

public enum Carburante {
    BENZINA(1.89),
    DIESEL(1.72),
    GPL(1.62){
        @Override
        public String toString() {
            return this.name();
        }
    },
    METANO(1.64),
    ELETTRICO(1.58);

    private double eurokm;
    Carburante(double pricekm){
        eurokm=pricekm;
    }

    public double getEurokm() {
        return eurokm;
    }

    @Override
    public String toString() {
        return "Carburante{" +
                this.name()+" -> " +
                "eurokm=" + eurokm +
                '}';
    }
}
