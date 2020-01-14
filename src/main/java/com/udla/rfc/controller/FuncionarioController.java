package com.udla.rfc.controller;

import com.udla.rfc.ejb.FuncionarioFacadeLocal;
import com.udla.rfc.ejb.PersonaFacadeLocal;
import com.udla.rfc.model.Area;
import com.udla.rfc.model.Persona;
import com.udla.rfc.model.Funcionario;
import com.udla.rfc.model.FuncionarioPK;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import static javax.faces.annotation.FacesConfig.Version.JSF_2_3;

import javax.faces.annotation.FacesConfig;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

@FacesConfig(
        // Activates CDI build-in beans
        version = JSF_2_3
)

@Named
@ViewScoped
public class FuncionarioController implements Serializable{
    
    private static final long serialVersionUID = 1L;
   
    @EJB
    private PersonaFacadeLocal personaEJB;
    @EJB
    private FuncionarioFacadeLocal funcionarioEJB;
    
    private Persona persona;
    private Funcionario funcionario;
    private Area area;

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }
    
    @PostConstruct
    public void init() {
        persona = new Persona();
        area = new Area();
        area.setIdArea(1);
        funcionario = new Funcionario();
    }
    
    public void nuevoFuncionario(){
        try {
            Persona personaInsertada = personaEJB.insertar(persona);
            FuncionarioPK pkCompuesta = new FuncionarioPK();
            pkCompuesta.setIdArea(area.getIdArea());
            pkCompuesta.setIdPersona(personaInsertada.getIdPersona());
            pkCompuesta.setIdAprobador(personaInsertada.getIdPersona());
            funcionario.setFuncionarioPK(pkCompuesta);
            funcionario.setArea(area);
            funcionario.setPersona(personaInsertada);
            funcionario.setPersona1(personaInsertada);
            funcionarioEJB.create(funcionario);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Aviso", "Registro exitoso"));
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Aviso", "Error!"));
        }
    }
}
