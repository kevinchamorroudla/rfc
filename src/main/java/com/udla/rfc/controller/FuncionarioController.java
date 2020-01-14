package com.udla.rfc.controller;

import com.udla.rfc.ejb.FuncionarioFacadeLocal;
import com.udla.rfc.ejb.PersonaFacadeLocal;
import com.udla.rfc.model.Area;
import com.udla.rfc.model.Persona;
import com.udla.rfc.model.Funcionario;
import com.udla.rfc.model.FuncionarioPK;
import com.udla.rfc.viewModels.FuncionarioViewModel;
import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

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
    private List<FuncionarioViewModel> funcionarios;
    
    @PostConstruct
    public void init() {
        getAllFuncionarios();
        //System.out.println(getFuncionarios());
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

    public List<FuncionarioViewModel> getFuncionarios() {
        return funcionarios;
    }

    public void setFuncionarios(List<FuncionarioViewModel> funcionarios) {
        this.funcionarios = funcionarios;
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
            getAllFuncionarios();
        } catch (Exception e) {
        }
    }
    
    public void getAllFuncionarios(){
        try {
            List<Funcionario> lFuncionarios = funcionarioEJB.findAll();
            this.funcionarios = lFuncionarios.stream().map(x -> new FuncionarioViewModel(
                    x.getPersona1().getCedula(), x.getPersona1().getNombre(), x.getPersona1().getApellido(), x.getArea().getNombre(), x.getArea().getDescripcion()
            )).collect(Collectors.toList());
        } catch (Exception e) {
        }
    }
}
