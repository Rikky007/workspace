package cz.vsmie.example.hibernate.service.impl;

import cz.vsmie.example.hibernate.command.KategorieCommand;
import cz.vsmie.example.hibernate.db.dao.KategorieDAO;
import cz.vsmie.example.hibernate.db.entity.Kategorie;
import cz.vsmie.example.hibernate.service.KategorieService;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Servisni trida, ktera se stara o kategorie.
 *
 * @see KategorieService
 *
 * @author Ing. Jiří Franc
 */
@Component("kategorieService")
public class KategorieServiceImpl implements KategorieService {

    @Autowired
    private KategorieDAO kategorieDAO;

    @Override
    public KategorieCommand findById(Long idKategorie) {
        //z kategorie nalezene v DB si pripravime command object formulare
        Kategorie k = kategorieDAO.findById(idKategorie);
        if (k == null) {
            return null;
        }
        return new KategorieCommand(k.getId(), k.getNazev(), k.getPopis());
    }

    @Override
    public List<KategorieCommand> findAll() {
        List<KategorieCommand> kategorie = new ArrayList<KategorieCommand>();
        //list kategorii prevedeme na list command objectu - nemuseli bychom delat (zde jen pro ilustraci prace s vysledky z DB)
        for (Kategorie k : kategorieDAO.findAllActive()) {
            kategorie.add(new KategorieCommand(k.getId(), k.getNazev(), k.getPopis()));
        }
        return kategorie;
    }

    @Override
    public void saveOrUpdate(KategorieCommand command) {
        //vytvorime instanci domain objektu, kterou nasledne ulozime/upravime v DB
        Kategorie k = new Kategorie();
        k.setNazev(command.getNazev());
        k.setPopis(command.getPopis());
        //pokud nam prisel z formulare command object bez idecka, jedna se o novou kategorii - vkladame
        if (command.getIdKategorie() == null || command.getIdKategorie().equals(0L)) {
            k.setDatumVytvoreni(new Date());
            k.setSmazano(Boolean.FALSE);
            kategorieDAO.saveKategorie(k);
        } //jinak jde o editaci, takze updatujeme
        else {
            k.setId(command.getIdKategorie());
            kategorieDAO.updateKategorie(k);
        }
    }

    @Override
    public void delete(Long id) {
        kategorieDAO.delete(id);
    }
}
