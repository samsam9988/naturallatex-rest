/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package naturallatex.facade;

import java.util.Collection;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import naturallatex.entity.SignupForDiscount;
import java.util.Date;
import javax.persistence.NoResultException;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author sam
 */
 @Transactional
@Repository
public class SignupForDiscountFacade extends AbstractFacade<SignupForDiscount> implements SignupForDiscountFacadeLocal {
    private static final Logger logger = Logger.getLogger(SignupForDiscountFacade.class);
    
    @PersistenceContext
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public SignupForDiscountFacade() {
        super(SignupForDiscount.class);
    }

    @Override
    public SignupForDiscount findByEmailAddress(String emailAddr) {
        Query q = em.createNamedQuery("SignupForDiscount.findByEmailAddress");
        q.setParameter("emailAddress", emailAddr);
         if (q.getResultList().isEmpty()) {
            return null;
        }
         SignupForDiscount blog =  (SignupForDiscount) q.getResultList().get(0);
        return (SignupForDiscount) q.getResultList().get(0);
    }

    @Override
    public Collection<SignupForDiscount> findBySignupDate(Date date) {
        Query q = em.createNamedQuery("SignupForDiscount.findBySignupDate");
        q.setParameter("signupDate", date);
        try {
          return (Collection<SignupForDiscount>) q.getResultList();
        } catch (NoResultException e) {
          return null;
        }
    }
    
   
}
