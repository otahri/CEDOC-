/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sessionbeans;

import beans.Doctorant;
import beans.ObtenirDiplome;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author machd
 */
@Stateless
public class ObtenirDiplomeFacade extends AbstractFacade<ObtenirDiplome> {
    @PersistenceContext(unitName = "cedoc3.0PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ObtenirDiplomeFacade() {
        super(ObtenirDiplome.class);
    }
    
     public List obtByDoc(int i) {
        Query rq = em.createNamedQuery("Doctorant.findByIdDoctorant");
        rq.setParameter("idDoctorant", i);
        Doctorant doc = (Doctorant) rq.getSingleResult();
        Query req = em.createNamedQuery("ObtenirDiplome.findByidDoctorant");

        req.setParameter("idDoctorant", doc);
        return req.getResultList();
    }
    
}
