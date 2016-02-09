/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.vsmie.example.hibernate.service;

import cz.vsmie.example.hibernate.command.AlbumCommand;
import java.util.List;

/**
 *
 * @author Grant
 */
public interface AlbumService {
    
    
    /**
     * @return vsechny ulozene kategerie v DB.
     */
    public List<AlbumCommand> findAll();
    
    /**
     * Metoda pro nalezeni kategorie dle ID v DB.
     * 
     * @param idKategorie bude pouzite jako ID pro vyhledavani
     * @return nalezenou kategorie pripadne null v pripade neuspechu
     */
    public AlbumCommand findById(Long idKategorie);
    
    /**
     * Metoda ulozi kategorii do DB nebo provede update kategorie
     * @param command objekt formulare
     */
    public void saveOrUpdate(AlbumCommand command);

    /**
     * Metoda pro smazani kategorie z DB
     * 
     * @param id pouzije se pro vyhledavani v DB a odstraneni objektu z ni
     */
    public void delete(Long id);
    
}
