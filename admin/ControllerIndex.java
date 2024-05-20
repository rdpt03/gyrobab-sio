/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gyrobab.admin;

/**
 *
 * @author Rafael
 */


import gyrobab.GyroBAB;
import gyrobab.core.Administrateur;
import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class ControllerIndex {
    
    @FXML
    //private AnchorPane rootPane;
    private Stage stage;
    private Scene scene;
    private Parent root;
    
    
    
    @FXML
    public void ovrirCreationUnGestionnaire(ActionEvent event) throws IOException {
        ouvrirMenu(event,"creerGestionnaire.fxml");
        System.out.println(GyroBAB.getAdministrateur().obtenirListeDesGestionnaires());
    }
    @FXML
    public void voirGestionnaires(ActionEvent event) throws IOException {
        ouvrirMenu(event,"menuGestionnaires.fxml");
        System.out.println(GyroBAB.getAdministrateur().obtenirListeDesGestionnaires());
    }
    @FXML
    public void quitter(ActionEvent event) throws IOException{
        ouvrirMenu(event,"../index.fxml");
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
