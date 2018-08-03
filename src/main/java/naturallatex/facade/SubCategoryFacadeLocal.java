/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package naturallatex.facade;

import java.util.Collection;
 
import naturallatex.entity.SubCategory;


/**
 *
 * @author sam
 */
 
public interface SubCategoryFacadeLocal {

    SubCategory create(SubCategory parentCategory);

    void edit(SubCategory SubCategory);

    void remove(SubCategory SubCategory);

    SubCategory find(Object id);

    Collection<SubCategory> findAll();

    int count();
    
    public SubCategory findBySubCategoryId(Integer id);
    
    
}
