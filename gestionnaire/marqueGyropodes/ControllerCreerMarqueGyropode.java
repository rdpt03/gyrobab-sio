/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gyrobab.gestionnaire.marqueGyropodes;

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
import java.util.Collection;

public class ControllerCreerMarqueGyropode {
    @FXML
    //private AnchorPane rootPane;
    private Stage stage;
    private Scene scene;
    private Parent root;
    public Label erreur;

    public TextField nomForm;
    public TextField siteWebForm;
    public TextField nomCommercialForm;
    public TextField telCommercialForm;
    public TextField mailCommercialForm;
    public TextField nomSAVForm;
    public TextField telSAVForm;
    public TextField mailSAVForm;

    public String nom;
    public String siteWeb;
    public String nomCommercial;
    public String telCommercial;
    public String mailCommercial;
    public String nomSAV;
    public String telSAV;
    public String mailSAV;



    public void retour(ActionEvent event) throws IOException{
        ouvrirMenu(event,"menuMarqueGyropodes.fxml");
    }

    @FXML

    private void initialize() {
        ;
    }
    @FXML
    public void creerUneMarqueGyropode(ActionEvent event) throws IOException{

        //OBTENIR LES DONNES DU FORM :
        nom=nomForm.getText();
        siteWeb=siteWebForm.getText();
        nomCommercial=nomCommercialForm.getText();
        telCommercial=telCommercialForm.getText();
        mailCommercial=mailCommercialForm.getText();
        nomSAV=nomSAVForm.getText();
        telSAV=telSAVForm.getText();
        mailSAV=mailSAVForm.getText();

        //si manque des valleurs
        if(nom.isEmpty() || siteWeb.isEmpty() || nomCommercial.isEmpty() || telCommercial.isEmpty() || mailCommercial.isEmpty() || nomSAV.isEmpty() || telSAV.isEmpty() || mailSAV.isEmpty()){
            erreur.setTextFill(Color.RED);
            erreur.setText("veuillez renseigner toutes les valeurs s'il vous plait.");
            return;//arreter
        }
        //sinon :

        //enlever le message d'erreur
        erreur.setText(null);


        //CREER:
        gyrobab.core.Gestionnaire.ajouterMarque(nom, siteWeb, nomCommercial, telCommercial, mailCommercial, nomSAV, telSAV, mailSAV);
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
