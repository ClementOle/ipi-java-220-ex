package com.ipiecoles.java.java220;

import org.joda.time.LocalDate;

import java.util.ArrayList;
import java.util.HashSet;


public class Manager extends Employe {

    private HashSet<Technicien> equipe = new HashSet<>();

    public Manager() {
        super();
    }

    public Manager(String nom, String prenom, String matricule, LocalDate dateEmbauche, Double salaire, HashSet<Technicien> equipe) {
        super(nom, prenom, matricule, dateEmbauche, salaire);
        this.equipe = equipe;
    }

    public HashSet<Technicien> getEquipe() {
        return equipe;
    }

    public void setEquipe(HashSet<Technicien> equipe) {
        this.equipe = equipe;
    }

    public void ajoutTechnicienEquipe(Technicien technicien) {
        equipe.add(technicien);
    }

    public void ajoutTechnicienEquipe(String nom, String prenom, String matricule, LocalDate date, Double salaire, Integer grade) {
        Technicien technicien = new Technicien(nom, prenom, matricule, date, salaire, grade);
        equipe.add(technicien);
    }
    @Override
    public void setSalaire(Double salaire) {
        super.setSalaire(salaire*Entreprise.INDICE_MANAGER + (salaire * (double)equipe.size() / 10));
    }

    @Override
    public void augmenterSalaire(Double pourcentage) {
        super.augmenterSalaire(pourcentage);
        augmenterSalaireEquipe(pourcentage);
    }

    private void augmenterSalaireEquipe(Double pourcentage) {
        for(Technicien technicien : equipe) {
            technicien.augmenterSalaire(pourcentage);
        }
    }

    @Override
    public Double getPrimeAnnuelle() {
        return Entreprise.primeAnnuelleBase() + equipe.size() * Entreprise.PRIME_MANAGER_PAR_TECHNICIEN;
    }

    public ArrayList<Technicien> equipeParGrade(){

        return null;
    }


}
