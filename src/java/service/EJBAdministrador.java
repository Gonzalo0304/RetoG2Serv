/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import entities.Administrador;
import entities.Cliente;
import entities.Dietista;
import excepciones.CreateException;
import excepciones.DeleteException;
import excepciones.UpdateException;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Gonzalo
 */
@Stateless
public class EJBAdministrador implements AdministradorInterface {
    
    @PersistenceContext(unitName = "Reto2G2ServPU")
    private EntityManager em;
    
    @Override
    public void crearAdministrador(Administrador admin) throws CreateException {
        em.persist(admin);
    }

    @Override
    public void crearCliente(Cliente cliente) throws CreateException {
        em.persist(cliente);
    }

    @Override
    public void crearDietista(Dietista dietista) throws CreateException {
        em.persist(dietista);
    }

    @Override
    public void modificarAdministrador(Administrador admin) throws UpdateException {
        em.merge(admin);
    }

    @Override
    public void modificarCliente(Cliente cliente) throws UpdateException {
        em.merge(cliente);
    }

    @Override
    public void modificarDietista(Dietista dietista) throws UpdateException {
        em.merge(dietista);
    }

    @Override
    public void eliminarCliente(Cliente cliente) throws DeleteException {
        em.remove(cliente);
    }

    @Override
    public void eliminarDietista(Dietista dietista) throws DeleteException {
        em.remove(dietista);
    }
    
}
