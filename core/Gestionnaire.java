/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gyrobab.core;

import gyrobab.core.Utilisateur;
import gyrobab.core.TypePieceIdentite;
import gyrobab.core.Usager;

import java.time.MonthDay;
import java.util.ArrayList;
import java.time.LocalDate;

/**
 *
 * @author Rafael
 */
public class Gestionnaire extends Utilisateur {
    private LocalDate dateEmbauche;
    private LocalDate finContrat;
    private String typeEmploi;
    //USAGERS
    private static ArrayList<Usager> usagers = new ArrayList<>();

    //AJOUTER UNE MARQUE PAS DANS L'UML
    private static ArrayList<MarqueGyropode> marquesDesGyropodes = new ArrayList<>(); //MARQUE DES GYROPODES
    private static ArrayList<ModeleGyropode> modeleDesGyropodes = new ArrayList<>();//Modeles GYROPODE
    private static ArrayList<Saison> listeDesSaisons = new ArrayList<>();//SAISONS
    private static ArrayList<Tarif> listeDesTarifs = new ArrayList<>();//tarifications
    private static ArrayList<Guidon> listeDesGuidons = new ArrayList<>();
    private static ArrayList<Monoroue> listeDesMonoroues = new ArrayList<>();
    private static ArrayList<Plateau> listeDesPlateaux = new ArrayList<>();//gyropodes

    private static ArrayList<TypePieceIdentite> listeTypePieceIdentite = new ArrayList<>();


    public LocalDate getDateEmbauche() {
        return dateEmbauche;
    }

    public void setDateEmbauche(LocalDate dateEmbauche) {
        this.dateEmbauche = dateEmbauche;
    }

    public static void setMarquesDesGyropodes(ArrayList<MarqueGyropode> marquesDesGyropodes) {
        Gestionnaire.marquesDesGyropodes = marquesDesGyropodes;
    }

    public static void setModeleDesGyropodes(ArrayList<ModeleGyropode> modeleDesGyropodes) {
        Gestionnaire.modeleDesGyropodes = modeleDesGyropodes;
    }

    public static void setListeDesSaisons(ArrayList<Saison> listeDesSaisons) {
        Gestionnaire.listeDesSaisons = listeDesSaisons;
    }

    public static void setListeDesTarifs(ArrayList<Tarif> listeDesTarifs) {
        Gestionnaire.listeDesTarifs = listeDesTarifs;
    }

    public static void setListeDesGuidons(ArrayList<Guidon> listeDesGuidons) {
        Gestionnaire.listeDesGuidons = listeDesGuidons;
    }

    public static void setListeDesMonoroues(ArrayList<Monoroue> listeDesMonoroues) {
        Gestionnaire.listeDesMonoroues = listeDesMonoroues;
    }

    public static void setListeDesPlateaux(ArrayList<Plateau> listeDesPlateaux) {
        Gestionnaire.listeDesPlateaux = listeDesPlateaux;
    }

    public static ArrayList<TypePieceIdentite> getListeTypePieceIdentite() {
        return listeTypePieceIdentite;
    }

    public static void setListeTypePieceIdentite(ArrayList<TypePieceIdentite> listeTypePieceIdentite) {
        Gestionnaire.listeTypePieceIdentite = listeTypePieceIdentite;
    }
    //-----------------------------------------------------------------------------------
    public LocalDate getLocalDateEmbauche() {
        return dateEmbauche;
    }

    public void setLocalDateEmbauche(LocalDate dateEmbauche) {
        this.dateEmbauche = dateEmbauche;
    }

    public LocalDate getFinContrat() {
        return finContrat;
    }

    public void setFinContrat(LocalDate finContrat) {
        this.finContrat = finContrat;
    }

    public String getTypeEmploi() {
        return typeEmploi;
    }

    public void setTypeEmploi(String typeEmploi) {
        this.typeEmploi = typeEmploi;
    }

    public static ArrayList<Usager> getUsagers() {
        return usagers;
    }

    public static void setUsagers(ArrayList<Usager> usagers) {
        Gestionnaire.usagers = usagers;
    }

    //CONTRUCT E TOSTRING
    public Gestionnaire(String mailUtilisateur, String nomUtilisateur, String prenomUtilisateur, String nomDeFamille, LocalDate dateEmbauche, LocalDate finContrat, String typeEmploi) {
        super(mailUtilisateur, nomUtilisateur, prenomUtilisateur,nomDeFamille);
        this.dateEmbauche = dateEmbauche;
        this.finContrat = finContrat;
        this.typeEmploi = typeEmploi;
    }

    @Override
    public String toString() {
        return super.toString()+"Gestionnaire{" + "dateEmbauche=" + dateEmbauche + ", finContrat=" + finContrat + ", typeEmploi=" + typeEmploi + '}';
    }

    
    
    

