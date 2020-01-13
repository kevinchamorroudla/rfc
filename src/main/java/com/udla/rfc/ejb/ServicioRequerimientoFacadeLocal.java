/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udla.rfc.ejb;

import com.udla.rfc.model.ServicioRequerimiento;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Kevin
 */
@Local
public interface ServicioRequerimientoFacadeLocal {

    void create(ServicioRequerimiento servicioRequerimiento);

    void edit(ServicioRequerimiento servicioRequerimiento);

    void remove(ServicioRequerimiento servicioRequerimiento);

    ServicioRequerimiento find(Object id);

    List<ServicioRequerimiento> findAll();

    List<ServicioRequerimiento> findRange(int[] range);

    int count();
    
}
