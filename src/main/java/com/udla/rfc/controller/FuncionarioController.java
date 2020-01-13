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
    
    private String cedula;
    private String nombre;
    private String apellido;
    private Persona persona;
    private Funcionario funcionario;
    private Area area;
    
    @PostConstruct
    public void init() {
        System.out.println("Entro INIT");
        persona = new Persona();
        area = new Area();
        area.setIdArea(1);
        funcionario = new Funcionario();
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
    
    public void nuevoFuncionario(){
        try {
            persona.setCedula(getCedula());
            persona.setApellido(getApellido());
            persona.setNombre(getNombre());
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
        } catch (Exception e) {
        }
    }
}
