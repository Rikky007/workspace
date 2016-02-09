package cz.vsmie.example.hibernate.service;

import cz.vsmie.example.hibernate.command.KategorieCommand;
import java.util.List;

/**
 * Interface servisni tridy, ktera se stara o kategorie. 
 * 
 * @author Ing. Jiří Franc
 */
public interface KategorieService {
    
    /**
     * @return vsechny ulozene kategerie v DB.
     */
    public List<KategorieCommand> findAll();
    
    /**
     * Metoda pro nalezeni kategorie dle ID v DB.
     * 
     * @param idKategorie bude pouzite jako ID pro vyhledavani
     * @return nalezenou kategorie pripadne null v pripade neuspechu
     */
    public KategorieCommand findById(Long idKategorie);
    
    /**
     * Metoda ulozi kategorii do DB nebo provede update kategorie
     * @param command objekt formulare
     */
    public void saveOrUpdate(KategorieCommand command);

    /**
     * Metoda pro smazani kategorie z DB
     * 
     * @param id pouzije se pro vyhledavani v DB a odstraneni objektu z ni
     */
    public void delete(Long id);
}
