/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package naturallatex.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author sam
 */
@Entity
@Table(name = "category")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Category.findAll", query = "SELECT c FROM Category c"),
    @NamedQuery(name = "Category.findByCategoryTableId", query = "SELECT c FROM Category c WHERE c.categoryTableId = :categoryTableId"),
    @NamedQuery(name = "Category.findAllDistParentSubId", query = "SELECT DISTINCT c.parentCategoryId, c.subCategoryId FROM Category c ORDER BY c.parentCategoryId  DESC, c.subCategoryId"),
    @NamedQuery(name = "Category.findAllDistParentId", query = "SELECT DISTINCT c.parentCategoryId FROM Category c ORDER BY c.parentCategoryId  DESC"),
    @NamedQuery(name = "Category.findAllDistSubCategory", query = "SELECT DISTINCT c.subCategoryId, c.subCategoryName FROM Category c ORDER BY c.subCategoryId  DESC"),
    @NamedQuery(name = "Category.findByParentCategoryId", query = "SELECT c FROM Category c WHERE c.parentCategoryId = :parentCategoryId"),
    @NamedQuery(name = "Category.findByParentCategoryName", query = "SELECT c FROM Category c WHERE c.parentCategoryName = :parentCategoryName"),
    @NamedQuery(name = "Category.findBySubCategoryId", query = "SELECT c FROM Category c WHERE c.subCategoryId = :subCategoryId"),
    @NamedQuery(name = "Category.findBySubCategoryName", query = "SELECT c FROM Category c WHERE c.subCategoryName = :subCategoryName"),
    @NamedQuery(name = "Category.findByProductId", query = "SELECT c FROM Category c WHERE c.productId = :productId")})
public class Category implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "category_table_id")
    private Integer categoryTableId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "parent_category_id")
    private int parentCategoryId;
    @Size(max = 30)
    @Column(name = "parent_category_name")
    private String parentCategoryName;
    @Basic(optional = false)
    @NotNull
    @Column(name = "sub_category_id")
    private int subCategoryId;
    @Size(max = 50)
    @Column(name = "sub_category_name")
    private String subCategoryName;
    @Column(name = "product_id")
    private Integer productId;

    public Category() {
    }

    public Category(Integer categoryTableId) {
        this.categoryTableId = categoryTableId;
    }

    public Category(Integer categoryTableId, int parentCategoryId, int subCategoryId) {
        this.categoryTableId = categoryTableId;
        this.parentCategoryId = parentCategoryId;
        this.subCategoryId = subCategoryId;
    }

    public Integer getCategoryTableId() {
        return categoryTableId;
    }

    public void setCategoryTableId(Integer categoryTableId) {
        this.categoryTableId = categoryTableId;
    }

    public int getParentCategoryId() {
        return parentCategoryId;
    }

    public void setParentCategoryId(int parentCategoryId) {
        this.parentCategoryId = parentCategoryId;
    }

    public String getParentCategoryName() {
        return parentCategoryName;
    }

    public void setParentCategoryName(String parentCategoryName) {
        this.parentCategoryName = parentCategoryName;
    }

    public int getSubCategoryId() {
        return subCategoryId;
    }

    public void setSubCategoryId(int subCategoryId) {
        this.subCategoryId = subCategoryId;
    }

    public String getSubCategoryName() {
        return subCategoryName;
    }

    public void setSubCategoryName(String subCategoryName) {
        this.subCategoryName = subCategoryName;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (categoryTableId != null ? categoryTableId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Category)) {
            return false;
        }
        Category other = (Category) object;
        if ((this.categoryTableId == null && other.categoryTableId != null) || (this.categoryTableId != null && !this.categoryTableId.equals(other.categoryTableId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "natural_latex.entity.Category[ categoryTableId=" + categoryTableId + " ]";
    }
    
}
