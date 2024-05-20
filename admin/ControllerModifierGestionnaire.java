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
import java.time.LocalDate;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class ControllerModifierGestionnaire {
    public static Administrateur administrateur = GyroBAB.getAdministrateur();

    private AnchorPane rootPane;
    @FXML
    private Stage stage;
    @FXML
    private Scene scene;
    @FXML
    private Parent root;
    @FXML
    public Label erreur;
    @FXML
    public TextField prenom;
    @FXML
    public TextField nom;
    @FXML
    public TextField mail;
    @FXML
    public TextField nomutilisateur;
    @FXML
    public TextField typeContrat;
    @FXML
    public DatePicker dateEmbauche;
    @FXML
    public DatePicker finContrat;

    private String prenomGest;
    private String nomGest;
    private String nomUtilisateurGest;
    private String mailGest;
    private String typeContratGest;
    private LocalDate dateEmbaucheGest;
    private LocalDate finContratGest;

    @FXML
    private CheckBox checkBoxDateFinContrat;

    private Gestionnaire gestionnaireAModifier;


    //INITIALIZER
    public void initData(Gestionnaire gestionnaire) {
        gestionnaireAModifier = gestionnaire;
        // Nom Prenom et NomUtilisauteur
        nom.setText(gestionnaire.getNomDeFamille());
        prenom.setText(gestionnaire.getPrenomUtilisateur());
        nomutilisateur.setText(gestionnaire.getNomUtilisateur());
        //mail
        mail.setText(gestionnaire.getMailUtilisateur());
        //type
        typeContrat.setText(gestionnaire.getTypeEmploi());
        //dates
        dateEmbauche.setValue(gestionnaire.getLocalDateEmbauche());
    }



    //boutton retour a la page
    public void retourALaPage(ActionEvent event) throws IOException{
        ouvrirMenu(event,"menuSaisons.fxml");
    }

    //checkbox activer ou desactiver
    public void activerDateFinContrat(ActionEvent event) throws IOException{
        finContrat.setDisable(!checkBoxDateFinContrat.isSelected());
    }

    //boutton creer
    public void modifierGestionnaire(ActionEvent event) throws IOException{

        prenomGest = prenom.getText();
        nomGest=nom.getText();
        nomUtilisateurGest=nomutilisateur.getText();
        mailGest=mail.getText();
        typeContratGest=typeContrat.getText();

        dateEmbaucheGest=dateEmbauche.getValue();
        if(!checkBoxDateFinContrat.isSelected()){
            finContratGest=LocalDate.of(9999,12,31);;
        }
        else{
            finContratGest=finContrat.getValue();
        }
        if(dateEmbaucheGest==null||finContratGest==null){
            erreur.setText("veuillez renseigner les dates au bon format 'JJ/MM/YYYY'");
            return;
        }

        //S'il y a des valeus vides sauf finContratGest alors : 
        if (mailGest.isEmpty() || nomUtilisateurGest.isEmpty() || prenomGest.isEmpty() || nomGest.isEmpty() || typeContratGest.isEmpty()){
            erreur.setTextFill(Color.RED);
            erreur.setText("Veuillez remplir les cases!"); //afficher un message
             System.out.println(mailGest + " - " + nomUtilisateurGest + " - " + prenomGest + " - " + nomGest + " - " + dateEmbaucheGest + " - " + finContratGest + " - " + typeContratGest);
            return;
        }
        erreur.setText(null);

        //si le mail est pas au bon format
        if(!mailGest.contains("@")){
            erreur.setTextFill(Color.RED);
            erreur.setText("Veuillez ecrire le mail au bon format example : 'nom@example.com'");
            return;
        }

        //s'il y a une date de fin et celle la est avant la date de embauche : 
        if(finContratGest != null && finContratGest.isBefore(dateEmbaucheGest)){
            erreur.setTextFill(Color.RED);
            erreur.setText("La date de Fin de Contrat ne peut pas etre avant la date d'embauche");
            return;
        }

        administrateur.modifierGestionnaire(gestionnaireAModifier,prenomGest,nomGest,nomUtilisateurGest,mailGest,typeContratGest,dateEmbaucheGest,finContratGest);
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
