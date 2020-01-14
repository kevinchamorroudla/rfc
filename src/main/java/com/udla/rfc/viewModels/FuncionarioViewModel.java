package com.udla.rfc.viewModels;

import java.io.Serializable;

public class FuncionarioViewModel implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    private String cedula;
    private String nombre;
    private String apellido;
    private String areaNombre;
    private String areaDescripcion;

    public FuncionarioViewModel(String cedula, String nombre, String apellido, String areaNombre, String areaDescripcion) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.apellido = apellido;
        this.areaNombre = areaNombre;
        this.areaDescripcion = areaDescripcion;
    }
    
    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getAreaNombre() {
        return areaNombre;
    }

    public void setAreaNombre(String areaNombre) {
        this.areaNombre = areaNombre;
    }

    public String getAreaDescripcion() {
        return areaDescripcion;
    }

    public void setAreaDescripcion(String areaDescripcion) {
        this.areaDescripcion = areaDescripcion;
    }

    @Override
    public String toString() {
        return "FuncionarioViewModel{" + "cedula=" + cedula + ", nombre=" + nombre + ", apellido=" + apellido + ", areaNombre=" + areaNombre + ", areaDescripcion=" + areaDescripcion + '}';
    }
    
}
