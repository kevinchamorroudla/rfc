package com.udla.rfc.viewModels;

public class RequerimientoViewModel {
    private String solicitanteNombre;
    private String tipo;
    private String descripcion;
    private String estado;

    public RequerimientoViewModel(String solicitanteNombre, String tipo, String descripcion, String estado) {
        this.solicitanteNombre = solicitanteNombre;
        this.tipo = tipo;
        this.descripcion = descripcion;
        this.estado = estado;
    }

    public String getSolicitanteNombre() {
        return solicitanteNombre;
    }

    public void setSolicitanteNombre(String solicitanteNombre) {
        this.solicitanteNombre = solicitanteNombre;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "RequerimientoViewModel{" + "solicitanteNombre=" + solicitanteNombre + ", tipo=" + tipo + ", descripcion=" + descripcion + ", estado=" + estado + '}';
    }
    
}
