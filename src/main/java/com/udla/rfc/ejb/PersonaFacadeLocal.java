/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udla.rfc.ejb;

import com.udla.rfc.model.Persona;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Kevin
 */
@Local
public interface PersonaFacadeLocal {

    void create(Persona persona);
    
    Persona insertar(Persona persona);

    void edit(Persona persona);

    void remove(Persona persona);

    Persona find(Object id);

    List<Persona> findAll();

    List<Persona> findRange(int[] range);

    int count();
    
}
