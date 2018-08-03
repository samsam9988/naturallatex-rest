/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package naturallatex.service;

import java.util.Collection;
import naturallatex.entity.BillingAddress;
import naturallatex.facade.BillingAddressFacadeLocal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BillingAddressServiceImpl implements BillingAddressService {

    @Autowired
    BillingAddressFacadeLocal billingAddressFacadeLocal;
            
    @Override
    public void edit(BillingAddress c) {
        try {
           billingAddressFacadeLocal.edit(c);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public BillingAddress create(BillingAddress address) {
        try {
           return billingAddressFacadeLocal.create(address);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public BillingAddress findByBillingAddressId(Integer id) {
        try {
           return billingAddressFacadeLocal.findByBillingAddressId(id);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public BillingAddress findByDefaultAddressOfCustId(Integer custId) {
        try {
           return billingAddressFacadeLocal.findByDefaultAddressOfCustId(custId);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Collection<BillingAddress> findAll() {
        return billingAddressFacadeLocal.findAll();
    }

    @Override
    public void remove(Integer id) {
        try {
           BillingAddress billingAddress = billingAddressFacadeLocal.findByBillingAddressId(id);
           billingAddressFacadeLocal.remove(billingAddress);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
