/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gyrobab.gestionnaire.usager;

/**
 *
 * @author Rafael
 */


import gyrobab.GyroBAB;
import gyrobab.core.Administrateur;
import gyrobab.core.Gestionnaire;
import gyrobab.core.TypePieceIdentite;
import gyrobab.core.Usager;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Collection;

public class ControllerModifierUsager {

    private Stage stage;
    private Scene scene;
    private Parent root;
    public Label erreur;
    public TextField prenom;
    public TextField nom;
    public TextField mail;
    public TextField nomutilisateur;
    public TextField nPieceIdentite;
    public ComboBox<TypePieceIdentite> typePieceIdentite; //MODIFICAR
    public DatePicker dateDeNaissance;

    @FXML
    private String prenomUsager;
    private String nomUsager;
    private String nomUtilisateurUsager;
    private String mailUsager;
    private LocalDate dateDeNaissanceUsager;
    private String nPieceIdentiteUsager;
    private TypePieceIdentite typePieceIdentiteUsager;

    @FXML
    private CheckBox checkBoxDateFinContrat;
    private Usager usagerAModfier=null;


    //INITIALIZER
    public void initData(Usager usager) {
        // Popule o ComboBox com itens dinamicamente
        Collection<TypePieceIdentite> typePCIdentite = gyrobab.core.Gestionnaire.getListeTypePieceIdentite();
        typePieceIdentite.getItems().addAll(typePCIdentite);


        usagerAModfier = usager;
        // Nom Prenom et NomUtilisauteur
        nom.setText(usager.getNomDeFamille());
        prenom.setText(usager.getPrenomUtilisateur());
        nomutilisateur.setText(usager.getNomUtilisateur());
        //mail
        mail.setText(usager.getMailUtilisateur());
        //piece identie
        typePieceIdentite.setValue(usager.getTypePieceIdentite());
        nPieceIdentite.setText(usager.getnPieceIdentite());
        //dates
        dateDeNaissance.setValue(usager.getDateNaissance());
    }



    //boutton retour a la page
    public void retour(ActionEvent event) throws IOException{
        ouvrirMenu(event,"menuSaisons.fxml");
    }

    //checkbox activer ou desactiver

    //boutton creer
    public void modifierUnUsager(ActionEvent event) throws IOException{

        prenomUsager = prenom.getText();
        nomUsager=nom.getText();
        nomUtilisateurUsager=nomutilisateur.getText();
        mailUsager=mail.getText();
        typePieceIdentiteUsager=typePieceIdentite.getValue();
        nPieceIdentiteUsager=nPieceIdentite.getText();
        dateDeNaissanceUsager=dateDeNaissance.getValue();

        if(dateDeNaissanceUsager==null){
            erreur.setText("veuillez renseigner les dates au bon format 'JJ/MM/YYYY'");
            return;
        }

        //S'il y a des valeus vides sauf finContratGest alors : 
        if (mailUsager.isEmpty() || nomUsager.isEmpty() || prenomUsager.isEmpty() || nomUtilisateurUsager.isEmpty() || nPieceIdentiteUsager.isEmpty()){
            erreur.setTextFill(Color.RED);
            erreur.setText("Veuillez remplir les cases!"); //afficher un message
            return;
        }
        erreur.setText(null);

        //si le mail est pas au bon format
        if(!mailUsager.contains("@")){
            erreur.setTextFill(Color.RED);
            erreur.setText("Veuillez ecrire le mail au bon format example : 'nom@example.com'");
            return;
        }

        gyrobab.core.Gestionnaire.modifierUsager(usagerAModfier,prenomUsager,nomUsager,nomUtilisateurUsager,mailUsager,typePieceIdentiteUsager,nPieceIdentiteUsager,dateDeNaissanceUsager);
        ouvrirMenu(event,"menuUsagers.fxml");
    }


    //BASE DES MENUS
    private void ouvrirMenu(ActionEvent event, String menu) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource(menu));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
