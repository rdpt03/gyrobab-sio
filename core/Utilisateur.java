/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gyrobab.core;

import java.util.ArrayList;

/**
 *
 * @author Rafael
 */
public abstract class Utilisateur {
    private String mailUtilisateur;
    private String nomUtilisateur;
    private String prenomUtilisateur;
    private String nomDeFamille;
    private static ArrayList<String> listeNomsUtilisateurs = new ArrayList();

    public String getMailUtilisateur() {
        return mailUtilisateur;
    }

    public void setMailUtilisateur(String mailUtilisateur) {
        this.mailUtilisateur = mailUtilisateur;
    }

    public String getNomUtilisateur() {
        return nomUtilisateur;
    }

    public void setNomUtilisateur(String nomUtilisateur) {
        this.nomUtilisateur = nomUtilisateur;
    }

    public String getPrenomUtilisateur() {
        return prenomUtilisateur;
    }

    public void setPrenomUtilisateur(String prenomUtilisateur) {
        this.prenomUtilisateur = prenomUtilisateur;
    }

    public String getNomDeFamille() {
        return nomDeFamille;
    }

    public void setNomDeFamille(String nomDeFamille) {
        this.nomDeFamille = nomDeFamille;
    }
    
    public static ArrayList<String> getListeNomsUtilisateurs() {
        return listeNomsUtilisateurs;
    }

    public static void setListeNomsUtilisateurs(ArrayList<String> listeNomsUtilisateurs) {
        Utilisateur.listeNomsUtilisateurs = listeNomsUtilisateurs;
    }
    
    
    //public static void ajouterUnNomDUtilisateur(String nomUtilisateur){
    //    Utilisateur.listeNomsUtilisateurs.add(nomUtilisateur);
    //}
    public static boolean utilisateurEstPris(String nomUtilisateur){
        if ((listeNomsUtilisateurs.contains(nomUtilisateur))){
            return true;
        }
        else{
            return false;
        }
    }
    
    public Utilisateur(String mailUtilisateur, String nomUtilisateur, String prenomUtilisateur,String nomDeFamille) {
        listeNomsUtilisateurs.add(nomUtilisateur);
        this.mailUtilisateur = mailUtilisateur;
        this.nomUtilisateur = nomUtilisateur;
        this.prenomUtilisateur = prenomUtilisateur;
        this.nomDeFamille = nomDeFamille;
    }

    @Override
    public String toString() {
        return "utilisateur{" + "mailUtilisateur=" + mailUtilisateur + ", nomUtilisateur=" + nomUtilisateur + ", prenomUtilisateur=" + prenomUtilisateur + "}";
    }
    
    
}
