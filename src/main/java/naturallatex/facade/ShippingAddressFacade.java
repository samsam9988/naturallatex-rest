/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package naturallatex.facade;

import java.util.Collection;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import naturallatex.entity.ShippingAddress;
import naturallatex.utils.RandomNumberUtil;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author sam
 */
 @Transactional
@Repository
public class ShippingAddressFacade extends AbstractFacade<ShippingAddress> implements ShippingAddressFacadeLocal {
    @PersistenceContext
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ShippingAddressFacade() {
        super(ShippingAddress.class);
    }
    
    @Override
    public ShippingAddress findByShippingAddressId(Integer id) {
        Query q = em.createNamedQuery("ShippingAddress.findByShippingAddressId");
        q.setParameter("shippingAddressId", id);
        if (q.getResultList().isEmpty()) {
            return null;
        } else {
            try {
                Collection<ShippingAddress> addrs = (Collection<ShippingAddress>) q.getResultList();
                for (ShippingAddress addr : addrs) {
//                    addr.getCustId();
//                    addr.getCustId().getCustId();
                    addr.getAddress();
                    return addr;
                }
            }
            catch (NoResultException e) {
                return null;
            }
        }
        return null;
//        return (ShippingAddress) q.getResultList().get(0);
    }

    @Override
    public Collection<ShippingAddress> findByCustId(Integer id) {
        Query q = em.createNamedQuery("ShippingAddress.findByCustId");
        q.setParameter("custId", id);
        try {
          return (Collection<ShippingAddress>) q.getResultList();
        } catch (NoResultException e) {
          return null;
        }
    }
    
    @Override
    public Collection<ShippingAddress> findByCustEmailAddress(String emailAddress) {
        Query q = em.createNamedQuery("ShippingAddress.findByCustEmailAddress");
        q.setParameter("emailAddress", emailAddress);
        try {
          return (Collection<ShippingAddress>) q.getResultList();
        } catch (NoResultException e) {
          return null;
        }
    }
    
    @Override
    public ShippingAddress create(ShippingAddress addr) {
        return super.create(addr);
    }
    
    @Override
    public ShippingAddress findByDefaultAddressOfCustId(Integer custId) {
        Query q = em.createNamedQuery("ShippingAddress.findByDefaultAddressOfCustId");
        q.setParameter("custId", custId);
         if (q.getResultList().isEmpty()) {
            return null;
        } 
         ShippingAddress sAddr =  (ShippingAddress) q.getResultList().get(0);
//         sAddr.getCustId().getEmailAddress();
        return sAddr;
    }
    
    @Override
    public ShippingAddress findShippingAddressByNamesOfCustId(Integer custId, ShippingAddress shippingAddress) {
        Collection<ShippingAddress> addrs = this.findByCustId(custId);
        if (CollectionUtils.isEmpty(addrs)) {
            return null;
        }
        for (ShippingAddress _shippingAddr : addrs) {
            if (_shippingAddr != null) {
                if (_shippingAddr.equals(shippingAddress)) {
                    return _shippingAddr;
                }
            }
        }
        return null;
    }
    
}
