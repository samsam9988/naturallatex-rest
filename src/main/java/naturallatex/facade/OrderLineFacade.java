/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package naturallatex.facade;

 
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import naturallatex.entity.OrderLine;
import naturallatex.entity.PurchaseOrder;
import naturallatex.utils.RandomNumberUtil;
import java.util.Collection;
import java.util.Iterator;
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
public class OrderLineFacade extends AbstractFacade<OrderLine> implements OrderLineFacadeLocal {
    private static final Logger logger = Logger.getLogger(OrderLineFacade.class);
    
    @PersistenceContext
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public OrderLineFacade() {
        super(OrderLine.class);
    }
    
    @Override
    public OrderLine findByOrderLineId(Integer id) {
        Query q = em.createNamedQuery("OrderLine.findByOrderLineNumber");
        q.setParameter("orderLineNumber", id);
         if (q.getResultList().isEmpty()) {
            return null;
        }
         OrderLine orderLine =  (OrderLine) q.getResultList().get(0);
        return (OrderLine) q.getResultList().get(0);
    }

    @Override
    public Integer createWithPurchaseOrder(PurchaseOrder purchaseOrder, Collection<OrderLine> orderLines) {
        logger.info("===createWithPurchaseOrder==== ");
        Integer id = RandomNumberUtil.bigId();
        purchaseOrder.setOrderId(id);
        Iterator<OrderLine> orderLineIter = orderLines.iterator();
        while (orderLineIter.hasNext()) {
            OrderLine orderLine = orderLineIter.next();
            orderLine.setOrderId(purchaseOrder);
            logger.debug("****orderLine: "+orderLine.toString());
            this.create(orderLine);
        }
//        purchaseOrder.setOrderLineCollection(newOrderLines);
        
//        logger.info("***purchaseOrder: "+purchaseOrder.toString()+"\n\n");
//        logger.info("***newOrderLines(0): "+newOrderLines.iterator().next().toString()+"\n\n");
        return id;
    }

    @Override
    public OrderLine findByOrderIdAndProductSizeId(Integer orderId, Integer productSizeId) {
        Query q = em.createNamedQuery("OrderLine.findByOrderIdAndProductSizeId");
        q.setParameter("orderId", orderId);
        q.setParameter("productSizeId", productSizeId);
         if (q.getResultList().isEmpty()) {
            return null;
        }
         OrderLine orderLine =  (OrderLine) q.getResultList().get(0);
        return (OrderLine) q.getResultList().get(0);
    }

    @Override
    public Collection<OrderLine> findByOrderId(Integer orderId) {
        Query q = em.createNamedQuery("OrderLine.findByOrderId");
        q.setParameter("orderId", orderId);
        try {
          return (Collection<OrderLine>) q.getResultList();
        } catch (NoResultException e) {
          return null;
        }
    }
   
}
