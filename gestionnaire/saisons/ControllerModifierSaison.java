/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gyrobab.gestionnaire.saisons;

/**
 *
 * @author Rafael
 */


import gyrobab.core.Gestionnaire;
import gyrobab.core.Saison;
import gyrobab.core.TypePieceIdentite;
import gyrobab.core.Usager;
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
import java.time.MonthDay;
import java.util.Collection;

public class ControllerModifierSaison {

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
    private Saison saisonAModfier=null;


    //INITIALIZER
    public void initData(Saison saison) {


        //obtenir l'objet saison
        saisonAModfier = saison;
        // obtenir les differentes donnés
        libelleSaison.setText(saison.getTypeSaison());
        dateDebut.setValue(
                convertMonthDayToLocalDate(
                        saison.getLocalDateDebutSaison()
                )
        );
        dateFin.setValue(
                convertMonthDayToLocalDate(
                        saison.getLocalDateFinSaison()
                )
        );
    }



    //boutton retour a la page
    public void retour(ActionEvent event) throws IOException{
        ouvrirMenu(event,"menuSaisons.fxml");
    }

    //checkbox activer ou desactiver

    //boutton creer
    public void modifierUneSaison(ActionEvent event) throws IOException{

        libelleSaisonString = libelleSaison.getText();

        LocalDate dateDebutLD = dateDebut.getValue();
        LocalDate dateFinLD = dateFin.getValue();
        System.out.println(dateDebutLD + " - " + dateFinLD);
        //verifier les dates :
        if(dateDebutLD==null || dateFinLD == null){
            erreur.setTextFill(Color.RED);
            erreur.setText("veuillez renseigner les dates au bon format 'JJ/MM/YYYY' (l'année n'est pas inportant dans ce cas)");
            return;
        }

        //S'il y a des valeus vides alors :
        if (libelleSaisonString.isEmpty()){
            erreur.setTextFill(Color.RED);
            erreur.setText("Veuillez remplir les cases!"); //afficher un message
            return;
        }
        //sinon si tout est correct :
        erreur.setText(null);

        dateDebutMD = convertLocalDateToMonthDay(dateDebutLD);
        dateFinMD = convertLocalDateToMonthDay(dateFinLD);

        Gestionnaire.modifierSaisons(saisonAModfier,libelleSaisonString, dateDebutMD, dateFinMD);
        ouvrirMenu(event,"menuSaisons.fxml");
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
    private LocalDate convertMonthDayToLocalDate(MonthDay monthDay) {
        int month = monthDay.getMonthValue();
        int day = monthDay.getDayOfMonth();

        LocalDate localDate = LocalDate.now().withMonth(month).withDayOfMonth(day);
        return localDate;
    }
}
