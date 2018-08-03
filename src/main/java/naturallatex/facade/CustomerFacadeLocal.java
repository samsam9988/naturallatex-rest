/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package naturallatex.facade;

import naturallatex.entity.BillingAddress;
import java.util.Collection;
 
import naturallatex.entity.Customer;
import naturallatex.entity.PurchaseOrder;
import naturallatex.entity.ShippingAddress;


/**
 *
 * @author sam
 */
 
public interface CustomerFacadeLocal {

    Customer create(Customer customer);
//    void create(Customer cust, ShippingAddress shippingAddress, PreOrder preOrder);

    void edit(Customer customer);
    
//    Integer createAddressAndOrder(Customer cust, PaymentDetail paymentDetail, BillingAddress billingAddress, ShippingAddress shippingAddress, Collection<PurchaseOrder> poList);
//    Integer createAddressAndOrderForNewRegUser(Customer customer, PaymentDetail paymentDetail, BillingAddress billingAddress, ShippingAddress shippingAddress, Collection<PurchaseOrder> poList);
    
    Collection<Customer> findAll();

    int count();
    
    Customer findByCustId(Integer id);
    
    Customer findByEmailAddress(String email);
    
//    Customer findByFirstNullAddressOfCustId(Integer custId);
    
//    MatchingAddress findByBillingShippingAddressOfCustId(Integer custId, BillingAddress billingAddress, ShippingAddress shippingAddress);
            
//    Customer findByDefaultShippingAddressOfCustId(Integer custId);
//    Customer findByDefaultBillingAddressOfCustId(Integer custId);
//    Customer findByBillingShippingAddressOfCustId(Integer custId, BillingAddress billingAddress, ShippingAddress shippingAddress);
//    Customer findByBillingOrShippingAddressOfCustId(Integer custId, BillingAddress billingAddress, ShippingAddress shippingAddress);
    
//    ShippingAddress findShippingAddressByNamesOfCustId(Integer custId, ShippingAddress shippingAddress);
    
//    BillingAddress getDefaultBillingAddress(Customer cust);
//    
//    Collection<BillingAddress> findBillingAddressesByCust(Customer cust);
//
//    Collection<ShippingAddress> findShippingAddressesByCust(Customer cust);
//    
//    Collection<PurchaseOrder> findPurchaseOrdersByCust(Customer cust);

}
