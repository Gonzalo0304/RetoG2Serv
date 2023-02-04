/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import cifrado.Cifrado;
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
 * @author josue
 */
@Stateless

public class EJBDietista implements DietistaInterface {

    @PersistenceContext(unitName = "RetoG2Serv")
    private EntityManager em;
    /**
     * Crea un Objeto Dietista en la base de Datos
     * @param dietista es un Objeto de la Entidad Dietista
     * @throws CreateException Por si surge alguna excepcion durante el proceso
     */
    @Override
    public void crearDietista(Dietista dietista) throws CreateException {
        try {
                        Cifrado cifrado = new Cifrado();
            String contrasenia;
            contrasenia= cifrado.descifrarTexto1(dietista.getContrasenia());
            contrasenia = cifrado.hashearMensaje(contrasenia);
            dietista.setContrasenia(contrasenia);
            em.persist(dietista);
        } catch (Exception e) {
            throw new CreateException(e.getMessage());
        }
    }
  /**
     * Elimina un Objeto Dietista de la base de Datos
     * @param dietista es un Objeto de la Entidad Dietista
     * @throws DeleteException Por si surge alguna excepcion durante el proceso
     */
    @Override
    public void eliminarDietista(Dietista dietista) throws DeleteException {
        try {
            em.remove(em.merge(dietista));
        } catch (Exception e) {
            throw new DeleteException(e.getMessage());
        }
    }
    /**
     * Modifica un Objeto Dietista de la base de Datos
     * @param dietista es un Objeto de la Entidad Dietista
     * @throws UpdateException Por si surge alguna excepcion durante el proceso
     */
    @Override
    public void modificarDietista(Dietista dietista) throws UpdateException {
        try {
            em.merge(dietista);

            em.flush();
        } catch (Exception e) {
            throw new UpdateException(e.getMessage());
        }
    }
    /**
     * Busca un Objeto Dietista por su dni en la base de Datos
     * @param dni es un String
     * @return Devuelve un Objeto dietista con Datos
     * @throws ReadException Por si surge alguna excepcion durante el proceso
     */
    @Override
    public Dietista getDietistaPorDni(String dni) throws ReadException {
        Dietista dietista;
        try {
            dietista = em.find(Dietista.class, dni);

        } catch (Exception e) {
            throw new ReadException(e.getMessage());
        }

        return dietista;
    }
 /**
     * Busca una lista de todos los objetos de Dietista en la base de Datos
     * @return Devuelve una Lista de Dietistas
     * @throws ReadException Por si surge alguna excepcion durante el proceso
     */
    @Override
    public Collection<Dietista> getDietistaTodos() throws ReadException {
        List<Dietista> dietistas = null;
        try {
            dietistas = em.createNamedQuery("getDietistaTodos").getResultList();
        } catch (Exception e) {
            throw new ReadException(e.getMessage());
        }
        return dietistas;
    }

}
