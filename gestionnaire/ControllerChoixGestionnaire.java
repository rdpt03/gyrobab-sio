package gyrobab.gestionnaire;

import gyrobab.GyroBAB;
import gyrobab.admin.ControllerModifierGestionnaire;
import gyrobab.core.Administrateur;
import gyrobab.core.Gestionnaire;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;

public class ControllerChoixGestionnaire {
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
@FXML
    private Stage stage;
    @FXML
    private Scene scene;
    @FXML
    public Label erreur;
    @FXML
    public TextField user;
    private ArrayList<Gestionnaire> listeGestionnaires;

    private String nomUtilisateurGestionnaire;

    public void retourALaPage(ActionEvent event) throws IOException {
        ouvrirMenu(event,"../index.fxml");
    }

    //checkbox activer ou desactiver


    //boutton creer
    @FXML
    public void entrerDansLeCompte(ActionEvent event) throws IOException{
        //obtenir le texte du formulaire
        nomUtilisateurGestionnaire = user.getText();
        //parcourir la liste des administrateurs
        for (Gestionnaire gest : GyroBAB.getAdministrateur().obtenirListeDesGestionnaires()) {
            //si le saisi dans le formulaire est egal au champs nomUtilisateur du gestionnaire actuel :
            if (gest.getNomUtilisateur().equals(nomUtilisateurGestionnaire)) {
                try {
                    //Configurer et charger la scene
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("index.fxml"));
                    Parent root = loader.load();


                    ControllerIndex secondController = loader.getController();
                    secondController.initData(gest);


                    Stage stage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
                    stage.setScene(new Scene(root));
                    stage.show();
                }
                catch (IOException e) {
                    System.err.println(String.format("Error: %s", e.getMessage()));
                }

            }
            else{
                System.out.println("NOP!");
            }
        }

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
