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
@Table(name = "tb_sensor_type")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TbSensorType.findAll", query = "SELECT t FROM TbSensorType t")
    , @NamedQuery(name = "TbSensorType.findByPkId", query = "SELECT t FROM TbSensorType t WHERE t.pkId = :pkId")
    , @NamedQuery(name = "TbSensorType.findByStrDescription", query = "SELECT t FROM TbSensorType t WHERE t.strDescription = :strDescription")
    , @NamedQuery(name = "TbSensorType.findByStrGeneralType", query = "SELECT t FROM TbSensorType t WHERE t.strGeneralType = :strGeneralType")
    , @NamedQuery(name = "TbSensorType.findByStrReferenceModel", query = "SELECT t FROM TbSensorType t WHERE t.strReferenceModel = :strReferenceModel")
    , @NamedQuery(name = "TbSensorType.findByStrMinValue", query = "SELECT t FROM TbSensorType t WHERE t.strMinValue = :strMinValue")
    , @NamedQuery(name = "TbSensorType.findByStrMaxValue", query = "SELECT t FROM TbSensorType t WHERE t.strMaxValue = :strMaxValue")})
public class TbSensorType implements Serializable {

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
    @Column(name = "str_general_type")
    private String strGeneralType;
    @Basic(optional = false)
    @Column(name = "str_reference_model")
    private String strReferenceModel;
    @Basic(optional = false)
    @Column(name = "str_min_value")
    private String strMinValue;
    @Basic(optional = false)
    @Column(name = "str_max_value")
    private String strMaxValue;
    @JoinColumn(name = "fk_unit_of_measurement_id", referencedColumnName = "pk_id")
    @ManyToOne(optional = false)
    private TbUnitOfMeasurement fkUnitOfMeasurementId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fkSensorTypeId")
    private List<TbSensor> tbSensorList;

    public TbSensorType() {
    }

    public TbSensorType(Integer pkId) {
        this.pkId = pkId;
    }

    public TbSensorType(Integer pkId, String strDescription, String strGeneralType, String strReferenceModel, String strMinValue, String strMaxValue) {
        this.pkId = pkId;
        this.strDescription = strDescription;
        this.strGeneralType = strGeneralType;
        this.strReferenceModel = strReferenceModel;
        this.strMinValue = strMinValue;
        this.strMaxValue = strMaxValue;
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

    public String getStrGeneralType() {
        return strGeneralType;
    }

    public void setStrGeneralType(String strGeneralType) {
        this.strGeneralType = strGeneralType;
    }

    public String getStrReferenceModel() {
        return strReferenceModel;
    }

    public void setStrReferenceModel(String strReferenceModel) {
        this.strReferenceModel = strReferenceModel;
    }

    public String getStrMinValue() {
        return strMinValue;
    }

    public void setStrMinValue(String strMinValue) {
        this.strMinValue = strMinValue;
    }

    public String getStrMaxValue() {
        return strMaxValue;
    }

    public void setStrMaxValue(String strMaxValue) {
        this.strMaxValue = strMaxValue;
    }

    public TbUnitOfMeasurement getFkUnitOfMeasurementId() {
        return fkUnitOfMeasurementId;
    }

    public void setFkUnitOfMeasurementId(TbUnitOfMeasurement fkUnitOfMeasurementId) {
        this.fkUnitOfMeasurementId = fkUnitOfMeasurementId;
    }

    @XmlTransient
    public List<TbSensor> getTbSensorList() {
        return tbSensorList;
    }

    public void setTbSensorList(List<TbSensor> tbSensorList) {
        this.tbSensorList = tbSensorList;
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
        if (!(object instanceof TbSensorType)) {
            return false;
        }
        TbSensorType other = (TbSensorType) object;
        if ((this.pkId == null && other.pkId != null) || (this.pkId != null && !this.pkId.equals(other.pkId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.puc_rio.inf.les.med.dao.model.TbSensorType[ pkId=" + pkId + " ]";
    }
    
}
