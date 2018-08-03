/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package naturallatex.facade;

import java.util.Collection;
 
import naturallatex.entity.ProductSize;

/**
 *
 * @author sam
 */
 
public interface ProductSizeFacadeLocal {

//    void create(Product purchaseOrder);
//
//    void edit(Product purchaseOrder);
//
//    void remove(Product purchaseOrder);
//
//    Product find(Object id);
//
//    Collection<Product> findAll();
//
//    Collection<Product> findRange(int[] range);
//
//    int count();
    
    
    public ProductSize findByProductSizeId(Integer productId);
    public ProductSize findByProductIdAndSize(Integer productId, String size);
    public ProductSize findByProductIdAndSizeAndFirmnessAndThickness(Integer productId, String size, String firmness, Integer thickness);
    
    public Collection<ProductSize> findSizesByProductId(Integer productId);
    
    public Collection<String> findDistSizesByProductId(Integer productId);
    public Collection<String> findDistFirmnessesByProductId(Integer productId);
    public Collection<Integer> findDistThicknessesByProductId(Integer productId);
    public Collection<ProductSize> findThicknessesByProductIdAndSize(Integer productId, String sizeName);
    public Collection<ProductSize> findFirmnessesByProductIdAndSizeAndThickness(Integer productId, String sizeName, Integer thickness);
//    public Integer findThicknessByProductIdAndSizeAndFirmness(Integer productId, String sizeName, String firmness);
//    public String findFirmnessByProductIdAndSizeAndThickness(Integer productId, String sizeName, Integer thickness);
}
