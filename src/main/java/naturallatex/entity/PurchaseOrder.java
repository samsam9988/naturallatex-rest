/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package naturallatex.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author sam
 */
@Entity
@Table(name = "purchase_order")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PurchaseOrder.findAll", query = "SELECT p FROM PurchaseOrder p"),
    @NamedQuery(name = "PurchaseOrder.findByOrderId", query = "SELECT p FROM PurchaseOrder p WHERE p.orderId = :orderId"),
    @NamedQuery(name = "PurchaseOrder.findByOrderDate", query = "SELECT p FROM PurchaseOrder p WHERE p.orderDate = :orderDate"),
    @NamedQuery(name = "PurchaseOrder.findByPaymentDate", query = "SELECT p FROM PurchaseOrder p WHERE p.paymentDate = :paymentDate"),
    @NamedQuery(name = "PurchaseOrder.findByProductSizeId", query = "SELECT p FROM PurchaseOrder p WHERE p.productSizeId = :productSizeId"),
    @NamedQuery(name = "PurchaseOrder.findByTransitInsuranceFee", query = "SELECT p FROM PurchaseOrder p WHERE p.transitInsuranceFee = :transitInsuranceFee"),
    @NamedQuery(name = "PurchaseOrder.findByShippingNotes", query = "SELECT p FROM PurchaseOrder p WHERE p.shippingNotes = :shippingNotes"),
    @NamedQuery(name = "PurchaseOrder.findByQty", query = "SELECT p FROM PurchaseOrder p WHERE p.qty = :qty"),
    @NamedQuery(name = "PurchaseOrder.findByTotalItemAmount", query = "SELECT p FROM PurchaseOrder p WHERE p.totalItemAmount = :totalItemAmount"),
    @NamedQuery(name = "PurchaseOrder.findByShippingDate", query = "SELECT p FROM PurchaseOrder p WHERE p.shippingDate = :shippingDate"),
    @NamedQuery(name = "PurchaseOrder.findByCustId", query = "SELECT p FROM PurchaseOrder p WHERE p.custId.custId = :custId ORDER BY p.orderDate DESC"),
    @NamedQuery(name = "PurchaseOrder.findByCardType", query = "SELECT p FROM PurchaseOrder p WHERE p.cardType = :cardType"),
    @NamedQuery(name = "PurchaseOrder.findByCardNumber", query = "SELECT p FROM PurchaseOrder p WHERE p.cardNumber = :cardNumber"),
    @NamedQuery(name = "PurchaseOrder.findByExpDate", query = "SELECT p FROM PurchaseOrder p WHERE p.expDate = :expDate"),
    @NamedQuery(name = "PurchaseOrder.findByCardVerificationCode", query = "SELECT p FROM PurchaseOrder p WHERE p.cardVerificationCode = :cardVerificationCode"),
    @NamedQuery(name = "PurchaseOrder.findByCardHolderName", query = "SELECT p FROM PurchaseOrder p WHERE p.cardHolderName = :cardHolderName")})
public class PurchaseOrder implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "order_id")
    private Integer orderId;
    @Column(name = "order_date")
    @Temporal(TemporalType.DATE)
    private Date orderDate;
    @Column(name = "payment_date")
    @Temporal(TemporalType.DATE)
    private Date paymentDate;
    @Basic(optional = false)
    @NotNull
    @Column(name = "product_size_id")
    private int productSizeId;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "transit_insurance_fee")
    private Double transitInsuranceFee;
    @Column(name = "discount_rate")
    private Double discountRate;
    @Column(name = "shipping_fee")
    private Double shippingFee;
    @Size(max = 125)
    @Column(name = "shipping_notes")
    private String shippingNotes;
    private Integer qty;
    @Column(name = "total_item_amount")
    private Double totalItemAmount;
    @Column(name = "coupon_code")
    private String couponCode;
    @Column(name = "shipping_date")
    @Temporal(TemporalType.DATE)
    private Date shippingDate;
    @Size(max = 20)
    @Column(name = "card_type")
    private String cardType;
    @Size(max = 56)
    @Column(name = "card_number")
    private String cardNumber;
    @Size(max = 7)
    @Column(name = "exp_date")
    private String expDate;
    @Size(max = 10)
    @Column(name = "card_verification_code")
    private String cardVerificationCode;
    @Size(max = 56)
    @Column(name = "card_holder_name")
    private String cardHolderName;
    @Column(name = "courier")
    private String courier;
    @Column(name = "consignment_number")
    private String consignmentNumber;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "orderId")
    private Collection<OrderLine> orderLineCollection;
    @JoinColumn(name = "cust_id", referencedColumnName = "cust_id", nullable=true)
    @ManyToOne(optional = false)
