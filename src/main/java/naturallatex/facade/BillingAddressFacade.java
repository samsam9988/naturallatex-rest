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
import naturallatex.entity.BillingAddress;
import naturallatex.utils.RandomNumberUtil;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Repository
public class BillingAddressFacade extends AbstractFacade<BillingAddress> implements BillingAddressFacadeLocal {
    @PersistenceContext
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public BillingAddressFacade() {
        super(BillingAddress.class);
    }
    
    @Override
    public BillingAddress findByBillingAddressId(Integer id) {
        Query q = em.createNamedQuery("BillingAddress.findByBillingAddressId");
        q.setParameter("billingAddressId", id);
        if (q.getResultList().isEmpty()) {
            return null;
        } else {
            try {
                Collection<BillingAddress> addrs = (Collection<BillingAddress>) q.getResultList();
                for (BillingAddress addr : addrs) {
//                    addr.getCustId();
//                    addr.getCustId().getCustId();
//                    addr.getAddress();
                    return addr;
                }
            }
            catch (NoResultException e) {
                return null;
            }
        }
        return null;
    }

    @Override
    public Collection<BillingAddress> findByCustEmailAddress(String emailAddress) {
        Query q = em.createNamedQuery("BillingAddress.findByCustEmailAddress");
        q.setParameter("emailAddress", emailAddress);
        try {
          return (Collection<BillingAddress>) q.getResultList();
        } catch (NoResultException e) {
          return null;
        }
    }
    
    @Override
    public BillingAddress findByDefaultAddressOfCustId(Integer custId) {
        Query q = em.createNamedQuery("BillingAddress.findByDefaultAddressOfCustId");
        q.setParameter("custId", custId);
         if (q.getResultList().isEmpty()) {
            return null;
        } 
         BillingAddress bAddr =  (BillingAddress) q.getResultList().get(0);
//         bAddr.getCustId().getEmailAddress();
        return bAddr;
    }
}
