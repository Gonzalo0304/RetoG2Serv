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

/**
 *
 * @author josue
 */
public interface DietistaInterface {

    /**
     *
     * @param dietista
     * @throws CreateException
     */
    public void crearDietista(Dietista dietista) throws CreateException;

    /**
     *
     * @param dietista
     * @throws DeleteException
     */
    public void eliminarDietista(Dietista dietista) throws DeleteException;

    /**
     *
     * @param dietista
     * @throws UpdateException
     */
    public void modificarDietista(Dietista dietista) throws UpdateException;

    /**
     *
     * @param dni
     * @return
     * @throws ReadException
     */
    public Dietista getDietistaPorDni(String dni) throws ReadException;

    /**
     *
     * @return
     * @throws ReadException
     */
    public Collection<Dietista> getDietistaTodos() throws ReadException;

}
