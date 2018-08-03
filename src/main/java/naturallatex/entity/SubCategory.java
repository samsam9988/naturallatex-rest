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
@Table(name = "sub_category")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SubCategory.findAll", query = "SELECT s FROM SubCategory s"),
    @NamedQuery(name = "SubCategory.findBySubCategoryId", query = "SELECT s FROM SubCategory s WHERE s.subCategoryId = :subCategoryId"),
    @NamedQuery(name = "SubCategory.findBySubCategoryPhotoUrl", query = "SELECT s FROM SubCategory s WHERE s.subCategoryPhotoUrl = :subCategoryPhotoUrl")})
public class SubCategory implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "sub_category_id")
    private Integer subCategoryId;
    @Size(max = 500)
    @Column(name = "sub_category_photo_url")
    private String subCategoryPhotoUrl;

    public SubCategory() {
    }

    public SubCategory(Integer subCategoryId) {
        this.subCategoryId = subCategoryId;
    }

    public Integer getSubCategoryId() {
        return subCategoryId;
    }

    public void setSubCategoryId(Integer subCategoryId) {
        this.subCategoryId = subCategoryId;
    }

    public String getSubCategoryPhotoUrl() {
        return subCategoryPhotoUrl;
    }

    public void setSubCategoryPhotoUrl(String subCategoryPhotoUrl) {
        this.subCategoryPhotoUrl = subCategoryPhotoUrl;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (subCategoryId != null ? subCategoryId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SubCategory)) {
            return false;
        }
        SubCategory other = (SubCategory) object;
        if ((this.subCategoryId == null && other.subCategoryId != null) || (this.subCategoryId != null && !this.subCategoryId.equals(other.subCategoryId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "natural_latex.entity.SubCategory[ subCategoryId=" + subCategoryId + " ]";
    }
    
}
