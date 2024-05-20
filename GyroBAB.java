package gyrobab;

import gyrobab.core.Administrateur;
import java.time.LocalDate;
import java.time.MonthDay;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class GyroBAB extends Application {

    //CREATION DE L'instance ADMIN
    private static Administrateur administrateur = new Administrateur(null,null,null,null);
    
    @Override
    public void start(Stage primaryStage) {

        //les Types de Piece d'identité
        gyrobab.core.Gestionnaire.ajouterTypePieceIdentite("CID","Carte d'idenetité");
        gyrobab.core.Gestionnaire.ajouterTypePieceIdentite("PSS","Passeport");
        gyrobab.core.Gestionnaire.ajouterTypePieceIdentite("PDC","Permis de Conduire");


        //LAB
        //Gestionnaire DEMO
        System.out.println(gyrobab.core.Gestionnaire.getListeTypePieceIdentite().get(1));
        //gest
        administrateur.creerCompteGestionnaire("Rafael", "Alves","rafa","rafa@",null,null,null  );
        //user
        gyrobab.core.Gestionnaire.ajouterUsager("rafael@alves","rafaelalves","Rafael","Alves",LocalDate.of(2003,05,30),"R002FR45ES450000000041",gyrobab.core.Gestionnaire.getListeTypePieceIdentite().get(1));
        gyrobab.core.Gestionnaire.ajouterUsager("rafael@tara","TAKALA","Rafael","Alves",LocalDate.of(1983,01,13),"R002FR45ES450000000041",gyrobab.core.Gestionnaire.getListeTypePieceIdentite().get(1));
        //saisons
        gyrobab.core.Gestionnaire.ajouterSaisons("basse", MonthDay.of(10,1),MonthDay.of(05,5));
        gyrobab.core.Gestionnaire.ajouterSaisons("Haute", MonthDay.of(05,6),MonthDay.of(10,2));
        //tarifs
        gyrobab.core.Gestionnaire.ajouterTarif(gyrobab.core.Gestionnaire.getListeDesSaisons().get(0),1.25);
        gyrobab.core.Gestionnaire.ajouterTarif(gyrobab.core.Gestionnaire.getListeDesSaisons().get(1),2.39);
        //marque
        gyrobab.core.Gestionnaire.ajouterMarque("Segway", "https://fr-fr.segway.com/", "M Lespacieux", "01 00 01 77 44", "commercial@segway.com", "M Barquinaux", "01 00 01 77 45","sav@segway.fr");

        System.out.println(gyrobab.core.Usager.obtenirAgeMoyenne());
        //Codigo
        try {
            // Carregar o arquivo FXML
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(GyroBAB.class.getResource("index.fxml"));
            AnchorPane rootLayout = (AnchorPane) loader.load();

            // Configurar a cena
            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.setTitle("Exemplo JavaFX com FXML");
            primaryStage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
    //GETTER POUR L'ADMIN
    public static Administrateur getAdministrateur(){
        return administrateur;
    }
}
