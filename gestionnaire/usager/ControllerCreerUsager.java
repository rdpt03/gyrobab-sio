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
import gyrobab.core.TypePieceIdentite;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Collection;
import java.util.List;

public class ControllerCreerUsager {
    public static Administrateur administrateur = GyroBAB.getAdministrateur();
    @FXML
    //private AnchorPane rootPane;
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


    public void retour(ActionEvent event) throws IOException{
        ouvrirMenu(event,"menuUsagers.fxml");
    }
    
    //boutton creer

    @FXML///////////////BUGF
    private void initialize() {
        // Popule o ComboBox com itens dinamicamente
        Collection<TypePieceIdentite> typePCIdentite = gyrobab.core.Gestionnaire.getListeTypePieceIdentite();
        typePieceIdentite.getItems().addAll(typePCIdentite);
    }

    public void creerUnUsager(ActionEvent event) throws IOException{
        prenomUsager = prenom.getText();
        nomUsager=nom.getText();
        nomUtilisateurUsager=nomutilisateur.getText();
        mailUsager=mail.getText();
        dateDeNaissanceUsager=dateDeNaissance.getValue();
        nPieceIdentiteUsager=nPieceIdentite.getText();
        typePieceIdentiteUsager=typePieceIdentite.getValue();
        System.out.println(typePieceIdentiteUsager);
        if(typePieceIdentiteUsager==null){
            erreur.setTextFill(Color.RED);
            erreur.setText("veuillez choisir un type de Piece d'identite");
            return;
        }


        if(dateDeNaissanceUsager==null){
            erreur.setText("veuillez renseigner la date au bon format 'JJ/MM/YYYY'");
            return;
        }

        //S'il y a des valeus vides sauf finContratGest alors :
        if (mailUsager.isEmpty() || nomUtilisateurUsager.isEmpty() || prenomUsager.isEmpty() || nomUsager.isEmpty() || nPieceIdentiteUsager.isEmpty()){
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


        gyrobab.core.Gestionnaire.ajouterUsager(mailUsager, nomUtilisateurUsager, prenomUsager,nomUsager,dateDeNaissanceUsager,nPieceIdentiteUsager,typePieceIdentiteUsager);
        erreur.setTextFill(Color.GREEN);
        erreur.setText("Usager Ajouté avec succes");
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
