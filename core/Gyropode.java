/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gyrobab.core;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author rlarralde
 */
public abstract class Gyropode {



    private String nRference;
    private String nSerieConstructeur;
    private String couleur;
    private LocalDate dateAchat;
    private int nUtilisations;
    private double nKmEffectue;
    private double nHeureRoule;
    private double latitude;
    private double longitude;
    private double niveauBatterie;
    private double dureeRouageRestant;
    private double tempsRechargeEstime;
    private boolean bloque;
    private boolean enMaintenance;
    private static int nUtilisationsTotal;
    private static double nKmTotal;
    private static double nHeuresTotal;
    private MarqueGyropode marqueDuGyropode;

    public String getnRference() {
        return nRference;
    }

    public void setnRference(String nRference) {
        this.nRference = nRference;
    }

    public String getnSerieConstructeur() {
        return nSerieConstructeur;
    }

    public void setnSerieConstructeur(String nSerieConstructeur) {
        this.nSerieConstructeur = nSerieConstructeur;
    }

    public String getCouleur() {
        return couleur;
    }

    public void setCouleur(String couleur) {
        this.couleur = couleur;
    }

    public LocalDate getDateAchat() {
        return dateAchat;
    }

    public void setDateAchat(LocalDate dateAchat) {
        this.dateAchat = dateAchat;
    }

    public int getnUtilisations() {
        return nUtilisations;
    }

    public void setnUtilisations(int nUtilisations) {
        this.nUtilisations = nUtilisations;
    }

    public double getnKmEffectue() {
        return nKmEffectue;
    }

    public void setnKmEffectue(double nKmEffectue) {
        this.nKmEffectue = nKmEffectue;
    }

    public double getnHeureRoule() {
        return nHeureRoule;
    }

    public void setnHeureRoule(double nHeureRoule) {
        this.nHeureRoule = nHeureRoule;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public double getNiveauBatterie() {
        return niveauBatterie;
    }

    public void setNiveauBatterie(double niveauBatterie) {
        this.niveauBatterie = niveauBatterie;
    }

    public double getDureeRouageRestant() {
        return dureeRouageRestant;
    }

    public void setDureeRouageRestant(double dureeRouageRestant) {
        this.dureeRouageRestant = dureeRouageRestant;
    }

    public double getTempsRechargeEstime() {
        return tempsRechargeEstime;
    }

    public void setTempsRechargeEstime(double tempsRechargeEstime) {
        this.tempsRechargeEstime = tempsRechargeEstime;
    }

    public boolean isBloque() {
        return bloque;
    }

    public void setBloque(boolean bloque) {
        this.bloque = bloque;
    }

    public boolean isEnMaintenance() {
        return enMaintenance;
    }

    public void setEnMaintenance(boolean enMaintenance) {
        this.enMaintenance = enMaintenance;
    }

    public static int getnUtilisationsTotal() {
        return nUtilisationsTotal;
    }

    public static void setnUtilisationsTotal(int nUtilisationsTotal) {
        Gyropode.nUtilisationsTotal = nUtilisationsTotal;
    }

    public static double getnKmTotal() {
        return nKmTotal;
    }

    public static void setnKmTotal(double nKmTotal) {
        Gyropode.nKmTotal = nKmTotal;
    }

    public static double getnHeuresTotal() {
        return nHeuresTotal;
    }

    public static void setnHeuresTotal(double nHeuresTotal) {
        Gyropode.nHeuresTotal = nHeuresTotal;
    }

    public MarqueGyropode getMarqueDuGyropode() {
        return this.marqueDuGyropode;
    }

    public void setMarqueDuGyropode(MarqueGyropode marqueDuGyropode) {
        this.marqueDuGyropode = marqueDuGyropode;
    }

    
    
    public double geolocaliserLatidude(){
        return Math.random() * 0.048948 + 43.478843;
    }
    
    public double geolocaliserLongitude(){
        return Math.random() * -0.059698 - 1.463571;
    }
    
    public void bloquer(){
        if(this.bloque == true){
            System.out.println("Desolé, mais ce Gyropode ("+this.nRference+") est deja bloqué.");
        }
        else {
            this.bloque = true;
        }
    }
    
    public void debloquer(){
        if(this.bloque == false){
            System.out.println("Desolé, mais ce Gyropode ("+this.nRference+") est deja debloqué.");
        }
        else {
            this.bloque = false;
        }        
    }
    
    public void mettreEnMaintenance(){
        if(this.enMaintenance == true){
            System.out.println("Desolé, mais ce Gyropode ("+this.nRference+") est deja bloqué.");
        }
        else {
            this.enMaintenance = true;
        }
    }
    
    public void mettreEnSerivce(){
        if(this.enMaintenance == true){
            System.out.println("Desolé, mais ce Gyropode ("+this.nRference+") est deja bloqué.");
        }
        else {
            this.enMaintenance = true;
        }
    }
    
    public void recupererNiveauChargeBatterie(){
        ;
    }
    
    public void recupererRoulageEstime(){
        ;
    }
    
    public void recupererTempsRestantEstimePourCharger(){
        ;
    }
    
    public void majInfo(){
        ;
    }
    
    public Gyropode(MarqueGyropode marqueDuGyropode, String nRference, String nSerieConstructeur, String couleur, LocalDate dateAchat, int nUtilisations, double nKmEffectue, double nHeureRoule, double latitude, double longitude, double niveauBatterie, double dureeRouageRestant, double tempsRechargeEstime, boolean bloque, boolean enMaintenance) {
        this.marqueDuGyropode = marqueDuGyropode;
        this.nRference = nRference;
        this.nSerieConstructeur = nSerieConstructeur;
        this.couleur = couleur;
        this.dateAchat = dateAchat;
        this.nUtilisations = nUtilisations;
        this.nKmEffectue = nKmEffectue;
        this.nHeureRoule = nHeureRoule;
        this.latitude = latitude;
        this.longitude = longitude;
        this.niveauBatterie = niveauBatterie;
        this.dureeRouageRestant = dureeRouageRestant;
        this.tempsRechargeEstime = tempsRechargeEstime;
        this.bloque = bloque;
        this.enMaintenance = enMaintenance;
        Gyropode.nUtilisationsTotal += nUtilisations;
        Gyropode.nKmTotal += nKmEffectue;
        Gyropode.nHeuresTotal += nHeureRoule;
        
        
    }

    @Override
    public String toString() {
        return "Gyropode{Marque="+ this.marqueDuGyropode.getNom() + ", nRference=" + this.nRference + ", nSerieConstructeur=" + this.nSerieConstructeur + ", couleur=" + this.couleur + ", dateAchat=" + this.dateAchat + ", nUtilisations=" + this.nUtilisations + ", nKmEffectue=" + this.nKmEffectue + ", nHeureRoule=" + this.nHeureRoule + ", latitude=" + this.latitude + ", longitude=" + this.longitude + ", niveauBatterie=" + this.niveauBatterie + ", dureeRouageRestant=" + this.dureeRouageRestant + ", tempsRechargeEstime=" + this.tempsRechargeEstime + ", bloque=" + this.bloque + ", enMaintenance=" + this.enMaintenance + "}\n";
    }
    
}