//    @ManyToOne(optional = true, cascade = CascadeType.ALL)
    private Customer custId;

    public PurchaseOrder() {
    }

    public PurchaseOrder(Integer orderId) {
        this.orderId = orderId;
    }

    public PurchaseOrder(Integer orderId, int productSizeId) {
        this.orderId = orderId;
        this.productSizeId = productSizeId;
    }

    public Double getShippingFee() {
        return shippingFee;
    }

    public void setShippingFee(Double shippingFee) {
        this.shippingFee = shippingFee;
    }

    
    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public Date getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(Date paymentDate) {
        this.paymentDate = paymentDate;
    }

    public int getProductSizeId() {
        return productSizeId;
    }

    public void setProductSizeId(int productSizeId) {
        this.productSizeId = productSizeId;
    }

    public String getCouponCode() {
        return couponCode;
    }

    public void setCouponCode(String couponCode) {
        this.couponCode = couponCode;
    }

    
    public Double getTransitInsuranceFee() {
        return transitInsuranceFee;
    }

    public Double getDiscountRate() {
        return discountRate;
    }

    public void setDiscountRate(Double discountRate) {
        this.discountRate = discountRate;
    }

    
    public void setTransitInsuranceFee(Double transitInsuranceFee) {
        this.transitInsuranceFee = transitInsuranceFee;
    }

    public String getShippingNotes() {
        return shippingNotes;
    }

    public void setShippingNotes(String shippingNotes) {
        this.shippingNotes = shippingNotes;
    }

    public Integer getQty() {
        return qty;
    }

    public void setQty(Integer qty) {
        this.qty = qty;
    }

    public Double getTotalItemAmount() {
        return totalItemAmount;
    }

    public void setTotalItemAmount(Double totalItemAmount) {
        this.totalItemAmount = totalItemAmount;
    }

    public Date getShippingDate() {
        return shippingDate;
    }

    public void setShippingDate(Date shippingDate) {
        this.shippingDate = shippingDate;
    }

    public String getCardType() {
        return cardType;
    }

    public void setCardType(String cardType) {
        this.cardType = cardType;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getExpDate() {
        return expDate;
    }

    public void setExpDate(String expDate) {
        this.expDate = expDate;
    }

    public String getCardVerificationCode() {
        return cardVerificationCode;
    }

    public void setCardVerificationCode(String cardVerificationCode) {
        this.cardVerificationCode = cardVerificationCode;
    }

    public String getCardHolderName() {
        return cardHolderName;
    }

    public String getCourier() {
        return courier;
    }

    public void setCourier(String courier) {
        this.courier = courier;
    }

    public String getConsignmentNumber() {
        return consignmentNumber;
    }

    public void setConsignmentNumber(String consignmentNumber) {
        this.consignmentNumber = consignmentNumber;
    }

    
    public void setCardHolderName(String cardHolderName) {
        this.cardHolderName = cardHolderName;
    }

    @XmlTransient
    @JsonIgnore
    public Collection<OrderLine> getOrderLineCollection() {
        return orderLineCollection;
    }

    public void setOrderLineCollection(Collection<OrderLine> orderLineCollection) {
        this.orderLineCollection = orderLineCollection;
    }

    public Customer getCustId() {
        return custId;
    }

    public void setCustId(Customer custId) {
        this.custId = custId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (orderId != null ? orderId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PurchaseOrder)) {
            return false;
        }
        PurchaseOrder other = (PurchaseOrder) object;
        if ((this.orderId == null && other.orderId != null) || (this.orderId != null && !this.orderId.equals(other.orderId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "natural_latex.entity.PurchaseOrder[ orderId=" + orderId + " ]";
    }
    
}
