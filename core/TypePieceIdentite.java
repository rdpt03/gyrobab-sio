/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gyrobab.core;

/**
 *
 * @author Rafael
 */
public class TypePieceIdentite {
    private String codePieceIdentite;
    private String libellePieceIdentite;

    public String getCodePieceIdentite() {
        return codePieceIdentite;
    }

    public void setCodePieceIdentite(String codePieceIdentite) {
        this.codePieceIdentite = codePieceIdentite;
    }

    public String getLibellePieceIdentite() {
        return libellePieceIdentite;
    }

    public void setLibellePieceIdentite(String libellePieceIdentite) {
        this.libellePieceIdentite = libellePieceIdentite;
    }

    public TypePieceIdentite(String codePieceIdentite, String libellePieceIdentite) {
        this.codePieceIdentite = codePieceIdentite;
        this.libellePieceIdentite = libellePieceIdentite;
    }

    /*@Override
    public String toString() {
        return "typePieceIdentite{" + "codePieceIdentite=" + codePieceIdentite + ", libellePieceIdentite=" + libellePieceIdentite + '}';
    }
    */
    @Override
    public String toString(){
        return libellePieceIdentite;
    }
}