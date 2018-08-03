package naturallatex.service;

import naturallatex.entity.Category;
import naturallatex.entity.DistParentChildCategoryId;
import naturallatex.entity.DistSubCategory;
import java.util.Collection;

public interface CategoryService {

    public void edit(Category c);

    public void remove(Category c);

    public int count();

    public Collection<Category> findAll();
    
     public void create(Category p);

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
