/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package naturallatex.facade;

import java.util.Collection;
 
import naturallatex.entity.ParentCategory;


 
public interface ParentCategoryFacadeLocal {

    ParentCategory create(ParentCategory parentCategory);

    void edit(ParentCategory ParentCategory);

    void remove(ParentCategory ParentCategory);

    ParentCategory find(Object id);

    Collection<ParentCategory> findAll();

    int count();
    
    public ParentCategory findByParentCategoryId(Integer id);
    
    
}
