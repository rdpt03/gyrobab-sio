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
import gyrobab.core.Gestionnaire;
import java.util.ArrayList;
import java.util.List;

public class GestionnairesDAO {
    private static List<Gestionnaire> gestionnaire = new ArrayList<>();
    static{
        gestionnaire = GyroBAB.getAdministrateur().obtenirListeDesGestionnaires();
    }
/*    static {
        produtos.add(new Produto("Produto 1", 10.0));
        produtos.add(new Produto("Produto 2", 20.0));
        produtos.add(new Produto("Produto 3", 30.0));
    /}
*/
    public static List<Gestionnaire> getProdutos() {
        return gestionnaire;
    }
}

