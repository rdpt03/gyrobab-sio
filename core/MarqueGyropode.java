/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gyrobab.core;

/**
 *
 * @author rdasilva
 */
public class MarqueGyropode {
    private String nom;
    private String siteWeb;
    private String nomCommercial;
    private String telCommercial;
    private String mailCommercial;
    private String nomSAV;
    private String telSAV;
    private String mailSAV;

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getSiteWeb() {
        return siteWeb;
    }

    public void setSiteWeb(String siteWeb) {
        this.siteWeb = siteWeb;
    }

    public String getNomCommercial() {
        return nomCommercial;
    }

    public void setNomCommercial(String nomCommercial) {
        this.nomCommercial = nomCommercial;
    }

    public String getTelCommercial() {
        return telCommercial;
    }

    public void setTelCommercial(String telCommercial) {
        this.telCommercial = telCommercial;
    }

    public String getMailCommercial() {
        return mailCommercial;
    }

    public void setMailCommercial(String mailCommercial) {
        this.mailCommercial = mailCommercial;
    }

    public String getNomSAV() {
        return nomSAV;
    }

    public void setNomSAV(String nomSAV) {
        this.nomSAV = nomSAV;
    }

    public String getTelSAV() {
        return telSAV;
    }

    public void setTelSAV(String telSAV) {
        this.telSAV = telSAV;
    }

    public String getMailSAV() {
        return mailSAV;
    }

    public void setMailSAV(String mailSAV) {
        this.mailSAV = mailSAV;
    }

    public MarqueGyropode(String nom, String siteWeb, String nomCommercial, String telCommercial, String mailCommercial, String nomSAV, String telSAV, String mailSAV) {
        this.nom = nom;
        this.siteWeb = siteWeb;
        this.nomCommercial = nomCommercial;
        this.telCommercial = telCommercial;
        this.mailCommercial = mailCommercial;
        this.nomSAV = nomSAV;
        this.telSAV = telSAV;
        this.mailSAV = mailSAV;
    }

    @Override
    public String toString() {
        return "MarqueGyropode{" + "nom=" + nom + ", siteWeb=" + siteWeb + ", nomCommercial=" + nomCommercial + ", telCommercial=" + telCommercial + ", mailCommercial=" + mailCommercial + ", nomSAV=" + nomSAV + ", telSAV=" + telSAV + ", mailSAV=" + mailSAV + '}';
    }
    
    
    
}
