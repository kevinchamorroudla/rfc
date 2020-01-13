/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udla.rfc.model;

import java.io.Serializable;
import java.util.Collection;
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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Kevin
 */
@Entity
@Table(name = "requerimiento")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Requerimiento.findAll", query = "SELECT r FROM Requerimiento r"),
    @NamedQuery(name = "Requerimiento.findByEstado", query = "SELECT r FROM Requerimiento r WHERE r.estado = :estado"),
    @NamedQuery(name = "Requerimiento.findByTipo", query = "SELECT r FROM Requerimiento r WHERE r.tipo = :tipo"),
    @NamedQuery(name = "Requerimiento.findByPrioridad", query = "SELECT r FROM Requerimiento r WHERE r.prioridad = :prioridad"),
    @NamedQuery(name = "Requerimiento.findByIdAprobador", query = "SELECT r FROM Requerimiento r WHERE r.idAprobador = :idAprobador"),
    @NamedQuery(name = "Requerimiento.findByDescripcion", query = "SELECT r FROM Requerimiento r WHERE r.descripcion = :descripcion"),
    @NamedQuery(name = "Requerimiento.findByIdRequerimiento", query = "SELECT r FROM Requerimiento r WHERE r.idRequerimiento = :idRequerimiento")})
public class Requerimiento implements Serializable {

    private static final long serialVersionUID = 1L;
    @Size(max = 45)
    @Column(name = "estado")
    private String estado;
    @Size(max = 45)
    @Column(name = "tipo")
    private String tipo;
    @Size(max = 45)
    @Column(name = "prioridad")
    private String prioridad;
    @Column(name = "idAprobador")
    private Integer idAprobador;
    @Size(max = 45)
    @Column(name = "descripcion")
    private String descripcion;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idRequerimiento")
    private Integer idRequerimiento;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "requerimiento")
    private Collection<ServicioRequerimiento> servicioRequerimientoCollection;
    @JoinColumn(name = "idSolicitante", referencedColumnName = "idPersona")
    @ManyToOne
    private Persona idSolicitante;

    public Requerimiento() {
    }

    public Requerimiento(Integer idRequerimiento) {
        this.idRequerimiento = idRequerimiento;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getPrioridad() {
        return prioridad;
    }

    public void setPrioridad(String prioridad) {
        this.prioridad = prioridad;
    }

    public Integer getIdAprobador() {
        return idAprobador;
    }

    public void setIdAprobador(Integer idAprobador) {
        this.idAprobador = idAprobador;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Integer getIdRequerimiento() {
        return idRequerimiento;
    }

    public void setIdRequerimiento(Integer idRequerimiento) {
        this.idRequerimiento = idRequerimiento;
    }

    @XmlTransient
    public Collection<ServicioRequerimiento> getServicioRequerimientoCollection() {
        return servicioRequerimientoCollection;
    }

    public void setServicioRequerimientoCollection(Collection<ServicioRequerimiento> servicioRequerimientoCollection) {
        this.servicioRequerimientoCollection = servicioRequerimientoCollection;
    }

    public Persona getIdSolicitante() {
        return idSolicitante;
    }

    public void setIdSolicitante(Persona idSolicitante) {
        this.idSolicitante = idSolicitante;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idRequerimiento != null ? idRequerimiento.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Requerimiento)) {
            return false;
        }
        Requerimiento other = (Requerimiento) object;
        if ((this.idRequerimiento == null && other.idRequerimiento != null) || (this.idRequerimiento != null && !this.idRequerimiento.equals(other.idRequerimiento))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.udla.rfc.model.Requerimiento[ idRequerimiento=" + idRequerimiento + " ]";
    }
    
}
