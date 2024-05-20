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
import java.time.format.DateTimeFormatter;
import java.util.Collection;

public class ControllerMenuTarifs {

    //private AnchorPane rootPane;
    @FXML
    private Stage stage;
    @FXML
    private Scene scene;
    @FXML
    private Parent root;
    @FXML
    private TableView<Tarif> tableView;

    @FXML
    private TableColumn<Tarif, String> prix;

    @FXML
    private TableColumn<Tarif, String> saison;

    public void initialize() {
        // Configurar as colunas
        prix.setCellValueFactory(cellData -> new SimpleStringProperty( String.valueOf( cellData.getValue().getTarif() ) ) );
        saison.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getSaison().getTypeSaison()));


        Collection<Tarif> tarifs = Gestionnaire.getListeDesTarifs();
        ObservableList<Tarif> tarifsList = FXCollections.observableArrayList(tarifs);
        tableView.setItems(tarifsList);
    }
    
    
    
    @FXML
    public void retour(ActionEvent event) throws IOException {
        ouvrirMenu(event,"../index.fxml");
    }

    public void ajouterTarif(ActionEvent event) throws IOException{
        ouvrirMenu(event,"creerTarif.fxml");
    }

////////////////////////////////SELECIONAR//////////////////////////////
public void modifierTarif(ActionEvent event) throws IOException{

        //mandar pro outro lado
    Tarif tarif = tableView.getSelectionModel().getSelectedItem();
    try {
        // Carregue a segunda cena
        FXMLLoader loader = new FXMLLoader(getClass().getResource("modifierTarif.fxml"));
        Parent root = loader.load();

        // Obtenha o controlador da segunda cena e passe o objeto Gestionnaire
        ControllerModifierTarif secondController = loader.getController();
        secondController.initData(tarif);

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
    public void removeTarif(ActionEvent event) throws IOException {

        Tarif tarif = tableView.getSelectionModel().getSelectedItem();
        
        //supprimer
        Gestionnaire.getListeDesTarifs().remove(tarif);
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