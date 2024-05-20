/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gyrobab.core;

import gyrobab.core.Utilisateur;
import java.util.ArrayList;
import java.time.LocalDate;

/**
 *
 * @author Rafael
 */
public class Administrateur extends Utilisateur{
    
    private static ArrayList<Gestionnaire> gestionnaires = new ArrayList<>();
    
    public Administrateur(String mailUtilisateur, String nomUtilisateur, String prenomUtilisateur, String nomDeFamille){
        super(mailUtilisateur, nomUtilisateur, prenomUtilisateur, nomDeFamille);
    }
    
    public void creerCompteGestionnaire(String prenomUtilisateur, String nomDeFamille, String nomUtilisateur,  String mailUtilisateur, String typeEmploi,LocalDate dateEmbauche, LocalDate finContrat){
        //nom prenom et nomUtilisateur
        if(prenomUtilisateur==null){prenomUtilisateur="";}

        if(nomDeFamille==null){nomDeFamille="";}

        if(nomUtilisateur==null){nomUtilisateur="";}

        //mail
        if(mailUtilisateur==null){mailUtilisateur="@";}

        //type
        if(typeEmploi==null){typeEmploi="";}

        if(dateEmbauche==null){dateEmbauche=LocalDate.of(9999,12,31);}

        if(finContrat==null){finContrat=LocalDate.of(9999,12,31);}

        gestionnaires.add(new Gestionnaire( mailUtilisateur, nomUtilisateur, prenomUtilisateur, nomDeFamille, dateEmbauche,finContrat, typeEmploi));
    }
    
    public void supprimerGestionnaire(int nGestionnaire){
        ;
    }
    //ADD ON UML
    public void modifierGestionnaire(Gestionnaire gestionnaire, String prenomUtilisateur, String nomDeFamille, String nomUtilisateur,  String mailUtilisateur, String typeEmploi,LocalDate dateEmbauche, LocalDate finContrat){

        //nom prenom et nomUtilisateur
        if(prenomUtilisateur==null){prenomUtilisateur="";}
        gestionnaire.setPrenomUtilisateur(prenomUtilisateur);

        if(nomDeFamille==null){nomDeFamille="";}
        gestionnaire.setNomDeFamille(nomDeFamille);

        if(nomUtilisateur==null){nomUtilisateur="";}
        gestionnaire.setNomUtilisateur(nomUtilisateur);

        //mail
        if(mailUtilisateur==null){mailUtilisateur="@";}
        gestionnaire.setMailUtilisateur(mailUtilisateur);

        //type
        if(typeEmploi==null){typeEmploi="";}
        gestionnaire.setTypeEmploi(typeEmploi);

        if(dateEmbauche==null){dateEmbauche=LocalDate.of(9999,12,31);}
        gestionnaire.setLocalDateEmbauche(dateEmbauche);

        if(finContrat==null){finContrat=LocalDate.of(9999,12,31);}
        gestionnaire.setFinContrat(finContrat);
    }
    
    
    //ADD ON UML
    public ArrayList<Gestionnaire> obtenirListeDesGestionnaires(){
        return gestionnaires;
    }
    public int quantiteGestionnaires(){
        return gestionnaires.size();
    }
    
    
    
    public Gestionnaire obtenirGestionnaireParID(int i){
        Gestionnaire gestionnaire = gestionnaires.get(i);
        return gestionnaire;
    }
    
    
    public Gestionnaire obtenirGestionnaireParNomUtilisateur(String nomUtilisateur){
        for (Gestionnaire gestionnaire : gestionnaires) {
            if (gestionnaire.getNomUtilisateur().equals(nomUtilisateur)) {
                return gestionnaire;
            }
        }
        return null; // Retorna null se o gestionnaire não for encontrado
    }
}
