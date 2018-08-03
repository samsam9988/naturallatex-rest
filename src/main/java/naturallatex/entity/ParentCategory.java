/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package naturallatex.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author sam
 */
@Entity
@Table(name = "parent_category")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ParentCategory.findAll", query = "SELECT p FROM ParentCategory p"),
    @NamedQuery(name = "ParentCategory.findByParentCategoryId", query = "SELECT p FROM ParentCategory p WHERE p.parentCategoryId = :parentCategoryId"),
    @NamedQuery(name = "ParentCategory.findByParentCategoryPhotoUrl", query = "SELECT p FROM ParentCategory p WHERE p.parentCategoryPhotoUrl = :parentCategoryPhotoUrl")})
public class ParentCategory implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "parent_category_id")
    private Integer parentCategoryId;
    @Size(max = 500)
    @Column(name = "parent_category_photo_url")
    private String parentCategoryPhotoUrl;

    public ParentCategory() {
    }

    public ParentCategory(Integer parentCategoryId) {
        this.parentCategoryId = parentCategoryId;
    }

    public Integer getParentCategoryId() {
        return parentCategoryId;
    }

    public void setParentCategoryId(Integer parentCategoryId) {
        this.parentCategoryId = parentCategoryId;
    }

    public String getParentCategoryPhotoUrl() {
        return parentCategoryPhotoUrl;
    }

    public void setParentCategoryPhotoUrl(String parentCategoryPhotoUrl) {
        this.parentCategoryPhotoUrl = parentCategoryPhotoUrl;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (parentCategoryId != null ? parentCategoryId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ParentCategory)) {
            return false;
        }
        ParentCategory other = (ParentCategory) object;
        if ((this.parentCategoryId == null && other.parentCategoryId != null) || (this.parentCategoryId != null && !this.parentCategoryId.equals(other.parentCategoryId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "natural_latex.entity.ParentCategory[ parentCategoryId=" + parentCategoryId + " ]";
    }
    
}
