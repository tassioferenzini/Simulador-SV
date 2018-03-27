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
import javax.persistence.ManyToMany;
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
@Table(name = "tb_monitoring")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TbMonitoring.findAll", query = "SELECT t FROM TbMonitoring t")
    , @NamedQuery(name = "TbMonitoring.findByPkId", query = "SELECT t FROM TbMonitoring t WHERE t.pkId = :pkId")
    , @NamedQuery(name = "TbMonitoring.findByBoolActive", query = "SELECT t FROM TbMonitoring t WHERE t.boolActive = :boolActive")
    , @NamedQuery(name = "TbMonitoring.findByDtmStartData", query = "SELECT t FROM TbMonitoring t WHERE t.dtmStartData = :dtmStartData")
    , @NamedQuery(name = "TbMonitoring.findByDtmEndData", query = "SELECT t FROM TbMonitoring t WHERE t.dtmEndData = :dtmEndData")})
public class TbMonitoring implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pk_id")
    private Integer pkId;
    @Basic(optional = false)
    @Column(name = "bool_active")
    private boolean boolActive;
    @Basic(optional = false)
    @Column(name = "dtm_start_data")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dtmStartData;
    @Column(name = "dtm_end_data")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dtmEndData;
    @ManyToMany(mappedBy = "tbMonitoringList")
    private List<TbHealthProvider> tbHealthProviderList;
    @ManyToMany(mappedBy = "tbMonitoringList")
    private List<TbAnomaly> tbAnomalyList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fkMonitoringId")
    private List<TbMonitoringHasSensor> tbMonitoringHasSensorList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fkMonitoringId")
    private List<TbNotification> tbNotificationList;
    @JoinColumn(name = "fk_health_provider_id", referencedColumnName = "pk_id")
    @ManyToOne(optional = false)
    private TbHealthProvider fkHealthProviderId;
    @JoinColumn(name = "fk_patient_id", referencedColumnName = "pk_id")
    @ManyToOne(optional = false)
    private TbPatient fkPatientId;

    public TbMonitoring() {
    }

    public TbMonitoring(Integer pkId) {
        this.pkId = pkId;
    }

    public TbMonitoring(Integer pkId, boolean boolActive, Date dtmStartData) {
        this.pkId = pkId;
        this.boolActive = boolActive;
        this.dtmStartData = dtmStartData;
    }

    public Integer getPkId() {
        return pkId;
    }

    public void setPkId(Integer pkId) {
        this.pkId = pkId;
    }

    public boolean getBoolActive() {
        return boolActive;
    }

    public void setBoolActive(boolean boolActive) {
        this.boolActive = boolActive;
    }

    public Date getDtmStartData() {
        return dtmStartData;
    }

    public void setDtmStartData(Date dtmStartData) {
        this.dtmStartData = dtmStartData;
    }

    public Date getDtmEndData() {
        return dtmEndData;
    }

    public void setDtmEndData(Date dtmEndData) {
        this.dtmEndData = dtmEndData;
    }

    @XmlTransient
    public List<TbHealthProvider> getTbHealthProviderList() {
        return tbHealthProviderList;
    }

    public void setTbHealthProviderList(List<TbHealthProvider> tbHealthProviderList) {
        this.tbHealthProviderList = tbHealthProviderList;
    }

    @XmlTransient
    public List<TbAnomaly> getTbAnomalyList() {
        return tbAnomalyList;
    }

    public void setTbAnomalyList(List<TbAnomaly> tbAnomalyList) {
        this.tbAnomalyList = tbAnomalyList;
    }

    @XmlTransient
    public List<TbMonitoringHasSensor> getTbMonitoringHasSensorList() {
        return tbMonitoringHasSensorList;
    }

    public void setTbMonitoringHasSensorList(List<TbMonitoringHasSensor> tbMonitoringHasSensorList) {
        this.tbMonitoringHasSensorList = tbMonitoringHasSensorList;
    }

    @XmlTransient
    public List<TbNotification> getTbNotificationList() {
        return tbNotificationList;
    }

    public void setTbNotificationList(List<TbNotification> tbNotificationList) {
        this.tbNotificationList = tbNotificationList;
    }

    public TbHealthProvider getFkHealthProviderId() {
        return fkHealthProviderId;
    }

    public void setFkHealthProviderId(TbHealthProvider fkHealthProviderId) {
        this.fkHealthProviderId = fkHealthProviderId;
    }

    public TbPatient getFkPatientId() {
        return fkPatientId;
    }

    public void setFkPatientId(TbPatient fkPatientId) {
        this.fkPatientId = fkPatientId;
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
        if (!(object instanceof TbMonitoring)) {
            return false;
        }
        TbMonitoring other = (TbMonitoring) object;
        if ((this.pkId == null && other.pkId != null) || (this.pkId != null && !this.pkId.equals(other.pkId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.puc_rio.inf.les.med.dao.model.TbMonitoring[ pkId=" + pkId + " ]";
    }
    
}
