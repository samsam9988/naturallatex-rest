package naturallatex.service;

import java.util.Collection;
import naturallatex.entity.BillingAddress;

public interface BillingAddressService {
   
    public Collection<BillingAddress> findAll();
    
    public void edit(BillingAddress c);

    public BillingAddress findByBillingAddressId(Integer id);

    BillingAddress findByDefaultAddressOfCustId(Integer custId);
    
    public BillingAddress create(BillingAddress address);
    
    public void remove(Integer id);

}
