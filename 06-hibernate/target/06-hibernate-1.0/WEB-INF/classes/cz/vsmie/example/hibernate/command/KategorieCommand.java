package cz.vsmie.example.hibernate.command;

import java.util.Date;

/**
 * Trida reprezentuje formular pro pridani/editaci kategorie.
 * V html vyrenderovanem v prohlizeci najdeme input typu hidden s atributem name=idKategorie, 
 * input typu text s atributem name=nazev a 
 * textareu s atributem name=popis
 * 
 * @author Ing. Jiří Franc
 */
public class KategorieCommand {
    private Long idKategorie;
    private String nazev;
    private String popis;
    
    
    private Boolean smazano;
    private Date datumVytvoreni;

    public KategorieCommand() {
    }
    
    public KategorieCommand(Long idKategorie, String nazev, String popis) {
        this.idKategorie = idKategorie;
        this.nazev = nazev;
        this.popis = popis;
    }
    
    public KategorieCommand(Long idKategorie, String nazev, String popis, Boolean smazano, Date datumVytvoreni) {
        this.idKategorie = idKategorie;
        this.nazev = nazev;
        this.popis = popis;
        this.smazano = smazano;
        this.datumVytvoreni = datumVytvoreni;
    }

    public Long getIdKategorie() {
        return idKategorie;
    }

    public void setIdKategorie(Long idKategorie) {
        this.idKategorie = idKategorie;
    }

    public String getNazev() {
        return nazev;
    }

    public void setNazev(String nazev) {
        this.nazev = nazev;
    }

    public String getPopis() {
        return popis;
    }

    public void setPopis(String popis) {
        this.popis = popis;
    }

    public Boolean getSmazano() {
        return smazano;
    }

    public void setSmazano(Boolean smazano) {
        this.smazano = smazano;
    }

    public Date getDatumVytvoreni() {
        return datumVytvoreni;
    }

    public void setDatumVytvoreni(Date datumVytvoreni) {
        this.datumVytvoreni = datumVytvoreni;
    }
}
