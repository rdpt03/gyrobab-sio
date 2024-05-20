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
import gyrobab.core.Gestionnaire;
import java.io.IOException;
import javafx.beans.property.SimpleDoubleProperty;
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
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class ControllerMenuGestionnaires {
        @FXML
    //private AnchorPane rootPane;
    private Stage stage;
    private Scene scene;
    private Parent root;
    @FXML
    private TableView<Gestionnaire> tableView;

    @FXML
    private TableColumn<Gestionnaire, String> prenom;

    @FXML
    private TableColumn<Gestionnaire, String> nom;
    @FXML
    private TableColumn<Gestionnaire, String> nomUtilisateur;
    @FXML
    private TableColumn<Gestionnaire, String> mail;
    @FXML
    private TableColumn<Gestionnaire, String> dateEmbauche;
    @FXML
    private TableColumn<Gestionnaire, String> finDuContrat;
    @FXML
    private TableColumn<Gestionnaire, String> type;

    public void initialize() {
        // Configurar as colunas
        prenom.         setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getPrenomUtilisateur().toString()));
        nom.            setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getNomDeFamille().toString()));
        nomUtilisateur. setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getNomUtilisateur().toString()));
        mail.           setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getMailUtilisateur().toString()));
        dateEmbauche.   setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getLocalDateEmbauche().toString()));
        finDuContrat.   setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getFinContrat().toString()));
        type.           setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getTypeEmploi().toString()));
        // Converter a ArrayList para uma ObservableList e definir na TableView
        ObservableList<Gestionnaire> produtosList = FXCollections.observableArrayList(GestionnairesDAO.getProdutos());
        tableView.setItems(produtosList);
    }
    
    
    
    @FXML
    public void retour(ActionEvent event) throws IOException {
        ouvrirMenu(event,"index.fxml");
    }
    
    //BASE DES MENUS
    private void ouvrirMenu(ActionEvent event, String menu) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource(menu));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }



////////////////////////////////SELECIONAR//////////////////////////////
    public void modifierGestionnaires(ActionEvent event) throws IOException{
        //mandar pro outro lado
        Gestionnaire gestionnaire = tableView.getSelectionModel().getSelectedItem();
        try {
            // Crie um objeto Gestionnaire

            // Carregue a segunda cena
            FXMLLoader loader = new FXMLLoader(getClass().getResource("modifierGestionnaire.fxml"));
            Parent root = loader.load();

            // Obtenha o controlador da segunda cena e passe o objeto Gestionnaire
            ControllerModifierGestionnaire secondController = loader.getController();
            secondController.initData(gestionnaire);

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
    public void removeGestionnaire(ActionEvent event) throws IOException {

        Gestionnaire gestionnaire = tableView.getSelectionModel().getSelectedItem();
        
        //supprimer
        GyroBAB.getAdministrateur().obtenirListeDesGestionnaires().remove(gestionnaire);
        ouvrirMenu(event,"menuSaisons.fxml");
        
    }
}