    //METHODES MARQUE GYROPODES
    //TO ADD ON UML
    public static void ajouterMarque(String nom, String siteWeb, String nomCommercial, String telCommercial, String mailCommercial, String nomSAV, String telSAV, String mailSAV){
        marquesDesGyropodes.add(new MarqueGyropode(nom,siteWeb,nomCommercial,telCommercial,mailCommercial,nomSAV,telSAV,mailSAV));
    }
    public static void modifierMarqueDesGyropodes(MarqueGyropode marque, String nom, String siteWeb, String nomCommercial, String telCommercial, String mailCommercial, String nomSAV, String telSAV, String mailSAV){
        marque.setNom(nom);
        marque.setSiteWeb(siteWeb);
        marque.setNomCommercial(nomCommercial);
        marque.setTelCommercial(telCommercial);
        marque.setMailCommercial(mailCommercial);
        marque.setNomSAV(nomSAV);
        marque.setTelSAV(telSAV);
        marque.setMailSAV(mailSAV);
    }
    public static void supprimerMarqueDesGyropodes(MarqueGyropode marque){
        marquesDesGyropodes.remove(marque);
    }


    //METHODE Modeles GYROPODE
    public static void ajouterModele(Tarif tarif,String codeModele, String nomModele, String prixModele, LocalDate dateCommercialisation, int vitesse, double autonomieKM, double poids, double encombrement, double gardeAuSol, double poidsMax, int puissance, String caracteristiquesBatterie, int tempsDeChargement, double deniveleMax, String caracteristiquesRoues, String typesDeCirculation, int garantie, String cheminPhoto){
        modeleDesGyropodes.add(new ModeleGyropode(tarif,codeModele,nomModele,prixModele,dateCommercialisation,vitesse,autonomieKM,poids,encombrement,gardeAuSol,poidsMax,puissance,caracteristiquesBatterie,tempsDeChargement,deniveleMax,caracteristiquesRoues,typesDeCirculation, garantie,cheminPhoto));
    }
    public static void modifierModele(){}
    public static void supprimerModele(ModeleGyropode modele){
        modeleDesGyropodes.remove(modele);
    }



    //METHODES SAISONS
    public static void ajouterSaisons(String typeSaison, MonthDay dateDebutSaison, MonthDay dateFinSaison){
        listeDesSaisons.add(new Saison(typeSaison,dateDebutSaison, dateFinSaison));
    }
    public static void modifierSaisons(Saison saison, String typeSaison, MonthDay dateDebut,MonthDay dateFin){
        saison.setTypeSaison(typeSaison);
        saison.setLocalDateDebutSaison(dateDebut);
        saison.setLocalDateFinSaison(dateFin);
    }
    public static void supprimerSaisons(Saison saison){
        listeDesSaisons.remove(saison);
    }



    //methodes tarifications
    public static void ajouterTarif(Saison saison, double tarif){
        listeDesTarifs.add(new Tarif(saison,tarif));
    }
    public static void modifierTarif(Tarif tarif,Saison saison,double prix){
        tarif.setTarif(prix);
        tarif.setSaison(saison);
    }
    public static void supprimerTarif(Tarif tarif){
        listeDesTarifs.remove(tarif);
    }



    //methodes Usagers (ver se tenho ou nao)
    public static void ajouterUsager(String mailUtilisateur, String nomUtilisateur, String prenomUtilisateur, String nomDeFamille, LocalDate dateNaissance, String nPieceIdentite, TypePieceIdentite typePCIdentite){

        ArrayList listeNomsUtilisateurs = Utilisateur.getListeNomsUtilisateurs();
        if ((listeNomsUtilisateurs.contains(nomUtilisateur))){
            System.out.println("Desolé, mais le nom d'utilisateur "+nomUtilisateur+" est déjà pris.");
        }
        else{
            usagers.add(new Usager(mailUtilisateur, nomUtilisateur, prenomUtilisateur, nomDeFamille, dateNaissance, nPieceIdentite, typePCIdentite));
        }
    }
    /*public String getListeUsagers(){
        String listeDeUsagers = "";
        for(int i=0;i<usagers.size();i++){
            listeDeUsagers =+ i+" : "+usagers.get(i)+"\n";
        }
        return listeDeUsagers;
    }*/

    public static void modifierUsager(Usager usager,String prenomUsager,String nomUsager,String nomUtilisateurUsager,
                                      String mailUsager,TypePieceIdentite typePieceIdentiteUsager,String nPieceIdentiteUsager,
                                      LocalDate dateDeNaissanceUsager){
        usager.setPrenomUtilisateur(prenomUsager);
        usager.setNomDeFamille(nomUsager);
        usager.setNomUtilisateur(nomUtilisateurUsager);
        usager.setMailUtilisateur(mailUsager);
        usager.setTypePieceIdentite(typePieceIdentiteUsager);
        usager.setnPieceIdentite(nPieceIdentiteUsager);
        usager.setDateNaissance(dateDeNaissanceUsager);

    }
    public static void supprimerUsager(Usager usager){
        usagers.remove(usager);
    }



