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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author sam
 */
@Entity
@Table(name = "customer")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Customer.findAll", query = "SELECT c FROM Customer c"),
    @NamedQuery(name = "Customer.findByCustId", query = "SELECT c FROM Customer c WHERE c.custId = :custId"),
    @NamedQuery(name = "Customer.findByFirstName", query = "SELECT c FROM Customer c WHERE c.firstName = :firstName"),
    @NamedQuery(name = "Customer.findByLastName", query = "SELECT c FROM Customer c WHERE c.lastName = :lastName"),
    @NamedQuery(name = "Customer.findByPassword", query = "SELECT c FROM Customer c WHERE c.password = :password"),
    @NamedQuery(name = "Customer.findByEmailAddress", query = "SELECT c FROM Customer c WHERE c.emailAddress = :emailAddress"),
    @NamedQuery(name = "Customer.findByPhone", query = "SELECT c FROM Customer c WHERE c.phone = :phone"),
    @NamedQuery(name = "Customer.findByFax", query = "SELECT c FROM Customer c WHERE c.fax = :fax"),
    @NamedQuery(name = "Customer.findByStatus", query = "SELECT c FROM Customer c WHERE c.status = :status"),
    @NamedQuery(name = "Customer.findByRegDate", query = "SELECT c FROM Customer c WHERE c.regDate = :regDate"),
    @NamedQuery(name = "Customer.findByCancelDate", query = "SELECT c FROM Customer c WHERE c.cancelDate = :cancelDate")})
public class Customer implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "cust_id")
    private Integer custId;
    @Size(max = 60)
    @Column(name = "first_name")
    private String firstName;
    @Size(max = 60)
    @Column(name = "last_name")
    private String lastName;
    @Size(max = 256)
    private String password;
    @Size(max = 125)
    @Column(name = "email_address")
    private String emailAddress;
    // @Pattern(regexp="^\\(?(\\d{3})\\)?[- ]?(\\d{3})[- ]?(\\d{4})$", message="Invalid phone/fax format, should be as xxx-xxx-xxxx")//if the field contains phone or fax number consider using this annotation to enforce field validation
    @Size(max = 60)
    private String phone;
    // @Pattern(regexp="^\\(?(\\d{3})\\)?[- ]?(\\d{3})[- ]?(\\d{4})$", message="Invalid phone/fax format, should be as xxx-xxx-xxxx")//if the field contains phone or fax number consider using this annotation to enforce field validation
    @Size(max = 56)
    private String fax;
    private Boolean status;
    @Column(name = "reg_date")
    @Temporal(TemporalType.DATE)
    private Date regDate;
    @Column(name = "cancel_date")
    @Temporal(TemporalType.DATE)
    private Date cancelDate;
    @JoinColumn(name = "shipping_address_id", referencedColumnName = "shipping_address_id")
    @ManyToOne(optional = false, cascade = CascadeType.ALL)
//    @ManyToOne(optional = true, cascade = CascadeType.ALL)
    private ShippingAddress shippingAddressId;
    @JoinColumn(name = "billing_address_id", referencedColumnName = "billing_address_id")
    @ManyToOne(optional = false, cascade = CascadeType.ALL)
//    @ManyToOne(optional = true, cascade = CascadeType.ALL)
    private BillingAddress billingAddressId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "custId")
    private Collection<PurchaseOrder> purchaseOrderCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "custId")
    private Collection<CustomerRegistration> customerRegistrationCollection;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "custId")
    private Collection<Payment> paymentCollection;

    public Customer() {
    }

    public Customer(Integer custId) {
        this.custId = custId;
    }

    public Integer getCustId() {
        return custId;
    }

    public void setCustId(Integer custId) {
        this.custId = custId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
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

    @XmlTransient
    @JsonIgnore
    public Collection<PurchaseOrder> getPurchaseOrderCollection() {
        return purchaseOrderCollection;
    }

    public void setPurchaseOrderCollection(Collection<PurchaseOrder> purchaseOrderCollection) {
        this.purchaseOrderCollection = purchaseOrderCollection;
    }

    @XmlTransient
    @JsonIgnore
    public Collection<CustomerRegistration> getCustomerRegistrationCollection() {
        return customerRegistrationCollection;
    }

    public void setCustomerRegistrationCollection(Collection<CustomerRegistration> customerRegistrationCollection) {
        this.customerRegistrationCollection = customerRegistrationCollection;
    }

    

    @XmlTransient
    @JsonIgnore
    public Collection<Payment> getPaymentCollection() {
        return paymentCollection;
    }

    public void setPaymentCollection(Collection<Payment> paymentCollection) {
        this.paymentCollection = paymentCollection;
    }
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (custId != null ? custId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Customer)) {
            return false;
        }
        Customer other = (Customer) object;
        if ((this.custId == null && other.custId != null) || (this.custId != null && !this.custId.equals(other.custId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "natural_latex.entity.Customer[ custId=" + custId + " ]";
    }
    
}
