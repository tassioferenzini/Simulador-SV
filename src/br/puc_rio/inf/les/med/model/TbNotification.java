/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.puc_rio.inf.les.med.model;

import java.io.Serializable;
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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author tassio
 */
@Entity
@Table(name = "tb_notification")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TbNotification.findAll", query = "SELECT t FROM TbNotification t")
    , @NamedQuery(name = "TbNotification.findByPkId", query = "SELECT t FROM TbNotification t WHERE t.pkId = :pkId")
    , @NamedQuery(name = "TbNotification.findByNum1Priority", query = "SELECT t FROM TbNotification t WHERE t.num1Priority = :num1Priority")})
public class TbNotification implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pk_id")
    private Integer pkId;
    @Basic(optional = false)
    @Column(name = "num1_priority")
    private int num1Priority;
    @JoinColumn(name = "fk_monitoring_id", referencedColumnName = "pk_id")
    @ManyToOne(optional = false)
    private TbMonitoring fkMonitoringId;
    @JoinColumn(name = "fk_type_of_notification_id", referencedColumnName = "pk_id")
    @ManyToOne(optional = false)
    private TbTypeOfNotification fkTypeOfNotificationId;

    public TbNotification() {
    }

    public TbNotification(Integer pkId) {
        this.pkId = pkId;
    }

    public TbNotification(Integer pkId, int num1Priority) {
        this.pkId = pkId;
        this.num1Priority = num1Priority;
    }

    public Integer getPkId() {
        return pkId;
    }

    public void setPkId(Integer pkId) {
        this.pkId = pkId;
    }

    public int getNum1Priority() {
        return num1Priority;
    }

    public void setNum1Priority(int num1Priority) {
        this.num1Priority = num1Priority;
    }

    public TbMonitoring getFkMonitoringId() {
        return fkMonitoringId;
    }

    public void setFkMonitoringId(TbMonitoring fkMonitoringId) {
        this.fkMonitoringId = fkMonitoringId;
    }

    public TbTypeOfNotification getFkTypeOfNotificationId() {
        return fkTypeOfNotificationId;
    }

    public void setFkTypeOfNotificationId(TbTypeOfNotification fkTypeOfNotificationId) {
        this.fkTypeOfNotificationId = fkTypeOfNotificationId;
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
        if (!(object instanceof TbNotification)) {
            return false;
        }
        TbNotification other = (TbNotification) object;
        if ((this.pkId == null && other.pkId != null) || (this.pkId != null && !this.pkId.equals(other.pkId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.puc_rio.inf.les.med.dao.model.TbNotification[ pkId=" + pkId + " ]";
    }
    
}
