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
import gyrobab.core.Usager;
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

public class ControllerMenuSaisons {

    //private AnchorPane rootPane;
    @FXML
    private Stage stage;
    @FXML
    private Scene scene;
    @FXML
    private Parent root;
    @FXML
    private TableView<Saison> tableView;

    @FXML
    private TableColumn<Saison, String> libelleSaisons;

    @FXML
    private TableColumn<Saison, String> dateDebut;
    @FXML
    private TableColumn<Saison, String> dateFin;

    public void initialize() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM-dd");
        // Configurar as colunas
        libelleSaisons.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getTypeSaison()));
        dateDebut.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getLocalDateDebutSaison().format(formatter)));
        dateFin.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getLocalDateFinSaison().format(formatter)));
        Collection<Saison> saisons = gyrobab.core.Gestionnaire.getListeDesSaisons();
        ObservableList<Saison> saisonsList = FXCollections.observableArrayList(saisons);
        tableView.setItems(saisonsList);
    }
    
    
    
    @FXML
    public void retour(ActionEvent event) throws IOException {
        ouvrirMenu(event,"../index.fxml");
    }

    public void ajouterSaison(ActionEvent event) throws IOException{
        ouvrirMenu(event,"creerSaison.fxml");
    }

////////////////////////////////SELECIONAR//////////////////////////////
public void modifierSaison(ActionEvent event) throws IOException{
    //mandar pro outro lado
    Saison saison = tableView.getSelectionModel().getSelectedItem();
    try {
        // Crie um objeto Gestionnaire

        // Carregue a segunda cena
        FXMLLoader loader = new FXMLLoader(getClass().getResource("modifierSaison.fxml"));
        Parent root = loader.load();

        // Obtenha o controlador da segunda cena e passe o objeto Gestionnaire
        ControllerModifierSaison secondController = loader.getController();
        secondController.initData(saison);

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
    public void removeSaison(ActionEvent event) throws IOException {

        Saison saison = tableView.getSelectionModel().getSelectedItem();
        
        //supprimer
        Gestionnaire.getListeDesSaisons().remove(saison);
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
}