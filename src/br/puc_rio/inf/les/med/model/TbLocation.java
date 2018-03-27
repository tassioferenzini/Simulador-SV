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
@Table(name = "tb_location")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TbLocation.findAll", query = "SELECT t FROM TbLocation t")
    , @NamedQuery(name = "TbLocation.findByPkId", query = "SELECT t FROM TbLocation t WHERE t.pkId = :pkId")
    , @NamedQuery(name = "TbLocation.findByStrRoom", query = "SELECT t FROM TbLocation t WHERE t.strRoom = :strRoom")
    , @NamedQuery(name = "TbLocation.findByStrSpot", query = "SELECT t FROM TbLocation t WHERE t.strSpot = :strSpot")})
public class TbLocation implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pk_id")
    private Integer pkId;
    @Column(name = "str_room")
    private String strRoom;
    @Column(name = "str_spot")
    private String strSpot;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fkLocationId")
    private List<TbPatient> tbPatientList;

    public TbLocation() {
    }

    public TbLocation(Integer pkId) {
        this.pkId = pkId;
    }

    public Integer getPkId() {
        return pkId;
    }

    public void setPkId(Integer pkId) {
        this.pkId = pkId;
    }

    public String getStrRoom() {
        return strRoom;
    }

    public void setStrRoom(String strRoom) {
        this.strRoom = strRoom;
    }

    public String getStrSpot() {
        return strSpot;
    }

    public void setStrSpot(String strSpot) {
        this.strSpot = strSpot;
    }

    @XmlTransient
    public List<TbPatient> getTbPatientList() {
        return tbPatientList;
    }

    public void setTbPatientList(List<TbPatient> tbPatientList) {
        this.tbPatientList = tbPatientList;
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
        if (!(object instanceof TbLocation)) {
            return false;
        }
        TbLocation other = (TbLocation) object;
        if ((this.pkId == null && other.pkId != null) || (this.pkId != null && !this.pkId.equals(other.pkId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.puc_rio.inf.les.med.dao.model.TbLocation[ pkId=" + pkId + " ]";
    }
    
}
