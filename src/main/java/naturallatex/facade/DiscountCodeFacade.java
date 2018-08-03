/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package naturallatex.facade;

import java.util.Collection;
import java.util.Date;
 
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import naturallatex.entity.DiscountCode;
import javax.persistence.NoResultException;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author sam
 */
 @Transactional
@Repository
public class DiscountCodeFacade extends AbstractFacade<DiscountCode> implements DiscountCodeFacadeLocal {
    private static final Logger logger = Logger.getLogger(DiscountCodeFacade.class);
    
    @PersistenceContext
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public DiscountCodeFacade() {
        super(DiscountCode.class);
    }
    
    @Override
    public DiscountCode findByDiscountCode(String discountCode) {
        Query q = em.createNamedQuery("DiscountCode.findByDiscountCode");
        q.setParameter("discountCode", StringUtils.upperCase(discountCode).trim());
         if (q.getResultList().isEmpty()) {
            return null;
        }
        return (DiscountCode) q.getResultList().get(0);
    }

    @Override
    public Collection<DiscountCode> findByExpiryDateRange(Date startDate, Date endDate) {
        Query q = em.createNamedQuery("DiscountCode.findBySubCategoryId");
        q.setParameter("startExpiryDate", startDate);
        q.setParameter("endExpiryDate", endDate);
        try {
          return (Collection<DiscountCode>) q.getResultList();
        } catch (NoResultException e) {
          return null;
        }
    }
    
   
}
