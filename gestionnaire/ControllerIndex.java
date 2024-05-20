/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gyrobab.gestionnaire;

/**
 *
 * @author Rafael
 */


import gyrobab.GyroBAB;
import gyrobab.core.Gestionnaire;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import javax.swing.*;
import java.io.IOException;

public class ControllerIndex {
    
    @FXML
    //private AnchorPane rootPane;
    private Stage stage;
    private Scene scene;
    private Parent root;
    @FXML
    public Text gestionnaireName;
    public Text agemoyenne;
    private Gestionnaire gestionnaire;
    

    public void initData(Gestionnaire gest){
        gestionnaire=gest;
        gestionnaireName.setText(gestionnaire.getNomUtilisateur());

    }

    @FXML

    private void initialize() {
        agemoyenne.setText(String.valueOf(gyrobab.core.Usager.obtenirAgeMoyenne()));
    }


    @FXML
    public void listeUsagers(ActionEvent event) throws IOException {
        ouvrirMenu(event,"usager/menuUsagers.fxml");
    }
    public void listeSaisons(ActionEvent event) throws IOException{
        ouvrirMenu(event,"saisons/menuSaisons.fxml");
    }

    public void listeTarifications(ActionEvent event) throws IOException{
        ouvrirMenu(event,"tarifications/menuTarifs.fxml");
    }
    public void listeMarqueGyropodes(ActionEvent event) throws IOException{
        ouvrirMenu(event,"marqueGyropodes/menuMarqueGyropodes.fxml");
    }
    
    //BASE DES MENUS
    private void ouvrirMenu(ActionEvent event, String menu) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource(menu));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    public void quitter(ActionEvent actionEvent) throws IOException {
        ouvrirMenu(actionEvent,"../index.fxml");
    }
}
