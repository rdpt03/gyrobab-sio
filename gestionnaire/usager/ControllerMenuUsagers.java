/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gyrobab.gestionnaire.usager;

/**
 *
 * @author Rafael
 */

import gyrobab.admin.ControllerModifierGestionnaire;
import gyrobab.core.Gestionnaire;
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
import java.util.Collection;

public class ControllerMenuUsagers {
        @FXML
    //private AnchorPane rootPane;
    private Stage stage;
    private Scene scene;
    private Parent root;
    @FXML
    private TableView<Usager> tableView;

    @FXML
    private TableColumn<Usager, String> prenom;

    @FXML
    private TableColumn<Usager, String> nom;
    @FXML
    private TableColumn<Usager, String> nomUtilisateur;
    @FXML
    private TableColumn<Usager, String> mail;
    @FXML
    private TableColumn<Usager, String> dateDeNaissance;
    @FXML
    private TableColumn<Usager, String> nPieceIdenite;
    @FXML
    private TableColumn<Usager, String> typePieceIdentite;

    public void initialize() {
        //Configurer les collones
        prenom.         setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getPrenomUtilisateur()));
        nom.            setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getNomDeFamille()));
        nomUtilisateur. setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getNomUtilisateur()));
        mail.           setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getMailUtilisateur()));
        dateDeNaissance.   setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getDateNaissance().toString()));
        nPieceIdenite.   setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getnPieceIdentite().toString()));
        typePieceIdentite.           setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getTypePieceIdentite().getLibellePieceIdentite()));
        //Convertir la ArrayList en ObservableList
        Collection<Usager> usagers = gyrobab.core.Gestionnaire.getUsagers();
        ObservableList<Usager> usagersList = FXCollections.observableArrayList(usagers);
        //mettre la usagers dans la liste
        tableView.setItems(usagersList);
    }
    
    
    
    @FXML
    public void retour(ActionEvent event) throws IOException {
        ouvrirMenu(event,"../index.fxml");
    }

    public void ajouterUsager(ActionEvent event) throws IOException{
        ouvrirMenu(event,"creerUsager.fxml");
    }

////////////////////////////////SELECIONAR//////////////////////////////
public void modifierUsager(ActionEvent event) throws IOException{
    //mandar pro outro lado
    Usager usager = tableView.getSelectionModel().getSelectedItem();
    try {
        // Crie um objeto Gestionnaire

        // Carregue a segunda cena
        FXMLLoader loader = new FXMLLoader(getClass().getResource("modifierUsager.fxml"));
        Parent root = loader.load();

        // Obtenha o controlador da segunda cena e passe o objeto Gestionnaire
        ControllerModifierUsager secondController = loader.getController();
        secondController.initData(usager);

        // Configure a segunda cena no palco
        Stage stage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.show();
    }
    catch (IOException e) {
        System.err.println(String.format("Error: %s", e.getMessage()));
    }
}

    //APAGAR 
    public void removeUsager(ActionEvent event) throws IOException {

        Usager usager = tableView.getSelectionModel().getSelectedItem();
        
        //supprimer
        gyrobab.core.Gestionnaire.getUsagers().remove(usager);
        ouvrirMenu(event,"menuUsagers.fxml");
        
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