    //methodees gyropodes
    public static void ajouterGuidon(MarqueGyropode marqueDuGyropode, double hauterGuidon, double volCoffreLateral, double volCoffreAvant, double surfacePorteBagage, String nRference, String nSerieConstructeur, String couleur, LocalDate dateAchat, int nUtilisations, double nKmEffectue, double nHeureRoule, double latitude, double longitude, double niveauBatterie, double dureeRouageRestant, double tempsRechargeEstime, boolean bloque, boolean enMaintenance) {
        listeDesGuidons.add(new Guidon(marqueDuGyropode, hauterGuidon, volCoffreLateral, volCoffreAvant, surfacePorteBagage, nRference, nSerieConstructeur, couleur, dateAchat, nUtilisations, nKmEffectue, nHeureRoule, latitude, longitude, niveauBatterie, dureeRouageRestant, tempsRechargeEstime, bloque, enMaintenance));
    }

    public static void ajouterMonoroue(MarqueGyropode marqueDuGyropode, String typeFreinGyroscopique, String systemeCalePieds, String systemeDePoigneeDemport, String nRference, String nSerieConstructeur, String couleur, LocalDate dateAchat, int nUtilisations, double nKmEffectue, double nHeureRoule, double latitude, double longitude, double niveauBatterie, double dureeRouageRestant, double tempsRechargeEstime, boolean bloque, boolean enMaintenance) {
        listeDesMonoroues.add(new Monoroue(marqueDuGyropode, typeFreinGyroscopique, systemeCalePieds, systemeDePoigneeDemport, nRference, nSerieConstructeur, couleur, dateAchat, nUtilisations, nKmEffectue, nHeureRoule, latitude, longitude, niveauBatterie, dureeRouageRestant, tempsRechargeEstime, bloque, enMaintenance));
    }

    public static void ajouterPlateau(MarqueGyropode marqueDuGyropode, String systemeAutoEquilibrage, boolean sacDeTransport, String systemeDetorsion, String typePatin, String nRference, String nSerieConstructeur, String couleur, LocalDate dateAchat, int nUtilisations, double nKmEffectue, double nHeureRoule, double latitude, double longitude, double niveauBatterie, double dureeRouageRestant, double tempsRechargeEstime, boolean bloque, boolean enMaintenance) {
        listeDesPlateaux.add(new Plateau(marqueDuGyropode, systemeAutoEquilibrage, sacDeTransport, systemeDetorsion, typePatin, nRference, nSerieConstructeur, couleur, dateAchat, nUtilisations, nKmEffectue, nHeureRoule, latitude, longitude, niveauBatterie, dureeRouageRestant, tempsRechargeEstime, bloque, enMaintenance));
    }

    public static void modifierGuidon(Guidon gyropode) {
        // Implemente a lógica para modificar um Guidon
    }

    public static void modifierMonoroue(Monoroue gyropode) {
        // Implemente a lógica para modificar um Monoroue
    }

    public static void modifierPlateau(Plateau gyropode) {
        // Implemente a lógica para modificar um Plateau
    }

    public static void supprimerGuidon(Guidon gyropode) {
        listeDesGuidons.remove(gyropode);
    }

    public static void supprimerMonoroue(Monoroue gyropode) {
        listeDesMonoroues.remove(gyropode);
    }

    public static void supprimerPlateau(Plateau gyropode) {
        listeDesPlateaux.remove(gyropode);
    }

    // Getters para cada lista

    public static ArrayList<MarqueGyropode> getMarquesDesGyropodes() {
        return marquesDesGyropodes;
    }

    public static ArrayList<ModeleGyropode> getModeleDesGyropodes() {
        return modeleDesGyropodes;
    }

    public static ArrayList<Saison> getListeDesSaisons() {
        return listeDesSaisons;
    }

    public static ArrayList<Tarif> getListeDesTarifs() {
        return listeDesTarifs;
    }

    public static ArrayList<Guidon> getListeDesGuidons() {
        return listeDesGuidons;
    }

    public static ArrayList<Monoroue> getListeDesMonoroues() {
        return listeDesMonoroues;
    }

    public static ArrayList<Plateau> getListeDesPlateaux() {
        return listeDesPlateaux;
    }
    //Liste des Usagers


    //TypePieceIdentite

    public static void ajouterTypePieceIdentite(String codePieceIdentite,String libellePieceIdentite) {
        listeTypePieceIdentite.add(new TypePieceIdentite(codePieceIdentite,libellePieceIdentite));
    }
    public static void modifierTypePieceIdentite(Guidon gyropode) {
        // Implemente a lógica para modificar um listeTypePieceIdentite
    }

    public static void supprimerTypePieceIdentite(Plateau gyropode) {
        listeTypePieceIdentite.remove(gyropode);
    }
}
