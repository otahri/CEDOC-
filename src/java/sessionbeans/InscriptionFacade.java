/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sessionbeans;

import beans.Doctorant;
import beans.Inscription;
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
public class InscriptionFacade extends AbstractFacade<Inscription> {
    @PersistenceContext(unitName = "cedoc3.0PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public InscriptionFacade() {
        super(Inscription.class);
    }
    
    public boolean getbyetat ()
    {
        return em.createNamedQuery("").setParameter("etat", "En attente").getResultList().isEmpty();
   
    } 
    
     public List getCountByYear(){
        Query req=em.createNamedQuery("Inscription.findCountByYear");
        return req.getResultList();
    }
     
    public List getInscrByEtat(String etat){
        Query req=em.createNamedQuery("Inscription.findCountByYearEtat").setParameter("etat", etat);
        return req.getResultList();
    }
    
    public Inscription getInscrByDoc(int i) {
        Query rq = em.createNamedQuery("Doctorant.findByIdDoctorant");
        rq.setParameter("idDoctorant", i);
        Doctorant doc=(Doctorant) rq.getSingleResult();
        Query req = em.createNamedQuery("Inscription.findByDoctorant");
        req.setParameter("idDoctorant", doc);
        return (Inscription) req.getSingleResult();
    }
    
    
}
