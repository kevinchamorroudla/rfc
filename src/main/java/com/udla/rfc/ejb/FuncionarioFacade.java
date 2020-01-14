/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udla.rfc.ejb;

import com.udla.rfc.model.Area;
import com.udla.rfc.model.Funcionario;
import com.udla.rfc.model.Persona;
import com.udla.rfc.viewModels.FuncionarioViewModel;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Root;

/**
 *
 * @author Kevin
 */
@Stateless
public class FuncionarioFacade extends AbstractFacade<Funcionario> implements FuncionarioFacadeLocal {

    @PersistenceContext(unitName = "rfcPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public FuncionarioFacade() {
        super(Funcionario.class);
    }
    
    @Override
    public List<FuncionarioViewModel> findAllFuncionarios() {
        CriteriaBuilder builder = getEntityManager().getCriteriaBuilder();
        
        CriteriaQuery<FuncionarioViewModel> query  = builder.createQuery( FuncionarioViewModel.class );
        Root<Funcionario> from = query.from( Funcionario.class );
        
        Join<Funcionario, Persona> joinPersona = from.join("idPersona");
        Join<Funcionario, Area> joinArea = from.join("idArea"); 
        
        query.multiselect(joinPersona.get("cedula"), joinPersona.get("nombre"), 
                joinPersona.get("apellido"), joinArea.get("nombre"), joinArea.get("descripcion"));
        
        TypedQuery<FuncionarioViewModel> createQuery = getEntityManager().createQuery(query);       
        List<FuncionarioViewModel> resultList = createQuery.getResultList();
        return resultList;
    }
    
}
