package com.ipiecoles.java.java220;

import org.joda.time.LocalDate;

public class Entreprise {
    public static Double SALAIRE_BASE = 1480.27;
    public static Integer NB_CONGES_BASE = 25;
    public static Double INDICE_MANAGER = 1.3;
    public static Double PRIME_MANAGER_PAR_TECHNICIEN = 250d;
    public static Double PRIME_ANCIENNETE = 100d;

    public static Double primeAnnuelleBase(){
        return LocalDate.now().getYear()/2d;
    }
}

