/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gyrobab.core;

import java.time.LocalDate;

/**
 *
 * @author rdasilva
 */
public class ModeleGyropode {
    private String codeModele;
    private String nomModele;
    private String prixModele;
    private LocalDate dateCommercialisation;
    private int vitesse;
    private double autonomieKM;
    private double poids;
    private double encombrement;
    private double gardeAuSol;
    private double poidsMax;
    private int puissance;
    private String caracteristiquesBatterie;
    private int tempsDeChargement;
    private double deniveleMax;
    private String caracteristiquesRoues;
    private String typesDeCirculation;
    private int garantie;
    private String cheminPhoto;
    private Tarif tarifDuGyropode;

    public String getCodeModele() {
        return codeModele;
    }

    public void setCodeModele(String codeModele) {
        this.codeModele = codeModele;
    }

    public String getNomModele() {
        return nomModele;
    }

    public void setNomModele(String nomModele) {
        this.nomModele = nomModele;
    }

    public String getPrixModele() {
        return prixModele;
    }

    public void setPrixModele(String prixModele) {
        this.prixModele = prixModele;
    }

    public LocalDate getDateCommercialisation() {
        return dateCommercialisation;
    }

    public void setDateCommercialisation(LocalDate dateCommercialisation) {
        this.dateCommercialisation = dateCommercialisation;
    }

    public int getVitesse() {
        return vitesse;
    }

    public void setVitesse(int vitesse) {
        this.vitesse = vitesse;
    }

    public double getAutonomieKM() {
        return autonomieKM;
    }

    public void setAutonomieKM(double autonomieKM) {
        this.autonomieKM = autonomieKM;
    }

    public double getPoids() {
        return poids;
    }

    public void setPoids(double poids) {
        this.poids = poids;
    }

    public double getEncombrement() {
        return encombrement;
    }

    public void setEncombrement(double encombrement) {
        this.encombrement = encombrement;
    }

    public double getGardeAuSol() {
        return gardeAuSol;
    }

    public void setGardeAuSol(double gardeAuSol) {
        this.gardeAuSol = gardeAuSol;
    }

    public double getPoidsMax() {
        return poidsMax;
    }

    public void setPoidsMax(double poidsMax) {
        this.poidsMax = poidsMax;
    }

    public int getPuissance() {
        return puissance;
    }

    public void setPuissance(int puissance) {
        this.puissance = puissance;
    }

    public String getCaracteristiquesBatterie() {
        return caracteristiquesBatterie;
    }

    public void setCaracteristiquesBatterie(String caracteristiquesBatterie) {
        this.caracteristiquesBatterie = caracteristiquesBatterie;
    }

    public int getTempsDeChargement() {
        return this.tempsDeChargement;
    }

    public void setTempsDeChargement(int tempsDeChargement) {
        this.tempsDeChargement = tempsDeChargement;
    }

    public double getDeniveleMax() {
        return this.deniveleMax;
    }

    public void setDeniveleMax(double deniveleMax) {
        this.deniveleMax = deniveleMax;
    }

    public String getCaracteristiquesRoues() {
        return this.caracteristiquesRoues;
    }

    public void setCaracteristiquesRoues(String caracteristiquesRoues) {
        this.caracteristiquesRoues = caracteristiquesRoues;
    }

    public String getTypesDeCirculation() {
        return this.typesDeCirculation;
    }

    public void setTypesDeCirculation(String typesDeCirculation) {
        this.typesDeCirculation = typesDeCirculation;
    }

    public int getGarantie() {
        return this.garantie;
    }

    public void setGarantie(int garantie) {
        this.garantie = garantie;
    }

    public String getCheminPhoto() {
        return this.cheminPhoto;
    }

    public void setCheminPhoto(String cheminPhoto) {
        this.cheminPhoto = cheminPhoto;
    }

    public Tarif getTarifDuGyropode() {
        return this.tarifDuGyropode;
    }

    public void setTarifDuGyropode(Tarif tarifDuGyropode) {
        this.tarifDuGyropode = tarifDuGyropode;
    }
    

    public ModeleGyropode(Tarif tarif,String codeModele, String nomModele, String prixModele, LocalDate dateCommercialisation, int vitesse, double autonomieKM, double poids, double encombrement, double gardeAuSol, double poidsMax, int puissance, String caracteristiquesBatterie, int tempsDeChargement, double deniveleMax, String caracteristiquesRoues, String typesDeCirculation, int garantie, String cheminPhoto) {
        this.codeModele = codeModele;
        this.nomModele = nomModele;
        this.prixModele = prixModele;
        this.dateCommercialisation = dateCommercialisation;
        this.vitesse = vitesse;
        this.autonomieKM = autonomieKM;
        this.poids = poids;
        this.encombrement = encombrement;
        this.gardeAuSol = gardeAuSol;
        this.poidsMax = poidsMax;
        this.puissance = puissance;
        this.caracteristiquesBatterie = caracteristiquesBatterie;
        this.tempsDeChargement = tempsDeChargement;
        this.deniveleMax = deniveleMax;
        this.caracteristiquesRoues = caracteristiquesRoues;
        this.typesDeCirculation = typesDeCirculation;
        this.garantie = garantie;
        this.cheminPhoto = cheminPhoto;
    }

    @Override
    public String toString() {
        return "ModeleGyropode{" + "codeModele=" + this.codeModele + ", nomModele=" + this.nomModele + ", prixModele=" + this.prixModele + ", dateCommercialisation=" + this.dateCommercialisation + ", vitesse=" + this.vitesse + ", autonomieKM=" + this.autonomieKM + ", poids=" + this.poids + ", encombrement=" + this.encombrement + ", gardeAuSol=" + this.gardeAuSol + ", poidsMax=" + this.poidsMax + ", puissance=" + this.puissance + ", caracteristiquesBatterie=" + this.caracteristiquesBatterie + ", tempsDeChargement=" + this.tempsDeChargement + ", deniveleMax=" + this.deniveleMax + ", caracteristiquesRoues=" + this.caracteristiquesRoues + ", typesDeCirculation=" + this.typesDeCirculation + ", garantie=" + this.garantie + ", cheminPhoto=" + this.cheminPhoto + ", tarif="+this.tarifDuGyropode+'}';
    }
    
    
    
}
