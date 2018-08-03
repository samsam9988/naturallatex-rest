/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package naturallatex.facade;

import java.util.Collection;
 
import naturallatex.entity.ProductImages;


/**
 *
 * @author sam
 */
 
public interface ProductImagesFacadeLocal {

    ProductImages create(ProductImages productImages);

    void edit(ProductImages ProductImages);

    void remove(ProductImages ProductImages);

    ProductImages find(Object id);

    Collection<ProductImages> findAll();

    int count();
    
    public ProductImages findByProductImagesId(Integer id);
    public Collection<ProductImages> findByProductId(Integer id);
    
    
}
