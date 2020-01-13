package com.udla.rfc.controller;

import com.udla.rfc.ejb.RequerimientoFacadeLocal;
import com.udla.rfc.model.Requerimiento;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

@Named
@ViewScoped
public class RequerimientoController implements Serializable {
    
    @EJB
    private RequerimientoFacadeLocal requerimientoEJB;
    private Requerimiento requerimiento;

    public Requerimiento getRequerimiento() {
        return requerimiento;
    }

    public void setRequerimiento(Requerimiento requerimiento) {
        this.requerimiento = requerimiento;
    }
    
    @PostConstruct
    public void init(){
        requerimiento = new Requerimiento();
    }
    
    public void nuevoRequerimiento(){
        try {
            requerimientoEJB.create(getRequerimiento());
        } catch (Exception e) {
        }
    }
}
