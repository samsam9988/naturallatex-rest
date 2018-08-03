/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package naturallatex.facade;

 
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import naturallatex.entity.Reviews;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author sam
 */
 @Transactional
@Repository
public class ReviewsFacade extends AbstractFacade<Reviews> implements ReviewsFacadeLocal {
    private static final Logger logger = Logger.getLogger(ReviewsFacade.class);
    
    @PersistenceContext
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ReviewsFacade() {
        super(Reviews.class);
    }
    
    @Override
    public Reviews findByReviewsId(Integer id) {
        Query q = em.createNamedQuery("Reviews.findByReviewsId");
        q.setParameter("reviewId", id);
         if (q.getResultList().isEmpty()) {
            return null;
        }
         Reviews reviews =  (Reviews) q.getResultList().get(0);
         reviews.getReviewId();
        return (Reviews) q.getResultList().get(0);
    }

    
}
