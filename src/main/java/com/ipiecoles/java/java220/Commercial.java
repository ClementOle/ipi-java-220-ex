package com.ipiecoles.java.java220;

import org.joda.time.LocalDate;

import java.util.Objects;

public class Commercial extends Employe{
    private Double caAnnuel = 0d;
    private Integer performance = 0;

    public Commercial(){
        super();
    }

    public Commercial(String nom, String prenom, String matricule, LocalDate dateEmbauche, Double salaire, Double caAnnuel) {
        super(nom, prenom, matricule, dateEmbauche, salaire);
        this.caAnnuel = caAnnuel;
    }

    public Commercial(String nom, String prenom, String matricule, LocalDate dateEmbauche, Double salaire, Double caAnnuel, Integer performance) {
        this(nom, prenom, matricule, dateEmbauche, salaire, caAnnuel);
        this.performance = performance;
    }

    public void setCaAnnuel(Double caAnnuel) {
        this.caAnnuel = caAnnuel;
    }

    public Double getCaAnnuel() {
        return caAnnuel;
    }

    @Override
    public Double getPrimeAnnuelle() {
        if (this.getCaAnnuel() != null) {
            return Math.max(Math.ceil(this.getCaAnnuel() * 0.05), 500);
        }
        return 500d;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Commercial)) return false;
        if (!super.equals(o)) return false;
        Commercial that = (Commercial) o;
        return Objects.equals(caAnnuel, that.caAnnuel);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), caAnnuel);
    }

    public Boolean performanceEgale(Integer performance){
        return Objects.equals(this.performance ,performance);
    }

    public Note equivalenceNote() {
        switch(this.performance) {
            case 0:
            case 50:
                return Note.INSUFFISANT;
            case 100:
                return Note.PASSABLE;
            case 150:
                return Note.BIEN;
            case 200:
                return Note.TRES_BIEN;
            default:
                return null;
        }
    }


}
