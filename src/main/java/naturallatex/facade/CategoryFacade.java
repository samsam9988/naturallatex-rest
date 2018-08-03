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
import naturallatex.entity.Category;
import naturallatex.entity.DistParentChildCategoryId;
import naturallatex.entity.DistSubCategory;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Repository
public class CategoryFacade extends AbstractFacade<Category> implements CategoryFacadeLocal {
    @PersistenceContext
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CategoryFacade() {
        super(Category.class);
    }
    
    

    @Override
    public Category findByCategoryTableId(Integer id) {
        Query q = em.createNamedQuery("Category.findByCategoryTableId");
        q.setParameter("categoryTableId", id);
        return (Category) q.getResultList().get(0); 
    }

    @Override
    public Collection<Category> findByParentCategoryId(Integer id) {
        Query q = em.createNamedQuery("Category.findByParentCategoryId");
        q.setParameter("parentCategoryId", id);
        try {
          return (Collection<Category>) q.getResultList();
        } catch (NoResultException e) {
          return null;
        }
    }

    @Override
    public Collection<Category> findByParentCategoryName(String name) {
        Query q = em.createNamedQuery("Category.findByParentCategoryName");
        q.setParameter("parentCategoryName", name);
        try {
          return (Collection<Category>) q.getResultList();
        } catch (NoResultException e) {
          return null;
        }
    }

    @Override
    public Category findBySubCategoryId(Integer id) {
        Query q = em.createNamedQuery("Category.findBySubCategoryId");
        q.setParameter("subCategoryId", id);
        if (q.getResultList().isEmpty()) {
            return null;
        }
        return (Category) q.getResultList().get(0);
    }

    @Override
    public Category findBySubCategoryName(String name) {
         Query q = em.createNamedQuery("Category.findBySubCategoryName");
        q.setParameter("subCategoryName", name);
        if (q.getResultList().isEmpty()) {
            return null;
        }
        return (Category) q.getResultList().get(0);
    }

    @Override
    public Category findByProductId(Integer id) {
        Query q = em.createNamedQuery("Category.findByProductId");
        q.setParameter("productId", id);
        if (q.getResultList().isEmpty()) {
            return null;
        }
        return (Category) q.getResultList().get(0);
    }

    @Override
    public Collection<Category> findByParentCategoryIdAndSubCategoryId(Integer parentCategoryId, Integer subCategoryId) {
        Query q = em.createNamedQuery("Category.findByParentCategoryIdAndSubCategoryId");
        q.setParameter("parentCategoryId", parentCategoryId);
        q.setParameter("subCategoryId", subCategoryId);
        try {
          return (Collection<Category>) q.getResultList();
        } catch (NoResultException e) {
          return null;
        }
    }

    @Override
    public Collection<DistParentChildCategoryId> findAllDistParentSubId() {
        Query q = em.createNamedQuery("Category.findAllDistParentSubId");
        try {
          Collection<DistParentChildCategoryId> dpcCollection = new ArrayList<DistParentChildCategoryId>();  
          List<Object[]> results = q.getResultList();
          for (Object[] result : results) {
//              System.out.println("Country: " + result[0] + ", Capital: " + result[1]);
              DistParentChildCategoryId dpcCategory = new DistParentChildCategoryId();
              dpcCategory.setParentCategoryId((Integer) result[0]);
              dpcCategory.setSubCategoryId((Integer) result[1]);
              dpcCollection.add(dpcCategory);
          }
          return dpcCollection;
//          return (Collection<Category>) q.getResultList();
        } catch (NoResultException e) {
          return null;
        }
    }

    @Override
    public Collection<Integer> findAllDistParentId() {
        Query q = em.createNamedQuery("Category.findAllDistParentId");
        try {
          Collection<Integer> dpcCollection = new ArrayList<>();  
          Collection<Integer> results = q.getResultList();
          for (Integer result : results) {
              dpcCollection.add(result);
          }
          return dpcCollection;
//          return (Collection<Category>) q.getResultList();
        } catch (NoResultException e) {
          return null;
        }
    }

    @Override
    public Collection<DistSubCategory> findAllDistSubCategory() {
        Query q = em.createNamedQuery("Category.findAllDistSubCategory");
        try {
          Collection<DistSubCategory> dpcCollection = new ArrayList<>();  
          Collection<Object[]> results = q.getResultList();
          for (Object[] result : results) {
              DistSubCategory dpcCategory = new DistSubCategory();
              dpcCategory.setSubCategoryId((Integer) result[0]);
              dpcCategory.setSubCategoryName((String) result[1]);
              dpcCollection.add(dpcCategory);
          }
          return dpcCollection;
//          return (Collection<Category>) q.getResultList();
        } catch (NoResultException e) {
          return null;
        }
    }
    
}
