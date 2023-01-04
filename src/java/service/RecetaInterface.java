/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import entities.Alimento;
import entities.Dietista;
import entities.Receta;
import entities.TipoAlimento;
import excepciones.CreateException;
import excepciones.DeleteException;
import excepciones.ReadException;
import excepciones.UpdateException;
import java.util.Collection;

/**
 * Interfaz para EJBReceta
 *
 * @author jon
 */
public interface RecetaInterface {

    /**
     * Este metodo busca la receta por la id
     *
     * @param idReceta Es un String
     * @return Devuelve un Objeto entidad Receta
     * @throws excepciones.ReadException se lanza cuando ocurre un error en la
     * busqueda del objeto alimento en la base de datos
     */
    
    
    public void crearReceta(Receta receta) throws CreateException;
    
    public void modificarReceta(Receta receta) throws UpdateException;
    
    public void borrarReceta (Receta receta) throws DeleteException;
    
    public Receta getRecetaPorId(String idReceta) throws ReadException;

    public Collection<Receta> getRecetaTodos() throws ReadException;

    public Collection<Receta> getRecetaNombreDietista(String nombreDietista) throws ReadException;
    
    public Collection<Receta> getRecetasAlfabeticamente() throws ReadException;
    
    public Collection <Receta> getNombreReceta(String nombreReceta) throws ReadException;
    
    public Collection<Receta> getRecetaTipo(String tipoReceta) throws ReadException;
    
     public Collection<Receta> getRecetaFechaCreacion() throws ReadException;


}
