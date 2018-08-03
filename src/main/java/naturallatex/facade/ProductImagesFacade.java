/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package naturallatex.facade;

 
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import naturallatex.entity.ProductImages;
import java.util.Collection;
import javax.persistence.NoResultException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author sam
 */
 @Transactional
@Repository
public class ProductImagesFacade extends AbstractFacade<ProductImages> implements ProductImagesFacadeLocal {
    @PersistenceContext
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ProductImagesFacade() {
        super(ProductImages.class);
    }

    @Override
    public ProductImages findByProductImagesId(Integer id) {
         Query q = em.createNamedQuery("ProductImages.findByProductImagesId");
        q.setParameter("productImagesId", id);
        return (ProductImages) q.getResultList().get(0); 
    }

    @Override
    public Collection<ProductImages> findByProductId(Integer id) {
        Query q = em.createNamedQuery("ProductImages.findByProductId");
        q.setParameter("productId", id);
        try {
          return (Collection<ProductImages>) q.getResultList();
        } catch (NoResultException e) {
          return null;
        }
    }
    
    

   
    
}
