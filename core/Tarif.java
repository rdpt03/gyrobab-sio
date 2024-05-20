/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gyrobab.core;

/**
 *
 * @author rdasilva
 */
public class Tarif {
    private double tarif;
    private Saison saison;

    public double getTarif() {
        return tarif;
    }

    public void setTarif(double tarif) {
        this.tarif = tarif;
    }

    public Saison getSaison() {
        return saison;
    }

    public void setSaison(Saison saison) {
        this.saison = saison;
    }

    
    public Tarif(Saison saison, double tarif) {
        this.saison = saison;
        this.tarif = tarif;
    }

    
    @Override
    public String toString() {
        return "Tarif{Saison="+saison.getTypeSaison() + ", tarif=" + tarif + '}';
    }
    
    
}
