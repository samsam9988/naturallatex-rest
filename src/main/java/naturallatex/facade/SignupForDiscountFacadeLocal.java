/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package naturallatex.facade;

import java.util.Collection;
 
import naturallatex.entity.SignupForDiscount;
import java.util.Date;


/**
 *
 * @author sam
 */
 
public interface SignupForDiscountFacadeLocal {

    SignupForDiscount create(SignupForDiscount signup);

    void edit(SignupForDiscount signup);
    
    Collection<SignupForDiscount> findAll();

    int count();
    
    SignupForDiscount findByEmailAddress(String emailAddr);

    Collection<SignupForDiscount> findBySignupDate(Date date);
}
