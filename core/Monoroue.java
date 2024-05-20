/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gyrobab.core;

import java.time.LocalDate;

/**
 *
 * @author rlarralde
 */
public class Monoroue extends Gyropode{
    private String typeFreinGyroscopique;
    private String systemeCalePieds;
    private String systemeDePoigneeDemport;

    public String getTypeFreinGyroscopique() {
        return typeFreinGyroscopique;
    }

    public void setTypeFreinGyroscopique(String typeFreinGyroscopique) {
        this.typeFreinGyroscopique = typeFreinGyroscopique;
    }

    public String getSystemeCalePieds() {
        return systemeCalePieds;
    }

    public void setSystemeCalePieds(String systemeCalePieds) {
        this.systemeCalePieds = systemeCalePieds;
    }

    public String getSystemeDePoigneeDemport() {
        return systemeDePoigneeDemport;
    }

    public void setSystemeDePoigneeDemport(String systemeDePoigneeDemport) {
        this.systemeDePoigneeDemport = systemeDePoigneeDemport;
    }

    public Monoroue(MarqueGyropode marqueDuGyropode,String typeFreinGyroscopique, String systemeCalePieds, String systemeDePoigneeDemport, String nRference, String nSerieConstructeur, String couleur, LocalDate dateAchat, int nUtilisations, double nKmEffectue, double nHeureRoule, double latitude, double longitude, double niveauBatterie, double dureeRouageRestant, double tempsRechargeEstime, boolean bloque, boolean enMaintenance) {
        super(marqueDuGyropode,nRference, nSerieConstructeur, couleur, dateAchat, nUtilisations, nKmEffectue, nHeureRoule, latitude, longitude, niveauBatterie, dureeRouageRestant, tempsRechargeEstime, bloque, enMaintenance);
        this.typeFreinGyroscopique = typeFreinGyroscopique;
        this.systemeCalePieds = systemeCalePieds;
        this.systemeDePoigneeDemport = systemeDePoigneeDemport;
    }

    @Override
    public String toString() {
        return super.toString()+"Monoroue{" + "typeFreinGyroscopique=" + typeFreinGyroscopique + ", systemeCalePieds=" + systemeCalePieds + ", systemeDePoigneeDemport=" + systemeDePoigneeDemport + '}';
    }
    
    
    
}
