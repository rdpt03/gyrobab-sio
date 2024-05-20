/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gyrobab.core;

import java.time.LocalDate;

/**
 *
 * @author Rafael
 */
public class Louer {
    private LocalDate dateLocation;
    //private String demiJournee;
    private int demiJournee;
    private double prixTotal;
    private static double chiffreAffairesTotal;
    private static int nLocation;
    //private Gestionnaire nomGestionnaireLoueur;//UNUSED
    private Usager usager;//UML
    private Gyropode gyropode;

    public LocalDate getDateLocation() {
        return dateLocation;
    }

    public void setDateLocation(LocalDate dateLocation) {
        this.dateLocation = dateLocation;
    }

    public int getDemiJournee() {
        return demiJournee;
    }

    public void setDemiJournee(int demiJournee) {
        this.demiJournee = demiJournee;
    }

    public double getPrixTotal() {
        return prixTotal;
    }

    public void setPrixTotal(double prixTotal) {
        this.prixTotal = prixTotal;
    }

    public static double getChiffreAffairesTotal() {
        return chiffreAffairesTotal;
    }

    public static void setChiffreAffairesTotal(double chiffreAffairesTotal) {
        Louer.chiffreAffairesTotal = chiffreAffairesTotal;
    }

    public static int getnLocation() {
        return nLocation;
    }

    public static void setnLocation(int nLocation) {
        Louer.nLocation = nLocation;
    }
    /*
    public Gestionnaire getNomGestionnaireLoueur(){/////////////////////////UNUSED
        return this.nomGestionnaireLoueur; 
    }
    
    public void setNomGestionnaireLoueur(Gestionnaire nom){//////////////////UNUSED
        this.nomGestionnaireLoueur = nom;
    }
    */

    public Usager getUsager() {
        return this.usager;
    }

    public void setUsager(Usager usager) {
        this.usager = usager;
    }
    
    //TEMPORRY
    public Louer(Gyropode gyropode ,Usager usager,LocalDate dateLocation, int demiJournee, Tarif tarif){
             ;//A COMPLETAR   
        this.gyropode = gyropode;
        this.usager = usager;
        this.dateLocation = dateLocation;
        this.demiJournee = demiJournee;
        //OBTENIR LE PRIX TOTAL EN EUROS
        double tarifLocation = tarif.getTarif();
        this.prixTotal = tarifLocation * demiJournee;
        //LE PRIX FINAL EST TARIF * DEMI JOURNEE 
    }
    //public Louer(LocalDate dateLocation, int demiJournee, double prixTotal) {
        //this.dateLocation = dateLocation;
        //this.demiJournee = demiJournee;
        //this.prixTotal = prixTotal;
    //}

    @Override
    public String toString() {
        return "louer{" + "dateLocation=" + dateLocation + ", demiJournee=" + demiJournee + ", prixTotal=" + prixTotal + '}';
    }

    
    //METHODS
    
    public void reserver(Gyropode gyropode ,Usager usager,LocalDate dateLocation, int demiJournee, Tarif tarif){
     ;//A COMPLETAR   
    this.gyropode = gyropode;
    this.usager = usager;
    this.dateLocation = dateLocation;
    this.demiJournee = demiJournee;
    //OBTENIR LE PRIX TOTAL EN EUROS
    double tarifLocation = tarif.getTarif();
    this.prixTotal = tarifLocation * demiJournee;
    //LE PRIX FINAL EST TARIF * DEMI JOURNEE 
    
    }
}
