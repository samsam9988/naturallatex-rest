/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package naturallatex.facade;

import java.util.Collection;
 
import naturallatex.entity.ShippingAddress;


/**
 *
 * @author sam
 */
 
public interface ShippingAddressFacadeLocal {

    ShippingAddress create(ShippingAddress c);

    void edit(ShippingAddress c);
    
    Collection<ShippingAddress> findAll();
    
    Collection<ShippingAddress> findByCustEmailAddress(String emailAddress);

    int count();
    
    ShippingAddress findByShippingAddressId(Integer id);
    
    ShippingAddress findByDefaultAddressOfCustId(Integer custId);
    
    Collection<ShippingAddress> findByCustId(Integer id);
    
    ShippingAddress findShippingAddressByNamesOfCustId(Integer custId, ShippingAddress shippingAddress);
}
