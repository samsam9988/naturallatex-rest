package naturallatex.service;

import naturallatex.entity.Category;
import naturallatex.entity.DistParentChildCategoryId;
import naturallatex.entity.DistSubCategory;
import java.util.ArrayList;
import java.util.Collection;

import naturallatex.facade.CategoryFacadeLocal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author sam
 */
@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    CategoryFacadeLocal categoryFacadeLocal;
    
    @Override
    public int count() {
        int c = 0;
        try {   
            c = categoryFacadeLocal.count();
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
        
        return c;
    }
    
    @Override
    public void edit(Category c) {
        try {
           categoryFacadeLocal.edit(c);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    
    @Override
    public void remove(Category c) {
        try {
           categoryFacadeLocal.remove(c);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }
 
    @Override
    public Collection<Category> findAll() {
        Collection<Category> result = new ArrayList<Category>();
        try {
            result = categoryFacadeLocal.findAll();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        
        return result;
    }

   
   
    @Override
    public void create(Category p) {
        try {
           categoryFacadeLocal.create(p);
        } catch (Exception e) {
            throw new RuntimeException(e);
            
        }
    }

  
    

    @Override
    public Category findByCategoryTableId(Integer id) {
        Category p = null;
        try {
           p = categoryFacadeLocal.findByCategoryTableId(id);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return p;
    }

    @Override
    public Collection<Category> findByParentCategoryId(Integer id) {
        Collection<Category> result = new ArrayList<Category>();
        try {
           result = categoryFacadeLocal.findByParentCategoryId(id);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return result;
    }

    @Override
    public Collection<Category> findByParentCategoryName(String name) {
        Collection<Category> result = new ArrayList<Category>();
        try {
           result = categoryFacadeLocal.findByParentCategoryName(name);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return result;
    }

    @Override
    public Category findBySubCategoryId(Integer id) {
        Category p = null;
        try {
           p = categoryFacadeLocal.findBySubCategoryId(id);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return p;
    }

    @Override
    public Category findBySubCategoryName(String name) {
        Category p = null;
        try {
           p = categoryFacadeLocal.findBySubCategoryName(name);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return p;
    }

    @Override
    public Category findByProductId(Integer id) {
        Category p = null;
        try {
           p = categoryFacadeLocal.findByProductId(id);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return p;
    }

    @Override
    public Collection<Category> findByParentCategoryIdAndSubCategoryId(Integer parentCategoryId, Integer subCategoryId) {
        Collection<Category> result = new ArrayList<Category>();
        try {
           result = categoryFacadeLocal.findByParentCategoryIdAndSubCategoryId(parentCategoryId, subCategoryId);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return result;
    }

    @Override
    public Collection<DistParentChildCategoryId> findAllDistParentSubId() {
        Collection<DistParentChildCategoryId> result = new ArrayList<DistParentChildCategoryId>();
        try {
           result = categoryFacadeLocal.findAllDistParentSubId();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return result;
    }

    @Override
    public Collection<Integer> findAllDistParentId() {
        Collection<Integer> result = new ArrayList<>();
        try {
           result = categoryFacadeLocal.findAllDistParentId();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return result;
    }

    @Override
    public Collection<DistSubCategory> findAllDistSubCategory() {
        Collection<DistSubCategory> result = new ArrayList<>();
        try {
           result = categoryFacadeLocal.findAllDistSubCategory();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return result;
    }

    

   
}

