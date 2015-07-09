/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sessionbeans;

import beans.Utilisateur;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author machd
 */
@Stateless
public class UtilisateurFacade extends AbstractFacade<Utilisateur> {
    @PersistenceContext(unitName = "cedoc3.0PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public Utilisateur findByMP(String mp) {

        Query qr = em.createNamedQuery("Utilisateur.findByMotpasse");
        qr.setParameter("Mot_passe", mp);
        Utilisateur u = (Utilisateur)qr.getSingleResult();
        
        return u;
        
    }
    
    
    
    
    public UtilisateurFacade() {
        super(Utilisateur.class);
    }
    
}
