/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package naturallatex.facade;

import naturallatex.entity.Product;
import java.util.Collection;
import java.util.List;
 

/**
 *
 * @author sam
 */
 
public interface ProductFacadeLocal {

    Product create(Product purchaseOrder);
//    void createBatch(List<Product> products);
//    void createByShoppingCart(List<Product> products);

    void editBatch(Collection<Product> products);

    void edit(Product purchaseOrder);

    void remove(Product purchaseOrder);

    Product find(Object id);

    Collection<Product> findAll();

    Collection<Product> findRange(int[] range);

    int count();
    
    
    public Collection<Product> findByProductCode(String code);
    public Product findByProductId(Integer productId);
    public Product findByProductName(String productName);

    
}
