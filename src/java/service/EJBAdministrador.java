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
import excepciones.UpdateException;
import java.util.Collection;
import java.util.List;
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

    /**
     * Crea un Objeto Administrador en la base de Datos
     *
     * @param admin es un Objeto de la entidad Administrador
     * @throws CreateException Por si surge alguna excepcion durante el proceso
     */
    @Override
    public void crearAdministrador(Administrador admin) throws CreateException {
        em.persist(admin);
    }

    /**
     * Crea un Objeto Cliente en la base de Datos
     *
     * @param cliente es un Objeto de la entidad Cliente
     * @throws CreateException Por si surge alguna excepcion durante el proceso
     */
    @Override
    public void crearCliente(Cliente cliente) throws CreateException {
        em.persist(cliente);
    }

    /**
     * Crea un Objeto Dietista en la base de Datos
     *
     * @param dietista es un Objeto de la entidad Dietista
     * @throws CreateException Por si surge alguna excepcion durante el proceso
     */
    @Override
    public void crearDietista(Dietista dietista) throws CreateException {
        em.persist(dietista);
    }

    /**
     * Modifica un Objeto Administrador de la base de Datos
     *
     * @param admin es un Objeto de la entidad Administrador
     * @throws UpdateException Por si surge alguna excepcion durante el proceso
     */
    @Override
    public void modificarAdministrador(Administrador admin) throws UpdateException {
        em.merge(admin);
    }

    /**
     * Modifica un Objeto Cliente de la base de Datos
     *
     * @param cliente es un Objeto de la entidad Cliente
     * @throws UpdateException Por si surge alguna excepcion durante el proceso
     */
    @Override
    public void modificarCliente(Cliente cliente) throws UpdateException {
        em.merge(cliente);
    }

    /**
     * Modifica un Objeto Dietista de la base de Datos
     *
     * @param dietista es un Objeto de la entidad Dietista
     * @throws UpdateException Por si surge alguna excepcion durante el proceso
     */
    @Override
    public void modificarDietista(Dietista dietista) throws UpdateException {
        em.merge(dietista);
    }

    /**
     * Elimina un Objeto Cliente de la base de Datos
     *
     * @param cliente es un Objeto de la entidad Cliente
     * @throws DeleteException Por si surge alguna excepcion durante el proceso
     */
    @Override
    public void eliminarCliente(Cliente cliente) throws DeleteException {
        em.remove(cliente);
    }

    /**
     * Elimina un Objeto Dietista de la base de Datos
     *
     * @param dietista es un Objeto de la entidad Dietista
     * @throws DeleteException Por si surge alguna excepcion durante el proceso
     */
    @Override
    public void eliminarDietista(Dietista dietista) throws DeleteException {
        em.remove(dietista);
    }

    /**
     * Busca una lista de todos los objetos de Alimento en la base de Datos
     *
     * @return Devuelve una Lista de Alimentos
     * @throws ReadException Por si surge alguna excepcion durante el proceso
     */
    @Override
    public Collection<Administrador> getAdministradorTodos() throws ReadException {
        List<Administrador> administradores = null;
        try {
            administradores = em.createNamedQuery("getAdministradorTodos").getResultList();
        } catch (Exception e) {
            throw new ReadException(e.getMessage());
        }
        return administradores;
    }

}
