/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package naturallatex.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author sam
 */
@Entity
@Table(catalog = "natural_latex")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Payment.findAll", query = "SELECT p FROM Payment p"),
    @NamedQuery(name = "Payment.findByPaymentId", query = "SELECT p FROM Payment p WHERE p.paymentId = :paymentId"),
    @NamedQuery(name = "Payment.findByOrderDate", query = "SELECT p FROM Payment p WHERE p.orderDate = :orderDate"),
    @NamedQuery(name = "Payment.findByPaymentDate", query = "SELECT p FROM Payment p WHERE p.paymentDate = :paymentDate"),
    @NamedQuery(name = "Payment.findByProductId", query = "SELECT p FROM Payment p WHERE p.productId = :productId"),
    @NamedQuery(name = "Payment.findByTransitInsuranceFee", query = "SELECT p FROM Payment p WHERE p.transitInsuranceFee = :transitInsuranceFee"),
    @NamedQuery(name = "Payment.findByShippingNotes", query = "SELECT p FROM Payment p WHERE p.shippingNotes = :shippingNotes"),
    @NamedQuery(name = "Payment.findByQty", query = "SELECT p FROM Payment p WHERE p.qty = :qty"),
    @NamedQuery(name = "Payment.findByTotalItemAmount", query = "SELECT p FROM Payment p WHERE p.totalItemAmount = :totalItemAmount"),
    @NamedQuery(name = "Payment.findByShippingDate", query = "SELECT p FROM Payment p WHERE p.shippingDate = :shippingDate"),
    @NamedQuery(name = "Payment.findByCardType", query = "SELECT p FROM Payment p WHERE p.cardType = :cardType"),
    @NamedQuery(name = "Payment.findByCardNumber", query = "SELECT p FROM Payment p WHERE p.cardNumber = :cardNumber"),
    @NamedQuery(name = "Payment.findByExpDate", query = "SELECT p FROM Payment p WHERE p.expDate = :expDate"),
    @NamedQuery(name = "Payment.findByCardVerificationCode", query = "SELECT p FROM Payment p WHERE p.cardVerificationCode = :cardVerificationCode"),
    @NamedQuery(name = "Payment.findByCardHolderName", query = "SELECT p FROM Payment p WHERE p.cardHolderName = :cardHolderName"),
    @NamedQuery(name = "Payment.findByCouponCode", query = "SELECT p FROM Payment p WHERE p.couponCode = :couponCode"),
    @NamedQuery(name = "Payment.findByDiscountRate", query = "SELECT p FROM Payment p WHERE p.discountRate = :discountRate"),
    @NamedQuery(name = "Payment.findByShippingFee", query = "SELECT p FROM Payment p WHERE p.shippingFee = :shippingFee"),
    @NamedQuery(name = "Payment.findByCourier", query = "SELECT p FROM Payment p WHERE p.courier = :courier"),
    @NamedQuery(name = "Payment.findByConsignmentNumber", query = "SELECT p FROM Payment p WHERE p.consignmentNumber = :consignmentNumber")})
public class Payment implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "payment_id")
    private Integer paymentId;
    @Column(name = "order_date")
    @Temporal(TemporalType.DATE)
    private Date orderDate;
    @Column(name = "payment_date")
    @Temporal(TemporalType.DATE)
    private Date paymentDate;
    @Basic(optional = false)
    @NotNull
    @Column(name = "product_id")
    private int productId;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "transit_insurance_fee")
    private Double transitInsuranceFee;
    @Size(max = 125)
    @Column(name = "shipping_notes")
    private String shippingNotes;
    private Integer qty;
    @Column(name = "total_item_amount")
    private Double totalItemAmount;
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
    @Size(max = 10)
    @Column(name = "coupon_code")
    private String couponCode;
    @Column(name = "discount_rate")
    private Double discountRate;
    @Column(name = "shipping_fee")
    private Double shippingFee;
    @Size(max = 35)
    private String courier;
    @Size(max = 24)
    @Column(name = "consignment_number")
    private String consignmentNumber;
    @JoinColumn(name = "cust_id", referencedColumnName = "cust_id")
    @ManyToOne(optional = false)
    private Customer custId;

    public Payment() {
    }

    public Payment(Integer paymentId) {
        this.paymentId = paymentId;
    }

    public Payment(Integer paymentId, int productId) {
        this.paymentId = paymentId;
        this.productId = productId;
    }

    public Integer getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(Integer paymentId) {
        this.paymentId = paymentId;
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

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public Double getTransitInsuranceFee() {
        return transitInsuranceFee;
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

    public void setCardHolderName(String cardHolderName) {
        this.cardHolderName = cardHolderName;
    }

    public String getCouponCode() {
        return couponCode;
    }

    public void setCouponCode(String couponCode) {
        this.couponCode = couponCode;
    }

    public Double getDiscountRate() {
        return discountRate;
    }

    public void setDiscountRate(Double discountRate) {
        this.discountRate = discountRate;
    }

    public Double getShippingFee() {
        return shippingFee;
    }

    public void setShippingFee(Double shippingFee) {
        this.shippingFee = shippingFee;
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

    public Customer getCustId() {
        return custId;
    }

    public void setCustId(Customer custId) {
        this.custId = custId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (paymentId != null ? paymentId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Payment)) {
            return false;
        }
        Payment other = (Payment) object;
        if ((this.paymentId == null && other.paymentId != null) || (this.paymentId != null && !this.paymentId.equals(other.paymentId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "naturallatex.entity.Payment[ paymentId=" + paymentId + " ]";
    }
    
}
