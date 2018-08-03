/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package naturallatex.facade;

import java.util.Collection;
 
import naturallatex.entity.ProductReview;


/**
 *
 * @author sam
 */
 
public interface ProductReviewFacadeLocal {

    ProductReview create(ProductReview review);

    void edit(ProductReview review);
    
    Collection<ProductReview> findAll();

    int count();
    
    ProductReview findByReviewId(Integer id);

    Collection<ProductReview> findByProductId(Integer id);
}
