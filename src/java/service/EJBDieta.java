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
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Gonzalo
 */
public class EJBDieta implements DietaInterface {

    @PersistenceContext(unitName = "Reto2G2ServPU")    
    private EntityManager em;

    @Override
    public void crearDieta(Dieta dieta) throws CreateException {
        em.persist(dieta);
    }

    @Override
    public void eliminarDieta(Dieta dieta) throws DeleteException {
        em.remove(dieta);
    }

    @Override
    public void modificarDieta(Dieta dieta) throws UpdateException {
        em.merge(dieta);
    }

    @Override
    public Dieta getDietaoPorNombre(String nombreDieta) throws ReadException {
        Dieta dieta;
        dieta = em.find(Dieta.class, nombreDieta);

        return dieta;
    }

    @Override
    public Dieta getDietaoPorId(String idDieta) throws ReadException {
        Dieta dieta;
        dieta = em.find(Dieta.class, idDieta);

        return dieta;
    }
    
    @Override
    public Collection<Dieta> getDietaAll() throws ReadException{
        Collection<Dieta> listaDieta;
        listaDieta = em.createNamedQuery("getDietaTodos").getResultList();
        return listaDieta;
    }
    
    @Override
    public Collection<Dieta> getDietaPorTipo(TipoDieta tipoDieta) throws ReadException {
        Collection<Dieta> listaDieta;
        listaDieta = em.createNamedQuery("dietaPorNombre").setParameter("tipoDieta", em.find(Dieta.class, tipoDieta)).getResultList();

        return listaDieta;
    }

    @Override
    public Collection<Dieta> getDietaPorTiempoMinimo(Integer tiempo) throws ReadException {
        Collection<Dieta> listaDieta;
        listaDieta = em.createNamedQuery("dietaPorTiempo").setParameter("tiempoDieta", em.find(Dieta.class, tiempo)).getResultList();

        return listaDieta;
    }

    @Override
    public Collection<Dieta> getDietaPorTiempoMaximo(Integer tiempo) throws ReadException {
        Collection<Dieta> listaDieta;
        listaDieta = em.createNamedQuery("dietaPorTiempo").setParameter("tiempoDieta", em.find(Dieta.class, tiempo)).getResultList();
        
        return listaDieta;
    }

    @Override
    public Collection<Dieta> getDietaPorTiempoEntre(Integer tiempoMax, Integer tiempoMin) throws ReadException {
        Collection<Dieta> listaDieta;
        listaDieta = em.createNamedQuery("dietaPorTiempo").setParameter("tiempoDietaMax", em.find(Dieta.class, tiempoMax)).getResultList();
        
        return listaDieta;
    }

    @Override
    public Collection<Dieta> getDietaPorObjetivo(Objetivo OBJETIVO) throws ReadException {
        Collection<Dieta> listaDieta = null;
        listaDieta = em.createNamedQuery("dietaPorObjetivo").setParameter("objetivoDieta", em.find(Dieta.class, OBJETIVO)).getResultList();
        
        return listaDieta;
    }

}
