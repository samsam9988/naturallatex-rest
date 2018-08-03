/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package naturallatex.facade;

import java.util.Collection;
import java.util.Date;
 
import naturallatex.entity.DiscountCode;


/**
 *
 * @author sam
 */
 
public interface DiscountCodeFacadeLocal {

    DiscountCode create(DiscountCode discountCode);

    void edit(DiscountCode discountCode);
    
    Collection<DiscountCode> findAll();

    int count();
    
    DiscountCode findByDiscountCode(String discountCode);

    Collection<DiscountCode> findByExpiryDateRange(Date startDate, Date endDate);
}
