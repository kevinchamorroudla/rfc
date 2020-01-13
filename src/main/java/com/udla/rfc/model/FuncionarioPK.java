/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udla.rfc.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Kevin
 */
@Embeddable
public class FuncionarioPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "idPersona")
    private int idPersona;
    @Basic(optional = false)
    @NotNull
    @Column(name = "idAprobador")
    private int idAprobador;
    @Basic(optional = false)
    @NotNull
    @Column(name = "idArea")
    private int idArea;

    public FuncionarioPK() {
    }

    public FuncionarioPK(int idPersona, int idAprobador, int idArea) {
        this.idPersona = idPersona;
        this.idAprobador = idAprobador;
        this.idArea = idArea;
    }

    public int getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(int idPersona) {
        this.idPersona = idPersona;
    }

    public int getIdAprobador() {
        return idAprobador;
    }

    public void setIdAprobador(int idAprobador) {
        this.idAprobador = idAprobador;
    }

    public int getIdArea() {
        return idArea;
    }

    public void setIdArea(int idArea) {
        this.idArea = idArea;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idPersona;
        hash += (int) idAprobador;
        hash += (int) idArea;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FuncionarioPK)) {
            return false;
        }
        FuncionarioPK other = (FuncionarioPK) object;
        if (this.idPersona != other.idPersona) {
            return false;
        }
        if (this.idAprobador != other.idAprobador) {
            return false;
        }
        if (this.idArea != other.idArea) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.udla.rfc.model.FuncionarioPK[ idPersona=" + idPersona + ", idAprobador=" + idAprobador + ", idArea=" + idArea + " ]";
    }
    
}
