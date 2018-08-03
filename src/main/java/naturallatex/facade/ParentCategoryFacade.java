/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package naturallatex.facade;

 
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import naturallatex.entity.ParentCategory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author sam
 */
 @Transactional
@Repository
public class ParentCategoryFacade extends AbstractFacade<ParentCategory> implements ParentCategoryFacadeLocal {
    @PersistenceContext
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ParentCategoryFacade() {
        super(ParentCategory.class);
    }

    @Override
    public ParentCategory findByParentCategoryId(Integer id) {
         Query q = em.createNamedQuery("ParentCategory.findByParentCategoryId");
        q.setParameter("parentCategoryId", id);
        return (ParentCategory) q.getResultList().get(0); 
    }
    
    

   
    
}
