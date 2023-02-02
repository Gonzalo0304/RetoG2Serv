/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import entities.Dieta;
import entities.Objetivo;
import entities.TipoDieta;
import excepciones.CreateException;
import excepciones.DeleteException;
import excepciones.ReadException;
import excepciones.UpdateException;
import java.util.Collection;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Gonzalo
 */
@Stateless
public class EJBDieta implements DietaInterface {

    @PersistenceContext(unitName = "Reto2G2ServPU")    
    private EntityManager em;

    /**
     * Crea un Objeto Dieta en la base de Datos
     * @param dieta es un Objeto de la Entidad Dieta
     * @throws CreateException por si surge alguna excepcion durante el proceso
     */
    @Override
    public void crearDieta(Dieta dieta) throws CreateException {
        em.persist(dieta);
    }

    /**
     * Elimina un Objeto Dieta en la base de Datos
     * @param dieta es un Objeto de la Entidad Dieta
     * @throws DeleteException por si surge alguna excepcion durante el proceso
     */
    @Override
    public void eliminarDieta(Dieta dieta) throws DeleteException {
        em.remove(em.merge(dieta));
    }

    /**
     * Modifica un Objeto Dieta en la base de Datos
     * @param dieta es un Objeto de la Entidad Dieta
     * @throws UpdateException por si surge alguna excepcion durante el proceso
     */
    @Override
    public void modificarDieta(Dieta dieta) throws UpdateException {
        em.merge(dieta);
    }

    /**
     * Busca un Objeto Dieta por su nombreDieta en la base de Datos
     * @param nombreDieta es un String
     * @return Devuelve un Objeto Dieta con datos
     * @throws ReadException por si surge alguna excepcion durante el proceso
     */
    @Override
    public Dieta getDietaoPorNombre(String nombreDieta) throws ReadException {
        Dieta dieta;
        dieta = em.find(Dieta.class, nombreDieta);

        return dieta;
    }

    /**
     * Busca un Objeto Dieta por su idDieta en la base de Datos
     * @param idDieta es un String
     * @return Devuelve un Objeto Dieta con datos
     * @throws ReadException por si surge alguna excepcion durante el proceso
     */
    @Override
    public Dieta getDietaoPorId(String idDieta) throws ReadException {
        Dieta dieta;
        dieta = em.find(Dieta.class, idDieta);

        return dieta;
    }
    
    /**
     * Busca una lista de todos los objetos de Dieta en la base de Datos
     * @return Devuelve una lista de Dietas
     * @throws ReadException por si surge alguna excepcion durante el proceso
     */
    @Override
    public Collection<Dieta> getDietaAll() throws ReadException{
        Collection<Dieta> listaDieta;
        listaDieta = em.createNamedQuery("getDietaTodos").getResultList();
        return listaDieta;
    }
    
    /**
     * Busca una lista de todos los objetos de Dieta que tenga como atributo
     * un tipo de dieta predeterminado
     * @param tipoDieta es un objeto tipoDieta
     * @return devuelve una lista de Dietas
     * @throws ReadException por si surge alguna excepcion durante el proceso
     */
    @Override
    public Collection<Dieta> getDietaPorTipo(TipoDieta tipoDieta) throws ReadException {
        Collection<Dieta> listaDieta;
        listaDieta = em.createNamedQuery("dietaPorNombre").setParameter("tipoDieta", em.find(Dieta.class, tipoDieta)).getResultList();

        return listaDieta;
    }

    /**
     * Busca una lista de todos los objetos de Dieta que tenga como atributo
     * un tiempo predeterminado
     * @param tiempo es un Integer
     * @return devuelve una lista de Dietas
     * @throws ReadException por si surge alguna excepcion durante el proceso
     */
    @Override
    public Collection<Dieta> getDietaPorTiempoMinimo(Integer tiempo) throws ReadException {
        Collection<Dieta> listaDieta;
        listaDieta = em.createNamedQuery("dietaPorTiempo").setParameter("tiempoDieta", em.find(Dieta.class, tiempo)).getResultList();

        return listaDieta;
    }

    /**
     * Busca una lista de todos los objetos de Dieta que tenga como atributo
     * un tiempo predeterminado
     * @param tiempo es un Integer
     * @return devuelve una lista de Dietas
     * @throws ReadException por si surge alguna excepcion durante el proceso
     */
    @Override
    public Collection<Dieta> getDietaPorTiempoMaximo(Integer tiempo) throws ReadException {
        Collection<Dieta> listaDieta;
        listaDieta = em.createNamedQuery("dietaPorTiempo").setParameter("tiempoDieta", em.find(Dieta.class, tiempo)).getResultList();
        
        return listaDieta;
    }

    /**
     * Busca una lista de todos los objetos de Dieta que tenga como atributo
     * un tiempo predeterminado que se encuentre una orquilla de numeros
     * @param tiempoMax es un Integer
     * @param tiempoMin es un Integer
     * @return devuelve una lista de Dietas
     * @throws ReadException por si surge alguna excepcion durante el proceso
     */
    @Override
    public Collection<Dieta> getDietaPorTiempoEntre(Integer tiempoMax, Integer tiempoMin) throws ReadException {
        Collection<Dieta> listaDieta;
        listaDieta = em.createNamedQuery("dietaPorTiempo").setParameter("tiempoDietaMax", em.find(Dieta.class, tiempoMax)).getResultList();
        
        return listaDieta;
    }

    /**
     * Busca una lista de todos los objetos de Dieta que tenga como atributo
     * un tiempo predeterminado
     * @param OBJETIVO es un objeto Objetivo
     * @return devuelve una lista de Dietas
     * @throws ReadException por si surge alguna excepcion durante el proceso
     */
    @Override
    public Collection<Dieta> getDietaPorObjetivo(Objetivo OBJETIVO) throws ReadException {
        Collection<Dieta> listaDieta = null;
        listaDieta = em.createNamedQuery("dietaPorObjetivo").setParameter("objetivoDieta", em.find(Dieta.class, OBJETIVO)).getResultList();
        
        return listaDieta;
    }

}
