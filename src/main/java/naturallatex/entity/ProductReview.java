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
@Table(name = "product_review")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ProductReview.findAll", query = "SELECT p FROM ProductReview p"),
    @NamedQuery(name = "ProductReview.findByReviewId", query = "SELECT p FROM ProductReview p WHERE p.reviewId = :reviewId"),
    @NamedQuery(name = "ProductReview.findByProductId", query = "SELECT p FROM ProductReview p WHERE p.productId = :productId"),
    @NamedQuery(name = "ProductReview.findByReviewText", query = "SELECT p FROM ProductReview p WHERE p.reviewText = :reviewText"),
    @NamedQuery(name = "ProductReview.findByAuther", query = "SELECT p FROM ProductReview p WHERE p.auther = :auther"),
    @NamedQuery(name = "ProductReview.findByEmailAddr", query = "SELECT p FROM ProductReview p WHERE p.emailAddr = :emailAddr"),
    @NamedQuery(name = "ProductReview.findByReviewDate", query = "SELECT p FROM ProductReview p WHERE p.reviewDate = :reviewDate"),
    @NamedQuery(name = "ProductReview.findByRatingStars", query = "SELECT p FROM ProductReview p WHERE p.ratingStars = :ratingStars")})
public class ProductReview implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "review_id")
    private Integer reviewId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "product_id")
    private int productId;
    @Size(max = 500)
    @Column(name = "review_text")
    private String reviewText;
    @Size(max = 100)
    private String auther;
    @Size(max = 100)
    @Column(name = "email_addr")
    private String emailAddr;
    @Column(name = "review_date")
    @Temporal(TemporalType.DATE)
    private Date reviewDate;
    @Column(name = "rating_stars")
    private Integer ratingStars;

    public ProductReview() {
    }

    public ProductReview(Integer reviewId) {
        this.reviewId = reviewId;
    }

    public ProductReview(Integer reviewId, int productId) {
        this.reviewId = reviewId;
        this.productId = productId;
    }

    public Integer getReviewId() {
        return reviewId;
    }

    public void setReviewId(Integer reviewId) {
        this.reviewId = reviewId;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getReviewText() {
        return reviewText;
    }

    public void setReviewText(String reviewText) {
        this.reviewText = reviewText;
    }

    public String getAuther() {
        return auther;
    }

    public void setAuther(String auther) {
        this.auther = auther;
    }

    public String getEmailAddr() {
        return emailAddr;
    }

    public void setEmailAddr(String emailAddr) {
        this.emailAddr = emailAddr;
    }

    public Date getReviewDate() {
        return reviewDate;
    }

    public void setReviewDate(Date reviewDate) {
        this.reviewDate = reviewDate;
    }

    public Integer getRatingStars() {
        return ratingStars;
    }

    public void setRatingStars(Integer ratingStars) {
        this.ratingStars = ratingStars;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (reviewId != null ? reviewId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProductReview)) {
            return false;
        }
        ProductReview other = (ProductReview) object;
        if ((this.reviewId == null && other.reviewId != null) || (this.reviewId != null && !this.reviewId.equals(other.reviewId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "natural_latex.entity.ProductReview[ reviewId=" + reviewId + " ]";
    }
    
}
