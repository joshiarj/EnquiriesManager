package com.arj.enquiry.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
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

@Entity
@Table(name = "tbl_enquiries")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Enquiry.findAll", query = "SELECT e FROM Enquiry e"),
    @NamedQuery(name = "Enquiry.findByEnquiryId", query = "SELECT e FROM Enquiry e WHERE e.enquiryId = :enquiryId"),
    @NamedQuery(name = "Enquiry.findByEnquiryFirstName", query = "SELECT e FROM Enquiry e WHERE e.enquiryFirstName = :enquiryFirstName"),
    @NamedQuery(name = "Enquiry.findByEnquiryLastName", query = "SELECT e FROM Enquiry e WHERE e.enquiryLastName = :enquiryLastName"),
    @NamedQuery(name = "Enquiry.findByEnquiryEmail", query = "SELECT e FROM Enquiry e WHERE e.enquiryEmail = :enquiryEmail"),
    @NamedQuery(name = "Enquiry.findByEnquiryGender", query = "SELECT e FROM Enquiry e WHERE e.enquiryGender = :enquiryGender"),
    @NamedQuery(name = "Enquiry.findByEnquiryAddedDate", query = "SELECT e FROM Enquiry e WHERE e.enquiryAddedDate = :enquiryAddedDate"),
    @NamedQuery(name = "Enquiry.findByStatus", query = "SELECT e FROM Enquiry e WHERE e.status = :status")})
public class Enquiry implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "enquiry_id")
    private Integer enquiryId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "enquiry_first_name")
    private String enquiryFirstName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "enquiry_last_name")
    private String enquiryLastName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "enquiry_email")
    private String enquiryEmail;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "enquiry_gender")
    private String enquiryGender;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "enquiry_message")
    private String enquiryMessage;
    @Basic(optional = false)
    @Column(name = "enquiry_added_date", insertable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date enquiryAddedDate;
    @Basic(optional = false)
    @NotNull
    @Column(name = "status")
    private boolean status;
    @JoinColumn(name = "course_id", referencedColumnName = "course_id")
    @ManyToOne(optional = false)
    private Course courseId;
    @JoinColumn(name = "faculty_id", referencedColumnName = "faculty_id")
    @ManyToOne(optional = false)
    private Faculty facultyId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "enquiryId")
    private List<FollowupMsg> followupMsgList;

    public Enquiry() {
    }

    public Enquiry(Integer enquiryId) {
        this.enquiryId = enquiryId;
    }

    public Enquiry(Integer enquiryId, String enquiryFirstName, String enquiryLastName, String enquiryEmail, String enquiryGender, String enquiryMessage, Date enquiryAddedDate, boolean status) {
        this.enquiryId = enquiryId;
        this.enquiryFirstName = enquiryFirstName;
        this.enquiryLastName = enquiryLastName;
        this.enquiryEmail = enquiryEmail;
        this.enquiryGender = enquiryGender;
        this.enquiryMessage = enquiryMessage;
        this.enquiryAddedDate = enquiryAddedDate;
        this.status = status;
    }

    public Integer getEnquiryId() {
        return enquiryId;
    }

    public void setEnquiryId(Integer enquiryId) {
        this.enquiryId = enquiryId;
    }

    public String getEnquiryFirstName() {
        return enquiryFirstName;
    }

    public void setEnquiryFirstName(String enquiryFirstName) {
        this.enquiryFirstName = enquiryFirstName;
    }

    public String getEnquiryLastName() {
        return enquiryLastName;
    }

    public void setEnquiryLastName(String enquiryLastName) {
        this.enquiryLastName = enquiryLastName;
    }

    public String getEnquiryEmail() {
        return enquiryEmail;
    }

    public void setEnquiryEmail(String enquiryEmail) {
        this.enquiryEmail = enquiryEmail;
    }

    public String getEnquiryGender() {
        return enquiryGender;
    }

    public void setEnquiryGender(String enquiryGender) {
        this.enquiryGender = enquiryGender;
    }

    public String getEnquiryMessage() {
        return enquiryMessage;
    }

    public void setEnquiryMessage(String enquiryMessage) {
        this.enquiryMessage = enquiryMessage;
    }

    public Date getEnquiryAddedDate() {
        return enquiryAddedDate;
    }

    public void setEnquiryAddedDate(Date enquiryAddedDate) {
        this.enquiryAddedDate = enquiryAddedDate;
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Course getCourseId() {
        return courseId;
    }

    public void setCourseId(Course courseId) {
        this.courseId = courseId;
    }

    public Faculty getFacultyId() {
        return facultyId;
    }

    public void setFacultyId(Faculty facultyId) {
        this.facultyId = facultyId;
    }

    @XmlTransient
    public List<FollowupMsg> getFollowupMsgList() {
        return followupMsgList;
    }

    public void setFollowupMsgList(List<FollowupMsg> followupMsgList) {
        this.followupMsgList = followupMsgList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (enquiryId != null ? enquiryId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Enquiry)) {
            return false;
        }
        Enquiry other = (Enquiry) object;
        if ((this.enquiryId == null && other.enquiryId != null) || (this.enquiryId != null && !this.enquiryId.equals(other.enquiryId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.arj.enquiry.entity.Enquiry[ enquiryId=" + enquiryId + " ]";
    }
    
}
