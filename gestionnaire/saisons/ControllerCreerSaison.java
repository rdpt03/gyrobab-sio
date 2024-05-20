/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gyrobab.gestionnaire.saisons;

/**
 *
 * @author Rafael
 */


import gyrobab.GyroBAB;
import gyrobab.core.Administrateur;
import gyrobab.core.TypePieceIdentite;
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

public class ControllerCreerSaison {
    @FXML
    //private AnchorPane rootPane;
    private Stage stage;
    private Scene scene;
    private Parent root;
    public Label erreur;
    public TextField libelleSaison;
    public DatePicker dateDebut;
    public DatePicker dateFin;

    @FXML
    public String libelleSaisonString;
    public MonthDay dateDebutMD;
    public MonthDay dateFinMD;


    public void retour(ActionEvent event) throws IOException{
        ouvrirMenu(event,"menuSaisons.fxml");
    }
    
    //boutton creer

    /*
    @FXML///////////////BUGF

    private void initialize() {
        ;
    }
*/
    @FXML
    public void creerUneSaison(ActionEvent event) throws IOException{
        //OBTENIR LE NOM:
        libelleSaisonString = libelleSaison.getText();

        //si le nom est vide
        if (libelleSaisonString.isEmpty()){
            erreur.setTextFill(Color.RED);
            erreur.setText("Veuillez remplir le Type de saison!"); //afficher un message

            return;
        }


        //OBTENIR LES DATES :
        LocalDate dateDebutLD = dateDebut.getValue();
        LocalDate dateFinLD = dateFin.getValue();

        //verifier les dates :
        if(dateDebutLD==null || dateFinLD == null){
            erreur.setText("veuillez renseigner les dates au bon format 'JJ/MM/YYYY' (l'année n'est pas inportant dans ce cas)");
            return;
        }
        System.out.println("ewfde");
        erreur.setText(null);

        //convertir les dates LocalDate en MonthDay (Perd l'anné)
        dateDebutMD = convertLocalDateToMonthDay(dateDebutLD);
        dateFinMD = convertLocalDateToMonthDay(dateFinLD);

        //CREER:
        gyrobab.core.Gestionnaire.ajouterSaisons(libelleSaisonString, dateDebutMD, dateFinMD);
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
    private MonthDay convertLocalDateToMonthDay(LocalDate dateLD){
        int month = dateLD.getMonthValue();
        int day = dateLD.getDayOfMonth();

        MonthDay dateMD = MonthDay.of(month, day);
        return dateMD;
    }
}
