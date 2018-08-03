/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package naturallatex.facade;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import naturallatex.entity.SubCategory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author sam
 */
 @Transactional
@Repository
public class SubCategoryFacade extends AbstractFacade<SubCategory> implements SubCategoryFacadeLocal {
    @PersistenceContext
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public SubCategoryFacade() {
        super(SubCategory.class);
    }

    @Override
    public SubCategory findBySubCategoryId(Integer id) {
         Query q = em.createNamedQuery("ParentCategory.findBySubCategoryId");
        q.setParameter("parentCategoryId", id);
        return (SubCategory) q.getResultList().get(0); 
    }
    
    

   
    
}
