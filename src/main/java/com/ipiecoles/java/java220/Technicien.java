package com.ipiecoles.java.java220;
import com.ipiecoles.java.java220.exceptions.TechnicienException;
import org.joda.time.LocalDate;

import java.util.Objects;


public class Technicien extends Employe implements Comparable {
    private Integer grade;


    public Technicien() throws TechnicienException {
    }

    public Technicien(String nom, String prenom, String matricule, LocalDate dateEmbauche, Double salaire, Integer grade) {
        super(nom, prenom, matricule, dateEmbauche, salaire);
        this.grade = grade;
    }

    public Integer getGrade() {
        return grade;
    }

    public void setGrade(Integer grade) throws TechnicienException{
        if(grade == null || grade < 1 || grade > 5) {
            throw new TechnicienException(this, grade);
        }
        this.grade = grade;
    }

    @Override
    public Double getPrimeAnnuelle() {
        return (Entreprise.primeAnnuelleBase() + Entreprise.primeAnnuelleBase() * (grade / 10.0) + (Entreprise.PRIME_ANCIENNETE * this.getNombreAnneeAnciennete()));
    }

    @Override
    public void setSalaire(Double salaire) {
        super.setSalaire(salaire * (1 + grade/10d));
    }

    public Integer getNbConges() {
        return super.getNbConges() + this.getNombreAnneeAnciennete();
    }


    @Override
    public int compareTo(Technicien o) {
        return Integer.compare(o.getGrade(), this.grade);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Technicien)) return false;
        if (!super.equals(o)) return false;
        Technicien that = (Technicien) o;
        return Objects.equals(grade, that.grade);
    }

    @Override
    public int hashCode() {

        return Objects.hash(super.hashCode(), grade);
    }

    @Override
    public String toString() {
        return "Technicien{" +
                "grade=" + grade +
                '}' + super.toString();
    }
}
