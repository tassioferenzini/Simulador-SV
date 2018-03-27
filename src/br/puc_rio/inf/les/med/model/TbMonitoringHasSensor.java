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
@Table(name = "tb_monitoring_has_sensor")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TbMonitoringHasSensor.findAll", query = "SELECT t FROM TbMonitoringHasSensor t")
    , @NamedQuery(name = "TbMonitoringHasSensor.findByPkId", query = "SELECT t FROM TbMonitoringHasSensor t WHERE t.pkId = :pkId")
    , @NamedQuery(name = "TbMonitoringHasSensor.findByDmtStartData", query = "SELECT t FROM TbMonitoringHasSensor t WHERE t.dmtStartData = :dmtStartData")
    , @NamedQuery(name = "TbMonitoringHasSensor.findByDtmEndData", query = "SELECT t FROM TbMonitoringHasSensor t WHERE t.dtmEndData = :dtmEndData")})
public class TbMonitoringHasSensor implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pk_id")
    private Integer pkId;
    @Basic(optional = false)
    @Column(name = "dmt_start_data")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dmtStartData;
    @Basic(optional = false)
    @Column(name = "dtm_end_data")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dtmEndData;
    @JoinColumn(name = "fk_monitoring_id", referencedColumnName = "pk_id")
    @ManyToOne(optional = false)
    private TbMonitoring fkMonitoringId;
    @JoinColumn(name = "fk_sensor_id", referencedColumnName = "pk_id")
    @ManyToOne(optional = false)
    private TbSensor fkSensorId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fkMonitoringHasSensorId")
    private List<TbPatientData> tbPatientDataList;

    public TbMonitoringHasSensor() {
    }

    public TbMonitoringHasSensor(Integer pkId) {
        this.pkId = pkId;
    }

    public TbMonitoringHasSensor(Integer pkId, Date dmtStartData, Date dtmEndData) {
        this.pkId = pkId;
        this.dmtStartData = dmtStartData;
        this.dtmEndData = dtmEndData;
    }

    public Integer getPkId() {
        return pkId;
    }

    public void setPkId(Integer pkId) {
        this.pkId = pkId;
    }

    public Date getDmtStartData() {
        return dmtStartData;
    }

    public void setDmtStartData(Date dmtStartData) {
        this.dmtStartData = dmtStartData;
    }

    public Date getDtmEndData() {
        return dtmEndData;
    }

    public void setDtmEndData(Date dtmEndData) {
        this.dtmEndData = dtmEndData;
    }

    public TbMonitoring getFkMonitoringId() {
        return fkMonitoringId;
    }

    public void setFkMonitoringId(TbMonitoring fkMonitoringId) {
        this.fkMonitoringId = fkMonitoringId;
    }

    public TbSensor getFkSensorId() {
        return fkSensorId;
    }

    public void setFkSensorId(TbSensor fkSensorId) {
        this.fkSensorId = fkSensorId;
    }

    @XmlTransient
    public List<TbPatientData> getTbPatientDataList() {
        return tbPatientDataList;
    }

    public void setTbPatientDataList(List<TbPatientData> tbPatientDataList) {
        this.tbPatientDataList = tbPatientDataList;
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
        if (!(object instanceof TbMonitoringHasSensor)) {
            return false;
        }
        TbMonitoringHasSensor other = (TbMonitoringHasSensor) object;
        if ((this.pkId == null && other.pkId != null) || (this.pkId != null && !this.pkId.equals(other.pkId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.puc_rio.inf.les.med.dao.model.TbMonitoringHasSensor[ pkId=" + pkId + " ]";
    }
    
}
