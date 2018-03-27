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
import javax.persistence.ManyToOne;
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
@Table(name = "tb_sensor")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TbSensor.findAll", query = "SELECT t FROM TbSensor t")
    , @NamedQuery(name = "TbSensor.findByPkId", query = "SELECT t FROM TbSensor t WHERE t.pkId = :pkId")
    , @NamedQuery(name = "TbSensor.findByBoolAvailable", query = "SELECT t FROM TbSensor t WHERE t.boolAvailable = :boolAvailable")
    , @NamedQuery(name = "TbSensor.findByStrDevice", query = "SELECT t FROM TbSensor t WHERE t.strDevice = :strDevice")})
public class TbSensor implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pk_id")
    private Integer pkId;
    @Basic(optional = false)
    @Column(name = "bool_available")
    private boolean boolAvailable;
    @Basic(optional = false)
    @Column(name = "str_device")
    private String strDevice;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fkSensorId")
    private List<TbMonitoringHasSensor> tbMonitoringHasSensorList;
    @JoinColumn(name = "fk_sensor_type_id", referencedColumnName = "pk_id")
    @ManyToOne(optional = false)
    private TbSensorType fkSensorTypeId;

    public TbSensor() {
    }

    public TbSensor(Integer pkId) {
        this.pkId = pkId;
    }

    public TbSensor(Integer pkId, boolean boolAvailable, String strDevice) {
        this.pkId = pkId;
        this.boolAvailable = boolAvailable;
        this.strDevice = strDevice;
    }

    public Integer getPkId() {
        return pkId;
    }

    public void setPkId(Integer pkId) {
        this.pkId = pkId;
    }

    public boolean getBoolAvailable() {
        return boolAvailable;
    }

    public void setBoolAvailable(boolean boolAvailable) {
        this.boolAvailable = boolAvailable;
    }

    public String getStrDevice() {
        return strDevice;
    }

    public void setStrDevice(String strDevice) {
        this.strDevice = strDevice;
    }

    @XmlTransient
    public List<TbMonitoringHasSensor> getTbMonitoringHasSensorList() {
        return tbMonitoringHasSensorList;
    }

    public void setTbMonitoringHasSensorList(List<TbMonitoringHasSensor> tbMonitoringHasSensorList) {
        this.tbMonitoringHasSensorList = tbMonitoringHasSensorList;
    }

    public TbSensorType getFkSensorTypeId() {
        return fkSensorTypeId;
    }

    public void setFkSensorTypeId(TbSensorType fkSensorTypeId) {
        this.fkSensorTypeId = fkSensorTypeId;
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
        if (!(object instanceof TbSensor)) {
            return false;
        }
        TbSensor other = (TbSensor) object;
        if ((this.pkId == null && other.pkId != null) || (this.pkId != null && !this.pkId.equals(other.pkId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.puc_rio.inf.les.med.dao.model.TbSensor[ pkId=" + pkId + " ]";
    }
    
}
