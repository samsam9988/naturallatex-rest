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

public class DistSubCategory implements Serializable {
    private static final long serialVersionUID = 1L;
    String subCategoryName;
    Integer subCategoryId;

    public String getSubCategoryName() {
        return subCategoryName;
    }

    public void setSubCategoryName(String subCategoryName) {
        this.subCategoryName = subCategoryName;
    }

    public Integer getSubCategoryId() {
        return subCategoryId;
    }

    public void setSubCategoryId(Integer subCategoryId) {
        this.subCategoryId = subCategoryId;
    }

    @Override
    public String toString() {
        return "DistSubCategory{" + "subCategoryName=" + subCategoryName + ", subCategoryId=" + subCategoryId + '}';
    }

    
}