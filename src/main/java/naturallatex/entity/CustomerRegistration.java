/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package naturallatex.entity;

import java.io.Serializable;
import java.util.Date;
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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author sam
 */
@Entity
@Table(name = "customer_registration")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CustomerRegistration.findAll", query = "SELECT c FROM CustomerRegistration c"),
    @NamedQuery(name = "CustomerRegistration.findByRegId", query = "SELECT c FROM CustomerRegistration c WHERE c.regId = :regId"),
    @NamedQuery(name = "CustomerRegistration.findByRegDate", query = "SELECT c FROM CustomerRegistration c WHERE c.regDate = :regDate"),
    @NamedQuery(name = "CustomerRegistration.findByCancelDate", query = "SELECT c FROM CustomerRegistration c WHERE c.cancelDate = :cancelDate")})
public class CustomerRegistration implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "reg_id")
    private Integer regId;
    @Column(name = "reg_date")
    @Temporal(TemporalType.DATE)
    private Date regDate;
    @Column(name = "cancel_date")
    @Temporal(TemporalType.DATE)
    private Date cancelDate;
    @JoinColumn(name = "cust_id", referencedColumnName = "cust_id")
    @ManyToOne(optional = false)
    private Customer custId;
    @JoinColumn(name = "shipping_address_id", referencedColumnName = "shipping_address_id")
    @ManyToOne
    private ShippingAddress shippingAddressId;
    @JoinColumn(name = "billing_address_id", referencedColumnName = "billing_address_id")
    @ManyToOne
    private BillingAddress billingAddressId;

    public CustomerRegistration() {
    }

    public CustomerRegistration(Integer regId) {
        this.regId = regId;
    }

    public Integer getRegId() {
        return regId;
    }

    public void setRegId(Integer regId) {
        this.regId = regId;
    }

    public Date getRegDate() {
        return regDate;
    }

    public void setRegDate(Date regDate) {
        this.regDate = regDate;
    }

    public Date getCancelDate() {
        return cancelDate;
    }

    public void setCancelDate(Date cancelDate) {
        this.cancelDate = cancelDate;
    }

    public Customer getCustId() {
        return custId;
    }

    public void setCustId(Customer custId) {
        this.custId = custId;
    }

    public ShippingAddress getShippingAddressId() {
        return shippingAddressId;
    }

    public void setShippingAddressId(ShippingAddress shippingAddressId) {
        this.shippingAddressId = shippingAddressId;
    }

    public BillingAddress getBillingAddressId() {
        return billingAddressId;
    }

    public void setBillingAddressId(BillingAddress billingAddressId) {
        this.billingAddressId = billingAddressId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (regId != null ? regId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CustomerRegistration)) {
            return false;
        }
        CustomerRegistration other = (CustomerRegistration) object;
        if ((this.regId == null && other.regId != null) || (this.regId != null && !this.regId.equals(other.regId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "natural_latex.entity.CustomerRegistration[ regId=" + regId + " ]";
    }
    
}
