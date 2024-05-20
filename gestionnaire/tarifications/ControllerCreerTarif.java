/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gyrobab.gestionnaire.tarifications;

/**
 *
 * @author Rafael
 */


import gyrobab.core.Saison;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;
import java.time.LocalDate;
import java.time.MonthDay;
import java.util.Collection;

public class ControllerCreerTarif {
    @FXML
    //private AnchorPane rootPane;
    private Stage stage;
    private Scene scene;
    private Parent root;
    public Label erreur;

    public ComboBox<Saison> saisonForm;
    public TextField prixForm;

    @FXML
    public Saison saison;
    public double prix;


    public void retour(ActionEvent event) throws IOException{
        ouvrirMenu(event,"menuTarifs.fxml");
    }

    @FXML

    private void initialize() {
        // Popule o ComboBox com itens dinamicamente
        Collection<Saison> lesSaisons = gyrobab.core.Gestionnaire.getListeDesSaisons();
        saisonForm.getItems().addAll(lesSaisons);
    }
    @FXML
    public void creerUneTarif(ActionEvent event) throws IOException{

        //OBTENIR LA SAISON :
        saison = saisonForm.getValue();
        //si aucune saison choisi alors :
        if(saison==null){
            erreur.setTextFill(Color.RED);//afficher message erreur
            erreur.setText("veuillez choisir un type de Piece d'identite");
            return;//retourner
        }
        //OBTENIR LE PRIX :

        //extraire du champs
        String prixString = prixForm.getText();

        //verifier si vide: si oui
        if(prixString.isEmpty()){
            erreur.setText("veuillez renseigner le prix s'il vous plait.");
            return;//arreter
        }
        //sinon :

        //remplacer les "," par des "."
        prixString = prixString.replace(",", ".");

        //verifier s'il y a des lettres : si oui
        if (!prixString.matches("-?\\d+(\\.\\d+)?")) {
            erreur.setTextFill(Color.RED);
            erreur.setText("Le prix saisi n'est pas valide.");
            return; //arreter
        }
        //sinon
        //convertir en Double et enregistrer
        prix = Double.parseDouble(prixString);

        //enlever le message d'erreur
        erreur.setText(null);


        //CREER:
        gyrobab.core.Gestionnaire.ajouterTarif(saison, prix);
        erreur.setTextFill(Color.GREEN);
        erreur.setText("Saison Ajouté avec succes");
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
