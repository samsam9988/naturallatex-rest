
package naturallatex.facade;

import java.util.Collection;
import naturallatex.entity.BillingAddress;

public interface BillingAddressFacadeLocal {

    BillingAddress create(BillingAddress c);
    
    void remove(BillingAddress c);

    void edit(BillingAddress c);
    
    Collection<BillingAddress> findAll();
    
    Collection<BillingAddress> findByCustEmailAddress(String emailAddress);

    int count();
    
    BillingAddress findByBillingAddressId(Integer id);
    
    BillingAddress findByDefaultAddressOfCustId(Integer custId);
}
