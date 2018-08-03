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
@Table(name = "billing_address")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "BillingAddress.findAll", query = "SELECT b FROM BillingAddress b"),
    @NamedQuery(name = "BillingAddress.findByBillingAddressId", query = "SELECT b FROM BillingAddress b WHERE b.billingAddressId = :billingAddressId"),
    @NamedQuery(name = "BillingAddress.findByFirstName", query = "SELECT b FROM BillingAddress b WHERE b.firstName = :firstName"),
    @NamedQuery(name = "BillingAddress.findByLastName", query = "SELECT b FROM BillingAddress b WHERE b.lastName = :lastName"),
    @NamedQuery(name = "BillingAddress.findByCompany", query = "SELECT b FROM BillingAddress b WHERE b.company = :company"),
    @NamedQuery(name = "BillingAddress.findByAddress", query = "SELECT b FROM BillingAddress b WHERE b.address = :address"),
    @NamedQuery(name = "BillingAddress.findByCity", query = "SELECT b FROM BillingAddress b WHERE b.city = :city"),
    @NamedQuery(name = "BillingAddress.findByState", query = "SELECT b FROM BillingAddress b WHERE b.state = :state"),
    @NamedQuery(name = "BillingAddress.findByPostcode", query = "SELECT b FROM BillingAddress b WHERE b.postcode = :postcode"),
    @NamedQuery(name = "BillingAddress.findByCountry", query = "SELECT b FROM BillingAddress b WHERE b.country = :country"),
    @NamedQuery(name = "BillingAddress.findByPhone", query = "SELECT b FROM BillingAddress b WHERE b.phone = :phone"),
    @NamedQuery(name = "BillingAddress.findByFax", query = "SELECT b FROM BillingAddress b WHERE b.fax = :fax"),
    @NamedQuery(name = "BillingAddress.findByEmailAddress", query = "SELECT b FROM BillingAddress b WHERE b.emailAddress = :emailAddress"),
    @NamedQuery(name = "BillingAddress.findByDefaultAddress", query = "SELECT b FROM BillingAddress b WHERE b.defaultAddress = :defaultAddress")})
public class BillingAddress implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "billing_address_id")
    private Integer billingAddressId;
    @Size(max = 60)
    @Column(name = "first_name")
    private String firstName;
    @Size(max = 60)
    @Column(name = "last_name")
    private String lastName;
    @Size(max = 256)
    private String company;
    @Size(max = 256)
    private String address;
    @Size(max = 60)
    private String city;
    @Size(max = 56)
    private String state;
    @Size(max = 56)
    private String postcode;
    @Size(max = 56)
    private String country;
    // @Pattern(regexp="^\\(?(\\d{3})\\)?[- ]?(\\d{3})[- ]?(\\d{4})$", message="Invalid phone/fax format, should be as xxx-xxx-xxxx")//if the field contains phone or fax number consider using this annotation to enforce field validation
    @Size(max = 56)
    private String phone;
    // @Pattern(regexp="^\\(?(\\d{3})\\)?[- ]?(\\d{3})[- ]?(\\d{4})$", message="Invalid phone/fax format, should be as xxx-xxx-xxxx")//if the field contains phone or fax number consider using this annotation to enforce field validation
    @Size(max = 56)
    private String fax;
    @Size(max = 255)
    @Column(name = "email_address")
    private String emailAddress;
    @Column(name = "default_address")
    private Boolean defaultAddress;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "billingAddressId")
    private Collection<Customer> customerCollection;
    @OneToMany(mappedBy = "billingAddressId")
    private Collection<CustomerRegistration> customerRegistrationCollection;

    public BillingAddress() {
    }

    public BillingAddress(Integer billingAddressId) {
        this.billingAddressId = billingAddressId;
    }

    public Integer getBillingAddressId() {
        return billingAddressId;
    }

    public void setBillingAddressId(Integer billingAddressId) {
        this.billingAddressId = billingAddressId;
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

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
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

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public Boolean getDefaultAddress() {
        return defaultAddress;
    }

    public void setDefaultAddress(Boolean defaultAddress) {
        this.defaultAddress = defaultAddress;
    }

    @XmlTransient
    @JsonIgnore
    public Collection<Customer> getCustomerCollection() {
        return customerCollection;
    }

    public void setCustomerCollection(Collection<Customer> customerCollection) {
        this.customerCollection = customerCollection;
    }

    @XmlTransient
    @JsonIgnore
    public Collection<CustomerRegistration> getCustomerRegistrationCollection() {
        return customerRegistrationCollection;
    }

    public void setCustomerRegistrationCollection(Collection<CustomerRegistration> customerRegistrationCollection) {
        this.customerRegistrationCollection = customerRegistrationCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (billingAddressId != null ? billingAddressId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BillingAddress)) {
            return false;
        }
        BillingAddress other = (BillingAddress) object;
        if ((this.billingAddressId == null && other.billingAddressId != null) || (this.billingAddressId != null && !this.billingAddressId.equals(other.billingAddressId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "natural_latex.entity.BillingAddress[ billingAddressId=" + billingAddressId + " ]";
    }
    
}
