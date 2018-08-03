/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package naturallatex.facade;

import naturallatex.entity.Customer;
import naturallatex.entity.Product;
import java.util.Collection;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import naturallatex.entity.PurchaseOrder;
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
public class PurchaseOrderFacade extends AbstractFacade<PurchaseOrder> implements PurchaseOrderFacadeLocal {
    private static final Logger logger = Logger.getLogger(PurchaseOrderFacade.class);
    
    @PersistenceContext
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PurchaseOrderFacade() {
        super(PurchaseOrder.class);
    }
    
    @Override
    public List<PurchaseOrder> findAll() {
        return  null;
    }
    
    @Override
    public List<PurchaseOrder> findRange(int[] range) {
        return null;
    }
    
    @Override
    public PurchaseOrder findByOrderId(Integer id) {
        return null;
//        Query q = em.createNamedQuery("PurchaseOrder.findByOrderId");
//        q.setParameter("orderId", id);
//        if (q.getResultList().isEmpty()) {
//            return null;
//        }
//         PurchaseOrder po =  (PurchaseOrder) q.getResultList().get(0);
////         po.getCustId().
////         po.getPaymentDetailId();
//        return po;
        
//        return (PurchaseOrder) q.getResultList().get(0); 
    }

    @Override
    public Collection<PurchaseOrder> findByOrderLineNumber(Integer id) {
//        Query q = em.createNamedQuery("PurchaseOrder.findByOrderLineNumber");
//        q.setParameter("orderLineNumber", id);
//        Collection<PurchaseOrder> pos  = (Collection<PurchaseOrder>) q.getResultList();
//        try {
////            for (PurchaseOrder po : pos) {
////                po.getCustId().getEmailAddress();
////                po.getOrderDate();
////                po.getOrderId();
////                po.getProductId();
////                po.getQty();
//////                po.getBillingAddressId();
////                po.getPaymentDetailId();
//////                po.getOrderLineNumber();
////                po.getQty();
//////                po.getShippingAddressId();
////                po.getShippingDate();
////                po.getShippingNotes();
////                po.getTransitInsuranceFee();
////            }
//            return pos;
//        } catch (NoResultException e) {
//          return null;
//        }
          return null;
    }
    
    @Override
    public Collection<PurchaseOrder> findByOrderDate(DateTime dateTime, int startPosition, int pageSize) {
        return null;
//        Query q = em.createNamedQuery("PurchaseOrder.findByOrderDate");
//        q.setParameter("orderDate", dateTime);
//        q.setFirstResult(startPosition);
//        q.setMaxResults(pageSize);
//        try {
//          return (Collection<PurchaseOrder>) q.getResultList();
//        } catch (NoResultException e) {
//          return null;
//        }
    }
    
     @Override
    public Collection<PurchaseOrder> findByPaymentDate(DateTime dateTime, int startPosition, int pageSize) {
//        Query q = em.createNamedQuery("PurchaseOrder.findByPaymentDate");
//        q.setParameter("paymentDate", dateTime);
//        q.setFirstResult(startPosition);
//        q.setMaxResults(pageSize);
//        try {
//          return (Collection<PurchaseOrder>) q.getResultList();
//        } catch (NoResultException e) {
//          return null;
//        }
        return null;
    }
    
   
    
    @Override
    public Collection<PurchaseOrder> findByCustomerId(Integer custId, int startPosition, int pageSize) {
//        Query q = em.createNamedQuery("PurchaseOrder.findByCustomerId");
//        q.setParameter("customerId", custId);
//        q.setFirstResult(startPosition);
//        q.setMaxResults(pageSize);
//        try {
//          return (Collection<PurchaseOrder>) q.getResultList();
//        } catch (NoResultException e) {
//          return null;
//        }
    return  null;
    }

    @Override
    public Collection<PurchaseOrder> findByProductId(Integer productId, int startPosition, int pageSize) {
//        Query q = em.createNamedQuery("PurchaseOrder.findByProductId");
//        q.setParameter("productId", productId);
//        q.setFirstResult(startPosition);
//        q.setMaxResults(pageSize);
//        try {
//          return (Collection<PurchaseOrder>) q.getResultList();
//        } catch (NoResultException e) {
//          return null;
//        }
return null;
    }
    


    @Override
    public Customer findCustomerByCustId(Integer custId) {
//        Query q = em.createNamedQuery("PurchaseOrder.findCustomerByCustId");
//        q.setParameter("custId", custId);
//        Collection<Customer> custList = (Collection<Customer>) q.getResultList();
//        try {
//            if (CollectionUtils.isEmpty(custList)) return null;
//            
//            return custList.iterator().next();
//        } catch (NoResultException e) {
//          return null;
//        }
return null;

    }

    @Override
    public Product findProductByProductId(Integer productId) {
//        Query q = em.createNamedQuery("PurchaseOrder.findProductByProductId");
//        q.setParameter("productId", productId);
//        Collection<Product> pList = (Collection<Product>) q.getResultList();
//        try {
//            if (CollectionUtils.isEmpty(pList)) return null;
//            
//            return pList.iterator().next();
//        } catch (NoResultException e) {
//          return null;
//        }
return null;
    }
 

    @Override
    public Collection<PurchaseOrder> findByCustId(Integer custId) {
//        Query q = em.createNamedQuery("PurchaseOrder.findByCustId");
//        q.setParameter("custId", custId);
//        try {
//          return (Collection<PurchaseOrder>) q.getResultList();
//        } catch (NoResultException e) {
//          return null;
//        }
return null;
    }

}
