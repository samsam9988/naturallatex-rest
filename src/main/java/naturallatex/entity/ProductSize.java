/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package naturallatex.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author sam
 */
@Entity
@Table(name = "product_size")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ProductSize.findAll", query = "SELECT p FROM ProductSize p"),
    @NamedQuery(name = "ProductSize.findByProductSizeId", query = "SELECT p FROM ProductSize p WHERE p.productSizeId = :productSizeId"),
    @NamedQuery(name = "ProductSize.findByProductIdAndSize", query = "SELECT p FROM ProductSize p WHERE p.sizeName = :sizeName AND p.productId.productId = :productId"),
    @NamedQuery(name = "ProductSize.findByProductIdAndSizeAndFirmnessAndThickness", query = "SELECT p FROM ProductSize p WHERE p.sizeName = :sizeName AND p.firmness = :firmness AND p.thickness = :thickness AND p.productId.productId = :productId"),
    
    @NamedQuery(name = "ProductSize.findSizesByProductId", query = "SELECT p FROM ProductSize p WHERE p.productId.productId = :productId"),
    @NamedQuery(name = "ProductSize.findThicknessesByProductIdAndSize", query = "SELECT p FROM ProductSize p WHERE p.productId.productId = :productId AND p.sizeName = :sizeName"),
    @NamedQuery(name = "ProductSize.findFirmnessesByProductIdAndSizeAndThickness", query = "SELECT p FROM ProductSize p WHERE p.productId.productId = :productId AND p.sizeName = :sizeName AND p.thickness = :thickness"),
    @NamedQuery(name = "ProductSize.findDistSizesByProductId", query = "SELECT DISTINCT p.sizeName FROM ProductSize p WHERE p.productId.productId = :productId"),
    @NamedQuery(name = "ProductSize.findDistFirmnessesByProductId", query = "SELECT DISTINCT p.firmness FROM ProductSize p WHERE p.productId.productId = :productId"),
    @NamedQuery(name = "ProductSize.findDistThicknessesByProductId", query = "SELECT DISTINCT p.thickness FROM ProductSize p WHERE p.productId.productId = :productId"),
//    @NamedQuery(name = "ProductSize.findThicknessByProductIdAndSizeAndFirmness", query = "SELECT p.thickness FROM ProductSize p WHERE p.productId.productId = :productId AND p.sizeName = :sizeName AND p.firmness = :firmness"),
//    @NamedQuery(name = "ProductSize.findFirmnessByProductIdAndSizeAndThickness", query = "SELECT p.thickness FROM ProductSize p WHERE p.productId.productId = :productId AND p.sizeName = :sizeName AND p.thickness = :thickness"),
    
    @NamedQuery(name = "ProductSize.findBySizeName", query = "SELECT p FROM ProductSize p WHERE p.sizeName = :sizeName"),
    @NamedQuery(name = "ProductSize.findByUnitPrice", query = "SELECT p FROM ProductSize p WHERE p.unitPrice = :unitPrice"),
    @NamedQuery(name = "ProductSize.findByOldUnitPrice", query = "SELECT p FROM ProductSize p WHERE p.oldUnitPrice = :oldUnitPrice"),
    @NamedQuery(name = "ProductSize.findByQty", query = "SELECT p FROM ProductSize p WHERE p.qty = :qty")})
public class ProductSize implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "product_size_id")
    private Integer productSizeId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "size_name")
    private String sizeName;
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "firmness")
    private String firmness;
    @NotNull
    @Column(name = "thickness")
    private Integer thickness;
    @Size(min = 1, max = 30)
    @Column(name = "dimension")
    private String dimension;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "unit_price")
    private Double unitPrice;
    @Column(name = "old_unit_price")
    private Double oldUnitPrice;
    private Integer qty;
    @Column(name = "visit_count")
    private Integer visitCount;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "productSizeId")
    private Collection<OrderLine> orderLineCollection;
    @JoinColumn(name = "product_id", referencedColumnName = "product_id")
    @ManyToOne(optional = false)
    private Product productId;

    public ProductSize() {
    }

    public ProductSize(Integer productSizeId) {
        this.productSizeId = productSizeId;
    }

    public ProductSize(Integer productSizeId, String sizeName) {
        this.productSizeId = productSizeId;
        this.sizeName = sizeName;
    }

    public Integer getProductSizeId() {
        return productSizeId;
    }

    public void setProductSizeId(Integer productSizeId) {
        this.productSizeId = productSizeId;
    }

    public String getSizeName() {
        return sizeName;
    }

    public void setSizeName(String sizeName) {
        this.sizeName = sizeName;
    }

    public String getFirmness() {
        return firmness;
    }

    public String getDimension() {
        return dimension;
    }

    public void setDimension(String dimension) {
        this.dimension = dimension;
    }

    
    public void setFirmness(String firmness) {
        this.firmness = firmness;
    }

    public Integer getThickness() {
        return thickness;
    }

    public void setThickness(Integer thickness) {
        this.thickness = thickness;
    }

    
    public Double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(Double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public Double getOldUnitPrice() {
        return oldUnitPrice;
    }

    public void setOldUnitPrice(Double oldUnitPrice) {
        this.oldUnitPrice = oldUnitPrice;
    }

    public Integer getQty() {
        return qty;
    }

    public void setQty(Integer qty) {
        this.qty = qty;
    }

    public Integer getVisitCount() {
        return visitCount;
    }

    public void setVisitCount(Integer visitCount) {
        this.visitCount = visitCount;
    }

    
    @XmlTransient
    @JsonIgnore
    public Collection<OrderLine> getOrderLineCollection() {
        return orderLineCollection;
    }

    public void setOrderLineCollection(Collection<OrderLine> orderLineCollection) {
        this.orderLineCollection = orderLineCollection;
    }

    public Product getProductId() {
        return productId;
    }

    public void setProductId(Product productId) {
        this.productId = productId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (productSizeId != null ? productSizeId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProductSize)) {
            return false;
        }
        ProductSize other = (ProductSize) object;
        if ((this.productSizeId == null && other.productSizeId != null) || (this.productSizeId != null && !this.productSizeId.equals(other.productSizeId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "natural_latex.entity.ProductSize[ productSizeId=" + productSizeId + " ]";
    }
    
}
