/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package naturallatex.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.util.Collection;
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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author sam
 */
@Entity
@Table(name = "shipping_address")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ShippingAddress.findAll", query = "SELECT s FROM ShippingAddress s"),
    @NamedQuery(name = "ShippingAddress.findByShippingAddressId", query = "SELECT s FROM ShippingAddress s WHERE s.shippingAddressId = :shippingAddressId"),
    @NamedQuery(name = "ShippingAddress.findByFirstName", query = "SELECT s FROM ShippingAddress s WHERE s.firstName = :firstName"),
    @NamedQuery(name = "ShippingAddress.findByLastName", query = "SELECT s FROM ShippingAddress s WHERE s.lastName = :lastName"),
    @NamedQuery(name = "ShippingAddress.findByCompany", query = "SELECT s FROM ShippingAddress s WHERE s.company = :company"),
    @NamedQuery(name = "ShippingAddress.findByAddress", query = "SELECT s FROM ShippingAddress s WHERE s.address = :address"),
    @NamedQuery(name = "ShippingAddress.findByCity", query = "SELECT s FROM ShippingAddress s WHERE s.city = :city"),
    @NamedQuery(name = "ShippingAddress.findByState", query = "SELECT s FROM ShippingAddress s WHERE s.state = :state"),
    @NamedQuery(name = "ShippingAddress.findByPostcode", query = "SELECT s FROM ShippingAddress s WHERE s.postcode = :postcode"),
    @NamedQuery(name = "ShippingAddress.findByCountry", query = "SELECT s FROM ShippingAddress s WHERE s.country = :country"),
    @NamedQuery(name = "ShippingAddress.findByPhone", query = "SELECT s FROM ShippingAddress s WHERE s.phone = :phone"),
    @NamedQuery(name = "ShippingAddress.findByFax", query = "SELECT s FROM ShippingAddress s WHERE s.fax = :fax"),
    @NamedQuery(name = "ShippingAddress.findByDefaultAddress", query = "SELECT s FROM ShippingAddress s WHERE s.defaultAddress = :defaultAddress"),
    @NamedQuery(name = "ShippingAddress.findByEmailAddress", query = "SELECT s FROM ShippingAddress s WHERE s.emailAddress = :emailAddress")})
public class ShippingAddress implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "shipping_address_id")
    private Integer shippingAddressId;
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
    @Column(name = "default_address")
    private Boolean defaultAddress;
    @Size(max = 255)
    @Column(name = "email_address")
    private String emailAddress;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "shippingAddressId")
    private Collection<Customer> customerCollection;
    @OneToMany(mappedBy = "shippingAddressId")
    private Collection<CustomerRegistration> customerRegistrationCollection;

    public ShippingAddress() {
    }

    public ShippingAddress(Integer shippingAddressId) {
        this.shippingAddressId = shippingAddressId;
    }

    public Integer getShippingAddressId() {
        return shippingAddressId;
    }

    public void setShippingAddressId(Integer shippingAddressId) {
        this.shippingAddressId = shippingAddressId;
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

    public Boolean getDefaultAddress() {
        return defaultAddress;
    }

    public void setDefaultAddress(Boolean defaultAddress) {
        this.defaultAddress = defaultAddress;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
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
        hash += (shippingAddressId != null ? shippingAddressId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ShippingAddress)) {
            return false;
        }
        ShippingAddress other = (ShippingAddress) object;
        if ((this.shippingAddressId == null && other.shippingAddressId != null) || (this.shippingAddressId != null && !this.shippingAddressId.equals(other.shippingAddressId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "natural_latex.entity.ShippingAddress[ shippingAddressId=" + shippingAddressId + " ]";
    }
    
}
