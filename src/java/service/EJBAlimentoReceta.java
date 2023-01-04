/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import entities.AlimentoReceta;
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
public class EJBAlimentoReceta implements AlimentoRecetaInterface {

    @PersistenceContext(unitName = "Reto2G2ServPU")
    private EntityManager em;

    @Override
    public void crearAlimentoReceta(AlimentoReceta alimentoReceta) throws CreateException {
        try {
            em.persist(alimentoReceta);
        } catch (Exception e) {
            throw new CreateException(e.getMessage());
        }
    }

    @Override
    public void eliminarAlimentoReceta(AlimentoReceta alimentoReceta) throws DeleteException {
        try {
            em.remove(em.merge(alimentoReceta));
        } catch (Exception e) {
            throw new DeleteException(e.getMessage());
        }
    }

    @Override
    public void modificarAlimentoReceta(AlimentoReceta alimentoReceta) throws UpdateException {
        try {
            em.merge(alimentoReceta);

            em.flush();
        } catch (Exception e) {
            throw new UpdateException(e.getMessage());
        }
    }

    @Override
    public AlimentoReceta getAlimentoRecetaPorIdReceta(String idReceta) throws ReadException {
        AlimentoReceta alimentoReceta;
        try {
            alimentoReceta = em.find(AlimentoReceta.class, idReceta);

        } catch (Exception e) {
            throw new ReadException(e.getMessage());
        }

        return alimentoReceta;
    }

    @Override
    public Collection<AlimentoReceta> getAlimentoRecetaTodos() throws ReadException {
        List<AlimentoReceta> listaAlimentoReceta = null;
        try {
            listaAlimentoReceta = em.createNamedQuery("getAlimentoRecetaTodos").getResultList();
        } catch (Exception e) {
            throw new ReadException(e.getMessage());
        }
        return listaAlimentoReceta;
    }

    @Override
    public Collection<AlimentoReceta> getAlimentoRecetaPorCantidad(Integer cantidad) throws ReadException {
        Collection<AlimentoReceta> listaAlimentoRecetas = null;
        try {

            listaAlimentoRecetas = em.createNamedQuery("getAlimentoRecetaPorCantidad").setParameter("cantidad", cantidad).getResultList();
        } catch (Exception e) {
            throw new ReadException(e.getMessage());
        }
        return listaAlimentoRecetas;
    }

}
