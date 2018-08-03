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
@Table(name = "product_images")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ProductImages.findAll", query = "SELECT p FROM ProductImages p"),
    @NamedQuery(name = "ProductImages.findByProductImageId", query = "SELECT p FROM ProductImages p WHERE p.productImageId = :productImageId"),
    @NamedQuery(name = "ProductImages.findByProductId", query = "SELECT p FROM ProductImages p WHERE p.productId = :productId"),
    @NamedQuery(name = "ProductImages.findByProductImageUrl", query = "SELECT p FROM ProductImages p WHERE p.productImageUrl = :productImageUrl")})
public class ProductImages implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "product_image_id")
    private Integer productImageId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "product_id")
    private int productId;
    @Size(max = 500)
    @Column(name = "product_image_url")
    private String productImageUrl;
    @Size(max = 500)
    @Column(name = "product_zoom_image_url")
    private String productZoomImageUrl;

    public ProductImages() {
    }

    public ProductImages(Integer productImageId) {
        this.productImageId = productImageId;
    }

    public ProductImages(Integer productImageId, int productId) {
        this.productImageId = productImageId;
        this.productId = productId;
    }

    public Integer getProductImageId() {
        return productImageId;
    }

    public void setProductImageId(Integer productImageId) {
        this.productImageId = productImageId;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductImageUrl() {
        return productImageUrl;
    }

    public void setProductImageUrl(String productImageUrl) {
        this.productImageUrl = productImageUrl;
    }

    public String getProductZoomImageUrl() {
        return productZoomImageUrl;
    }

    public void setProductZoomImageUrl(String productZoomImageUrl) {
        this.productZoomImageUrl = productZoomImageUrl;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (productImageId != null ? productImageId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProductImages)) {
            return false;
        }
        ProductImages other = (ProductImages) object;
        if ((this.productImageId == null && other.productImageId != null) || (this.productImageId != null && !this.productImageId.equals(other.productImageId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "natural_latex.entity.ProductImages[ productImageId=" + productImageId + " ]";
    }
    
}
