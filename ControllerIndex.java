/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gyrobab;

/**
 *
 * @author Rafael
 */


import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ControllerIndex {
    
    @FXML
    //private AnchorPane rootPane;
    private Stage stage;
    private Scene scene;
    private Parent root;

    
    
    @FXML
    private void openAdminMenu(ActionEvent event) throws IOException {
        ouvrirMenu(event,"admin/index.fxml");
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
    private void openGestMenu(ActionEvent event) throws IOException{
        ouvrirMenu(event,"gestionnaire/choixGestionnaire.fxml");
    }
}
