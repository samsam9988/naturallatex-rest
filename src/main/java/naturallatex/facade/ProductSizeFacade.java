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
import org.apache.log4j.Logger;
import naturallatex.entity.ProductSize;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author sam
 */
 @Transactional
@Repository
public class ProductSizeFacade extends AbstractFacade<ProductSize> implements ProductSizeFacadeLocal {
    private static final Logger logger = Logger.getLogger(ProductSizeFacade.class);
    @PersistenceContext
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ProductSizeFacade() {
        super(ProductSize.class);
    }

    
    @Override
    public ProductSize findByProductSizeId(Integer sizeId) {
        Query q = em.createNamedQuery("ProductSize.findByProductSizeId");
        q.setParameter("productSizeId", sizeId);
         if (q.getResultList().isEmpty()) {
            return null;
        }
        return (ProductSize) q.getResultList().get(0);
    }

    @Override
    public ProductSize findByProductIdAndSize(Integer productId, String size) {
        Query q = em.createNamedQuery("ProductSize.findByProductIdAndSize");
        q.setParameter("productId", productId);
        q.setParameter("sizeName", size);
         if (q.getResultList().isEmpty()) {
            return null;
        }
        return (ProductSize) q.getResultList().get(0);
    }

    @Override
    public ProductSize findByProductIdAndSizeAndFirmnessAndThickness(Integer productId, String size, String firmness, Integer thickness) {
        Query q = em.createNamedQuery("ProductSize.findByProductIdAndSizeAndFirmnessAndThickness");
        q.setParameter("productId", productId);
        q.setParameter("sizeName", size);
        q.setParameter("firmness", firmness);
        q.setParameter("thickness", thickness);
         if (q.getResultList().isEmpty()) {
            return null;
        }
        return (ProductSize) q.getResultList().get(0);
    }

    @Override
    public Collection<ProductSize> findSizesByProductId(Integer productId) {
        Query q = em.createNamedQuery("ProductSize.findSizesByProductId");
        q.setParameter("productId", productId);
        try {
          return (Collection<ProductSize>) q.getResultList();
        } catch (NoResultException e) {
          return null;
        }
    }

    @Override
    public Collection<ProductSize> findThicknessesByProductIdAndSize(Integer productId, String sizeName) {
        Query q = em.createNamedQuery("ProductSize.findThicknessesByProductIdAndSize");
        q.setParameter("productId", productId);
        q.setParameter("sizeName", sizeName);
        try {
          return (Collection<ProductSize>) q.getResultList();
        } catch (NoResultException e) {
          return null;
        }
    }

    @Override
    public Collection<ProductSize> findFirmnessesByProductIdAndSizeAndThickness(Integer productId, String sizeName, Integer thickness) {
        Query q = em.createNamedQuery("ProductSize.findFirmnessesByProductIdAndSizeAndThickness");
        q.setParameter("productId", productId);
        q.setParameter("sizeName", sizeName);
        q.setParameter("thickness", thickness);
        try {
          return (Collection<ProductSize>) q.getResultList();
        } catch (NoResultException e) {
          return null;
        }
    }

    @Override
    public Collection<String> findDistFirmnessesByProductId(Integer productId) {
        Query q = em.createNamedQuery("ProductSize.findDistFirmnessesByProductId");
        q.setParameter("productId", productId);
        try {
          return (Collection<String>) q.getResultList();
        } catch (NoResultException e) {
          return null;
        }
    }

    @Override
    public Collection<Integer> findDistThicknessesByProductId(Integer productId) {
        Query q = em.createNamedQuery("ProductSize.findDistThicknessesByProductId");
        q.setParameter("productId", productId);
        try {
          return (Collection<Integer>) q.getResultList();
        } catch (NoResultException e) {
          return null;
        }
    }

    @Override
    public Collection<String> findDistSizesByProductId(Integer productId) {
         Query q = em.createNamedQuery("ProductSize.findDistSizesByProductId");
        q.setParameter("productId", productId);
        try {
          return (Collection<String>) q.getResultList();
        } catch (NoResultException e) {
          return null;
        }
    }
//
//    @Override
//    public Integer findThicknessByProductIdAndSizeAndFirmness(Integer productId, String sizeName, String firmness) {
//        Query q = em.createNamedQuery("ProductSize.findThicknessByProductIdAndSizeAndFirmness");
//        q.setParameter("productId", productId);
//        q.setParameter("sizeName", sizeName);
//        q.setParameter("firmness", firmness);
//         if (q.getResultList().isEmpty()) {
//            return null;
//        }
//        return (Integer) q.getResultList().get(0);
//    }
//
//    @Override
//    public String findFirmnessByProductIdAndSizeAndThickness(Integer productId, String sizeName, Integer thickness) {
//        Query q = em.createNamedQuery("ProductSize.findFirmnessByProductIdAndSizeAndThickness");
//        q.setParameter("productId", productId);
//        q.setParameter("sizeName", sizeName);
//        q.setParameter("thickness", thickness);
//         if (q.getResultList().isEmpty()) {
//            return null;
//        }
//        return (String) q.getResultList().get(0);
//    }
}
