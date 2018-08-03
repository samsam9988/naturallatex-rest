/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package naturallatex.facade;

import java.util.Collection;
 
import naturallatex.entity.OrderLine;
import naturallatex.entity.PurchaseOrder;


/**
 *
 * @author sam
 */
 
public interface OrderLineFacadeLocal {

    OrderLine create(OrderLine orderLine);

    void edit(OrderLine orderLine);
    
    Collection<OrderLine> findAll();

    int count();
    
    OrderLine findByOrderLineId(Integer id);
    Collection<OrderLine> findByOrderId(Integer orderId);

    Integer createWithPurchaseOrder(PurchaseOrder purchaseOrder, Collection<OrderLine> orderLines);
    
    OrderLine findByOrderIdAndProductSizeId(Integer orderId, Integer productSizeId);
}
