/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package naturallatex.facade;

import java.util.Collection;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import naturallatex.entity.ContactUs;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author sam
 */
@Transactional
@Repository
public class ContactUsFacade extends AbstractFacade<ContactUs> implements ContactUsFacadeLocal {
    @PersistenceContext
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ContactUsFacade() {
        super(ContactUs.class);
    }
    
    @Override
    public ContactUs findByContactId(Integer id) {
        Query q = em.createNamedQuery("ContactUs.findByContactId");
        q.setParameter("contactId", id);
        if (q.getResultList().isEmpty()) {
            return null;
        }
        return (ContactUs) q.getResultList().get(0); 
    }
    
    @Override
    public Collection<ContactUs> findBySubject(String subject) {
        Query q = em.createNamedQuery("ContactUs.findBySubject");
        q.setParameter("subject", subject);
        try {
          return (Collection<ContactUs>) q.getResultList();
        } catch (NoResultException e) {
          return null;
        }
    }
   @Override
    public ContactUs findByEmailAddress(String emailAddress) {
        Query q = em.createNamedQuery("ContactUs.findByEmailAddress");
        q.setParameter("emailAddress", emailAddress);
        if (q.getResultList().isEmpty()) {
            return null;
        }
        return (ContactUs) q.getResultList().get(0); 
    }
    
    
    @Override
    public Collection<ContactUs> findByName(String name) {
        Query q = em.createNamedQuery("ContactUs.findByName");
        q.setParameter("name", name);
        try {
          return (Collection<ContactUs>) q.getResultList();
        } catch (NoResultException e) {
          return null;
        }
    }
    
    @Override
    public ContactUs findByEmailAndMessage(String email, String message) {
        Query q = em.createNamedQuery("ContactUs.findByEmailAndMessage");
        q.setParameter("emailAddress", email);
        q.setParameter("message", message);
        if (q.getResultList().isEmpty()) {
            return null;
        }
        return (ContactUs) q.getResultList().get(0); 
    }
}
