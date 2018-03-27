/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.puc_rio.inf.les.med.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author tassio
 */
@Entity
@Table(name = "tb_anomaly")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TbAnomaly.findAll", query = "SELECT t FROM TbAnomaly t")
    , @NamedQuery(name = "TbAnomaly.findByPkId", query = "SELECT t FROM TbAnomaly t WHERE t.pkId = :pkId")
    , @NamedQuery(name = "TbAnomaly.findByStrDescription", query = "SELECT t FROM TbAnomaly t WHERE t.strDescription = :strDescription")
    , @NamedQuery(name = "TbAnomaly.findByStrLabelMax", query = "SELECT t FROM TbAnomaly t WHERE t.strLabelMax = :strLabelMax")
    , @NamedQuery(name = "TbAnomaly.findByStrLabelMin", query = "SELECT t FROM TbAnomaly t WHERE t.strLabelMin = :strLabelMin")
    , @NamedQuery(name = "TbAnomaly.findByStrParamMax", query = "SELECT t FROM TbAnomaly t WHERE t.strParamMax = :strParamMax")
    , @NamedQuery(name = "TbAnomaly.findByStrParamMin", query = "SELECT t FROM TbAnomaly t WHERE t.strParamMin = :strParamMin")
    , @NamedQuery(name = "TbAnomaly.findByStrDefaultValue", query = "SELECT t FROM TbAnomaly t WHERE t.strDefaultValue = :strDefaultValue")})
public class TbAnomaly implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pk_id")
    private Integer pkId;
    @Basic(optional = false)
    @Column(name = "str_description")
    private String strDescription;
    @Basic(optional = false)
    @Column(name = "str_label_max")
    private String strLabelMax;
    @Basic(optional = false)
    @Column(name = "str_label_min")
    private String strLabelMin;
    @Basic(optional = false)
    @Column(name = "str_param_max")
    private String strParamMax;
    @Basic(optional = false)
    @Column(name = "str_param_min")
    private String strParamMin;
    @Basic(optional = false)
    @Column(name = "str_default_value")
    private String strDefaultValue;
    @JoinTable(name = "tb_monitoring_has_anomaly", joinColumns = {
        @JoinColumn(name = "fk_anomaly_pk_id", referencedColumnName = "pk_id")}, inverseJoinColumns = {
        @JoinColumn(name = "fk_monitoring_pk_id", referencedColumnName = "pk_id")})
    @ManyToMany
    private List<TbMonitoring> tbMonitoringList;
    @JoinColumn(name = "fk_anomaly_type_id", referencedColumnName = "pk_id")
    @ManyToOne(optional = false)
    private TbAnomalyType fkAnomalyTypeId;

    public TbAnomaly() {
    }

    public TbAnomaly(Integer pkId) {
        this.pkId = pkId;
    }

    public TbAnomaly(Integer pkId, String strDescription, String strLabelMax, String strLabelMin, String strParamMax, String strParamMin, String strDefaultValue) {
        this.pkId = pkId;
        this.strDescription = strDescription;
        this.strLabelMax = strLabelMax;
        this.strLabelMin = strLabelMin;
        this.strParamMax = strParamMax;
        this.strParamMin = strParamMin;
        this.strDefaultValue = strDefaultValue;
    }

    public Integer getPkId() {
        return pkId;
    }

    public void setPkId(Integer pkId) {
        this.pkId = pkId;
    }

    public String getStrDescription() {
        return strDescription;
    }

    public void setStrDescription(String strDescription) {
        this.strDescription = strDescription;
    }

    public String getStrLabelMax() {
        return strLabelMax;
    }

    public void setStrLabelMax(String strLabelMax) {
        this.strLabelMax = strLabelMax;
    }

    public String getStrLabelMin() {
        return strLabelMin;
    }

    public void setStrLabelMin(String strLabelMin) {
        this.strLabelMin = strLabelMin;
    }

    public String getStrParamMax() {
        return strParamMax;
    }

    public void setStrParamMax(String strParamMax) {
        this.strParamMax = strParamMax;
    }

    public String getStrParamMin() {
        return strParamMin;
    }

    public void setStrParamMin(String strParamMin) {
        this.strParamMin = strParamMin;
    }

    public String getStrDefaultValue() {
        return strDefaultValue;
    }

    public void setStrDefaultValue(String strDefaultValue) {
        this.strDefaultValue = strDefaultValue;
    }

    @XmlTransient
    public List<TbMonitoring> getTbMonitoringList() {
        return tbMonitoringList;
    }

    public void setTbMonitoringList(List<TbMonitoring> tbMonitoringList) {
        this.tbMonitoringList = tbMonitoringList;
    }

    public TbAnomalyType getFkAnomalyTypeId() {
        return fkAnomalyTypeId;
    }

    public void setFkAnomalyTypeId(TbAnomalyType fkAnomalyTypeId) {
        this.fkAnomalyTypeId = fkAnomalyTypeId;
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
        if (!(object instanceof TbAnomaly)) {
            return false;
        }
        TbAnomaly other = (TbAnomaly) object;
        if ((this.pkId == null && other.pkId != null) || (this.pkId != null && !this.pkId.equals(other.pkId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.puc_rio.inf.les.med.dao.model.TbAnomaly[ pkId=" + pkId + " ]";
    }
    
}
