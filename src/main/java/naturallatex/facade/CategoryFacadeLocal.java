/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package naturallatex.facade;

import java.util.Collection;
 
import naturallatex.entity.Category;
import naturallatex.entity.DistParentChildCategoryId;
import naturallatex.entity.DistSubCategory;

public interface CategoryFacadeLocal {

    Category create(Category category);

    void edit(Category category);

    void remove(Category category);

    Category find(Object id);

    Collection<Category> findAll();

    Collection<Category> findRange(int[] range);

    int count();
    
    public Category findByCategoryTableId(Integer id);
    public Collection<Category> findByParentCategoryId(Integer id);
    public Collection<Category> findByParentCategoryName(String name);
    public Category findBySubCategoryId(Integer id);
    public Category findBySubCategoryName(String name);
    public Category findByProductId(Integer id);
    public Collection<Category> findByParentCategoryIdAndSubCategoryId(Integer parentCategoryId, Integer subCategoryId);
    public Collection<DistParentChildCategoryId> findAllDistParentSubId();
    public Collection<Integer> findAllDistParentId();
    public Collection<DistSubCategory> findAllDistSubCategory();
    
}
