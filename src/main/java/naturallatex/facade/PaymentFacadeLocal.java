/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package naturallatex.facade;

import naturallatex.entity.Customer;
import naturallatex.entity.Payment;
import java.util.Collection;
 
import naturallatex.entity.Product;
import org.joda.time.DateTime;

/**
 *
 * @author sam
 */
 
public interface PaymentFacadeLocal {

    Payment create(Payment payment);

    void edit(Payment payment);

    void remove(Payment payment);

    Payment find(Object id);

    Collection<Payment> findRange(int[] range);

    Collection<Payment> findAll();

    int count();

    public Payment findByPaymentId(Integer id);

    public Collection<Payment> findByPaymentDate(DateTime dateTime, int startPosition, int pageSize);

    public Collection<Payment> findByCustomerId(Integer custId, int startPosition, int pageSize);

    public Collection<Payment> findByProductId(Integer productId, int startPosition, int pageSize);

    public Customer findCustomerByCustId(Integer custId);

    public Product findProductByProductId(Integer productId);

    public Collection<Payment> findByCustId(Integer custId);
}
