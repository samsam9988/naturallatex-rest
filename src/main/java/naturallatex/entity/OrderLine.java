/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package naturallatex.entity;

import java.io.Serializable;
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
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author sam
 */
@Entity
@Table(name = "order_line")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "OrderLine.findAll", query = "SELECT o FROM OrderLine o"),
    @NamedQuery(name = "OrderLine.findByOrderLineNumber", query = "SELECT o FROM OrderLine o WHERE o.orderLineNumber = :orderLineNumber"),
    @NamedQuery(name = "OrderLine.findByOrderId", query = "SELECT o FROM OrderLine o WHERE o.orderId.orderId = :orderId"),
    @NamedQuery(name = "OrderLine.findByOrderIdAndProductSizeId", query = "SELECT o FROM OrderLine o WHERE o.orderId.orderId = :orderId And o.productSizeId.productSizeId = :productSizeId"),
    @NamedQuery(name = "OrderLine.findByQty", query = "SELECT o FROM OrderLine o WHERE o.qty = :qty")})
public class OrderLine implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "order_line_number")
    private Integer orderLineNumber;
    private Integer qty;
    @Column(name = "unit_price")
    private Double unitPrice;
    @JoinColumn(name = "product_size_id", referencedColumnName = "product_size_id")
    @ManyToOne(optional = false)
    private ProductSize productSizeId;
    @JoinColumn(name = "order_id", referencedColumnName = "order_id")
    @ManyToOne(optional = false, cascade = CascadeType.ALL)
    private PurchaseOrder orderId;

    public OrderLine() {
    }

    public OrderLine(Integer orderLineNumber) {
        this.orderLineNumber = orderLineNumber;
    }

    public Double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(Double unitPrice) {
        this.unitPrice = unitPrice;
    }

    
    public Integer getOrderLineNumber() {
        return orderLineNumber;
    }

    public void setOrderLineNumber(Integer orderLineNumber) {
        this.orderLineNumber = orderLineNumber;
    }

    public Integer getQty() {
        return qty;
    }

    public void setQty(Integer qty) {
        this.qty = qty;
    }

    public ProductSize getProductSizeId() {
        return productSizeId;
    }

    public void setProductSizeId(ProductSize productSizeId) {
        this.productSizeId = productSizeId;
    }

    public PurchaseOrder getOrderId() {
        return orderId;
    }

    public void setOrderId(PurchaseOrder orderId) {
        this.orderId = orderId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (orderLineNumber != null ? orderLineNumber.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OrderLine)) {
            return false;
        }
        OrderLine other = (OrderLine) object;
        if ((this.orderLineNumber == null && other.orderLineNumber != null) || (this.orderLineNumber != null && !this.orderLineNumber.equals(other.orderLineNumber))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "natural_latex.entity.OrderLine[ orderLineNumber=" + orderLineNumber + " ]";
    }
    
}
