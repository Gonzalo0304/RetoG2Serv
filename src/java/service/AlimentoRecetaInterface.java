/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import entities.AlimentoReceta;
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
public interface AlimentoRecetaInterface {
    
    /**
     *
     * @param alimentoReceta
     * @throws CreateException
     */
    public void crearAlimentoReceta(AlimentoReceta alimentoReceta) throws CreateException;

    /**
     *
     * @param alimentoReceta
     * @throws DeleteException
     */
    public void eliminarAlimentoReceta(AlimentoReceta alimentoReceta) throws DeleteException;

    /**
     *
     * @param alimentoReceta
     * @throws UpdateException
     */
    public void modificarAlimentoReceta(AlimentoReceta alimentoReceta) throws UpdateException;

    /**
     *
     * @param idReceta
     * @return
     * @throws ReadException
     */
    public AlimentoReceta getAlimentoRecetaPorIdRecetaIdAlimento(String idReceta, String idAlimento) throws ReadException;

    /**
     *
     * @return
     * @throws ReadException
     */
    public Collection<AlimentoReceta> getAlimentoRecetaTodos() throws ReadException;
    
    
    public Collection<AlimentoReceta> getAlimentoRecetaPorCantidad(Integer cantidad) throws ReadException;

    
}
