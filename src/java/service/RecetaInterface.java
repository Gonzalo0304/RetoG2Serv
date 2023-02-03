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
     *   @throws CreateException Lanza una excepción de tipo CreateException si hay un problema en la creación de la receta.
     */
    
    
    public void crearReceta(Receta receta) throws CreateException;
    /**
     * 
     * @param receta
    * @throws UpdateException Lanza una excepción de tipo UpdateException si hay un problema en la actualización de la receta.
     */
    public void modificarReceta(Receta receta) throws UpdateException;
      /**
     * Este método borra una receta.
     *
     * @param receta ha borrar
     * @throws DeleteException Lanza una excepción de tipo DeleteException si hay un problema en el borrado de la receta.
     */
    public void borrarReceta (Receta receta) throws DeleteException;
     /**
     * Este método devuelve la receta que tenga un ID específico.
     *
     * @param idReceta id receta ha buscar
     * @return receta con ese id
     * @throws ReadException se lanza cuando ocurre un error en la
     * busqueda del objeto receta en la base de datos
     */
    public Receta getRecetaPorId(String idReceta) throws ReadException;
 /**
     * Este método devuelve una colección con todas las recetas existentes.
     *
     * @return 
     * @throws ReadException se lanza cuando ocurre un error en la
     * busqueda del objeto receta en la base de datos
     */
    public Collection<Receta> getRecetaTodos() throws ReadException;
/**
     * Este método devuelve una colección de recetas creadas por un dietista con
     * un nombre específico.
     *
     * @param nombreDietista
     * @return coleccion con del dietista que hemos buscado
     * @throws ReadException se lanza cuando ocurre un error en la
     * busqueda del objeto receta en la base de datos
     */
    public Collection<Receta> getRecetaNombreDietista(String nombreDietista) throws ReadException;
     /**
     * Este método devuelve una colección de recetas ordenadas alfabéticamente.
     *
     * @return coleccion de recetas ordenadas alfabeticamente
     * @throws ReadException se lanza cuando ocurre un error en la
     * busqueda del objeto receta en la base de datos
     */
    public Collection<Receta> getRecetasAlfabeticamente() throws ReadException;
    /**
     * Este método devuelve una colección de recetas con un nombre específico.
     *
     * @param nombreReceta
     * @return coleccion de recetas con ese nombre
     * @throws ReadException se lanza cuando ocurre un error en la
     * busqueda del objeto receta en la base de datos
     */
    public Collection <Receta> getNombreReceta(String nombreReceta) throws ReadException;
     /**
     * Este método devuelve una colección de recetas con un tipo específico.
     *
     * @param tipoReceta
     * @return coleccion de recetas por el tipo filtrado
     * @throws ReadException se lanza cuando ocurre un error en la
     * busqueda del objeto receta en la base de datos
     */
    public Collection<Receta> getRecetaTipo(String tipoReceta) throws ReadException;
      /**
     * Este método devuelve una colección de recetas ordenadas por fecha de
     * creación.
     *
     * @return coleccion de recetas ordenadas por fecha de creacion
     * @throws ReadException se lanza cuando ocurre un error en la
     * busqueda del objeto receta en la base de datos
     */
     public Collection<Receta> getRecetaFechaCreacion() throws ReadException;


}
