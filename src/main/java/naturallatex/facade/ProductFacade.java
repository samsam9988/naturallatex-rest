/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package naturallatex.facade;

import java.util.Collection;
import java.util.Iterator;
 
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import naturallatex.entity.Product;
import org.apache.commons.collections.CollectionUtils;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author sam
 */
 @Transactional
@Repository
public class ProductFacade extends AbstractFacade<Product> implements ProductFacadeLocal {
    private static final Logger logger = Logger.getLogger(ProductFacade.class);
    @PersistenceContext
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ProductFacade() {
        super(Product.class);
    }

    @Override
    public Collection<Product> findByProductCode(String code) {
        Query q = em.createNamedQuery("Product.findByProductCode");
        q.setParameter("productCode", code);
        try {
          return (Collection<Product>) q.getResultList();
        } catch (NoResultException e) {
          return null;
        }
        
        
    }

    
    
    @Override
    public Product findByProductId(Integer productId) {
        Query q = em.createNamedQuery("Product.findByProductId");
        q.setParameter("productId", productId);
         if (q.getResultList().isEmpty()) {
            return null;
        }
        return (Product) q.getResultList().get(0);
    }

    @Override
    public Product findByProductName(String productName) {
        Query q = em.createNamedQuery("Product.findByProductName");
        q.setParameter("productName", productName);
         if (q.getResultList().isEmpty()) {
            return null;
        }
        return (Product) q.getResultList().get(0);
    }

    @Override
    public void editBatch(Collection<Product> products) {
        if (CollectionUtils.isNotEmpty(products)) {
            Iterator<Product> iter = products.iterator();
            while (iter.hasNext()) {
                Product ol = iter.next();
                if (this.findByProductCode(ol.getProductCode()) != null) {
                    try {
                        super.edit(ol);
                    }
                    catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        }
    }

}
