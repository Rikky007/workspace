package cz.vsmie.example.hibernate.db.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 * Domain trida kategorie, ktera odpovida databazove tabulce kategorie. Cela je oanotovana pomoci
 * anotaci slouzicich k mapovani tridy na DB tabulku.
 * 
 * @author Ing. Jiří Franc
 */
//anotace pro oznaceni obecne tridy slouzici k mapovani
@Entity
//anotace pro namapovani tabulky, ktera je v postgresu ve schematu public a jmenuje se kategorie
@Table(name="ALBUM")
public class Kategorie implements Serializable {
    private Long id;
    private String nazev;
    private String popis = "test";
    private Boolean smazano = false;
    private Date datumVytvoreni = new Date();

    //anotace pro oznaceni primarniho klice
    @Id 
    //anotace pro namapovani obecne sloupce, zde s nazvem v DB "id"
    @Column(name="ALBUMID", unique=true, nullable=false)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name="TITLE")
    public String getNazev() {
        return nazev;
    }

    public void setNazev(String nazev) {
        this.nazev = nazev;
    }

    @Transient
    public String getPopis() {
        return popis;
    }
    public void setPopis(String popis) {
        this.popis = popis;
    }
    
    @Transient
    public Boolean getSmazano() {
        return smazano;
    }

    public void setSmazano(Boolean smazano) {
        this.smazano = smazano;
    }

    @Transient
    public Date getDatumVytvoreni() {
        return datumVytvoreni;
    }

    public void setDatumVytvoreni(Date datumVytvoreni) {
        this.datumVytvoreni = datumVytvoreni;
    }
}