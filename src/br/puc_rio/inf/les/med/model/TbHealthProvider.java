/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.puc_rio.inf.les.med.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author tassio
 */
@Entity
@Table(name = "tb_health_provider")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TbHealthProvider.findAll", query = "SELECT t FROM TbHealthProvider t")
    , @NamedQuery(name = "TbHealthProvider.findByPkId", query = "SELECT t FROM TbHealthProvider t WHERE t.pkId = :pkId")
    , @NamedQuery(name = "TbHealthProvider.findByStrName", query = "SELECT t FROM TbHealthProvider t WHERE t.strName = :strName")
    , @NamedQuery(name = "TbHealthProvider.findByStrSex", query = "SELECT t FROM TbHealthProvider t WHERE t.strSex = :strSex")
    , @NamedQuery(name = "TbHealthProvider.findByNum1Age", query = "SELECT t FROM TbHealthProvider t WHERE t.num1Age = :num1Age")
    , @NamedQuery(name = "TbHealthProvider.findByStrEmail", query = "SELECT t FROM TbHealthProvider t WHERE t.strEmail = :strEmail")
    , @NamedQuery(name = "TbHealthProvider.findByStrPhoneNumber", query = "SELECT t FROM TbHealthProvider t WHERE t.strPhoneNumber = :strPhoneNumber")
    , @NamedQuery(name = "TbHealthProvider.findByStrSpecialization", query = "SELECT t FROM TbHealthProvider t WHERE t.strSpecialization = :strSpecialization")
    , @NamedQuery(name = "TbHealthProvider.findByStrExperience", query = "SELECT t FROM TbHealthProvider t WHERE t.strExperience = :strExperience")
    , @NamedQuery(name = "TbHealthProvider.findByStrCrm", query = "SELECT t FROM TbHealthProvider t WHERE t.strCrm = :strCrm")})
public class TbHealthProvider implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pk_id")
    private Integer pkId;
    @Basic(optional = false)
    @Column(name = "str_name")
    private String strName;
    @Basic(optional = false)
    @Column(name = "str_sex")
    private String strSex;
    @Basic(optional = false)
    @Column(name = "num1_age")
    private int num1Age;
    @Basic(optional = false)
    @Column(name = "str_email")
    private String strEmail;
    @Basic(optional = false)
    @Column(name = "str_phone_number")
    private String strPhoneNumber;
    @Basic(optional = false)
    @Column(name = "str_specialization")
    private String strSpecialization;
    @Basic(optional = false)
    @Column(name = "str_experience")
    private String strExperience;
    @Basic(optional = false)
    @Column(name = "str_crm")
    private String strCrm;
    @JoinTable(name = "tb_monitoring_has_health_provider", joinColumns = {
        @JoinColumn(name = "fk_health_provider_pk_id", referencedColumnName = "pk_id")}, inverseJoinColumns = {
        @JoinColumn(name = "fk_monitoring_pk_id", referencedColumnName = "pk_id")})
    @ManyToMany
    private List<TbMonitoring> tbMonitoringList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fkHealthProviderId")
    private List<TbMonitoring> tbMonitoringList1;

    public TbHealthProvider() {
    }

    public TbHealthProvider(Integer pkId) {
        this.pkId = pkId;
    }

    public TbHealthProvider(Integer pkId, String strName, String strSex, int num1Age, String strEmail, String strPhoneNumber, String strSpecialization, String strExperience, String strCrm) {
        this.pkId = pkId;
        this.strName = strName;
        this.strSex = strSex;
        this.num1Age = num1Age;
        this.strEmail = strEmail;
        this.strPhoneNumber = strPhoneNumber;
        this.strSpecialization = strSpecialization;
        this.strExperience = strExperience;
        this.strCrm = strCrm;
    }

    public Integer getPkId() {
        return pkId;
    }

    public void setPkId(Integer pkId) {
        this.pkId = pkId;
    }

    public String getStrName() {
        return strName;
    }

    public void setStrName(String strName) {
        this.strName = strName;
    }

    public String getStrSex() {
        return strSex;
    }

    public void setStrSex(String strSex) {
        this.strSex = strSex;
    }

    public int getNum1Age() {
        return num1Age;
    }

    public void setNum1Age(int num1Age) {
        this.num1Age = num1Age;
    }

    public String getStrEmail() {
        return strEmail;
    }

    public void setStrEmail(String strEmail) {
        this.strEmail = strEmail;
    }

    public String getStrPhoneNumber() {
        return strPhoneNumber;
    }

    public void setStrPhoneNumber(String strPhoneNumber) {
        this.strPhoneNumber = strPhoneNumber;
    }

    public String getStrSpecialization() {
        return strSpecialization;
    }

    public void setStrSpecialization(String strSpecialization) {
        this.strSpecialization = strSpecialization;
    }

    public String getStrExperience() {
        return strExperience;
    }

    public void setStrExperience(String strExperience) {
        this.strExperience = strExperience;
    }

    public String getStrCrm() {
        return strCrm;
    }

    public void setStrCrm(String strCrm) {
        this.strCrm = strCrm;
    }

    @XmlTransient
    public List<TbMonitoring> getTbMonitoringList() {
        return tbMonitoringList;
    }

    public void setTbMonitoringList(List<TbMonitoring> tbMonitoringList) {
        this.tbMonitoringList = tbMonitoringList;
    }

    @XmlTransient
    public List<TbMonitoring> getTbMonitoringList1() {
        return tbMonitoringList1;
    }

    public void setTbMonitoringList1(List<TbMonitoring> tbMonitoringList1) {
        this.tbMonitoringList1 = tbMonitoringList1;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pkId != null ? pkId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TbHealthProvider)) {
            return false;
        }
        TbHealthProvider other = (TbHealthProvider) object;
        if ((this.pkId == null && other.pkId != null) || (this.pkId != null && !this.pkId.equals(other.pkId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.puc_rio.inf.les.med.dao.model.TbHealthProvider[ pkId=" + pkId + " ]";
    }
    
}
