/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gyrobab.core;

import java.time.LocalDate;
import java.time.MonthDay;

/**
 *
 * @author rdasilva
 */
public class Saison {
    private String typeSaison;
    private MonthDay dateDebutSaison;
    private MonthDay dateFinSaison;

    public String getTypeSaison() {
        return typeSaison;
    }

    public void setTypeSaison(String typeSaison) {
        this.typeSaison = typeSaison;
    }

    public MonthDay getLocalDateDebutSaison() {
        return dateDebutSaison;
    }

    public void setLocalDateDebutSaison(MonthDay dateDebutSaison) {
        this.dateDebutSaison = dateDebutSaison;
    }

    public MonthDay getLocalDateFinSaison() {
        return dateFinSaison;
    }

    public void setLocalDateFinSaison(MonthDay dateFinSaison) {
        this.dateFinSaison = dateFinSaison;
    }

    public Saison(String typeSaison, MonthDay dateDebutSaison, MonthDay dateFinSaison) {
        this.typeSaison = typeSaison;
        this.dateDebutSaison = dateDebutSaison;
        this.dateFinSaison = dateFinSaison;
    }

    @Override
    public String toString() {
        //return "Saison{" + "typeSaison=" + typeSaison + ", dateDebutSaison=" + dateDebutSaison + ", dateFinSaison=" + dateFinSaison + '}';
        return typeSaison;
    }
    
    
}
