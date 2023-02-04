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

    @PersistenceContext(unitName = "RetoG2Serv")
    private EntityManager em;

    /**
     * Crea un Objeto AlimentoReceta en la base de Datos
     *
     * @param alimentoReceta es un Objeto de la Entidad AlimentoReceta
     * @throws CreateException Por si surge alguna excepcion durante el proceso
     */
    @Override
    public void crearAlimentoReceta(AlimentoReceta alimentoReceta) throws CreateException {
        try {
            em.persist(alimentoReceta);
        } catch (Exception e) {
            throw new CreateException(e.getMessage());
        }
    }

    /**
     * Elimina un Objeto AlimentoRceta de la base de Datos
     *
     * @param alimentoReceta es un Objeto de la Entidad Alimento
     * @throws DeleteException Por si surge alguna excepcion durante el proceso
     */
    @Override
    public void eliminarAlimentoReceta(AlimentoReceta alimentoReceta) throws DeleteException {
        try {
            em.remove(em.merge(alimentoReceta));
        } catch (Exception e) {
            throw new DeleteException(e.getMessage());
        }
    }

    /**
     * Modifica un Objeto AlimentoReceta de la base de Datos
     *
     * @param alimentoReceta es un Objeto de la Entidad AlimentoReceta
     * @throws UpdateException Por si surge alguna excepcion durante el proceso
     */
    @Override
    public void modificarAlimentoReceta(AlimentoReceta alimentoReceta) throws UpdateException {
        try {
            em.merge(alimentoReceta);

            em.flush();
        } catch (Exception e) {
            throw new UpdateException(e.getMessage());
        }
    }

    /**
     * Busca un Objeto AlimentoReceta por su idReceta y idAlimento en la base de
     * Datos
     *
     * @param idReceta es un String
     * @param idAlimento es un String
     * @return Devuelve un Objeto alimentoReceta con Datos
     * @throws ReadException Por si surge alguna excepcion durante el proceso
     */
    @Override
    public AlimentoReceta getAlimentoRecetaPorIdRecetaIdAlimento(String idReceta, String idAlimento) throws ReadException {
        AlimentoReceta alimentoReceta = null;
        List<AlimentoReceta> listaAlimentoReceta = null;
        try {

            listaAlimentoReceta = em.createNamedQuery("getAlimentoRecetaTodos").getResultList();
            for (int i = 0; i < listaAlimentoReceta.size(); i++) {
                if (listaAlimentoReceta.get(i).getReceta().getIdReceta().equalsIgnoreCase(idReceta) && listaAlimentoReceta.get(i).getAlimento().getIdAlimento().equalsIgnoreCase(idAlimento)) {
                    alimentoReceta = listaAlimentoReceta.get(i);

                }

            }

        } catch (Exception e) {
            throw new ReadException(e.getMessage());
        }

        return alimentoReceta;
    }

    /**
     * Busca una lista de todos los objetos de AlimentoReceta en la base de
     * Datos
     *
     * @return Devuelve una Lista de AlimentoReceta
     * @throws ReadException Por si surge alguna excepcion durante el proceso
     */
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

    /**
     * Busca una lista de todos los objetos de AlimentoReceta que tenga como
     * atributo una cantidad de alimentoReceta predeterminado
     *
     * @param cantidad es un Integer
     * @return Devuelve una Lista de Alimentos
     * @throws ReadException Por si surge alguna excepcion durante el proceso
     */
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
