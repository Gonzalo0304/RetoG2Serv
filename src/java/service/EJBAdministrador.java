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
import excepciones.ReadException;
import java.util.Collection;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Gonzalo
 */
@Stateless
public class EJBAdministrador implements AdministradorInterface{

    @PersistenceContext(unitName = "Reto2G2ServPU")    
    private EntityManager em;
    
    @Override
    public void crearAdministrador(Administrador administrador) throws CreateException{
        em.persist(administrador);
    }
    
    @Override
    public void crearCliente(Cliente cliente) throws CreateException{
        em.persist(cliente);
    }

    @Override
    public void crearDietista(Dietista dietista) throws CreateException{
        em.persist(dietista);
    }
    
    @Override
    public void eliminarAdministrador(Administrador administrador) throws DeleteException{
        em.remove(administrador);
    }
    
    @Override
    public void eliminarCliente(Cliente cliente) throws DeleteException{
        em.remove(cliente);
    }

    @Override
    public void eliminarDietista(Dietista dietista) throws DeleteException{
        em.remove(dietista);        
    }

    @Override
    public Administrador getAdministradorPorDNI(String dni) throws ReadException{
        Administrador admin;
        admin = em.find(Administrador.class, dni);
        return admin;
    }

    @Override
    public Collection<Administrador> getAdministradorAll() throws ReadException{
        Collection<Administrador> listaAdmmin=null;
        listaAdmmin = em.createNamedQuery("getAdminTodos").getResultList();
        return listaAdmmin;
    }

    

    
    
    
}
