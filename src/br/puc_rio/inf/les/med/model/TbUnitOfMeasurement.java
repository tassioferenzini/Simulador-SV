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
@Table(name = "tb_unit_of_measurement")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TbUnitOfMeasurement.findAll", query = "SELECT t FROM TbUnitOfMeasurement t")
    , @NamedQuery(name = "TbUnitOfMeasurement.findByPkId", query = "SELECT t FROM TbUnitOfMeasurement t WHERE t.pkId = :pkId")
    , @NamedQuery(name = "TbUnitOfMeasurement.findByStrUnitOfMeasurement", query = "SELECT t FROM TbUnitOfMeasurement t WHERE t.strUnitOfMeasurement = :strUnitOfMeasurement")})
public class TbUnitOfMeasurement implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pk_id")
    private Integer pkId;
    @Basic(optional = false)
    @Column(name = "str_unit_of_measurement")
    private String strUnitOfMeasurement;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fkUnitOfMeasurementId")
    private List<TbSensorType> tbSensorTypeList;

    public TbUnitOfMeasurement() {
    }

    public TbUnitOfMeasurement(Integer pkId) {
        this.pkId = pkId;
    }

    public TbUnitOfMeasurement(Integer pkId, String strUnitOfMeasurement) {
        this.pkId = pkId;
        this.strUnitOfMeasurement = strUnitOfMeasurement;
    }

    public Integer getPkId() {
        return pkId;
    }

    public void setPkId(Integer pkId) {
        this.pkId = pkId;
    }

    public String getStrUnitOfMeasurement() {
        return strUnitOfMeasurement;
    }

    public void setStrUnitOfMeasurement(String strUnitOfMeasurement) {
        this.strUnitOfMeasurement = strUnitOfMeasurement;
    }

    @XmlTransient
    public List<TbSensorType> getTbSensorTypeList() {
        return tbSensorTypeList;
    }

    public void setTbSensorTypeList(List<TbSensorType> tbSensorTypeList) {
        this.tbSensorTypeList = tbSensorTypeList;
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
        if (!(object instanceof TbUnitOfMeasurement)) {
            return false;
        }
        TbUnitOfMeasurement other = (TbUnitOfMeasurement) object;
        if ((this.pkId == null && other.pkId != null) || (this.pkId != null && !this.pkId.equals(other.pkId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.puc_rio.inf.les.med.dao.model.TbUnitOfMeasurement[ pkId=" + pkId + " ]";
    }
    
}
