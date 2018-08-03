/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package naturallatex.facade;

import naturallatex.entity.Customer;
import naturallatex.entity.Product;
import java.util.Collection;
 
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import naturallatex.entity.Payment;
import org.apache.commons.collections.CollectionUtils;
import org.apache.log4j.Logger;
import org.joda.time.DateTime;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author sam
 */
 @Transactional
@Repository
public class PaymentFacade extends AbstractFacade<Payment> implements PaymentFacadeLocal {
    private static final Logger logger = Logger.getLogger(PaymentFacade.class);
    
    @PersistenceContext
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PaymentFacade() {
        super(Payment.class);
    }
    
    @Override
    public Payment findByPaymentId(Integer id) {
        Query q = em.createNamedQuery("Payment.findByPaymentId");
        q.setParameter("paymentId", id);
        if (q.getResultList().isEmpty()) {
            return null;
        }
         Payment po =  (Payment) q.getResultList().get(0);
//         po.getCustId().
//         po.getPaymentDetailId();
        return po;
        
//        return (Payment) q.getResultList().get(0); 
    }

    
     @Override
    public Collection<Payment> findByPaymentDate(DateTime dateTime, int startPosition, int pageSize) {
        Query q = em.createNamedQuery("Payment.findByPaymentDate");
        q.setParameter("paymentDate", dateTime);
        q.setFirstResult(startPosition);
        q.setMaxResults(pageSize);
        try {
          return (Collection<Payment>) q.getResultList();
        } catch (NoResultException e) {
          return null;
        }
    }
    
   
    
    @Override
    public Collection<Payment> findByCustomerId(Integer custId, int startPosition, int pageSize) {
        Query q = em.createNamedQuery("Payment.findByCustomerId");
        q.setParameter("customerId", custId);
        q.setFirstResult(startPosition);
        q.setMaxResults(pageSize);
        try {
          return (Collection<Payment>) q.getResultList();
        } catch (NoResultException e) {
          return null;
        }
    }

    @Override
    public Collection<Payment> findByProductId(Integer productId, int startPosition, int pageSize) {
        Query q = em.createNamedQuery("Payment.findByProductId");
        q.setParameter("productId", productId);
        q.setFirstResult(startPosition);
        q.setMaxResults(pageSize);
        try {
          return (Collection<Payment>) q.getResultList();
        } catch (NoResultException e) {
          return null;
        }
    }

    @Override
    public Customer findCustomerByCustId(Integer custId) {
        Query q = em.createNamedQuery("Payment.findCustomerByCustId");
        q.setParameter("custId", custId);
        Collection<Customer> custList = (Collection<Customer>) q.getResultList();
        try {
            if (CollectionUtils.isEmpty(custList)) return null;
            
            return custList.iterator().next();
        } catch (NoResultException e) {
          return null;
        }
    }

    @Override
    public Product findProductByProductId(Integer productId) {
        Query q = em.createNamedQuery("Payment.findProductByProductId");
        q.setParameter("productId", productId);
        Collection<Product> pList = (Collection<Product>) q.getResultList();
        try {
            if (CollectionUtils.isEmpty(pList)) return null;
            
            return pList.iterator().next();
        } catch (NoResultException e) {
          return null;
        }
    }

    @Override
    public Collection<Payment> findByCustId(Integer custId) {
        Query q = em.createNamedQuery("Payment.findByCustId");
        q.setParameter("custId", custId);
        try {
          return (Collection<Payment>) q.getResultList();
        } catch (NoResultException e) {
          return null;
        }
    }

}
