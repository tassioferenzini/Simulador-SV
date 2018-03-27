/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.puc_rio.inf.les.med.model;

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
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author tassio
 */
@Entity
@Table(name = "tb_patient")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TbPatient.findAll", query = "SELECT t FROM TbPatient t")
    , @NamedQuery(name = "TbPatient.findByPkId", query = "SELECT t FROM TbPatient t WHERE t.pkId = :pkId")
    , @NamedQuery(name = "TbPatient.findByStrName", query = "SELECT t FROM TbPatient t WHERE t.strName = :strName")
    , @NamedQuery(name = "TbPatient.findByStrSecondName", query = "SELECT t FROM TbPatient t WHERE t.strSecondName = :strSecondName")
    , @NamedQuery(name = "TbPatient.findByStrFamilyName", query = "SELECT t FROM TbPatient t WHERE t.strFamilyName = :strFamilyName")
    , @NamedQuery(name = "TbPatient.findByStrSex", query = "SELECT t FROM TbPatient t WHERE t.strSex = :strSex")
    , @NamedQuery(name = "TbPatient.findByDtmBirthDate", query = "SELECT t FROM TbPatient t WHERE t.dtmBirthDate = :dtmBirthDate")
    , @NamedQuery(name = "TbPatient.findByNum2Height", query = "SELECT t FROM TbPatient t WHERE t.num2Height = :num2Height")
    , @NamedQuery(name = "TbPatient.findByNum2Weight", query = "SELECT t FROM TbPatient t WHERE t.num2Weight = :num2Weight")
    , @NamedQuery(name = "TbPatient.findByStrDepartment", query = "SELECT t FROM TbPatient t WHERE t.strDepartment = :strDepartment")
    , @NamedQuery(name = "TbPatient.findByBoolAdmitted", query = "SELECT t FROM TbPatient t WHERE t.boolAdmitted = :boolAdmitted")
    , @NamedQuery(name = "TbPatient.findByDtmHospitalization", query = "SELECT t FROM TbPatient t WHERE t.dtmHospitalization = :dtmHospitalization")})
public class TbPatient implements Serializable {

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
    @Column(name = "str_second_name")
    private String strSecondName;
    @Basic(optional = false)
    @Column(name = "str_family_name")
    private String strFamilyName;
    @Basic(optional = false)
    @Column(name = "str_sex")
    private String strSex;
    @Basic(optional = false)
    @Column(name = "dtm_birth_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dtmBirthDate;
    @Basic(optional = false)
    @Column(name = "num2_height")
    private double num2Height;
    @Basic(optional = false)
    @Column(name = "num2_weight")
    private double num2Weight;
    @Basic(optional = false)
    @Column(name = "str_department")
    private String strDepartment;
    @Basic(optional = false)
    @Column(name = "bool_admitted")
    private boolean boolAdmitted;
    @Basic(optional = false)
    @Column(name = "dtm_hospitalization")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dtmHospitalization;
    @JoinColumn(name = "fk_location_id", referencedColumnName = "pk_id")
    @ManyToOne(optional = false)
    private TbLocation fkLocationId;
    @JoinColumn(name = "fk_patient_type_id", referencedColumnName = "pk_id")
    @ManyToOne(optional = false)
    private TbPatientType fkPatientTypeId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fkPatientId")
    private List<TbMonitoring> tbMonitoringList;

    public TbPatient() {
    }

    public TbPatient(Integer pkId) {
        this.pkId = pkId;
    }

    public TbPatient(Integer pkId, String strName, String strSecondName, String strFamilyName, String strSex, Date dtmBirthDate, double num2Height, double num2Weight, String strDepartment, boolean boolAdmitted, Date dtmHospitalization) {
        this.pkId = pkId;
        this.strName = strName;
        this.strSecondName = strSecondName;
        this.strFamilyName = strFamilyName;
        this.strSex = strSex;
        this.dtmBirthDate = dtmBirthDate;
        this.num2Height = num2Height;
        this.num2Weight = num2Weight;
        this.strDepartment = strDepartment;
        this.boolAdmitted = boolAdmitted;
        this.dtmHospitalization = dtmHospitalization;
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

    public String getStrSecondName() {
        return strSecondName;
    }

    public void setStrSecondName(String strSecondName) {
        this.strSecondName = strSecondName;
    }

    public String getStrFamilyName() {
        return strFamilyName;
    }

    public void setStrFamilyName(String strFamilyName) {
        this.strFamilyName = strFamilyName;
    }

    public String getStrSex() {
        return strSex;
    }

    public void setStrSex(String strSex) {
        this.strSex = strSex;
    }

    public Date getDtmBirthDate() {
        return dtmBirthDate;
    }

    public void setDtmBirthDate(Date dtmBirthDate) {
        this.dtmBirthDate = dtmBirthDate;
    }

    public double getNum2Height() {
        return num2Height;
    }

    public void setNum2Height(double num2Height) {
        this.num2Height = num2Height;
    }

    public double getNum2Weight() {
        return num2Weight;
    }

    public void setNum2Weight(double num2Weight) {
        this.num2Weight = num2Weight;
    }

    public String getStrDepartment() {
        return strDepartment;
    }

    public void setStrDepartment(String strDepartment) {
        this.strDepartment = strDepartment;
    }

    public boolean getBoolAdmitted() {
        return boolAdmitted;
    }

    public void setBoolAdmitted(boolean boolAdmitted) {
        this.boolAdmitted = boolAdmitted;
    }

    public Date getDtmHospitalization() {
        return dtmHospitalization;
    }

    public void setDtmHospitalization(Date dtmHospitalization) {
        this.dtmHospitalization = dtmHospitalization;
    }

    public TbLocation getFkLocationId() {
        return fkLocationId;
    }

    public void setFkLocationId(TbLocation fkLocationId) {
        this.fkLocationId = fkLocationId;
    }

    public TbPatientType getFkPatientTypeId() {
        return fkPatientTypeId;
    }

    public void setFkPatientTypeId(TbPatientType fkPatientTypeId) {
        this.fkPatientTypeId = fkPatientTypeId;
    }

    @XmlTransient
    public List<TbMonitoring> getTbMonitoringList() {
        return tbMonitoringList;
    }

    public void setTbMonitoringList(List<TbMonitoring> tbMonitoringList) {
        this.tbMonitoringList = tbMonitoringList;
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
        if (!(object instanceof TbPatient)) {
            return false;
        }
        TbPatient other = (TbPatient) object;
        if ((this.pkId == null && other.pkId != null) || (this.pkId != null && !this.pkId.equals(other.pkId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.puc_rio.inf.les.med.dao.model.TbPatient[ pkId=" + pkId + " ]";
    }
    
}
