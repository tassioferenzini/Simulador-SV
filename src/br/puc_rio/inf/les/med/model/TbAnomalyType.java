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
@Table(name = "tb_anomaly_type")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TbAnomalyType.findAll", query = "SELECT t FROM TbAnomalyType t")
    , @NamedQuery(name = "TbAnomalyType.findByPkId", query = "SELECT t FROM TbAnomalyType t WHERE t.pkId = :pkId")
    , @NamedQuery(name = "TbAnomalyType.findByStrType", query = "SELECT t FROM TbAnomalyType t WHERE t.strType = :strType")})
public class TbAnomalyType implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pk_id")
    private Integer pkId;
    @Basic(optional = false)
    @Column(name = "str_type")
    private String strType;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fkAnomalyTypeId")
    private List<TbAnomaly> tbAnomalyList;

    public TbAnomalyType() {
    }

    public TbAnomalyType(Integer pkId) {
        this.pkId = pkId;
    }

    public TbAnomalyType(Integer pkId, String strType) {
        this.pkId = pkId;
        this.strType = strType;
    }

    public Integer getPkId() {
        return pkId;
    }

    public void setPkId(Integer pkId) {
        this.pkId = pkId;
    }

    public String getStrType() {
        return strType;
    }

    public void setStrType(String strType) {
        this.strType = strType;
    }

    @XmlTransient
    public List<TbAnomaly> getTbAnomalyList() {
        return tbAnomalyList;
    }

    public void setTbAnomalyList(List<TbAnomaly> tbAnomalyList) {
        this.tbAnomalyList = tbAnomalyList;
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
        if (!(object instanceof TbAnomalyType)) {
            return false;
        }
        TbAnomalyType other = (TbAnomalyType) object;
        if ((this.pkId == null && other.pkId != null) || (this.pkId != null && !this.pkId.equals(other.pkId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.puc_rio.inf.les.med.dao.model.TbAnomalyType[ pkId=" + pkId + " ]";
    }
    
}
