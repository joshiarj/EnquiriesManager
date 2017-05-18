package com.arj.enquiry.entity;

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
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "tbl_followupmsgs")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "FollowupMsg.findAll", query = "SELECT f FROM FollowupMsg f"),
    @NamedQuery(name = "FollowupMsg.findByFollowupId", query = "SELECT f FROM FollowupMsg f WHERE f.followupId = :followupId"),
    @NamedQuery(name = "FollowupMsg.findByFollowupDate", query = "SELECT f FROM FollowupMsg f WHERE f.followupDate = :followupDate"),
    @NamedQuery(name = "FollowupMsg.findByFollowupMessage", query = "SELECT f FROM FollowupMsg f WHERE f.followupMessage = :followupMessage"),
    @NamedQuery(name = "FollowupMsg.findByNextFollowupDate", query = "SELECT f FROM FollowupMsg f WHERE f.nextFollowupDate = :nextFollowupDate"),
    @NamedQuery(name = "FollowupMsg.findByStatus", query = "SELECT f FROM FollowupMsg f WHERE f.status = :status")})
public class FollowupMsg implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "followup_id")
    private Integer followupId;
    @Basic(optional = false)
    @Column(name = "followup_date", insertable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date followupDate;
    @Basic(optional = false)
    @NotNull
    @Column(name = "followup_message")
    private int followupMessage;
    @Column(name = "next_followup_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date nextFollowupDate;
    @Basic(optional = false)
    @NotNull
    @Column(name = "status")
    private boolean status;
    @JoinColumn(name = "enquiry_id", referencedColumnName = "enquiry_id")
    @ManyToOne(optional = false)
    private Enquiry enquiryId;

    public FollowupMsg() {
    }

    public FollowupMsg(Integer followupId) {
        this.followupId = followupId;
    }

    public FollowupMsg(Integer followupId, Date followupDate, int followupMessage, boolean status) {
        this.followupId = followupId;
        this.followupDate = followupDate;
        this.followupMessage = followupMessage;
        this.status = status;
    }

    public Integer getFollowupId() {
        return followupId;
    }

    public void setFollowupId(Integer followupId) {
        this.followupId = followupId;
    }

    public Date getFollowupDate() {
        return followupDate;
    }

    public void setFollowupDate(Date followupDate) {
        this.followupDate = followupDate;
    }

    public int getFollowupMessage() {
        return followupMessage;
    }

    public void setFollowupMessage(int followupMessage) {
        this.followupMessage = followupMessage;
    }

    public Date getNextFollowupDate() {
        return nextFollowupDate;
    }

    public void setNextFollowupDate(Date nextFollowupDate) {
        this.nextFollowupDate = nextFollowupDate;
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Enquiry getEnquiryId() {
        return enquiryId;
    }

    public void setEnquiryId(Enquiry enquiryId) {
        this.enquiryId = enquiryId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (followupId != null ? followupId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FollowupMsg)) {
            return false;
        }
        FollowupMsg other = (FollowupMsg) object;
        if ((this.followupId == null && other.followupId != null) || (this.followupId != null && !this.followupId.equals(other.followupId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.arj.enquiry.entity.FollowupMsg[ followupId=" + followupId + " ]";
    }
    
}
