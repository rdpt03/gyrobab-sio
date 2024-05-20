/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gyrobab.core;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;


/**
 *
 * @author Rafael
 */
public class Usager extends Utilisateur{
    private LocalDate dateNaissance;
    private static int ageMoyenne;
    private String nPieceIdentite;
    private TypePieceIdentite typePieceIdentite;

    public LocalDate getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(LocalDate dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    public static int getAgeMoyenne() {
        return ageMoyenne;
    }

    public static void setAgeMoyenne(int ageMoyenne) {
        Usager.ageMoyenne = ageMoyenne;
    }

    public String getnPieceIdentite() {
        return nPieceIdentite;
    }

    public void setnPieceIdentite(String nPieceIdentite) {
        this.nPieceIdentite = nPieceIdentite;
    }

    public TypePieceIdentite getTypePieceIdentite() {
        return typePieceIdentite;
    }

    public void setTypePieceIdentite(TypePieceIdentite typePieceIdentite) {
        this.typePieceIdentite = typePieceIdentite;
    }

    /**
     *
     * @param dateNaissance
     * @param nPieceIdentite
     */
    public Usager(String mailUtilisateur, String nomUtilisateur, String prenomUtilisateur,String nomDeFamille,LocalDate dateNaissance, String nPieceIdentite, TypePieceIdentite typePCIdentite) {
        super(mailUtilisateur, nomUtilisateur, prenomUtilisateur, nomDeFamille);
        this.dateNaissance = dateNaissance;
        this.nPieceIdentite = nPieceIdentite;
        this.typePieceIdentite = typePCIdentite;
    }

    @Override
    public String toString() {
        return "Usager{"+ super.toString() + "dateNaissance=" + dateNaissance + ", nPieceIdentite=" + nPieceIdentite + '}';
    }
    
    //METHODS
    public int obtenirAgeUsager() {
        LocalDate dateActuel = LocalDate.now();
        LocalDate dateNaissanceUtilisateur = this.getDateNaissance();
        //date de naissande de l'utilisateur en localdate
        
        
        Period periode = Period.between(dateNaissanceUtilisateur, dateActuel);
        
        return periode.getYears();
    }
    public static int obtenirAgeMoyenne() {
        ArrayList<Usager> usagers = Gestionnaire.getUsagers();
        int sommeAgeTotal = 0;
        int ageMoyenneTotal = 0;
        int totalDeUtilisateurs = usagers.size();
        
        //System.out.println(totalDeUtilisateurs);
        
        for (int i=0;i<usagers.size();i++) {
            //System.out.println(i);
            sommeAgeTotal = sommeAgeTotal + usagers.get(i).obtenirAgeUsager();
            
            //System.out.println(usagers.get(i));
            
            //System.out.println("BOUCLEAGETOTAL:"+sommeAgeTotal);
        }
        ageMoyenneTotal = sommeAgeTotal / totalDeUtilisateurs;
        return ageMoyenneTotal;
    }  
    
}
