/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package naturallatex.entity;

import java.io.Serializable;


/**
 *
 * @author sam
 */

public class DistParentChildCategoryId implements Serializable {
    private static final long serialVersionUID = 1L;
    Integer parentCategoryId;
    Integer subCategoryId;

    public Integer getParentCategoryId() {
        return parentCategoryId;
    }

    public void setParentCategoryId(Integer parentCategoryId) {
        this.parentCategoryId = parentCategoryId;
    }

    public Integer getSubCategoryId() {
        return subCategoryId;
    }

    public void setSubCategoryId(Integer subCategoryId) {
        this.subCategoryId = subCategoryId;
    }

    @Override
    public String toString() {
        return "DistParentChildCategoryId{" + "parentCategoryId=" + parentCategoryId + ", subCategoryId=" + subCategoryId + '}';
    }
    
    
    
}