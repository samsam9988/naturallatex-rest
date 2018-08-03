/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package naturallatex.facade;

import naturallatex.entity.Customer;
import naturallatex.entity.PurchaseOrder;
import java.util.Collection;
 
import naturallatex.entity.Product;
import org.joda.time.DateTime;

/**
 *
 * @author sam
 */
 
public interface PurchaseOrderFacadeLocal {

    PurchaseOrder create(PurchaseOrder purchaseOrder);
    
    // return orderId
//    Integer createWithOrderLine(PurchaseOrder purchaseOrder, Collection<OrderLine> orderLines);
//    void createBatch(Collection<PurchaseOrder> purchaseOrders);

    void edit(PurchaseOrder purchaseOrder);
//    void editBatch(Collection<PurchaseOrder> purchaseOrders);

    void remove(PurchaseOrder purchaseOrder);

    PurchaseOrder find(Object id);
    
    Collection<PurchaseOrder> findRange(int[] range);
    
    Collection<PurchaseOrder> findAll();

    int count();
    
    public PurchaseOrder findByOrderId(Integer id);
    public Collection<PurchaseOrder> findByOrderDate(DateTime dateTime, int startPosition, int pageSize);
    public Collection<PurchaseOrder> findByPaymentDate(DateTime dateTime, int startPosition, int pageSize);
    public Collection<PurchaseOrder> findByCustomerId(Integer custId, int startPosition, int pageSize);
    public Collection<PurchaseOrder> findByProductId(Integer productId, int startPosition, int pageSize);
    public Collection<PurchaseOrder> findByOrderLineNumber(Integer id);
    public Customer findCustomerByCustId(Integer custId);
    public Product findProductByProductId(Integer productId);
    public Collection<PurchaseOrder> findByCustId(Integer custId);
//    public Collection<PurchaseOrder> findByEmailAddress(String emailAddress);
    
//    public Integer createWithPurchaseOrder(PurchaseOrder purchaseOrder, Collection<OrderLine> orderLines);
    
}
