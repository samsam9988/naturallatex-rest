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
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author sam
 */
@Entity
@Table(name = "contact_us")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ContactUs.findAll", query = "SELECT c FROM ContactUs c"),
    @NamedQuery(name = "ContactUs.findByContactId", query = "SELECT c FROM ContactUs c WHERE c.contactId = :contactId"),
    @NamedQuery(name = "ContactUs.findBySubject", query = "SELECT c FROM ContactUs c WHERE c.subject = :subject"),
    @NamedQuery(name = "ContactUs.findByEmailAddress", query = "SELECT c FROM ContactUs c WHERE c.emailAddress = :emailAddress"),
    @NamedQuery(name = "ContactUs.findByEmailAndMessage", query = "SELECT c FROM ContactUs c WHERE c.emailAddress = :emailAddress AND c.message = :message"),
    @NamedQuery(name = "ContactUs.findByName", query = "SELECT c FROM ContactUs c WHERE c.name = :name")})
public class ContactUs implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "contact_id")
    private Integer contactId;
    @Size(max = 65)
    private String subject;
    @Lob
    @Size(max = 65535)
    private String message;
    @Size(max = 256)
    @Column(name = "email_address")
    private String emailAddress;
    @Size(max = 65)
    private String name;
    @Column(name = "contact_date")
    @Temporal(TemporalType.DATE)
    private Date contactDate;

    public ContactUs() {
    }

    public ContactUs(Integer contactId) {
        this.contactId = contactId;
    }

    public Integer getContactId() {
        return contactId;
    }

    public void setContactId(Integer contactId) {
        this.contactId = contactId;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getContactDate() {
        return contactDate;
    }

    public void setContactDate(Date contactDate) {
        this.contactDate = contactDate;
    }
    
    

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (contactId != null ? contactId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ContactUs)) {
            return false;
        }
        ContactUs other = (ContactUs) object;
        if ((this.contactId == null && other.contactId != null) || (this.contactId != null && !this.contactId.equals(other.contactId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "natural_latex.entity.ContactUs[ contactId=" + contactId + " ]";
    }
    
}
