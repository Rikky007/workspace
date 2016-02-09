package cz.vsmie.example.hibernate.db.dao.impl;

import cz.vsmie.example.hibernate.db.dao.KategorieDAO;
import cz.vsmie.example.hibernate.db.entity.Kategorie;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Ing. Jiří Franc
 */
@Transactional
@SuppressWarnings("unchecked")
@Component("kategorieDAO")
public class KategorieDAOImpl implements KategorieDAO {

    @Autowired
    SessionFactory sessionFactory;

    protected Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    @Override
    public List<Kategorie> findAllActive() {
        Criteria c = getSession().createCriteria(Kategorie.class);
        //c.add(Restrictions.eq("smazano", false));
        return c.list();
    }

    @Override
    public Kategorie findById(Long idKategorie) {
        Criteria c = getSession().createCriteria(Kategorie.class);
        c.add(Restrictions.eq("id", idKategorie));
        return (Kategorie) c.uniqueResult();
    }

    @Override
    public void saveKategorie(Kategorie k) {
        getSession().save(k);
    }

    @Override
    public void updateKategorie(Kategorie k) {
        getSession().update(k);
    }

    @Override
    public void delete(Long idKategorie) {
        Kategorie k = findById(idKategorie);
        k.setSmazano(true);
        getSession().update(k);
    }
}
