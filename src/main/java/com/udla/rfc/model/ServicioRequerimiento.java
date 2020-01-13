/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udla.rfc.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
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
 * @author Kevin
 */
@Entity
@Table(name = "servicio_requerimiento")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ServicioRequerimiento.findAll", query = "SELECT s FROM ServicioRequerimiento s"),
    @NamedQuery(name = "ServicioRequerimiento.findByIdServicio", query = "SELECT s FROM ServicioRequerimiento s WHERE s.servicioRequerimientoPK.idServicio = :idServicio"),
    @NamedQuery(name = "ServicioRequerimiento.findByIdRequerimiento", query = "SELECT s FROM ServicioRequerimiento s WHERE s.servicioRequerimientoPK.idRequerimiento = :idRequerimiento"),
    @NamedQuery(name = "ServicioRequerimiento.findByFecha", query = "SELECT s FROM ServicioRequerimiento s WHERE s.fecha = :fecha")})
public class ServicioRequerimiento implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ServicioRequerimientoPK servicioRequerimientoPK;
    @Column(name = "fecha")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;
    @JoinColumn(name = "idRequerimiento", referencedColumnName = "idRequerimiento", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Requerimiento requerimiento;
    @JoinColumn(name = "idServicio", referencedColumnName = "idServicio", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Servicio servicio;

    public ServicioRequerimiento() {
    }

    public ServicioRequerimiento(ServicioRequerimientoPK servicioRequerimientoPK) {
        this.servicioRequerimientoPK = servicioRequerimientoPK;
    }

    public ServicioRequerimiento(int idServicio, int idRequerimiento) {
        this.servicioRequerimientoPK = new ServicioRequerimientoPK(idServicio, idRequerimiento);
    }

    public ServicioRequerimientoPK getServicioRequerimientoPK() {
        return servicioRequerimientoPK;
    }

    public void setServicioRequerimientoPK(ServicioRequerimientoPK servicioRequerimientoPK) {
        this.servicioRequerimientoPK = servicioRequerimientoPK;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Requerimiento getRequerimiento() {
        return requerimiento;
    }

    public void setRequerimiento(Requerimiento requerimiento) {
        this.requerimiento = requerimiento;
    }

    public Servicio getServicio() {
        return servicio;
    }

    public void setServicio(Servicio servicio) {
        this.servicio = servicio;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (servicioRequerimientoPK != null ? servicioRequerimientoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ServicioRequerimiento)) {
            return false;
        }
        ServicioRequerimiento other = (ServicioRequerimiento) object;
        if ((this.servicioRequerimientoPK == null && other.servicioRequerimientoPK != null) || (this.servicioRequerimientoPK != null && !this.servicioRequerimientoPK.equals(other.servicioRequerimientoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.udla.rfc.model.ServicioRequerimiento[ servicioRequerimientoPK=" + servicioRequerimientoPK + " ]";
    }
    
}
