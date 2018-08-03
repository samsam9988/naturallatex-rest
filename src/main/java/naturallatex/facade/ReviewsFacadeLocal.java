/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package naturallatex.facade;

import java.util.Collection;
 
import naturallatex.entity.Reviews;


/**
 *
 * @author sam
 */
 
public interface ReviewsFacadeLocal {

    Reviews create(Reviews reviews);

    void edit(Reviews reviews);
    
    Collection<Reviews> findAll();

    int count();
    
    Reviews findByReviewsId(Integer id);

//    Collection<Reviews> findByEmailAddress(String email);
}
