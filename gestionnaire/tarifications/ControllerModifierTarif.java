/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gyrobab.gestionnaire.tarifications;

/**
 *
 * @author Rafael
 */


import gyrobab.core.Gestionnaire;
import gyrobab.core.Saison;
import gyrobab.core.Tarif;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;
import java.time.LocalDate;
import java.time.MonthDay;
import java.util.Collection;

public class ControllerModifierTarif {
    private Stage stage;
    private Scene scene;
    private Parent root;
    public Label erreur;

    public ComboBox<Saison> saisonForm;
    public TextField prixForm;

    @FXML
    public Saison saison;
    public double prix;
    private Tarif tarifAModifier=null;


    //INITIALIZER
    public void initData(Tarif tarif) {
        //obtenir l'objet tarif
        tarifAModifier = tarif;
        // obtenir la saison correspondante
        saisonForm.setValue(tarif.getSaison());
        //obtenir le prix
        prixForm.setText(String.valueOf(tarif.getTarif()));
        Collection<Saison> lesSaisons = gyrobab.core.Gestionnaire.getListeDesSaisons();
        saisonForm.getItems().addAll(lesSaisons);
    }



    //boutton retour a la page
    public void retour(ActionEvent event) throws IOException{
        ouvrirMenu(event,"menuSaisons.fxml");
    }

    //boutton pour ajouter :
    public void modifierUneTarif(ActionEvent event) throws IOException{

        saison = saisonForm.getValue();

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

        Gestionnaire.modifierTarif(tarifAModifier,saison, prix);
        ouvrirMenu(event,"menuTarifs.fxml");
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
