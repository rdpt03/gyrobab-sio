/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gyrobab.gestionnaire.marqueGyropodes;

/**
 *
 * @author Rafael
 */

import gyrobab.core.Gestionnaire;
import gyrobab.core.MarqueGyropode;
import gyrobab.core.Tarif;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Collection;

public class ControllerMenuMarqueGyropodes {

    //private AnchorPane rootPane;
    @FXML
    private Stage stage;
    @FXML
    private Scene scene;
    @FXML
    private Parent root;
    @FXML
    private TableView<MarqueGyropode> tableView;
    @FXML
    private TableColumn<MarqueGyropode, String> nom;
    @FXML
    private TableColumn<MarqueGyropode, String> siteWeb;
    @FXML
    private TableColumn<MarqueGyropode, String> nomCommercial;
    @FXML
    private TableColumn<MarqueGyropode, String> telCommercial;
    @FXML
    private TableColumn<MarqueGyropode, String> mailCommercial;
    @FXML
    private TableColumn<MarqueGyropode, String> nomSAV;
    @FXML
    private TableColumn<MarqueGyropode, String> telSAV;
    @FXML
    private TableColumn<MarqueGyropode, String> mailSAV;


    public void initialize() {
        // Configurar as colunas
        nom.setCellValueFactory(cellData -> new SimpleStringProperty( cellData.getValue().getNom()  ) );

        siteWeb.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getSiteWeb()));

        nomCommercial.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getNomCommercial()));

        telCommercial.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getTelCommercial()));

        mailCommercial.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getMailCommercial()));

        nomSAV.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getNomSAV()));

        telSAV.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getTelSAV()));

        mailSAV.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getMailSAV()));

        Collection<MarqueGyropode> marquesDesGyropodes = Gestionnaire.getMarquesDesGyropodes();
        ObservableList<MarqueGyropode> listeMarqueDesGyropodes = FXCollections.observableArrayList(marquesDesGyropodes);
        tableView.setItems(listeMarqueDesGyropodes);
    }
    
    
    
    @FXML
    public void retour(ActionEvent event) throws IOException {
        ouvrirMenu(event,"../index.fxml");
    }

    public void ajouterMarqueGyropode(ActionEvent event) throws IOException{
        ouvrirMenu(event,"creerMarqueGyropode.fxml");
    }

////////////////////////////////SELECIONAR//////////////////////////////
public void modifierMarqueGyropode(ActionEvent event) throws IOException{

        //mandar pro outro lado
    MarqueGyropode marque = tableView.getSelectionModel().getSelectedItem();
    try {
        // Carregue a segunda cena
        FXMLLoader loader = new FXMLLoader(getClass().getResource("modifierMarqueGyropode.fxml"));
        Parent root = loader.load();

        // Obtenha o controlador da segunda cena e passe o objeto Gestionnaire
        ControllerModifierMarqueGyropode secondController = loader.getController();
        secondController.initData(marque);

        // Configure a segunda cena no palco
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.show();
    }
    catch (IOException e) {
        System.err.println(String.format("Error: %s", e.getMessage()));
    }

}


    //APAGAR 
    public void removeMarqueGyropode(ActionEvent event) throws IOException {

        MarqueGyropode marque = tableView.getSelectionModel().getSelectedItem();
        
        //supprimer
        Gestionnaire.getMarquesDesGyropodes().remove(marque);
        ouvrirMenu(event,"menuMarqueGyropodes.fxml");

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