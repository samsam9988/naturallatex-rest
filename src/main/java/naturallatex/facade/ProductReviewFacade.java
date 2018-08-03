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
import naturallatex.entity.ProductReview;
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
public class ProductReviewFacade extends AbstractFacade<ProductReview> implements ProductReviewFacadeLocal {
    private static final Logger logger = Logger.getLogger(ProductReviewFacade.class);
    
    @PersistenceContext
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ProductReviewFacade() {
        super(ProductReview.class);
    }
    
    @Override
    public ProductReview findByReviewId(Integer id) {
        Query q = em.createNamedQuery("ProductReview.findByReviewId");
        q.setParameter("reviewId", id);
         if (q.getResultList().isEmpty()) {
            return null;
        }
         ProductReview blog =  (ProductReview) q.getResultList().get(0);
        return (ProductReview) q.getResultList().get(0);
    }

    @Override
    public Collection<ProductReview> findByProductId(Integer id) {
        Query q = em.createNamedQuery("ProductReview.findByProductId");
        q.setParameter("productId", id);
        try {
          return (Collection<ProductReview>) q.getResultList();
        } catch (NoResultException e) {
          return null;
        }
    }
    
   
}
