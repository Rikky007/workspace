package cz.vsmie.example.hibernate.db.dao;

import cz.vsmie.example.hibernate.db.entity.Kategorie;
import java.util.List;

/**
 * DAO trida slouzici pro manipulaci s kategoriemi v databazi. Jednotlive metody obecne obsahuji
 * criteria, ktere se posilaji hibernatu.
 * 
 * @author Ing. Jiří Franc
 */
public interface KategorieDAO {
    /**
     * @return vraci vsechny radky v tabulce kategorie
     */
    public List<Kategorie> findAllActive();

    /**
     * 
     * @param idKategorie podle, ktereho chceme najit konkretni kategorii
     * @return vraci kategorii, kterou vyhleda dle predaveneho ID v Hibernatu
     */
    public Kategorie findById(Long idKategorie);

    /**
     * provede ulozeni kategorie do Hibernatu
     * 
     * @param k instance kategorie, ktera se ma ulozit
     */
    public void saveKategorie(Kategorie k);

    /**
     * provede update kategorie v Hibernatu
     * 
     * @param k instance kategorie, nad kterou chceme upravu provest s jiz upravenymi atributy
     */
    public void updateKategorie(Kategorie k);

    /**
     * provede upravu kategorie, kdy kategorii v Hibernatu nastavi atribut 'smazano' na true
     * 
     * @param idKategorie IDecko kategorie, ktera se ma upravit
     */
    public void delete(Long idKategorie);
}
