/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

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

    @PersistenceContext(unitName = "Reto2G2ServPU")
    private EntityManager em;

    @Override
    public void crearDietista(Dietista dietista) throws CreateException {
        try {
            em.persist(dietista);
        } catch (Exception e) {
            throw new CreateException(e.getMessage());
        }
    }

    @Override
    public void eliminarDietista(Dietista dietista) throws DeleteException {
        try {
            em.remove(em.merge(dietista));
        } catch (Exception e) {
            throw new DeleteException(e.getMessage());
        }
    }

    @Override
    public void modificarDietista(Dietista dietista) throws UpdateException {
        try {
            em.merge(dietista);

            em.flush();
        } catch (Exception e) {
            throw new UpdateException(e.getMessage());
        }
    }

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
