/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udla.rfc.controller;

import com.udla.rfc.ejb.FuncionarioFacadeLocal;
import com.udla.rfc.model.Funcionario;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

/**
 *
 * @author root
 */
@Named
@ViewScoped
public class LoginController implements Serializable {
    
    @EJB
    private FuncionarioFacadeLocal EJBUsuario;
    private Funcionario usuario;
    
    @PostConstruct
    public void init() {
        usuario = new Funcionario();
    }

    public Funcionario getUsuario() {
        return usuario;
    }

    public void setUsuario(Funcionario usuario) {
        this.usuario = usuario;
    }
    
    public String iniciarSesion() {
        Funcionario usr;
        String redireccion = null;
        try {
            usr = EJBUsuario.iniciarSesion(usuario);
            if (usr == null) {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Aviso", "Credenciales incorrectas"));
            } else {
                redireccion = "/secure/main?faces-redirect=true";
            }
        } catch(Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Aviso", "Error!"));
        }
        
        return redireccion;
    }
    
}
