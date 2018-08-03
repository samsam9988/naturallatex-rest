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
@Table(name = "signup_for_discount")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SignupForDiscount.findAll", query = "SELECT s FROM SignupForDiscount s"),
    @NamedQuery(name = "SignupForDiscount.findByEmailAddress", query = "SELECT s FROM SignupForDiscount s WHERE s.emailAddress = :emailAddress"),
    @NamedQuery(name = "SignupForDiscount.findBySignupDate", query = "SELECT s FROM SignupForDiscount s WHERE s.signupDate = :signupDate"),
    @NamedQuery(name = "SignupForDiscount.findByCount", query = "SELECT s FROM SignupForDiscount s WHERE s.count = :count")})
public class SignupForDiscount implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Size(min = 1, max = 100)
    @Column(name = "email_address")
    private String emailAddress;
    @Column(name = "signup_date")
    @Temporal(TemporalType.DATE)
    private Date signupDate;
    private Integer count;

    public SignupForDiscount() {
    }

    public SignupForDiscount(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public Date getSignupDate() {
        return signupDate;
    }

    public void setSignupDate(Date signupDate) {
        this.signupDate = signupDate;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (emailAddress != null ? emailAddress.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SignupForDiscount)) {
            return false;
        }
        SignupForDiscount other = (SignupForDiscount) object;
        if ((this.emailAddress == null && other.emailAddress != null) || (this.emailAddress != null && !this.emailAddress.equals(other.emailAddress))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "natural_latex.entity.SignupForDiscount[ emailAddress=" + emailAddress + " ]";
    }
    
}
