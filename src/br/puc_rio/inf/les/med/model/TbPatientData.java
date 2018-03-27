/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.puc_rio.inf.les.med.model;

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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author tassio
 */
@Entity
@Table(name = "tb_patient_data")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TbPatientData.findAll", query = "SELECT t FROM TbPatientData t")
    , @NamedQuery(name = "TbPatientData.findByPkId", query = "SELECT t FROM TbPatientData t WHERE t.pkId = :pkId")
    , @NamedQuery(name = "TbPatientData.findByStrValue", query = "SELECT t FROM TbPatientData t WHERE t.strValue = :strValue")
    , @NamedQuery(name = "TbPatientData.findByDtmTimestamp", query = "SELECT t FROM TbPatientData t WHERE t.dtmTimestamp = :dtmTimestamp")})
public class TbPatientData implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pk_id")
    private Integer pkId;
    @Basic(optional = false)
    @Column(name = "str_value")
    private String strValue;
    @Basic(optional = false)
    @Column(name = "dtm_timestamp")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dtmTimestamp;
    @JoinColumn(name = "fk_monitoring_has_sensor_id", referencedColumnName = "pk_id")
    @ManyToOne(optional = false)
    private TbMonitoringHasSensor fkMonitoringHasSensorId;

    public TbPatientData() {
    }

    public TbPatientData(Integer pkId) {
        this.pkId = pkId;
    }

    public TbPatientData(Integer pkId, String strValue, Date dtmTimestamp) {
        this.pkId = pkId;
        this.strValue = strValue;
        this.dtmTimestamp = dtmTimestamp;
    }

    public Integer getPkId() {
        return pkId;
    }

    public void setPkId(Integer pkId) {
        this.pkId = pkId;
    }

    public String getStrValue() {
        return strValue;
    }

    public void setStrValue(String strValue) {
        this.strValue = strValue;
    }

    public Date getDtmTimestamp() {
        return dtmTimestamp;
    }

    public void setDtmTimestamp(Date dtmTimestamp) {
        this.dtmTimestamp = dtmTimestamp;
    }

    public TbMonitoringHasSensor getFkMonitoringHasSensorId() {
        return fkMonitoringHasSensorId;
    }

    public void setFkMonitoringHasSensorId(TbMonitoringHasSensor fkMonitoringHasSensorId) {
        this.fkMonitoringHasSensorId = fkMonitoringHasSensorId;
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
        if (!(object instanceof TbPatientData)) {
            return false;
        }
        TbPatientData other = (TbPatientData) object;
        if ((this.pkId == null && other.pkId != null) || (this.pkId != null && !this.pkId.equals(other.pkId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.puc_rio.inf.les.med.dao.model.TbPatientData[ pkId=" + pkId + " ]";
    }
    
}
